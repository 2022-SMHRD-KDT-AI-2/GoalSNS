package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class ProfileEditController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberVO vo=new MemberVO();
		String mem_id=(String)request.getParameter("mem_id");
		MemberDAO dao=new MemberDAO();
		MemberVO memvo=dao.getByMemId(mem_id);
		request.setAttribute("memvo", memvo);
		return "profileEdit";
	}

}
