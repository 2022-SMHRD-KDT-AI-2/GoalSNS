package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.model.MemberDAO;
import goalsns.model.PostDAO;

public class UnFollowController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//������â�� ���̵�������
			String id = (String)request.getParameter("mem_id");
			//�α����� ����� ���̵�������
			HttpSession session=request.getSession();
			MemberVO memvo = (MemberVO)session.getAttribute("memvo");
			String from_mem=(String)memvo.getMem_id(); //�ڽ��� ���̵�
			//������â�� ���̵�������
			String to_mem=request.getParameter("mem_id"); //����� ���̵�
			FollowVO fvo=new FollowVO();
			MemberDAO dao=new MemberDAO();
			fvo.setTo_mem(to_mem);
			fvo.setFrom_mem(from_mem);
			dao.unFollow(fvo);
			
		 return "redirect:/profile.do?mem_id="+to_mem;
			
	}
	
}
