package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;
import goalsns.model.ProfileDAO;

public class ProfileDefaultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����� ���̵� �Խù� ���� �ȷο��� �ȷο� �� ��ٿ� ������ �̹��� �Խñ� ���
		String id = "test1";
		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();
		mvo = mdao.selectProfile(id);
		
		ProfileDAO dao = new ProfileDAO();
		return "profile";
	}

}
