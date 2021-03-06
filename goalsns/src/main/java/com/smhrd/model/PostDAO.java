package com.smhrd.model;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.smhrd.entity.Chart;
import com.smhrd.entity.ChellVO;
import com.smhrd.entity.CmtVO;
import com.smhrd.entity.HashtagVO;
import com.smhrd.entity.LikeCheckVO;
import com.smhrd.entity.LikeVO;
import com.smhrd.entity.MemChellVO;
import com.smhrd.entity.MemberVO;
import com.smhrd.entity.PostHashVO;
import com.smhrd.entity.PostVO;
import com.smhrd.entity.TrackerVO;
import com.smhrd.entity.TrendVO;

public class PostDAO {
	private static SqlSessionFactory sqlSessionFactory;
	
	//초기화 블럭.(프로그램 실행시 한번만 실행되는 부분.)
	static {
		try {
			String resource = "com/smhrd/model/config.xml";
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
	
	// (5) 인기 챌린지 해시태그
	public List<TrendVO> getTrend(){
		SqlSession session = sqlSessionFactory.openSession();
		List<TrendVO> list = session.selectList("getTrend"); 
		session.close();
		return list;
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
	
	// (6) 멤버-해시태그 매핑 테이블 조회
	public MemChellVO memChallSelect(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		MemChellVO vo = session.selectOne("memChallSelect", mcvo); 
		session.close();
		return vo;
	}
	
	// (7) 포스트 데이터에 챌린지 해시태그 아이디 업데이트
	public void postChellUpdate(PostVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("postChellUpdate", vo);
		session.commit();
		session.close();
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
	// (1) 검색단어를 이름으로 가진 챌린지 해시태그 아이디 가져오기.
	public ChellVO getSeqByChellName(String chell_name) {
		SqlSession session = sqlSessionFactory.openSession();
		ChellVO cvo = session.selectOne("getSeqByChellName", chell_name); 
		session.close();
		return cvo;
	}
	
	// (2) 검색단어를 이름으로 가진 해시태그 아이디 가져오기.
	public HashtagVO getSeqByHashName(String hashtag_name) {
		SqlSession session = sqlSessionFactory.openSession();
		HashtagVO hvo = session.selectOne("getSeqByHashName", hashtag_name); 
		session.close();
		return hvo;
	}
	
	// (2) 검색 단어를 포함하는 해시태그 리스트 가져오기.
	public List<PostVO> searchChellBySeq(int chell_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVO> list = session.selectList("searchChellBySeq", chell_seq); 
		session.close();
		return list;
	}
	
	// (3) 포스트 아이디 리스트를 통해 포스트 VO 리스트를 반환.
	public List<PostVO> searchHashBySeq(int hashtag_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVO> list = session.selectList("searchHashBySeq", hashtag_seq); 
		session.close();
		return list;
	}	
	
	//-----------------------------------챌린지 리워드--------------------------------------
	
	// (1) 해당 멤버에 대한 챌린지 해시태그 리스트 반환.
	public int[] getChellList(MemberVO mvo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<MemChellVO> list = session.selectList("getChellList", mvo); 
		int[] chellList = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			chellList[i] = list.get(i).getChell_seq();
		}
		session.close();
		return chellList;
	}
	
	// (2) 리워드1
	public String[] getReward1(MemChellVO mcvo) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVO> list = session.selectList("getReward1", mcvo); 
		String[] dateList = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			dateList[i] = dateFormat.format(list.get(i).getPost_date());
		}
		session.close();
		return dateList;
	}

	// (3) 리워드2
	public List<TrackerVO> getReward2(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<TrackerVO> list = session.selectList("getReward2", mcvo); 
		session.close();
		return list;
	}
	
	// (4) 챌린지 이름 가져오기
	public ChellVO getChellName(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		ChellVO chell_name = session.selectOne("getChellName", mcvo); 
		session.close();
		return chell_name;
	}
	
	// (5) 리워드3 (차트)
	public List<Chart> getReward3(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Chart> list = session.selectList("getReward3", mcvo); 
		session.close();
		return list;
	}	
	// (6) 평균 (차트)
	public List<Chart> getAvg(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Chart> list = session.selectList("getAvg", mcvo); 
		session.close();
		return list;
	}	
	// (5) 리워드3 (차트)
	public int getMemChellCnt(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<MemChellVO> cntList = session.selectList("getMemChellCnt", mcvo); 
		int cnt = cntList.size();
		session.close();
		return cnt;
	}	
	
	//-----------------------------------댓글, 좋아요--------------------------------------
	public int cmt(CmtVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int memvo = session.insert("cmt", vo);
		session.commit();
		session.close();
		return memvo;
	}
	
	public int like(LikeVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("like", vo);
		session.commit();
		session.close();
		return cnt;
	}
	
	public int likeDelete(LikeVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.delete("likeDelete", vo);
		session.commit();
		session.close();
		return cnt;
	}

	public void cmtDelete(int post_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("cmtDelete", post_seq);
		session.commit();
		session.close();
	}
	
	public List<CmtVO> selectCmt(CmtVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<CmtVO> list = session.selectList("selectCmt",vo);
		session.close();
		return list;	
	}
	
	public CmtVO getMyCmt(CmtVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		CmtVO cmt = session.selectOne("getMyCmt",vo);
		session.close();
		return cmt;	
	}
	
	public List<LikeVO> selectLike(LikeVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<LikeVO> list = session.selectList("selectLike",vo);
		session.close();
		return list;	
	}
	
	public LikeVO getLikeByPost(LikeVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		LikeVO like = session.selectOne("getLikeByPost",vo);
		session.close();
		return like;	
	}
	
	
	//-----------------------------------SNS 기능 구현을 위한 메소드--------------------------------------
	
	public List<LikeCheckVO> likeCheck(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<LikeCheckVO> list = session.selectList("likeCheck",vo);
		session.close();
		return list;	
	}
}
