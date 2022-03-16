package com.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.entity.FollowVO;
import com.smhrd.entity.MemberVO;
import com.smhrd.entity.PostVO;
import com.smhrd.model.MemberDAO;
import com.smhrd.model.PostDAO;

public class FollowedProfileController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String to_mem =request.getParameter("mem_id");
		
		return "redirect:/profile.do?mem_id="+to_mem;
	}

}
