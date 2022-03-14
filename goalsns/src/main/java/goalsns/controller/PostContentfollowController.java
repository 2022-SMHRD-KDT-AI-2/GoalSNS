package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.model.MemberDAO;
import goalsns.model.PostDAO;

public class PostContentfollowController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String to_mem = request.getParameter("follow_num");// 상대의 아이디 
		System.out.println(to_mem);
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String from_mem=(String)memvo.getMem_id(); // 자신의 아이디
		FollowVO fvo =new FollowVO();
		MemberDAO mdao=new MemberDAO();
		fvo.setTo_mem(to_mem);
		fvo.setFrom_mem(from_mem);
		
		//팔로우DB에 저장
		int follow=mdao.getFollow(fvo);
		if(follow==0) {
			mdao.follow(fvo);
			System.out.println(follow);
		} else {
			mdao.unFollow(fvo);
			System.out.println(follow);
		}
		JSONObject obj = new JSONObject();
		obj.put("follow",follow);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
		
		return null;
	}

}
