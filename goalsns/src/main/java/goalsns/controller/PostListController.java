package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.PostVO;
import goalsns.model.PostDAO;


public class PostListController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����� ��� ��ü �Խñۿ� ���� ����Ʈ ��ȯ.
		// ���߿��� �α����� ������ �Խñ��� ��ȯ�ϰ�.
		// �ȷο� ���� �Ŀ��� �ȷο��� �������� �۱��� ��ȯ�ϰ�.
		PostDAO dao = new PostDAO();
		List<PostVO> list = dao.selectPosts();
		request.setAttribute("list", list);
		return "main";
	}

}
