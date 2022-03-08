package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class MemberDeleteController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mem_pw = request.getParameter("pw");
		String test4 = "test4";
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(test4);
		vo.setMem_pw(mem_pw);
		
		MemberDAO dao = new MemberDAO();
		MemberVO memvo=dao.memberDelete(vo);
		HttpSession session=request.getSession();
		session.setAttribute("memvo", memvo);
		return "index";
		 
	}
}
