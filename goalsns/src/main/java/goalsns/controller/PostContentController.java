package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.CmtVO;
import goalsns.entity.PostVO;
import goalsns.model.PostDAO;

public class PostContentController implements Controller {
public String requestHandler(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	int post_seq = Integer.parseInt(request.getParameter("post_seq"));
	PostDAO dao = new PostDAO();
	PostVO vo = dao.getPostByIdx(post_seq);
	
	request.setAttribute("vo", vo);
	
	// ------------------- ´ñ±Û ¸®½ºÆ® --------------------------
	CmtVO cvo = new CmtVO();
	cvo.setPost_seq(post_seq);
	List<CmtVO> list = dao.selectCmt(cvo);
	request.setAttribute("list", list);
	
	return "postContent";
}
}
