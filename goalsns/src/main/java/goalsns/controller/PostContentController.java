package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.PostVO;
import goalsns.model.PostDAO;

public class PostContentController implements Controller {
public String requestHandler(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	int post_seq = Integer.parseInt(request.getParameter("post_seq"));
	PostDAO dao = new PostDAO();
	PostVO vo = dao.getPostByIdx(post_seq);
	
	request.setAttribute("vo", vo);
	return "postContent";
}
}
