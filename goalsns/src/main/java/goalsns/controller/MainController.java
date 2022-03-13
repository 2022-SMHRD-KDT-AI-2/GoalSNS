package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.LikeCheckVO;
import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.entity.TrendVO;
import goalsns.model.MemberDAO;
import goalsns.model.PostDAO;

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
		return "main";
		
	}

}
