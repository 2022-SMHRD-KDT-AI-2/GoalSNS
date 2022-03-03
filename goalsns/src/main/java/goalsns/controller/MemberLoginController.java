package goalsns.controller;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.controller.Controller;

public class MemberLoginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberVO vo=new MemberVO();
		
		MemberDAO mdao=new MemberDAO();
		String mem_id=request.getParameter("mem_id");
		String mem_pw=request.getParameter("mem_pw");
		MemberVO vo_id=mdao.memberIdCheck(mem_id);
		MemberVO vo_pw=mdao.memberPwCheck(mem_pw);
		request.setAttribute("vo_id", vo_id);
		request.setAttribute("vo_pw", vo_pw);
		if (mem_id.equals(vo_id) && mem_pw.equals(vo_pw)) {
			System.out.print("로그인 성공");
			return "index";
		}
		
		return "index";
	}
	
}
