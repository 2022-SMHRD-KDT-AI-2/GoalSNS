package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.model.ChallDAO;

public class ChallengeInsertController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chell_name = request.getParameter("chell_name");
		int chell_term = Integer.parseInt(request.getParameter("chell_term"));
		ChallDAO dao = new ChallDAO();
		return null;
	}

}
