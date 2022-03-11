package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goalsns.entity.MemberVO;

public class ChallRewardController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		/*
		 * (1) 챌린지 해시태그 리스트 가져오기. (커다란 리스트)
		 * (2) 챌린지 해시태그 아이디에 관한 해당 로그인 유저의 월별 달성도 출력. (작은 리스트)
		 * (3) 챌린지 해시태그 아이디에 관한 해당 로그인 유저의 월별 달성표 출력. (작은 리스트)
		 * 리스트[ [해시태그아이디, 리워드1, 리워드2] [해시태아이디, 리워드1, 리워드2] ...] 
		 */
		
		return null;
	}

}
