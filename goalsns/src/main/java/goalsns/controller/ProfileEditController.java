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
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String id=(String)memvo.getMem_id();
		MemberDAO dao=new MemberDAO();
		MemberVO vo=new MemberVO();
		vo.setMem_id(id);
		MemberVO mem_vo=dao.getByMemId(id);
		request.setAttribute("mem_vo", mem_vo);
		request.setAttribute("memvo", memvo);
		request.setAttribute("vo", vo);
		System.out.println(id);
		return "profileEdit";
	}

}
