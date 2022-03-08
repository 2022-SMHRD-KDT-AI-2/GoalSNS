package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class FollowController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo"); // 자신의 아이디
		String from_mem=(String)memvo.getMem_id();
		String to_mem = request.getParameter("123"); // 상대의 아이디
		FollowVO fvo =new FollowVO();
		MemberVO mvo=new MemberVO();
		MemberDAO dao=new MemberDAO();
		mvo.setMem_id(to_mem);
		dao.follow(to_mem);
		mvo.setMem_id(from_mem);
		dao.followed(from_mem);
		return "main";
	}

}
