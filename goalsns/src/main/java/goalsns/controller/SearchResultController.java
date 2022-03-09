package goalsns.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import goalsns.entity.PostChellVO;
import goalsns.entity.PostHashVO;
import goalsns.model.PostDAO;

public class SearchResultController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 해시태그 검색시. 해당 해시태그에 대한 결과를 반환해야함.
		// 해당 해시태그가 달린 게시물들 리스트 반환.
		// 해당 해시태그의 게시물들 개수 반환.
		String search = (String) request.getParameter("search");
		PostDAO dao = new PostDAO();
		
		List<PostChellVO> chellList = dao.autoSearchChell(search);
		List<PostHashVO> hashList = dao.autoSearchHash(search);
		int postCnt = 0;
		
		if(chellList != null) {
			request.setAttribute("list", chellList);
			postCnt = chellList.size();
		}
		else if(hashList != null) {
			request.setAttribute("list", hashList);
			postCnt = hashList.size();
		}
		else {
			//없음.
		}
		
		request.setAttribute("postCnt", postCnt);
		
		return "test";
	}

}
