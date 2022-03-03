package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.model.MemberDAO;
import goalsns.controller.Controller;
import goalsns.entity.MemberVO;

public class UserRegisterController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mem_id = request.getParameter("id");
		String mem_pw = request.getParameter("pw");
		String mem_email = request.getParameter("email");
		String mem_name = request.getParameter("name");
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(mem_id);
		vo.setMem_pw(mem_pw);
		vo.setMem_email(mem_email);
		vo.setMem_name(mem_name);
		
		MemberDAO dao = new MemberDAO();
		dao.register(vo);
		return "redirect:/signUp.jsp";
		
	}
	
}
