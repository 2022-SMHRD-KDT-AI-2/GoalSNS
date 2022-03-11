package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.MemChellVO;
import goalsns.entity.MemberVO;
import goalsns.entity.RewardVO;
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
		 * 커다란 리스트 엔티티 - int chell_seq, 달성도 엔티티(List<String> 날짜리스트), 달성표 엔티티(이미 만듦 TrackerVO)
		 */
		PostDAO pdao = new PostDAO();
		MemChellVO mcvo = new MemChellVO();
		mcvo.setMem_id(mem_id);
		int[] chellList = pdao.getChellList(mem_id);
		int size = chellList.length; 
		RewardVO[] rewardList = new RewardVO[size];
		for(int i=0; i<size; i++) {
			rewardList[i].setChell_seq(chellList[i]);
			mcvo.setChell_seq(chellList[i]);
			rewardList[i].setReward1(pdao.getReward1(mcvo));
			rewardList[i].setReward2(pdao.getReward2(mcvo));
		}
		request.setAttribute("rewardList", rewardList);
		
		return "test2";
	}

}
