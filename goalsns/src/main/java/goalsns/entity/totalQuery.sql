-- ���̺� ������ ���踦 ����Ͽ� �� ���� �����ص� ������ �߻����� �ʰ� ���ĵǾ����ϴ�.

-- t_chell Table Create SQL
CREATE TABLE t_chell
(
    chell_seq     NUMBER(12, 0)     NOT NULL, 
    chell_name    VARCHAR2(4000)    NOT NULL, 
    chell_term    NUMBER(12, 0)     NOT NULL, 
     PRIMARY KEY (chell_seq)
)
/

CREATE SEQUENCE t_chell_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_chell_AI_TRG
BEFORE INSERT ON t_chell 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_chell_SEQ.NEXTVAL
    INTO :NEW.chell_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_chell_AI_TRG;
/

--DROP SEQUENCE t_chell_SEQ;
/

COMMENT ON TABLE t_chell IS 'ç���� �ؽ��±� ���̺�'
/

COMMENT ON COLUMN t_chell.chell_seq IS 'ç���� �ؽ��±� ����'
/

COMMENT ON COLUMN t_chell.chell_name IS 'ç���� �ؽ��±� �̸�'
/

COMMENT ON COLUMN t_chell.chell_term IS 'ç���� �Ⱓ'
/


-- t_member Table Create SQL
CREATE TABLE t_member
(
    mem_id          VARCHAR2(30)      NOT NULL, 
    mem_pw          VARCHAR2(30)      NOT NULL, 
    mem_name        VARCHAR2(30)      NOT NULL, 
    mem_email       VARCHAR2(50)      NOT NULL, 
    mem_about       VARCHAR2(4000)    NOT NULL, 
    mem_joindate    DATE              DEFAULT SYSDATE NOT NULL, 
    admin_yn        CHAR(1)           DEFAULT 'n' NOT NULL, 
     PRIMARY KEY (mem_id)
)
/

COMMENT ON TABLE t_member IS 'ȸ�� ���̺�'
/

COMMENT ON COLUMN t_member.mem_id IS 'ȸ�� ���̵�'
/

COMMENT ON COLUMN t_member.mem_pw IS 'ȸ�� ��й�ȣ'
/

COMMENT ON COLUMN t_member.mem_name IS 'ȸ�� �̸�'
/

COMMENT ON COLUMN t_member.mem_email IS 'ȸ�� �̸���'
/

COMMENT ON COLUMN t_member.mem_about IS 'ȸ�� �Ұ���'
/

COMMENT ON COLUMN t_member.mem_joindate IS 'ȸ�� ��������'
/

COMMENT ON COLUMN t_member.admin_yn IS '������ ����'
/


-- t_hashTag Table Create SQL
CREATE TABLE t_hashTag
(
    hashtag_seq     NUMBER(12, 0)     NOT NULL, 
    hashtag_name    VARCHAR2(4000)    NOT NULL, 
     PRIMARY KEY (hashtag_seq)
)
/

CREATE SEQUENCE t_hashTag_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_hashTag_AI_TRG
BEFORE INSERT ON t_hashTag 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_hashTag_SEQ.NEXTVAL
    INTO :NEW.hashtag_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_hashTag_AI_TRG;
/

--DROP SEQUENCE t_hashTag_SEQ;
/

COMMENT ON TABLE t_hashTag IS '�ؽ��±� ���̺�'
/

COMMENT ON COLUMN t_hashTag.hashtag_seq IS '�ؽ��±� ����'
/

COMMENT ON COLUMN t_hashTag.hashtag_name IS '�ؽ��±� �̸�'
/


-- t_post Table Create SQL
CREATE TABLE t_post
(
    post_seq        NUMBER(12, 0)     NOT NULL, 
    post_content    VARCHAR2(4000)    NOT NULL, 
    post_file       VARCHAR2(200)     NOT NULL, 
    post_date       DATE              DEFAULT SYSDATE NOT NULL, 
    mem_id          VARCHAR2(30)      NOT NULL, 
    chell_seq       NUMBER(12, 0)     NULL, 
     PRIMARY KEY (post_seq)
)
/

CREATE SEQUENCE t_post_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_post_AI_TRG
BEFORE INSERT ON t_post 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_post_SEQ.NEXTVAL
    INTO :NEW.post_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_post_AI_TRG;
/

--DROP SEQUENCE t_post_SEQ;
/

COMMENT ON TABLE t_post IS '����Ʈ ���̺�'
/

COMMENT ON COLUMN t_post.post_seq IS '����Ʈ ����'
/

COMMENT ON COLUMN t_post.post_content IS '�� ����'
/

COMMENT ON COLUMN t_post.post_file IS '�� ÷������'
/

COMMENT ON COLUMN t_post.post_date IS '�� �ۼ���'
/

COMMENT ON COLUMN t_post.mem_id IS '�� �ۼ���'
/

COMMENT ON COLUMN t_post.chell_seq IS 'ç���� �ؽ��±�'
/

ALTER TABLE t_post
    ADD CONSTRAINT FK_t_post_mem_id_t_member_mem_ FOREIGN KEY (mem_id)
        REFERENCES t_member (mem_id)
/

ALTER TABLE t_post
    ADD CONSTRAINT FK_t_post_chell_seq_t_chell_ch FOREIGN KEY (chell_seq)
        REFERENCES t_chell (chell_seq)
/

-- t_mem_chell Table Create SQL
CREATE TABLE t_mem_chell
(
    mem_id         VARCHAR2(30)     NOT NULL, 
    chell_seq      NUMBER(12, 0)    NOT NULL, 
    mapping_seq    NUMBER(12, 0)    NOT NULL, 
     PRIMARY KEY (mapping_seq)
)
/

COMMENT ON TABLE t_mem_chell IS 'ȸ��-ç���� �ؽ��±� ���� ���̺�'
/

COMMENT ON COLUMN t_mem_chell.mem_id IS 'ȸ�� ���̵�'
/

COMMENT ON COLUMN t_mem_chell.chell_seq IS 'ç���� �ؽ��±� ����'
/

COMMENT ON COLUMN t_mem_chell.mapping_seq IS '���μ���'
/

ALTER TABLE t_mem_chell
    ADD CONSTRAINT FK_t_mem_chell_chell_seq_t_che FOREIGN KEY (chell_seq)
        REFERENCES t_chell (chell_seq)
/

ALTER TABLE t_mem_chell
    ADD CONSTRAINT FK_t_mem_chell_mem_id_t_member FOREIGN KEY (mem_id)
        REFERENCES t_member (mem_id)
/


-- t_post_hashtag Table Create SQL
CREATE TABLE t_post_hashtag
(
    post_seq       NUMBER(12, 0)    NOT NULL, 
    hashtag_seq    NUMBER(12, 0)    NOT NULL, 
    mapping_seq    NUMBER(12, 0)    NOT NULL, 
     PRIMARY KEY (mapping_seq)
)
/

COMMENT ON TABLE t_post_hashtag IS '����Ʈ-�ؽ��±� �������̺�'
/

COMMENT ON COLUMN t_post_hashtag.post_seq IS '����Ʈ ����'
/

COMMENT ON COLUMN t_post_hashtag.hashtag_seq IS '�ؽ��±� ����'
/

COMMENT ON COLUMN t_post_hashtag.mapping_seq IS '���μ���'
/

ALTER TABLE t_post_hashtag
    ADD CONSTRAINT FK_t_post_hashtag_hashtag_seq_ FOREIGN KEY (hashtag_seq)
        REFERENCES t_hashTag (hashtag_seq)
/

ALTER TABLE t_post_hashtag
    ADD CONSTRAINT FK_t_post_hashtag_post_seq_t_p FOREIGN KEY (post_seq)
        REFERENCES t_post (post_seq)
/


-- t_follow Table Create SQL
CREATE TABLE t_follow
(
    follow_seq    NUMBER(12, 0)    NOT NULL, 
    to_mem        VARCHAR2(30)     NOT NULL, 
    from_mem      VARCHAR2(30)     NOT NULL, 
     PRIMARY KEY (follow_seq)
)
/

CREATE SEQUENCE t_follow_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_follow_AI_TRG
BEFORE INSERT ON t_follow 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_follow_SEQ.NEXTVAL
    INTO :NEW.follow_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_follow_AI_TRG;
/

--DROP SEQUENCE t_follow_SEQ;
/

COMMENT ON TABLE t_follow IS '�ȷο� ���̺�'
/

COMMENT ON COLUMN t_follow.follow_seq IS '�ȷο� ����'
/

COMMENT ON COLUMN t_follow.to_mem IS '�ȷο�Ǵ� ����'
/

COMMENT ON COLUMN t_follow.from_mem IS '�ȷο��ϴ� ����'
/

ALTER TABLE t_follow
    ADD CONSTRAINT FK_t_follow_to_mem_t_member_me FOREIGN KEY (to_mem)
        REFERENCES t_member (mem_id)
/

ALTER TABLE t_follow
    ADD CONSTRAINT FK_t_follow_from_mem_t_member_ FOREIGN KEY (from_mem)
        REFERENCES t_member (mem_id)
/


-- t_like Table Create SQL
CREATE TABLE t_like
(
    like_seq    NUMBER(12, 0)    NOT NULL, 
    post_seq    NUMBER(12, 0)    NOT NULL, 
    mem_id      VARCHAR2(30)     NOT NULL, 
     PRIMARY KEY (like_seq)
)
/

CREATE SEQUENCE t_like_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_like_AI_TRG
BEFORE INSERT ON t_like 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_like_SEQ.NEXTVAL
    INTO :NEW.like_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_like_AI_TRG;
/

--DROP SEQUENCE t_like_SEQ;
/

COMMENT ON TABLE t_like IS '���ƿ� ���̺�'
/

COMMENT ON COLUMN t_like.like_seq IS '���ƿ� ����'
/

COMMENT ON COLUMN t_like.post_seq IS '����Ʈ ����'
/

COMMENT ON COLUMN t_like.mem_id IS 'ȸ�� ���̵�'
/

ALTER TABLE t_like
    ADD CONSTRAINT FK_t_like_post_seq_t_post_post FOREIGN KEY (post_seq)
        REFERENCES t_post (post_seq)
/

ALTER TABLE t_like
    ADD CONSTRAINT FK_t_like_mem_id_t_member_mem_ FOREIGN KEY (mem_id)
        REFERENCES t_member (mem_id)
/


-- t_cmt Table Create SQL
CREATE TABLE t_cmt
(
    cmt_seq        NUMBER(12, 0)     NOT NULL, 
    post_seq       NUMBER(12, 0)     NOT NULL, 
    cmt_content    VARCHAR2(4000)    NOT NULL, 
    cmt_date       DATE              DEFAULT SYSDATE NOT NULL, 
    mem_id         VARCHAR2(30)      NOT NULL, 
     PRIMARY KEY (cmt_seq)
)
/

CREATE SEQUENCE t_cmt_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER t_cmt_AI_TRG
BEFORE INSERT ON t_cmt 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT t_cmt_SEQ.NEXTVAL
    INTO :NEW.cmt_seq
    FROM DUAL;
END;
/

--DROP TRIGGER t_cmt_AI_TRG;
/

--DROP SEQUENCE t_cmt_SEQ;
/

COMMENT ON TABLE t_cmt IS '��� ���̺�'
/

COMMENT ON COLUMN t_cmt.cmt_seq IS '��� ����'
/

COMMENT ON COLUMN t_cmt.post_seq IS '����Ʈ ����'
/

COMMENT ON COLUMN t_cmt.cmt_content IS '��� ����'
/

COMMENT ON COLUMN t_cmt.cmt_date IS '��� �ۼ�����'
/

COMMENT ON COLUMN t_cmt.mem_id IS '��� �ۼ���'
/

ALTER TABLE t_cmt
    ADD CONSTRAINT FK_t_cmt_post_seq_t_post_post_ FOREIGN KEY (post_seq)
        REFERENCES t_post (post_seq)
/

ALTER TABLE t_cmt
    ADD CONSTRAINT FK_t_cmt_mem_id_t_member_mem_i FOREIGN KEY (mem_id)
        REFERENCES t_member (mem_id)
/

alter table t_member add mem_img VARCHAR2(200);

alter table t_member modify (mem_img default './profilePic/profile_none.png');

alter SEQUENCE T_CHELL_SEQ nocache;

alter table t_chell drop column chell_term;
