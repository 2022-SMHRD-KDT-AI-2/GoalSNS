package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.model.MemberDAO;
import goalsns.model.PostDAO;

public class FollowController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String to_mem =request.getParameter("mem_id"); // 상대의 아이디
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String mem_id=(String)memvo.getMem_id(); // 자신의 아이디
		FollowVO fvo =new FollowVO();
		MemberDAO dao=new MemberDAO();
		fvo.setTo_mem(to_mem);
		fvo.setFrom_mem(mem_id);
		//팔로우DB에 저장
		dao.follow(fvo);
		
		return "redirect:/profile.do?mem_id="+to_mem;
		
	}
}
