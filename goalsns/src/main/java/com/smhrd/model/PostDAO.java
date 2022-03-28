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
	
	//�ʱ�ȭ ����.(���α׷� ����� �ѹ��� ����Ǵ� �κ�.)
	static {
		try {
			String resource = "com/smhrd/model/config.xml";
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
	
	// (5) �α� ç���� �ؽ��±�
	public List<TrendVO> getTrend(){
		SqlSession session = sqlSessionFactory.openSession();
		List<TrendVO> list = session.selectList("getTrend"); 
		session.close();
		return list;
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
	
	// (6) ���-�ؽ��±� ���� ���̺� ��ȸ
	public MemChellVO memChallSelect(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		MemChellVO vo = session.selectOne("memChallSelect", mcvo); 
		session.close();
		return vo;
	}
	
	// (7) ����Ʈ �����Ϳ� ç���� �ؽ��±� ���̵� ������Ʈ
	public void postChellUpdate(PostVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("postChellUpdate", vo);
		session.commit();
		session.close();
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
	// (1) �˻��ܾ �̸����� ���� ç���� �ؽ��±� ���̵� ��������.
	public ChellVO getSeqByChellName(String chell_name) {
		SqlSession session = sqlSessionFactory.openSession();
		ChellVO cvo = session.selectOne("getSeqByChellName", chell_name); 
		session.close();
		return cvo;
	}
	
	// (2) �˻��ܾ �̸����� ���� �ؽ��±� ���̵� ��������.
	public HashtagVO getSeqByHashName(String hashtag_name) {
		SqlSession session = sqlSessionFactory.openSession();
		HashtagVO hvo = session.selectOne("getSeqByHashName", hashtag_name); 
		session.close();
		return hvo;
	}
	
	// (2) �˻� �ܾ �����ϴ� �ؽ��±� ����Ʈ ��������.
	public List<PostVO> searchChellBySeq(int chell_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVO> list = session.selectList("searchChellBySeq", chell_seq); 
		session.close();
		return list;
	}
	
	// (3) ����Ʈ ���̵� ����Ʈ�� ���� ����Ʈ VO ����Ʈ�� ��ȯ.
	public List<PostVO> searchHashBySeq(int hashtag_seq) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVO> list = session.selectList("searchHashBySeq", hashtag_seq); 
		session.close();
		return list;
	}	
	
	//-----------------------------------ç���� ������--------------------------------------
	
	// (1) �ش� ����� ���� ç���� �ؽ��±� ����Ʈ ��ȯ.
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
	
	// (2) ������1
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

	// (3) ������2
	public List<TrackerVO> getReward2(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<TrackerVO> list = session.selectList("getReward2", mcvo); 
		session.close();
		return list;
	}
	
	// (4) ç���� �̸� ��������
	public ChellVO getChellName(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		ChellVO chell_name = session.selectOne("getChellName", mcvo); 
		session.close();
		return chell_name;
	}
	
	// (5) ������3 (��Ʈ)
	public List<Chart> getReward3(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Chart> list = session.selectList("getReward3", mcvo); 
		session.close();
		return list;
	}	
	// (6) ��� (��Ʈ)
	public List<Chart> getAvg(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<Chart> list = session.selectList("getAvg", mcvo); 
		session.close();
		return list;
	}	
	// (5) ������3 (��Ʈ)
	public int getMemChellCnt(MemChellVO mcvo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<MemChellVO> cntList = session.selectList("getMemChellCnt", mcvo); 
		int cnt = cntList.size();
		session.close();
		return cnt;
	}	
	
	//-----------------------------------���, ���ƿ�--------------------------------------
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
	
	
	//-----------------------------------SNS ��� ������ ���� �޼ҵ�--------------------------------------
	
	public List<LikeCheckVO> likeCheck(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<LikeCheckVO> list = session.selectList("likeCheck",vo);
		session.close();
		return list;	
	}
}