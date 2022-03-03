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
		
		//Ŭ���̾�Ʈ�� ��û�� Ȯ��(�ľ�)�ϴ� �۾�.
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
		
		//���⼭ nextView�� ������ ���� forward �Ǵ� redirect �ϱ�.
		if(nextView != null) {
			if(nextView.indexOf("redirect:")!=-1) {
				nextView = nextView.split(":")[1];
				response.sendRedirect("/goalsns"+nextView);
			}
			else {
				//���� ������ �̸� -> ���� �������� �̸�(���)�� �����Ű�� API : ViewResolver
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeURL(nextView));
				rd.forward(request, response);
			}
		}
	}

}
