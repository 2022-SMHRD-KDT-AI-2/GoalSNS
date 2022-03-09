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
		String from_mem=request.getParameter("mem_id"); // 상대의 아이디
		String to_mem = request.getParameter("mem_id"); // 상대의 아이디
		FollowVO fvo =new FollowVO();
		MemberDAO dao=new MemberDAO();
		fvo.setTo_mem(to_mem);
		fvo.setFrom_mem(from_mem);
		if(mem_id)
		dao.follow(fvo);
		System.out.println("팔로우성공");
		return "main";
	}

}
