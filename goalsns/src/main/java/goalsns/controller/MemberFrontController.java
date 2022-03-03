package goalsns.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
=======
import goalsns.controller.Controller;
import goalsns.controller.HandlerMapping;
import goalsns.controller.ViewResolver;
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-2/GoalSNS.git
import goalsns.model.MemberDAO;

public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqpath=request.getRequestURI();
		String cpath=request.getContextPath();
		String command=reqpath.substring(cpath.length());
		
		//2. 요청에 따른 분기작업(if~else)
		MemberDAO dao=new MemberDAO();
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

<<<<<<< HEAD
}
=======
	}
}
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-2/GoalSNS.git
