package goalsns.controller;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.controller.Controller;

public class MemberLoginController implements Controller {
	
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberVO vo=new MemberVO();
		
		MemberDAO mdao=new MemberDAO();
		String mem_id=request.getParameter("mem_id");
		String mem_pw=request.getParameter("mem_pw");
		MemberVO vo_id=(MemberVO)mdao.memberIdCheck(mem_id);
		MemberVO vo_pw=(MemberVO)mdao.memberPwCheck(mem_pw);
		if (mem_id.equals(vo_id) && mem_pw.equals(vo_pw)) {
			return "main";
		}
		
		return "main";
	}
	
}
