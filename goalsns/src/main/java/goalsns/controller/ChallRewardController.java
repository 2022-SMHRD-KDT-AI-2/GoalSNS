package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.ChellVO;
import goalsns.entity.MemChellVO;
import goalsns.entity.MemberVO;
import goalsns.entity.RewardVO;
import goalsns.entity.TrophyVO;
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
		MemberVO mvo = new MemberVO();
		mvo.setMem_id(mem_id);
		int[] chellList = pdao.getChellList(mvo);
		int size = chellList.length; 
		int cnt = 0;
		String chell_name;
		RewardVO[] rewardList = new RewardVO[size];
		TrophyVO[] trophyList = new TrophyVO[size];

		
		for(int i=0; i<size; i++) {
			rewardList[i] = new RewardVO();
			
			rewardList[i].setChell_seq(chellList[i]);
			mcvo.setChell_seq(chellList[i]);
			chell_name = pdao.getChellName(mcvo).getChell_name();
			rewardList[i].setChell_name(chell_name);
			trophyList[i] = new TrophyVO();
			cnt = pdao.getReward1(mcvo).length;
			trophyList[i].setCnt(cnt);
			trophyList[i].calcRate(cnt);
			System.out.println("rate: "+trophyList[i].getRate());
			trophyList[i].calcColor(trophyList[i].getRate());
			rewardList[i].setReward1(trophyList[i]);
			
			rewardList[i].setReward2(pdao.getReward2(mcvo)); //check가 다 0으로 뜨긴하는데 success는 null/no null 제대로 인듯.
		}
		request.setAttribute("rewardList", rewardList);
		

		return "test2";
	}

}
