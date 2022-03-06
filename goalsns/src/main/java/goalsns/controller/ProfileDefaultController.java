package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.model.MemberDAO;
import goalsns.model.PostDAO;

public class ProfileDefaultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = "test1";
		MemberDAO mdao = new MemberDAO();
		PostDAO pdao = new PostDAO();
		MemberVO mvo = mdao.getMemberInfo(id);
		List<PostVO> postList = pdao.getMemberPosts(id);
		request.setAttribute("postList", postList);
		request.setAttribute("mvo", mvo);
		return "profile";
	}

}
