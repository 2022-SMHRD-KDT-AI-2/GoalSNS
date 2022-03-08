package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class FollowController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FollowVO fvo =new FollowVO();
		MemberVO mvo=new MemberVO();
		String memid=request.getParameter("aaaa");
		String memid1=request.getParameter("123");
		mvo.setMem_id(memid1);
		fvo.setTo_mem(memid1);
		MemberDAO dao=new MemberDAO();
		dao.follow(mvo);
		return "main";
	}

}
