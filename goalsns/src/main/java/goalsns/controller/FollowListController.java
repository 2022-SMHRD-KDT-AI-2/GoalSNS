package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class FollowListController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//로그인한 사람 아이디가져오기
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String from_mem=(String)memvo.getMem_id();
		MemberDAO dao=new MemberDAO();
		FollowVO fvo=new FollowVO();
		//FollowVO에 저장
		fvo.setFrom_mem(from_mem);
		//DB에서 로그인한 사람의 아이디에 있는 팔로우한사람 리스트출력
		List<FollowVO> flist=dao.followAll(fvo);
		request.setAttribute("flist", flist);
		return "test3";
	}

}
