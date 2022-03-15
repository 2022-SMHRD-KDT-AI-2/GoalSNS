package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.entity.PostVO;
import goalsns.model.MemberDAO;
import goalsns.model.PostDAO;

public class ProfileDefaultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ȷο�, �ȷο� �� + �Խù� ��
		//String id = "test1";
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
		List<FollowVO> tofollowlist=mdao.tofollowAll(fvo);
		List<FollowVO> tofollowedlist=mdao.tofollowedAll(fvo);
		List<PostVO> postList = pdao.getMemberPosts(id);
		int postCnt = postList.size();
		request.setAttribute("postList", postList);
		request.setAttribute("postCnt", postCnt);
		request.setAttribute("mvo", mvo);
		request.setAttribute("tofollowlist", tofollowlist);
		request.setAttribute("tofollowedlist", tofollowedlist);
		
		// -------------- �ȷο� �̹���(��� ����) ----------------------
		String[] followerImages = new String[tofollowlist.size()];
		for (int i = 0; i < tofollowlist.size(); i++) {
			followerImages[i] = mdao.getMemberInfo(tofollowlist.get(i).getFrom_mem()).getMem_img();
		}
		request.setAttribute("followerImages", followerImages);
		// -------------- �ȷο� �̹���(��� ����) ----------------------
		String[] followImages = new String[tofollowedlist.size()];
		for (int i = 0; i < tofollowedlist.size(); i++) {
			followImages[i] = mdao.getMemberInfo(tofollowedlist.get(i).getTo_mem()).getMem_img();
		}
		request.setAttribute("followImages", followImages);
		
		return "profile";
	}

}
