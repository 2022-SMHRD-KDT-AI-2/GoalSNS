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
	
	//초기화 블럭.(프로그램 실행시 한번만 실행되는 부분.)
	static {
		try {
			String resource = "goalsns/model/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// (1) 포스트 글쓰기
	public void postWrite(PostVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("postWrite", vo);
		session.commit();
		session.close();
	}
	
	// (2) 포스트 리스트 가져오기. (팔로우 시스템 구현 후에 팔로우한 유저의 글까지 가져오도록 수정하기.)
	public List<PostVO> selectPosts(String mem_id) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVO> list = session.selectList("selectPosts", mem_id); 
		session.close();
		return list;
	}
	
	// (3) 포스트 상세보기 - 포스트 아이디 값을 통해 해당 포스트 정보 가져오기
	public PostVO getPostByIdx(int post_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		PostVO vo = session.selectOne("getPostByIdx", post_seq);
		session.close();
		return vo;
	}
	
	// (4) 포스트 삭제하기 - 포스트 아이디 값을 통해 해당 포스트 삭제하기. (후에 해당 포스트를 참조하는 데이터까지 삭제하도록 수정.)
	public void postDelete(int post_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("postDelete", post_seq);
		session.commit();
		session.close();
	}
	
	//-----------------------------------일반 해시태그 기능 구현을 위한 메소드--------------------------------------
	
	// (1) 해시태그 이름을 통해 해시태그 정보 가져오기
	public HashtagVO hashSelect(String hashtag_name) {
		SqlSession session = sqlSessionFactory.openSession();
		HashtagVO vo = session.selectOne("hashSelect", hashtag_name); 
		session.close();
		return vo;
	}
	
	// (2) 해시태그 삽입하기
	public void hashInsert(HashtagVO hvo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("hashInsert", hvo);
		session.commit();
		session.close();
	}
	
	// (3) 포스트-해시태그 매핑 테이블 삽입하기
	public void postHashInsert(PostHashVO phvo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("postHashInsert", phvo);
		session.commit();
		session.close();		
	}
	
	// (4) 방금 삽입한 포스트의 포스트 아이디 가져오기
	public int getPostSeq(){
		SqlSession session = sqlSessionFactory.openSession();
		int post_seq = session.selectOne("getPostSeq"); 
		session.close();
		return post_seq;
	}
	
	// (5) 방금 삽입한 해시태그의 해시태그 아이디 가져오기
	public int getHashtagSeq(){
		SqlSession session = sqlSessionFactory.openSession();
		int post_seq = session.selectOne("getHashtagSeq");
		session.close();
		return post_seq;
	}
	
	//-----------------------------------챌린지 해시태그 기능 구현을 위한 메소드--------------------------------------
	
	// (1) 챌린지 해시태그 이름을 통해 해시태그 정보 가져오기
	public ChellVO challSelect(String chell_name) {
		SqlSession session = sqlSessionFactory.openSession();
		ChellVO vo = session.selectOne("challSelect", chell_name); 
		session.close();
		return vo;
	}
	
	// (2) 해시태그 삽입하기
	public void chellInsert(ChellVO cvo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("chellInsert", cvo);
		session.commit();
		session.close();
	}
	
	// (3) 방금 삽입한 챌린지 해시태그의 아이디 가져오기
	public int getChellSeq(){
		SqlSession session = sqlSessionFactory.openSession();
		int chell_seq = session.selectOne("getChellSeq");
		session.close();
		return chell_seq;
	}
	
	// (4) 멤버-해시태그 매핑 테이블 삽입하기
	public void memChellInsert(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("memChellInsert", mcvo);
		session.commit();
		session.close();		
	}
	
	// (5) 포스트-챌린지 매핑 테이블 삽입하기
	public void postChellInsert(PostChellVO pcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("postChellInsert", pcvo);
		session.commit();
		session.close();		
	}
	
	// (6) 멤버-해시태그 매핑 테이블 조회
	public MemChellVO memChallSelect(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		MemChellVO vo = session.selectOne("memChallSelect", mcvo); 
		session.close();
		return vo;
	}
	
	//-----------------------------------프로필 기능 구현을 위한 메소드--------------------------------------
	
	// (1) 해당 유저의 포스트 리스트 가져오기.
	public List<PostVO> getMemberPosts(String mem_id){
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVO> list = session.selectList("getMemberPosts", mem_id); 
		session.close();
		return list;
	}

	//-----------------------------------검색 기능 구현을 위한 메소드--------------------------------------
	
	// (1) 검색 단어를 포함하는 챌린지 해시태그 리스트 가져오기.
	public List<PostChellVO> autoSearchChell(String chell_name) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostChellVO> list = session.selectList("autoSearchChell", chell_name); 
		session.close();
		return list;
	}
	
	// (2) 검색 단어를 포함하는 해시태그 리스트 가져오기.
	public List<PostHashVO> autoSearchHash(String hashtag_name) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostHashVO> list = session.selectList("autoSearchHash", hashtag_name); 
		session.close();
		return list;
	}


	
}
