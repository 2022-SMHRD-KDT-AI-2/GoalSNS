package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.FollowVO;
import goalsns.model.MemberDAO;

public class UnFollowController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String to_mem=request.getParameter("mem_id");
			FollowVO fvo=new FollowVO();
			MemberDAO dao=new MemberDAO();
			fvo.setTo_mem(to_mem);
			dao.unFollow(fvo);
		return "profile";
	}
	
}
