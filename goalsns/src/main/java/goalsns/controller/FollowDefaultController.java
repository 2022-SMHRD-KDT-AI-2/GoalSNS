package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.model.MemberDAO;
import goalsns.model.PostDAO;

public class FollowDefaultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String to_mem=request.getParameter("mem_id");
		String id = (String)request.getParameter("mem_id");
		FollowVO fvo=new FollowVO();
		PostDAO pdao = new PostDAO();
		MemberDAO dao=new MemberDAO();
		FollowVO memfo=dao.getFollowInfo(to_mem);
		MemberVO mvo = dao.getMemberInfo(id);
		List<FollowVO> flist=dao.followAll();
		List<PostVO> postList = pdao.getMemberPosts(id);
		int postCnt = postList.size();
		if(memfo!=null) {
			System.out.println("팔로우되어있음");
			request.setAttribute("mvo", mvo);
			request.setAttribute("flist", flist);
			request.setAttribute("memfo", memfo);
			request.setAttribute("postList", postList);
			request.setAttribute("postCnt", postCnt);
			return "profile";
		} else {
			return "redirect:/follow.do";
		}
		
	}

}
