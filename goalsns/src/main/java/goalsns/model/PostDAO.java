package goalsns.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import goalsns.entity.ChellVO;
import goalsns.entity.HashtagVO;
import goalsns.entity.MemChellVO;
import goalsns.entity.PostChellVO;
import goalsns.entity.PostHashVO;
import goalsns.entity.PostVO;

public class PostDAO {
	private static SqlSessionFactory sqlSessionFactory;
	
	//�ʱ�ȭ ��.(���α׷� ����� �ѹ��� ����Ǵ� �κ�.)
	static {
		try {
			String resource = "goalsns/model/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// (1) ����Ʈ �۾���
	public void postWrite(PostVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("postWrite", vo);
		session.commit();
		session.close();
	}
	
	// (2) ����Ʈ ����Ʈ ��������. (�ȷο� �ý��� ���� �Ŀ� �ȷο��� ������ �۱��� ���������� �����ϱ�.)
	public List<PostVO> selectPosts(String mem_id) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVO> list = session.selectList("selectPosts", mem_id); 
		session.close();
		return list;
	}
	
	// (3) ����Ʈ �󼼺��� - ����Ʈ ���̵� ���� ���� �ش� ����Ʈ ���� ��������
	public PostVO getPostByIdx(int post_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		PostVO vo = session.selectOne("getPostByIdx", post_seq);
		session.close();
		return vo;
	}
	
	// (4) ����Ʈ �����ϱ� - ����Ʈ ���̵� ���� ���� �ش� ����Ʈ �����ϱ�. (�Ŀ� �ش� ����Ʈ�� �����ϴ� �����ͱ��� �����ϵ��� ����.)
	public void postDelete(int post_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("postDelete", post_seq);
		session.commit();
		session.close();
	}
	
	//-----------------------------------�Ϲ� �ؽ��±� ��� ������ ���� �޼ҵ�--------------------------------------
	
	// (1) �ؽ��±� �̸��� ���� �ؽ��±� ���� ��������
	public HashtagVO hashSelect(String hashtag_name) {
		SqlSession session = sqlSessionFactory.openSession();
		HashtagVO vo = session.selectOne("hashSelect", hashtag_name); 
		session.close();
		return vo;
	}
	
	// (2) �ؽ��±� �����ϱ�
	public void hashInsert(HashtagVO hvo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("hashInsert", hvo);
		session.commit();
		session.close();
	}
	
	// (3) ����Ʈ-�ؽ��±� ���� ���̺� �����ϱ�
	public void postHashInsert(PostHashVO phvo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("postHashInsert", phvo);
		session.commit();
		session.close();		
	}
	
	// (4) ��� ������ ����Ʈ�� ����Ʈ ���̵� ��������
	public int getPostSeq(){
		SqlSession session = sqlSessionFactory.openSession();
		int post_seq = session.selectOne("getPostSeq"); 
		session.close();
		return post_seq;
	}
	
	// (5) ��� ������ �ؽ��±��� �ؽ��±� ���̵� ��������
	public int getHashtagSeq(){
		SqlSession session = sqlSessionFactory.openSession();
		int post_seq = session.selectOne("getHashtagSeq");
		session.close();
		return post_seq;
	}
	
	//-----------------------------------ç���� �ؽ��±� ��� ������ ���� �޼ҵ�--------------------------------------
	
	// (1) ç���� �ؽ��±� �̸��� ���� �ؽ��±� ���� ��������
	public ChellVO challSelect(String chell_name) {
		SqlSession session = sqlSessionFactory.openSession();
		ChellVO vo = session.selectOne("challSelect", chell_name); 
		session.close();
		return vo;
	}
	
	// (2) �ؽ��±� �����ϱ�
	public void chellInsert(ChellVO cvo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("chellInsert", cvo);
		session.commit();
		session.close();
	}
	
	// (3) ��� ������ ç���� �ؽ��±��� ���̵� ��������
	public int getChellSeq(){
		SqlSession session = sqlSessionFactory.openSession();
		int chell_seq = session.selectOne("getChellSeq");
		session.close();
		return chell_seq;
	}
	
	// (4) ���-�ؽ��±� ���� ���̺� �����ϱ�
	public void memChellInsert(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("memChellInsert", mcvo);
		session.commit();
		session.close();		
	}
	
	// (5) ����Ʈ-ç���� ���� ���̺� �����ϱ�
	public void postChellInsert(PostChellVO pcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("postChellInsert", pcvo);
		session.commit();
		session.close();		
	}
	
	// (6) ���-�ؽ��±� ���� ���̺� ��ȸ
	public MemChellVO memChallSelect(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		MemChellVO vo = session.selectOne("memChallSelect", mcvo); 
		session.close();
		return vo;
	}
	
	//-----------------------------------������ ��� ������ ���� �޼ҵ�--------------------------------------
	
	// (1) �ش� ������ ����Ʈ ����Ʈ ��������.
	public List<PostVO> getMemberPosts(String mem_id){
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVO> list = session.selectList("getMemberPosts", mem_id); 
		session.close();
		return list;
	}

	//-----------------------------------�˻� ��� ������ ���� �޼ҵ�--------------------------------------
	
	// (1) �˻� �ܾ �����ϴ� ç���� �ؽ��±� ����Ʈ ��������.
	public List<PostChellVO> autoSearchChell(String chell_name) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostChellVO> list = session.selectList("autoSearchChell", chell_name); 
		session.close();
		return list;
	}
	
	// (2) �˻� �ܾ �����ϴ� �ؽ��±� ����Ʈ ��������.
	public List<PostHashVO> autoSearchHash(String hashtag_name) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostHashVO> list = session.selectList("autoSearchHash", hashtag_name); 
		session.close();
		return list;
	}


	
}
