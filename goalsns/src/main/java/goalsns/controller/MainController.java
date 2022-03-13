package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.LikeCheckVO;
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
		MemberDAO mdao = new MemberDAO();
		String mem_id = memvo.getMem_id();
		List<PostVO> list = dao.selectPosts(mem_id);
		String[] memImages = new String[list.size()];
		request.setAttribute("list", list);
		// -------------- 프로필 이미지(멤버 정보) ----------------------
		for(int i=0; i<list.size(); i++) {
			memImages[i] = mdao.getMemberInfo(list.get(i).getMem_id()).getMem_img();
		}
		request.setAttribute("memImages", memImages);
		// -------------- 좋아요 여부 -----------------------
		List<LikeCheckVO> likeCheck = dao.likeCheck(memvo);
		request.setAttribute("likeCheck", likeCheck);
		/*
		 * for(int i=0; i<likeCheck.size(); i++) {
		 * System.out.println(likeCheck.get(i).getLseq()); }
		 */
		// -------------- 인기 챌린지 해시태그 -----------------------
		List<TrendVO> trend = dao.getTrend();
		request.setAttribute("trend", trend);
		
		// ------------------- 유저 랭킹 --------------------------
		List<String> rank = mdao.getMemRank();
		request.setAttribute("rank", rank);
		return "main";
		
	}

}
