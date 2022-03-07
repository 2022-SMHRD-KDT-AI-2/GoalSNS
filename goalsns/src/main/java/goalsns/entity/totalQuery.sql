-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

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

COMMENT ON TABLE t_chell IS '챌린지 해시태그 테이블'
/

COMMENT ON COLUMN t_chell.chell_seq IS '챌린지 해시태그 순번'
/

COMMENT ON COLUMN t_chell.chell_name IS '챌린지 해시태그 이름'
/

COMMENT ON COLUMN t_chell.chell_term IS '챌린지 기간'
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

COMMENT ON TABLE t_member IS '회원 테이블'
/

COMMENT ON COLUMN t_member.mem_id IS '회원 아이디'
/

COMMENT ON COLUMN t_member.mem_pw IS '회원 비밀번호'
/

COMMENT ON COLUMN t_member.mem_name IS '회원 이름'
/

COMMENT ON COLUMN t_member.mem_email IS '회원 이메일'
/

COMMENT ON COLUMN t_member.mem_about IS '회원 소개글'
/

COMMENT ON COLUMN t_member.mem_joindate IS '회원 가입일자'
/

COMMENT ON COLUMN t_member.admin_yn IS '관리자 여부'
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

COMMENT ON TABLE t_hashTag IS '해시태그 테이블'
/

COMMENT ON COLUMN t_hashTag.hashtag_seq IS '해시태그 순번'
/

COMMENT ON COLUMN t_hashTag.hashtag_name IS '해시태그 이름'
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

COMMENT ON TABLE t_post IS '포스트 테이블'
/

COMMENT ON COLUMN t_post.post_seq IS '포스트 순번'
/

COMMENT ON COLUMN t_post.post_content IS '글 내용'
/

COMMENT ON COLUMN t_post.post_file IS '글 첨부파일'
/

COMMENT ON COLUMN t_post.post_date IS '글 작성일'
/

COMMENT ON COLUMN t_post.mem_id IS '글 작성자'
/

COMMENT ON COLUMN t_post.chell_seq IS '챌린지 해시태그'
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

COMMENT ON TABLE t_mem_chell IS '회원-챌린지 해시태그 매핑 테이블'
/

COMMENT ON COLUMN t_mem_chell.mem_id IS '회원 아이디'
/

COMMENT ON COLUMN t_mem_chell.chell_seq IS '챌린지 해시태그 순번'
/

COMMENT ON COLUMN t_mem_chell.mapping_seq IS '매핑순번'
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

COMMENT ON TABLE t_post_hashtag IS '포스트-해시태그 매핑테이블'
/

COMMENT ON COLUMN t_post_hashtag.post_seq IS '포스트 순번'
/

COMMENT ON COLUMN t_post_hashtag.hashtag_seq IS '해시태그 순번'
/

COMMENT ON COLUMN t_post_hashtag.mapping_seq IS '매핑순번'
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

COMMENT ON TABLE t_follow IS '팔로우 테이블'
/

COMMENT ON COLUMN t_follow.follow_seq IS '팔로우 순번'
/

COMMENT ON COLUMN t_follow.to_mem IS '팔로우되는 유저'
/

COMMENT ON COLUMN t_follow.from_mem IS '팔로우하는 유저'
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

COMMENT ON TABLE t_like IS '좋아요 테이블'
/

COMMENT ON COLUMN t_like.like_seq IS '좋아요 순번'
/

COMMENT ON COLUMN t_like.post_seq IS '포스트 순번'
/

COMMENT ON COLUMN t_like.mem_id IS '회원 아이디'
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

COMMENT ON TABLE t_cmt IS '댓글 테이블'
/

COMMENT ON COLUMN t_cmt.cmt_seq IS '댓글 순번'
/

COMMENT ON COLUMN t_cmt.post_seq IS '포스트 순번'
/

COMMENT ON COLUMN t_cmt.cmt_content IS '댓글 내용'
/

COMMENT ON COLUMN t_cmt.cmt_date IS '댓글 작성일자'
/

COMMENT ON COLUMN t_cmt.mem_id IS '댓글 작성자'
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
