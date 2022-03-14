package goalsns.model;

//import java.io.InputStream;
import java.util.List;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import goalsns.entity.CmtVO;
import goalsns.entity.FollowVO;
import goalsns.entity.LikeVO;
import goalsns.entity.MemberVO;



public class MemberDAO {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
		String resource = "goalsns/model/config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		
		}
	}
	
	public List<MemberVO> selectAll() {

		SqlSession session = sqlSessionFactory.openSession();
		List<MemberVO> list = session.selectList("selectAll");
		session.close();
		return list;
	}
	
	public int register(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("register", vo);
		session.commit();
		session.close();
		return cnt;
	}
	
	public int idCheck(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.selectOne("idCheck", vo);
		session.close();
		return result;
	}

	public MemberVO Login(MemberVO vo) {
		SqlSession session=sqlSessionFactory.openSession();
		MemberVO memvo=session.selectOne("Login", vo);
		session.close();
		return memvo;
	}
	
	public MemberVO memberDelete(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("memberDelete", vo);
		session.commit();
		session.close();
		return vo;
	}
	
	public void profileEdit(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("profileEdit",vo);
		session.commit();
		session.close();
	}
	
	public MemberVO getMemberInfo(String mem_id) {
		SqlSession session = sqlSessionFactory.openSession();
		MemberVO vo = session.selectOne("getMemberInfo", mem_id);
		session.close();
		return vo;
	}
	public List<FollowVO> followAll(FollowVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<FollowVO> list = session.selectList("followAll",vo);
		session.close();
		return list;
	}
	public List<FollowVO> tofollowAll(FollowVO vo){
		SqlSession session = sqlSessionFactory.openSession();
		List<FollowVO> list = session.selectList("tofollowAll",vo);
		session.close();
		return list;
	}
	public List<FollowVO> followedAll(FollowVO vo){
		SqlSession session = sqlSessionFactory.openSession();
		List<FollowVO> list = session.selectList("followedAll",vo);
		session.close();
		return list;
	}
	public List<FollowVO> tofollowedAll(FollowVO vo){
		SqlSession session = sqlSessionFactory.openSession();
		List<FollowVO> list = session.selectList("tofollowedAll",vo);
		session.close();
		return list;
	}
	public FollowVO getfollowid(FollowVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		FollowVO fvo=session.selectOne("getfollowid",vo);
		session.close();
		return fvo;
	}
	public int follow(FollowVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int memvo=session.insert("follow",vo);
		session.commit();
		session.close();
		return memvo;
	}
	public void unFollow(FollowVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("unFollow",vo);
		session.commit();
		session.close();
	}
	public List<FollowVO> getFollowInfo(FollowVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<FollowVO> fvo = session.selectList("getFollowInfo", vo);
		session.close();
		return fvo;
	}
	
	public MemberVO getByMemId(String id) {
		   SqlSession session=sqlSessionFactory.openSession();   
		   MemberVO idvo=session.selectOne("getByMemId", id);
		   session.close();
		   return idvo;
	   }
	
	public int cmt(CmtVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int memvo = session.insert("cmt", vo);
		session.commit();
		session.close();
		return memvo;
	}
	
	// À¯Àú ·©Å·
	public List<String> getMemRank() {
		SqlSession session = sqlSessionFactory.openSession();
		List<String> rank = session.selectList("getMemRank");
		session.close();
		return rank;
	}
	
}



