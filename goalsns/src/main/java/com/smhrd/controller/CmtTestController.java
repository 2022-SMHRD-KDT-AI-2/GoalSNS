package com.smhrd.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.smhrd.entity.CmtVO;
import com.smhrd.entity.MemberVO;
import com.smhrd.model.MemberDAO;
import com.smhrd.model.PostDAO;

public class CmtTestController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo"); 
		String mem_id=(String)memvo.getMem_id();
		
		int post_seq = Integer.parseInt(request.getParameter("post_seq"));
		String cmt_content = request.getParameter("content");
		
		CmtVO vo = new CmtVO();
		vo.setPost_seq(post_seq); 
		vo.setMem_id(mem_id);
		vo.setCmt_content(cmt_content);
		
		PostDAO dao = new PostDAO();
		dao.cmt(vo);
		MemberDAO mdao = new MemberDAO();
		int cmtCnt = dao.selectCmt(vo).size();
		String writerImg = mdao.getMemberInfo(vo.getMem_id()).getMem_img();
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		Date date = new Date();        
		String dateToStr = dateFormat.format(date);
		JSONObject obj = new JSONObject();
		obj.put("mem_id", mem_id);
		obj.put("post_seq", post_seq);
		obj.put("cmtCnt", cmtCnt);
		obj.put("cmt_date", dateToStr);
		obj.put("writerImg", writerImg);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
		
		return null;
	}

}
