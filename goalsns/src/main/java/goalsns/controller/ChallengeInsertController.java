package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.ChellVO;
import goalsns.model.PostDAO;

public class ChallengeInsertController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chell_name = request.getParameter("chell_name");
		//챌린지 해시태그 이름이 기존에 있다면 오류 메세지를 띄워야할듯...
		ChellVO vo = new ChellVO();
		vo.setChell_name(chell_name);
		PostDAO dao = new PostDAO();
		dao.ChallInsert(vo);
		return null;
	}

}
