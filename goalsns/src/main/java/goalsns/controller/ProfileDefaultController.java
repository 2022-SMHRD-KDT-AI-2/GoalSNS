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

public class ProfileDefaultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//팔로우, 팔로워 수 + 게시물 수
		//String id = "test1";
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String id = (String)request.getParameter("mem_id");
		String from_mem=(String)memvo.getMem_id();
		MemberDAO mdao = new MemberDAO();
		PostDAO pdao = new PostDAO();
		FollowVO fvo=new FollowVO();
		fvo.setTo_mem(id);
		fvo.setFrom_mem(from_mem);
		MemberVO mvo = mdao.getMemberInfo(id);
		List<FollowVO> memfo=mdao.getFollowInfo(fvo);
		List<FollowVO> followlist=mdao.followAll(fvo);
		List<FollowVO> followedlist=mdao.followedAll(fvo);
		List<PostVO> postList = pdao.getMemberPosts(id);
		int postCnt = postList.size();
		request.setAttribute("postList", postList);
		request.setAttribute("postCnt", postCnt);
		request.setAttribute("mvo", mvo);
		request.setAttribute("memfo", memfo);
		request.setAttribute("followlist", followlist);
		request.setAttribute("followedlist", followedlist);
		System.out.println(mvo);
		System.out.println(memvo);
		return "profile";
	}

}
