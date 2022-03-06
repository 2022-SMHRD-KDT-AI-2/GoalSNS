package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import goalsns.entity.HashtagVO;
import goalsns.entity.PostHashVO;
import goalsns.entity.PostVO;
import goalsns.model.PostDAO;

public class PostWriteController implements Controller {
public String requestHandler(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	//�̹����� ����Ǵ� ���
	//C:\aiweb\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\goalsns\postPic
	ServletContext context = request.getSession().getServletContext();
	String path = context.getRealPath("postPic");
	System.out.println("path: "+path);
	String encType = "UTF-8";
	int uploadFileSizeLimit = 20 * 1024 * 1024;
	
	MultipartRequest multi = new MultipartRequest(request, 
			path, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
	
	String post_content = multi.getParameter("post_content");
	String post_file = multi.getFilesystemName("post_file");

	PostVO vo = new PostVO();
	vo.setPost_content(post_content);
	vo.setPost_file(post_file);
	vo.setMem_id("test1");//�ڡڡڡڡڡ� ����� test1. ���߿��� ���� �α��� ���� ����ڷ� �����ؾ���.
	
	PostDAO dao = new PostDAO();
	dao.postWrite(vo);
	int post_seq = dao.getPostSeq()-1;
	System.out.println("post_seq: "+post_seq);
	
	//�Ʒ��δ� �ؽ��±� ������.
	
	HashtagVO hvo = new HashtagVO();
	PostHashVO phvo = new PostHashVO();
	HashtagVO exist_hvo = null;
	
	String[] content_list = post_content.split(" ");
	for(int i=0; i<content_list.length; i++) {
		if(content_list[i].charAt(0) == '#') {
			String hashtag_name = content_list[i].substring(1);
			hvo.setHashtag_name(hashtag_name);
			// ������ ��ϵ� �ؽ��±����� Ȯ��
			exist_hvo = dao.hashSelect(hashtag_name);
			// ��ϵ��� �ʾҴٸ� ��� �� ���� ���̺��� ����.
			if(exist_hvo==null) {
				dao.hashInsert(hvo);
				int hashtag_seq = dao.getHashtagSeq()-1;
				System.out.println("hashtag_seq: "+hashtag_seq);
				phvo.setPost_seq(post_seq);
				phvo.setHashtag_seq(hashtag_seq);
				dao.postHashInsert(phvo);
			}
			else { // ��ϵ� �ؽ��±׶�� ���� ���̺��� ����.
				int hashtag_seq = exist_hvo.getHashtag_seq();
				System.out.println("hashtag_seq: "+hashtag_seq);
				phvo.setPost_seq(post_seq);
				phvo.setHashtag_seq(hashtag_seq);
				dao.postHashInsert(phvo);
			}
		}
		
		
	}

	return "redirect:/postList.do"; // �������� �̵��ϰԲ�..
}
}
