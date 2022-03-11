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
		 * (1) ç���� �ؽ��±� ����Ʈ ��������. (Ŀ�ٶ� ����Ʈ)
		 * (2) ç���� �ؽ��±� ���̵� ���� �ش� �α��� ������ ���� �޼��� ���. (���� ����Ʈ)
		 * (3) ç���� �ؽ��±� ���̵� ���� �ش� �α��� ������ ���� �޼�ǥ ���. (���� ����Ʈ)
		 * ����Ʈ[ [�ؽ��±׾��̵�, ������1, ������2] [�ؽ��¾��̵�, ������1, ������2] ...] 
		 * Ŀ�ٶ� ����Ʈ ��ƼƼ, �޼��� ��ƼƼ, �޼�ǥ ��ƼƼ(�̹� ����)
		 */
		PostDAO pdao = new PostDAO();
		MemChellVO cvo = new MemChellVO();
		cvo.setMem_id(mem_id);
		List<Integer> chellList = pdao.ç�����ؽ��±׸���Ʈ�������¸޼ҵ�(mem_id);
		for(int i=0; i<chellList.size(); i++) {
			Ŀ�ٶ� ����Ʈ[i][0] = chellList[i];
			cvo.setChell_seq(chellList[i]);
			Ŀ�ٶ� ����Ʈ[i][1] = dao.�����޼��������ѰŰ������¸���Ʈ(cvo);
			Ŀ�ٶ� ����Ʈ[i][2] = dao.�����޼�ǥ�������¸���Ʈ(cvo);
		}
		request.setAttribute(Ŀ�ٶ�����Ʈ, Ŀ�ٶ�����Ʈ);
		
		return "challReward";
		
	}

}
