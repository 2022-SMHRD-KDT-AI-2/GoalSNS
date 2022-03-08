package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.model.PostDAO;

public class MainController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		// ����� �α����� ������ �Խñ��� ��ȯ.
		// �ȷο� ���� �Ŀ��� �ȷο��� �������� �۱��� ��ȯ�ϰ�.
		PostDAO dao = new PostDAO();
		String mem_id = memvo.getMem_id();
		List<PostVO> list = dao.selectPosts(mem_id);
		request.setAttribute("list", list);
		return "main";
	}

}