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

public class FollowController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = (String)request.getParameter("mem_id");
		String to_mem =request.getParameter("mem_id"); // 상대의 아이디
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		FollowVO fvo =new FollowVO();
		MemberDAO dao=new MemberDAO();
		String from_mem=(String)memvo.getMem_id(); // 자신의 아이디
		fvo.setTo_mem(to_mem);
		fvo.setFrom_mem(from_mem);
		//팔로우DB에 저장
		dao.follow(fvo);
		PostDAO pdao = new PostDAO();
		List<FollowVO> memfo=dao.getFollowInfo(fvo);
		MemberVO mvo = dao.getMemberInfo(id);
		List<PostVO> postList = pdao.getMemberPosts(to_mem);
		int postCnt = postList.size();
		request.setAttribute("mvo", mvo);
		request.setAttribute("memfo", memfo);
		request.setAttribute("postList", postList);
		request.setAttribute("postCnt", postCnt);
		return "profile";
	}
}
