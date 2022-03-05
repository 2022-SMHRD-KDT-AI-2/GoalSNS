package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class MemberLogoutController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		System.out.print(session);
		if(session!=null) {
			session.invalidate();
			System.out.print("로그아웃성공");
			return "index";
		} else {
			return "main";
		}
		
	}
	
}
