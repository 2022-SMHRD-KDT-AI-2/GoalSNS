package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class FollowController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo"); 
		String from_mem=(String)memvo.getMem_id(); // �ڽ��� ���̵�
		String to_mem = request.getParameter("mem_id"); // ����� ���̵�
		FollowVO fvo =new FollowVO();
		MemberDAO dao=new MemberDAO();
		fvo.setTo_mem(to_mem);
		dao.follow(fvo);
		fvo.setFrom_mem(from_mem);
		dao.followed(fvo);
		System.out.println("�ȷο켺��");
		System.out.println(to_mem);
		System.out.println(from_mem);
		return "main";
	}

}
