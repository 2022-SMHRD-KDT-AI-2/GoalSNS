package goalsns.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.CmtVO;
import goalsns.model.MemberDAO;

public class CmtController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mem_id = request.getParameter("id");
		String cmt_content = request.getParameter("content");
		//Date cmt_date = request.getParameter("date");
		
		CmtVO vo = new CmtVO();
		vo.setMem_id(mem_id);
		vo.setCmt_content(cmt_content);
		//vo.setCmt_date(cmt_date);
		
		MemberDAO dao = new MemberDAO();
		dao.cmt(vo);
		
		return "postContent";

	}

}
