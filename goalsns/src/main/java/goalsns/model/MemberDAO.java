package goalsns.model;

//import java.io.InputStream;
import java.util.List;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	public MemberVO Login(MemberVO vo) {
		SqlSession session=sqlSessionFactory.openSession();
		MemberVO memvo=session.selectOne("Login", vo);
		session.close();
		return memvo;
	}
	
	public void memberDelete(String pw) {
		SqlSession session = sqlSessionFactory.openSession();
		session.delete("memberDelete", pw);
		session.commit();
		session.close();
	}
	
	
}



