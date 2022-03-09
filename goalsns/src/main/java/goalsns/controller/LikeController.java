package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.CmtVO;
import goalsns.entity.LikeVO;
import goalsns.model.MemberDAO;

public class LikeController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int like_seq = Integer.parseInt(request.getParameter("seq"));
		String mem_id = request.getParameter("id");
		
		return "postContent";


	}
}
