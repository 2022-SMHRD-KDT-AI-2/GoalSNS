package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.smhrd.entity.FollowVO;
import com.smhrd.entity.MemberVO;
import com.smhrd.entity.PostVO;
import com.smhrd.model.MemberDAO;
import com.smhrd.model.PostDAO;

public class PostContentfollowController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String to_mem = request.getParameter("follow_num");// ����� ���̵� 
		System.out.println(to_mem);
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String from_mem=(String)memvo.getMem_id(); // �ڽ��� ���̵�
		FollowVO fvo =new FollowVO();
		MemberDAO mdao=new MemberDAO();
		fvo.setTo_mem(to_mem);
		fvo.setFrom_mem(from_mem);
		//�ȷο�DB�� ����
		
		int follow=mdao.getFollow(fvo);
		if(follow==0) {
			mdao.follow(fvo);
			
			System.out.println(follow);
		} else {
			mdao.unFollow(fvo);
			System.out.println(follow);
		}
		int followcnt=mdao.followcount(fvo);
		int followercnt=mdao.followercount(fvo);
		System.out.println(followcnt);
		System.out.println(followercnt);
		JSONObject obj = new JSONObject();
		follow=mdao.getFollow(fvo);
		obj.put("follow",follow);
		obj.put("followcnt",followcnt);
		obj.put("followercnt",followercnt);
			
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
		
		return null;
	}

}
