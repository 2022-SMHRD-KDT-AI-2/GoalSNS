package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.MemChellVO;
import goalsns.entity.MemberVO;
import goalsns.model.PostDAO;

public class ChallRewardController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String mem_id = memvo.getMem_id();
		/*
		 * (1) 챌린지 해시태그 리스트 가져오기. (커다란 리스트)
		 * (2) 챌린지 해시태그 아이디에 관한 해당 로그인 유저의 월별 달성도 출력. (작은 리스트)
		 * (3) 챌린지 해시태그 아이디에 관한 해당 로그인 유저의 월별 달성표 출력. (작은 리스트)
		 * 리스트[ [해시태그아이디, 리워드1, 리워드2] [해시태아이디, 리워드1, 리워드2] ...] 
		 * 커다란 리스트 엔티티, 달성도 엔티티, 달성표 엔티티(이미 만듦)
		 */
		PostDAO pdao = new PostDAO();
		MemChellVO cvo = new MemChellVO();
		cvo.setMem_id(mem_id);
		List<Integer> chellList = pdao.챌린지해시태그리스트가져오는메소드(mem_id);
		for(int i=0; i<chellList.size(); i++) {
			커다란 리스트[i][0] = chellList[i];
			cvo.setChell_seq(chellList[i]);
			커다란 리스트[i][1] = dao.월별달성도에관한거가져오는리스트(cvo);
			커다란 리스트[i][2] = dao.월별달성표가져오는리스트(cvo);
		}
		request.setAttribute(커다란리스트, 커다란리스트);
		
		return "challReward";
		
	}

}
