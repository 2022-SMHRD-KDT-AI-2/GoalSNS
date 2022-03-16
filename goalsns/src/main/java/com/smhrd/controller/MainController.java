package com.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.entity.CmtVO;
import com.smhrd.entity.LikeCheckVO;
import com.smhrd.entity.MemberVO;
import com.smhrd.entity.PostVO;
import com.smhrd.entity.TrendVO;
import com.smhrd.model.MemberDAO;
import com.smhrd.model.PostDAO;

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
		
		// ------------------- 댓글 개수 --------------------------
		CmtVO cvo = new CmtVO();
		int cmtCnt = 0;
		int[] cmtCntList = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			cvo.setPost_seq(list.get(i).getPost_seq());
			cmtCnt = dao.selectCmt(cvo).size();
			cmtCntList[i] = cmtCnt;
		}
		request.setAttribute("cmtCntList", cmtCntList);
		
		// ------------------- 내가 쓴 댓글 --------------------
		cvo.setMem_id(mem_id);
		String[] cmtList = new String[list.size()];
		String cmt;
		for(int i=0; i<list.size(); i++) {
			cvo.setPost_seq(list.get(i).getPost_seq());
			if(dao.getMyCmt(cvo) != null)
				cmt = dao.getMyCmt(cvo).getCmt_content();
			else
				cmt = null;
			cmtList[i] = cmt;
			System.out.println("cmtList[i]:"+cmtList[i]);
		}
		request.setAttribute("cmtList", cmtList);
		
		return "main";
		
	}

}
