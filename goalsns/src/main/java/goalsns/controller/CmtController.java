package goalsns.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.CmtVO;
import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class CmtController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo"); 
		String mem_id=(String)memvo.getMem_id();
		int cmt_seq = Integer.parseInt(request.getParameter("cmt_seq"));
		String cmt_content = request.getParameter("content");
		
		CmtVO vo = new CmtVO();
		vo.setCmt_seq(cmt_seq);
		vo.setMem_id(mem_id);
		vo.setCmt_content(cmt_content);
		
		MemberDAO dao = new MemberDAO();
		dao.cmt(vo);
		
		return "mainTest";

	}

}
