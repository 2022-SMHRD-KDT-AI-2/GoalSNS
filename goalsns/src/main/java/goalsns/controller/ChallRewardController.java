package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.MemberVO;

public class ChallRewardController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		/*
		 * (1) ç���� �ؽ��±� ����Ʈ ��������. (Ŀ�ٶ� ����Ʈ)
		 * (2) ç���� �ؽ��±� ���̵� ���� �ش� �α��� ������ ���� �޼��� ���. (���� ����Ʈ)
		 * (3) ç���� �ؽ��±� ���̵� ���� �ش� �α��� ������ ���� �޼�ǥ ���. (���� ����Ʈ)
		 * ����Ʈ[ [�ؽ��±׾��̵�, ������1, ������2] [�ؽ��¾��̵�, ������1, ������2] ...] 
		 */
		
		return null;
	}

}
