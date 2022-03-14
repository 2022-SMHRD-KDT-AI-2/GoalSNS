package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.model.MemberDAO;
import goalsns.model.PostDAO;

public class PostContentfollowController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String to_mem = request.getParameter("follow_num");// 상대의 아이디 
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String from_mem=(String)memvo.getMem_id(); // 자신의 아이디
		FollowVO fvo =new FollowVO();
		MemberDAO mdao=new MemberDAO();
		fvo.setTo_mem(to_mem);
		fvo.setFrom_mem(from_mem);
		//팔로우DB에 저장
		mdao.follow(fvo);
		
		return null;
	}

}
