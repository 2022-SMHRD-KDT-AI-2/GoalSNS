package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.model.MemberDAO;

public class UserRegisterController extends HttpServlet{
	//private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String mem_email = request.getParameter("mem_email");
		String mem_name = request.getParameter("mem_name");
		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");
		// �Ķ���� ���� ������Ȳ �޽��� ���
		if (mem_email == null || mem_email.equals("") || mem_name == null || mem_name.equals("") ||
				mem_id == null || mem_id.equals("") || mem_pw == null || mem_pw.equals("")) {
			request.getSession().setAttribute("messageType", "�����޽���");
			request.getSession().setAttribute("messageContent", "��� ������ �Է��ϼ���.");
			response.sendRedirect("signUp.jsp");
			return;
		}
		int result = new MemberDAO().register(mem_email,mem_name,mem_id,mem_pw);
		if(result == 1) {
			request.getSession().setAttribute("messageType", "�����޽���");
			request.getSession().setAttribute("messageContent", "ȸ�����Կ� �����߽��ϴ�.");
			response.sendRedirect("signUp.jsp");
		} else {
			request.getSession().setAttribute("messageType", "�����޽���");
			request.getSession().setAttribute("messageContent", "�̹� �����ϴ� ȸ���Դϴ�.");
			response.sendRedirect("signUp.jsp");
		}
	}

}
