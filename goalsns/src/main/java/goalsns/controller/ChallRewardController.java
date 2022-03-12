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
		 * (1) ç���� �ؽ��±� ����Ʈ ��������. (Ŀ�ٶ� ����Ʈ)
		 * (2) ç���� �ؽ��±� ���̵� ���� �ش� �α��� ������ ���� �޼��� ���. (���� ����Ʈ)
		 * (3) ç���� �ؽ��±� ���̵� ���� �ش� �α��� ������ ���� �޼�ǥ ���. (���� ����Ʈ)
		 * ����Ʈ[ [�ؽ��±׾��̵�, ������1, ������2] [�ؽ��¾��̵�, ������1, ������2] ...] 
		 * Ŀ�ٶ� ����Ʈ ��ƼƼ - int chell_seq, �޼��� ��ƼƼ(List<String> ��¥����Ʈ), �޼�ǥ ��ƼƼ(�̹� ���� TrackerVO)
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
			
			rewardList[i].setReward2(pdao.getReward2(mcvo)); //check�� �� 0���� �߱��ϴµ� success�� null/no null ����� �ε�.
		}
		request.setAttribute("rewardList", rewardList);
		

		return "test2";
	}

}
