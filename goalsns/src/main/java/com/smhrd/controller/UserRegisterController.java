package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.controller.Controller;
import com.smhrd.entity.MemberVO;
import com.smhrd.model.MemberDAO;

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
		
		return "../index";

	}
	
}
