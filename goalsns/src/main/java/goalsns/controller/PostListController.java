package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.PostVO;
import goalsns.model.PostDAO;


public class PostListController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//현재는 모든 전체 게시글에 대한 리스트 반환.
		// 나중에는 로그인한 유저의 게시글을 반환하게.
		// 팔로우 구현 후에는 팔로우한 유저들의 글까지 반환하게.
		PostDAO dao = new PostDAO();
		List<PostVO> list = dao.selectPosts();
		request.setAttribute("list", list);
		return "main";
	}

}
