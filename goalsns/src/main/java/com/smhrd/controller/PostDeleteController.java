package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.PostDAO;

public class PostDeleteController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//해당 포스트의 아이디값을 가져와야함. (+) 이 포스트의 작성자만이 해당 포스트를 삭제할 수 있음.
		int post_seq = Integer.parseInt(request.getParameter("post_seq"));
		PostDAO dao = new PostDAO();
		dao.postDelete(post_seq);
		return "redirect:/postList.do";
	}

}
