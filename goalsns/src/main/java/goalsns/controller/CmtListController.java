package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.CmtVO;
import goalsns.model.PostDAO;

public class CmtListController implements Controller{

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PostDAO dao = new PostDAO();
		List<CmtVO> list = dao.selectAll();
		request.setAttribute("list", list);
		return "redirect:/main.do";
	}

}
