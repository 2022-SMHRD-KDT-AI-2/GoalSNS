package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class IdCheckController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mem_id=request.getParameter("id");
		MemberVO vo=new MemberVO();
		MemberDAO dao=new MemberDAO();
		vo.setMem_id(mem_id);
		MemberVO idck=dao.idCheck(vo);
		request.setAttribute("idck", idck);
		System.out.println(mem_id);
		System.out.println(mem_id);
		return "signUp";
	}

}
