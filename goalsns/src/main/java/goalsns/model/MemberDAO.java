package goalsns.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import goalsns.entity.MemberVO;

public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private DataSource dataFactory;
	private ResultSet rs;
	
	public MemberDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:XE";
			String dbUserName = "cgi_5_0216_1";
			String dbPassword = "smhrd1";
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int registerCheck(String mem_id) {
		// ID 중복 체크 메서드
		psmt = null;
		rs = null;
		String SQL = "SELECT * FROM USER WHERE mem_id = ?";
		
		try {
			psmt = conn.prepareStatement(SQL);
			psmt.setString(1, mem_id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return 0; // 이미 존재하는 회원아이디	
			} else {
				return 1; //가입 가능한 회원 아이디
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1; // 데이터 베이스 오류
	}
	
	public int register(String mem_email,String mem_name,String mem_id,String mem_pw) {
		String sql = "insert into user values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem_email);
			psmt.setString(2, mem_name);
			psmt.setString(3, mem_id);
			psmt.setString(4, mem_pw);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1; // 데이터베이스 오류
		
	}
	
}



