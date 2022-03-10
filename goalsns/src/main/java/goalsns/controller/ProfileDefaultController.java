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

public class ProfileDefaultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ȷο�, �ȷο� �� + �Խù� ��
		//String id = "test1";
		String id = (String)request.getParameter("mem_id");
		String to_mem=request.getParameter("mem_id");
		MemberDAO mdao = new MemberDAO();
		PostDAO pdao = new PostDAO();
		FollowVO fvo=new FollowVO();
		MemberVO mvo = mdao.getMemberInfo(id);
		FollowVO memfo=mdao.getFollowInfo(to_mem);
		List<PostVO> postList = pdao.getMemberPosts(id);
		int postCnt = postList.size();
		request.setAttribute("postList", postList);
		request.setAttribute("postCnt", postCnt);
		request.setAttribute("mvo", mvo);
		request.setAttribute("memfo", memfo);
		return "profile";
	}

}
