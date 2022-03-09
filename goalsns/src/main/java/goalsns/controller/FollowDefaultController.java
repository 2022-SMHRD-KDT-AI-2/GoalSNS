package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.FollowVO;
import goalsns.model.MemberDAO;

public class FollowDefaultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FollowVO fvo=new FollowVO();
		MemberDAO dao=new MemberDAO();
		List<FollowVO> list=dao.followAll();
		return null;
	}

}
