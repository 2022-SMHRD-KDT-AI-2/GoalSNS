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
		// �ؽ��±� �˻���. �ش� �ؽ��±׿� ���� ����� ��ȯ�ؾ���.
		// �ش� �ؽ��±װ� �޸� �Խù��� ����Ʈ ��ȯ.
		// �ش� �ؽ��±��� �Խù��� ���� ��ȯ.
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
			//����.
		}
		
		request.setAttribute("postCnt", postCnt);
		
		return "test";
	}

}
