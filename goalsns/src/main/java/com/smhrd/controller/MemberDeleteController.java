package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.entity.MemberVO;
import com.smhrd.model.MemberDAO;

public class MemberDeleteController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String Mem_id=(String)memvo.getMem_id();
		String mem_pw = request.getParameter("mem_pw");
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(Mem_id);
		vo.setMem_pw(mem_pw);
		
		MemberDAO dao = new MemberDAO();
		dao.memberDelete(vo);
		return "index";
		 
	}
}
