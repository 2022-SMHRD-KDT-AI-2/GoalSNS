package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.model.PostDAO;

public class LikeDeleteController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int like_seq = Integer.parseInt(request.getParameter("like_seq"));
		PostDAO dao = new PostDAO();
		dao.likeDelete(like_seq);
		return "main";
	}

}
