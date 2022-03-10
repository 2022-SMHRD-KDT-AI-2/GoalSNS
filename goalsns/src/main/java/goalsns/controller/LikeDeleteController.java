package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.LikeVO;
import goalsns.entity.MemberVO;
//import goalsns.entity.LikeVO;
import goalsns.model.PostDAO;

public class LikeDeleteController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		HttpSession session=request.getSession();
//		MemberVO memvo = (MemberVO)session.getAttribute("memvo"); 
//		String mem_id=(String)memvo.getMem_id();
//		
		LikeVO vo = new LikeVO();
		int post_seq = Integer.parseInt(request.getParameter("post_seq"));
		//vo.setMem_id(mem_id);
		PostDAO dao = new PostDAO();
		dao.likeDelete(post_seq);
		return "redirect:/main.do";
	}

}
