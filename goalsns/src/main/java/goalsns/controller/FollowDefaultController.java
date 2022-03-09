package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class FollowDefaultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String to_mem=request.getParameter("mem_id");
		String id = (String)request.getParameter("mem_id");
		FollowVO fvo=new FollowVO();
		MemberDAO dao=new MemberDAO();
		FollowVO memfo=dao.getFollowInfo(to_mem);
		MemberVO mvo = dao.getMemberInfo(id);
		List<FollowVO> flist=dao.followAll();
		if(memfo!=null) {
			System.out.println("팔로우되어있음");
			request.setAttribute("mvo", mvo);
			request.setAttribute("flist", flist);
			request.setAttribute("fvo", fvo);
			return "profile";
		} else {
			return "redirect:/follow.do";
		}
		
	}

}
