package goalsns.controller;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.controller.Controller;

public class MemberLoginController implements Controller {
	
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String mem_id=request.getParameter("mem_id");
		String mem_pw=request.getParameter("mem_pw");
		MemberVO vo=new MemberVO();
		vo.setMem_id(mem_id);
		vo.setMem_pw(mem_pw);
		MemberDAO dao=new MemberDAO();
		MemberVO memvo=dao.Login(vo);
		if(memvo!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("memvo", memvo);
			System.out.print("로그인성공");
			System.out.print(session);

			return "redirect:/main.do";
		} else {
			System.out.print("로그인실패");

			return "index";
	}
	
}
