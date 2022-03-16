package com.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.entity.ChellVO;
import com.smhrd.entity.HashtagVO;
import com.smhrd.entity.PostVO;
import com.smhrd.model.PostDAO;

public class SearchResultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 해시태그 검색시. 해당 해시태그에 대한 결과를 반환해야함.
		// 해당 해시태그가 달린 게시물들 리스트 반환.
		// 해당 해시태그의 게시물들 개수 반환.
		String search = (String) request.getParameter("search");
		PostDAO dao = new PostDAO();
		
		ChellVO cvo = dao.getSeqByChellName(search);
		HashtagVO hvo = dao.getSeqByHashName(search);
		int postCnt = 0;
		List<PostVO> postList = null;
		
		if(cvo != null) {
			int chellId = cvo.getChell_seq();
			postList = dao.searchChellBySeq(chellId);
			postCnt = postList.size();
			search = '@'+search;
			
		}
		else if(hvo != null) {
			int hashId = hvo.getHashtag_seq();
			postList = dao.searchHashBySeq(hashId);
			postCnt = postList.size();
			search = '#'+search;
		}
		else {
			return "noSearchResult";
		}
		request.setAttribute("list", postList);
		request.setAttribute("search", search);
		request.setAttribute("postCnt", postCnt);
		
		return "searchResult";
	}

}
