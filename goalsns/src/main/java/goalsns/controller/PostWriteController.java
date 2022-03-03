package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import goalsns.entity.PostVO;
import goalsns.model.PostDAO;

public class PostWriteController implements Controller {
public String requestHandler(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	ServletContext context = request.getSession().getServletContext();
	String path = context.getRealPath("postPic");
	String encType = "UTF-8";
	int uploadFileSizeLimit = 20 * 1024 * 1024;
	
	MultipartRequest multi = new MultipartRequest(request, 
			path, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
	
	String post_content = multi.getParameter("post_content");
	String post_file = multi.getFilesystemName("post_file");

	PostVO vo = new PostVO();
	vo.setPost_content(post_content);
	vo.setPost_file(post_file);
	vo.setMem_id("test");

	PostDAO dao = new PostDAO();
	dao.postwrite(vo);
	return "redirect:main.jsp"; // 메인으로 이동하게끔..
}
}
