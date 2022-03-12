package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.LikeVO;
import goalsns.entity.MemberVO;
import goalsns.model.PostDAO;

public class PostLikeController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo"); 
		String mem_id=(String)memvo.getMem_id();
		
		int post_seq = Integer.parseInt(request.getParameter("post_seq"));
		
		LikeVO vo = new LikeVO();
		vo.setPost_seq(post_seq); 
		vo.setMem_id(mem_id);
		
		PostDAO dao = new PostDAO();
		dao.like(vo);
		
		return "redirect:/postContent.do?post_seq="+post_seq;
	}

}
