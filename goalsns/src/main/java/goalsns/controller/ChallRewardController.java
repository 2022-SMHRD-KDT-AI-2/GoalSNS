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
		 * (1) ç���� �ؽ��±� ����Ʈ ��������. (Ŀ�ٶ� ����Ʈ)
		 * (2) ç���� �ؽ��±� ���̵� ���� �ش� �α��� ������ ���� �޼��� ���. (���� ����Ʈ)
		 * (3) ç���� �ؽ��±� ���̵� ���� �ش� �α��� ������ ���� �޼�ǥ ���. (���� ����Ʈ)
		 * ����Ʈ[ [�ؽ��±׾��̵�, ������1, ������2] [�ؽ��¾��̵�, ������1, ������2] ...] 
		 * Ŀ�ٶ� ����Ʈ ��ƼƼ - int chell_seq, �޼��� ��ƼƼ(List<String> ��¥����Ʈ), �޼�ǥ ��ƼƼ(�̹� ���� TrackerVO)
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
