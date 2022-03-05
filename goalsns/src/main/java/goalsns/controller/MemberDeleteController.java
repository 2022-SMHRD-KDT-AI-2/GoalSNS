package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.model.MemberDAO;

public class MemberDeleteController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mem_pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		dao.memberDelete(mem_pw);
		return "index";
		 
	}
}
