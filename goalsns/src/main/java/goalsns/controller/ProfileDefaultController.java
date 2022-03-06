package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;
import goalsns.model.ProfileDAO;

public class ProfileDefaultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//사용자 아이디 게시물 갯수 팔로워수 팔로우 수 어바웃 프로필 이미지 게시글 목록
		String id = "test1";
		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();
		mvo = mdao.selectProfile(id);
		
		ProfileDAO dao = new ProfileDAO();
		return "profile";
	}

}
