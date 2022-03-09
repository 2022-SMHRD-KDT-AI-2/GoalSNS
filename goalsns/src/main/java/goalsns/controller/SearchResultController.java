package goalsns.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goalsns.entity.PostChellVO;
import goalsns.entity.PostHashVO;
import goalsns.entity.PostVO;
import goalsns.model.PostDAO;

public class SearchResultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 해시태그 검색시. 해당 해시태그에 대한 결과를 반환해야함.
		// 해당 해시태그가 달린 게시물들 리스트 반환.
		// 해당 해시태그의 게시물들 개수 반환.
		String search = (String) request.getParameter("search");
		PostDAO dao = new PostDAO();
		
		List<Integer> chellList = dao.autoSearchChell(search);
		List<Integer> hashList = dao.autoSearchHash(search);
		int postCnt = 0;
		List<PostVO> postList = null;
		
		if(chellList != null) {
			postCnt = chellList.size();
			search = '@'+search;
			postList = dao.getPostsBySeq(chellList);
			
		}
		else if(hashList != null) {
			postCnt = hashList.size();
			search = '#'+search;
			postList = dao.getPostsBySeq(hashList);
		}
		else {
			//없음.
		}
		request.setAttribute("list", postList);
		request.setAttribute("search", search);
		request.setAttribute("postCnt", postCnt);
		
		return "searchResult";
	}

}
