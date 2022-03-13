package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.CmtVO;
import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.model.MemberDAO;
import goalsns.model.PostDAO;

public class PostContentController implements Controller {
public String requestHandler(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	int post_seq = Integer.parseInt(request.getParameter("post_seq"));
	HttpSession session=request.getSession();
	MemberVO memvo = (MemberVO)session.getAttribute("memvo");
	String to_mem=(String)memvo.getMem_id();
	MemberDAO mdao=new MemberDAO();
	FollowVO fvo = new FollowVO();
	PostDAO dao = new PostDAO();
	PostVO vo = dao.getPostByIdx(post_seq);
	
	fvo.setTo_mem(vo.getMem_id());
	fvo.setFrom_mem(to_mem);
	FollowVO tfvo=mdao.getfollowid(fvo);
	request.setAttribute("vo", vo);
	request.setAttribute("tfvo", tfvo);
	// ------------------- ´ñ±Û ¸®½ºÆ® --------------------------
	CmtVO cvo = new CmtVO();
	cvo.setPost_seq(post_seq);
	List<CmtVO> list = dao.selectCmt(cvo);
	request.setAttribute("list", list);
	
	return "postContent";
}
}
