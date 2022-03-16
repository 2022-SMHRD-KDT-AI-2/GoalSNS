package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.controller.Controller;
import com.smhrd.controller.HandlerMapping;
import com.smhrd.controller.ViewResolver;
import com.smhrd.model.MemberDAO;
import com.smhrd.model.PostDAO;

public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String reqpath=request.getRequestURI();
		String cpath=request.getContextPath();
		String command=reqpath.substring(cpath.length());
		System.out.println(command);
		MemberDAO dao = new MemberDAO();
		//***View에 경로를 지정하는 변수***
		String nextVew=null;
		Controller controller=null;
		HandlerMapping mapping=new HandlerMapping();
		controller=mapping.getController(command);
		nextVew=controller.requestHandler(request, response);
		//_if_ 
		// 여기서 nextView의 정보를 보고 -> forward or redirect를 하기
		if(nextVew!=null) {
			if(nextVew.indexOf("redirect:")!=-1) {
				nextVew=nextVew.split(":")[1];
				response.sendRedirect("/goalsns"+nextVew); // 1. redirect
			} else {
				//뷰의논리적인이름(boardList)->뷰의물리적인이름(경로)으로 변경시키는 API : viewResolver
				RequestDispatcher rd=request.getRequestDispatcher(ViewResolver.makeURL(nextVew));
				rd.forward(request, response); // 2. forward	
			}
	}
	}
}
