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
		// ����� �α����� ������ �Խñ��� ��ȯ.
		// �ȷο� ���� �Ŀ��� �ȷο��� �������� �۱��� ��ȯ�ϰ�.
		PostDAO dao = new PostDAO();
		MemberDAO mdao = new MemberDAO();
		String mem_id = memvo.getMem_id();
		List<PostVO> list = dao.selectPosts(mem_id);
		String[] memImages = new String[list.size()];
		request.setAttribute("list", list);
		// -------------- ������ �̹���(��� ����) ----------------------
		for(int i=0; i<list.size(); i++) {
			memImages[i] = mdao.getMemberInfo(list.get(i).getMem_id()).getMem_img();
		}
		request.setAttribute("memImages", memImages);
		// -------------- ���ƿ� ���� -----------------------
		List<LikeCheckVO> likeCheck = dao.likeCheck(memvo);
		request.setAttribute("likeCheck", likeCheck);
		/*
		 * for(int i=0; i<likeCheck.size(); i++) {
		 * System.out.println(likeCheck.get(i).getLseq()); }
		 */
		// -------------- �α� ç���� �ؽ��±� -----------------------
		List<TrendVO> trend = dao.getTrend();
		request.setAttribute("trend", trend);
		
		// ------------------- ���� ��ŷ --------------------------
		List<String> rank = mdao.getMemRank();
		request.setAttribute("rank", rank);
		
		// ------------------- ��� ���� --------------------------
		CmtVO cvo = new CmtVO();
		int cmtCnt = 0;
		int[] cmtCntList = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			cvo.setPost_seq(list.get(i).getPost_seq());
			cmtCnt = dao.selectCmt(cvo).size();
			cmtCntList[i] = cmtCnt;
		}
		request.setAttribute("cmtCntList", cmtCntList);
		
		// ------------------- ���� �� ��� --------------------
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
