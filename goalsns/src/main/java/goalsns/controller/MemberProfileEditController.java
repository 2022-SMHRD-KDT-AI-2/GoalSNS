package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class MemberProfileEditController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberVO vo=new MemberVO();
		String mem_name=request.getParameter("mem_name");
		String mem_id=request.getParameter("mem_id");
		String mem_about=request.getParameter("mem_about");
		String mem_email=request.getParameter("mem_email");
		vo.setMem_name(mem_name);
		vo.setMem_id(mem_id);
		vo.setMem_about(mem_about);
		vo.setMem_email(mem_email);
		MemberDAO dao=new MemberDAO();
		dao.profileEdit(vo);
		request.setAttribute("vo", vo);
		return "main";
	}

}
