package com.smhrd.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.entity.ChellVO;
import com.smhrd.entity.FollowVO;
import com.smhrd.entity.MemChellVO;
import com.smhrd.entity.MemberVO;
import com.smhrd.entity.PostVO;
import com.smhrd.entity.RewardVO;
import com.smhrd.entity.TrophyVO;
import com.smhrd.model.MemberDAO;
import com.smhrd.model.PostDAO;

public class ChallRewardController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String id = (String)request.getParameter("mem_id");//상대방아이디
		String from_mem=(String)memvo.getMem_id();//자신의아이디
		MemberDAO mdao = new MemberDAO();
		PostDAO pdao = new PostDAO();
		FollowVO fvo=new FollowVO();
		fvo.setTo_mem(id);
		fvo.setFrom_mem(from_mem);
		MemberVO mvo = mdao.getMemberInfo(id);
		List<FollowVO> tofollowlist=mdao.tofollowAll(fvo);
		List<FollowVO> tofollowedlist=mdao.tofollowedAll(fvo);
		List<PostVO> postList = pdao.getMemberPosts(id);
		int postCnt = postList.size();
		request.setAttribute("postList", postList);
		request.setAttribute("postCnt", postCnt);
		request.setAttribute("mvo", mvo);
		request.setAttribute("tofollowlist", tofollowlist);
		request.setAttribute("tofollowedlist", tofollowedlist);
		List<FollowVO> memfo=mdao.getFollowInfo(fvo);
		request.setAttribute("memfo", memfo);
		
		// -------------- 팔로워 이미지(멤버 정보) ----------------------
		String[] followerImages = new String[tofollowlist.size()];
		for (int i = 0; i < tofollowlist.size(); i++) {
			followerImages[i] = mdao.getMemberInfo(tofollowlist.get(i).getFrom_mem()).getMem_img();
		}
		request.setAttribute("followerImages", followerImages);
		// -------------- 팔로우 이미지(멤버 정보) ----------------------
		String[] followImages = new String[tofollowedlist.size()];
		for (int i = 0; i < tofollowedlist.size(); i++) {
			followImages[i] = mdao.getMemberInfo(tofollowedlist.get(i).getTo_mem()).getMem_img();
		}
		request.setAttribute("followImages", followImages);
		/*
		 * (1) 챌린지 해시태그 리스트 가져오기. (커다란 리스트)
		 * (2) 챌린지 해시태그 아이디에 관한 해당 로그인 유저의 월별 달성도 출력. (작은 리스트)
		 * (3) 챌린지 해시태그 아이디에 관한 해당 로그인 유저의 월별 달성표 출력. (작은 리스트)
		 * 리스트[ [해시태그아이디, 리워드1, 리워드2] [해시태아이디, 리워드1, 리워드2] ...] 
		 * 커다란 리스트 엔티티 - int chell_seq, 달성도 엔티티(List<String> 날짜리스트), 달성표 엔티티(이미 만듦 TrackerVO)
		 */
		MemChellVO mcvo = new MemChellVO();
		mcvo.setMem_id(id);
		MemberVO mvo2 = new MemberVO();
		mvo2.setMem_id(id);
		int[] chellList = pdao.getChellList(mvo2);
		int size = chellList.length; 
		String chell_name;
		RewardVO[] rewardList = new RewardVO[size];
		TrophyVO[] trophyList = new TrophyVO[size];

		
		for(int i=0; i<size; i++) {
			int cnt = 0;
			rewardList[i] = new RewardVO();
			
			rewardList[i].setChell_seq(chellList[i]);
			mcvo.setChell_seq(chellList[i]);
			chell_name = pdao.getChellName(mcvo).getChell_name();
			rewardList[i].setChell_name(chell_name);
			
			rewardList[i].setReward2(pdao.getReward2(mcvo)); //check가 다 0으로 뜨긴하는데 success는 null/no null 제대로 인듯.
			for(int j=0; j<rewardList[i].getReward2().size(); j++) {
				if(rewardList[i].getReward2().get(j).getSuccess() != null) {
					cnt+=1;
				}
			}
			trophyList[i] = new TrophyVO();
			trophyList[i].setCnt(cnt);
			//cnt = pdao.getReward1(mcvo).length;
			trophyList[i].calcRate(cnt);
			System.out.println("rate: "+trophyList[i].getRate());
			trophyList[i].calcColor(trophyList[i].getRate());
			rewardList[i].setReward1(trophyList[i]);
			rewardList[i].setReward3(pdao.getReward3(mcvo));
			
			rewardList[i].setAvg(pdao.getAvg(mcvo));
			
			rewardList[i].setMem_cnt(pdao.getMemChellCnt(mcvo));
		}
		request.setAttribute("rewardList", rewardList);
		LocalDate now = LocalDate.now();
		int month = now.getMonthValue();
		request.setAttribute("month", month);

		return "challReward";
	}

}
