package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.FollowVO;
import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class FollowListController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�α����� ��� ���̵�������
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		String from_mem=(String)memvo.getMem_id();
		MemberDAO dao=new MemberDAO();
		FollowVO fvo=new FollowVO();
		//FollowVO�� ����
		fvo.setFrom_mem(from_mem);
		//DB���� �α����� ����� ���̵� �ִ� �ȷο��ѻ�� ����Ʈ���
		List<FollowVO> flist=dao.followAll(fvo);
		request.setAttribute("flist", flist);
		return "test3";
	}

}
