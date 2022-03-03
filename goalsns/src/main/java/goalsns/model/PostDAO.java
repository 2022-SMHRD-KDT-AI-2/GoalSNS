package goalsns.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	
	public void postWrite(PostVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		session.insert("postWrite", vo);
		session.commit();
		session.close();
	}
	
	public List<PostVO> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVO> list = session.selectList("selectAll"); 
		session.close();
		return list;
	}
}
