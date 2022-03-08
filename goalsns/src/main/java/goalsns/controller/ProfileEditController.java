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
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		MemberDAO dao=new MemberDAO();
		MemberVO vo=new MemberVO();
		MemberVO mem_vo=dao.getByMemId(vo);
		request.setAttribute("mem_vo", mem_vo);
		return "profileEdit";
	}

}
