package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.smhrd.entity.LikeVO;
import com.smhrd.entity.MemberVO;
import com.smhrd.model.PostDAO;

public class LikeTestController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String mem_id = memvo.getMem_id();
		
		int bno = Integer.parseInt(request.getParameter("board_num"));
		System.out.println("bno:"+bno);
		PostDAO dao = new PostDAO(); //보드넘에 대한 보드의 객체
		LikeVO vo = new LikeVO();
		vo.setPost_seq(bno);
		vo.setMem_id(mem_id);
		
		
		int like = dao.selectLike(vo).size();
		System.out.println("like 개수:"+ like);
		if(like != 0) {
			dao.likeDelete(vo); //삭제
			System.out.println("삭제");
		}
		else {
			dao.like(vo); //삽입
			System.out.println("삽입");
		}
		like = dao.selectLike(vo).size();
		JSONObject obj = new JSONObject();
		obj.put("like",like);
		obj.put("post_seq", bno);
		//request.setAttribute("json", json);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);

		return null;
	}

}
