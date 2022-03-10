package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.FollowVO;
import goalsns.model.MemberDAO;

public class FollowListController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDAO dao=new MemberDAO();
		List<FollowVO> flist=dao.followAll();
		request.setAttribute("flist", flist);
		return "test3";
	}

}
