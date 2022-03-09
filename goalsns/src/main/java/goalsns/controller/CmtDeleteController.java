package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.model.PostDAO;

public class CmtDeleteController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int cmt_seq = Integer.parseInt(request.getParameter("cmt_seq"));
		PostDAO dao = new PostDAO();
		dao.cmtDelete(cmt_seq);
		return "main";
	}

}
