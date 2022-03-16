package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import goalsns.entity.CmtVO;
import goalsns.entity.MemberVO;
import goalsns.model.PostDAO;

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
		
		int cmtCnt = dao.selectCmt(vo).size();
		
		JSONObject obj = new JSONObject();
		obj.put("mem_id", mem_id);
		obj.put("post_seq", post_seq);
		obj.put("cmtCnt", cmtCnt);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
		
		return null;
	}

}
