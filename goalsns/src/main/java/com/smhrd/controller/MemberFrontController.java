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
		//***View�� ��θ� �����ϴ� ����***
		String nextVew=null;
		Controller controller=null;
		HandlerMapping mapping=new HandlerMapping();
		controller=mapping.getController(command);
		nextVew=controller.requestHandler(request, response);
		//_if_ 
		// ���⼭ nextView�� ������ ���� -> forward or redirect�� �ϱ�
		if(nextVew!=null) {
			if(nextVew.indexOf("redirect:")!=-1) {
				nextVew=nextVew.split(":")[1];
				response.sendRedirect("/goalsns"+nextVew); // 1. redirect
			} else {
				//���ǳ������̸�(boardList)->���ǹ��������̸�(���)���� �����Ű�� API : viewResolver
				RequestDispatcher rd=request.getRequestDispatcher(ViewResolver.makeURL(nextVew));
				rd.forward(request, response); // 2. forward	
			}
	}
	}
}
