package goalsns.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.ChellVO;
import goalsns.entity.FollowVO;
import goalsns.entity.MemChellVO;
import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.entity.RewardVO;
import goalsns.entity.TrophyVO;
import goalsns.model.MemberDAO;
import goalsns.model.PostDAO;

public class ChallRewardController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String id = (String)request.getParameter("mem_id");//������̵�
		String from_mem=(String)memvo.getMem_id();//�ڽ��Ǿ��̵�
		MemberDAO mdao = new MemberDAO();
		PostDAO pdao = new PostDAO();
		FollowVO fvo=new FollowVO();
		fvo.setTo_mem(id);
		fvo.setFrom_mem(from_mem);
		MemberVO mvo = mdao.getMemberInfo(id);
		List<FollowVO> memfo=mdao.getFollowInfo(fvo);
		List<FollowVO> followlist=mdao.followAll(fvo);
		List<FollowVO> tofollowlist=mdao.tofollowAll(fvo);
		List<FollowVO> followedlist=mdao.followedAll(fvo);
		List<FollowVO> tofollowedlist=mdao.tofollowedAll(fvo);
		List<PostVO> postList = pdao.getMemberPosts(id);
		int postCnt = postList.size();
		request.setAttribute("postCnt", postCnt);
		request.setAttribute("mvo", mvo);
		request.setAttribute("memfo", memfo);
		request.setAttribute("followlist", followlist);
		request.setAttribute("followedlist", followedlist);
		request.setAttribute("tofollowlist", tofollowlist);
		request.setAttribute("tofollowedlist", tofollowedlist);
		/*
		 * (1) ç���� �ؽ��±� ����Ʈ ��������. (Ŀ�ٶ� ����Ʈ)
		 * (2) ç���� �ؽ��±� ���̵� ���� �ش� �α��� ������ ���� �޼��� ���. (���� ����Ʈ)
		 * (3) ç���� �ؽ��±� ���̵� ���� �ش� �α��� ������ ���� �޼�ǥ ���. (���� ����Ʈ)
		 * ����Ʈ[ [�ؽ��±׾��̵�, ������1, ������2] [�ؽ��¾��̵�, ������1, ������2] ...] 
		 * Ŀ�ٶ� ����Ʈ ��ƼƼ - int chell_seq, �޼��� ��ƼƼ(List<String> ��¥����Ʈ), �޼�ǥ ��ƼƼ(�̹� ���� TrackerVO)
		 */
		MemChellVO mcvo = new MemChellVO();
		mcvo.setMem_id(id);
		MemberVO mvo2 = new MemberVO();
		mvo2.setMem_id(id);
		int[] chellList = pdao.getChellList(mvo2);
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
		LocalDate now = LocalDate.now();
		int month = now.getMonthValue();
		request.setAttribute("month", month);

		return "challReward";
	}

}
