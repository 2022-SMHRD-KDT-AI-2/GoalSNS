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
		CmtVO vo = new CmtVO();
		List<CmtVO> list = dao.selectAll(vo);
		request.setAttribute("list", list);
		
		return "main";
	}

}
