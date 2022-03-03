package goalsns.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.controller.Controller;
import goalsns.controller.HandlerMapping;
import goalsns.controller.ViewResolver;
import goalsns.model.PostDAO;

/**
 * Servlet implementation class PostFrontController
 */
@WebServlet("*.po")
public class PostFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//클라이언트의 요청을 확인(파악)하는 작업.
		String reqPath = request.getRequestURI(); 
		String cpath = request.getContextPath(); 
		
		String command = reqPath.substring(cpath.length());
		System.out.println(command);
		
		PostDAO dao = new PostDAO();
		
		String nextView = null;
		Controller controller = null;
		//HandlerMapping
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextView = controller.requestHandler(request, response);
		
		//여기서 nextView의 정보를 보고 forward 또는 redirect 하기.
		if(nextView != null) {
			if(nextView.indexOf("redirect:")!=-1) {
				nextView = nextView.split(":")[1];
				response.sendRedirect("/goalsns"+nextView);
			}
			else {
				//뷰의 논리적인 이름 -> 뷰의 물리적인 이름(경로)로 변경시키는 API : ViewResolver
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeURL(nextView));
				rd.forward(request, response);
			}
		}
	}

}
