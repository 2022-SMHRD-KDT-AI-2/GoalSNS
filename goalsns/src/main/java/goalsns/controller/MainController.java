package goalsns.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.entity.TrendVO;
import goalsns.model.MemberDAO;
import goalsns.model.PostDAO;

public class MainController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		// 현재는 로그인한 유저의 게시글을 반환.
		// 팔로우 구현 후에는 팔로우한 유저들의 글까지 반환하게.
		PostDAO dao = new PostDAO();
		String mem_id = memvo.getMem_id();
		List<PostVO> list = dao.selectPosts(mem_id);
		request.setAttribute("list", list);
		// -------------- 좋아요 여부 -----------------------

		// -------------- 인기 챌린지 해시태그 -----------------------
		List<TrendVO> trend = dao.getTrend();
		request.setAttribute("trend", trend);
		
		// ------------------- 유저 랭킹 --------------------------
		MemberDAO mdao = new MemberDAO();
		List<String> rank = mdao.getMemRank();
		request.setAttribute("rank", rank);
		return "main";
		
	}

}
