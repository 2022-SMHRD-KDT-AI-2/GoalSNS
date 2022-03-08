package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import goalsns.entity.ChellVO;
import goalsns.entity.HashtagVO;
import goalsns.entity.MemChellVO;
import goalsns.entity.MemberVO;
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
	System.out.println("context: "+context);
	String path = context.getRealPath("postPic");
	System.out.println("path: "+path);
	String encType = "UTF-8";
	int uploadFileSizeLimit = 20 * 1024 * 1024;
	
	MultipartRequest multi = new MultipartRequest(request, 
			path, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
	
	String post_content = multi.getParameter("post_content");
	String post_file = multi.getFilesystemName("post_file");
	//String mem_id = "test1";//�ڡڡڡڡڡ� ����� test1. ���߿��� ���� �α��� ���� ����ڷ� �����ؾ���.
	HttpSession session=request.getSession();
	MemberVO memvo = (MemberVO)session.getAttribute("memvo");
	String mem_id = memvo.getMem_id();
	
	PostVO vo = new PostVO();
	vo.setPost_content(post_content);
	vo.setPost_file(post_file);
	vo.setMem_id(mem_id);
	
	PostDAO dao = new PostDAO();
	dao.postWrite(vo);
	int post_seq = dao.getPostSeq()-1;
	System.out.println("post_seq: "+post_seq);
	
	//�Ʒ��δ� �ؽ��±� ������.
	ChellVO cvo = new ChellVO();
	MemChellVO mcvo = new MemChellVO();
	ChellVO exist_cvo = null;
	int chell_seq;
	
	HashtagVO hvo = new HashtagVO();
	PostHashVO phvo = new PostHashVO();
	HashtagVO exist_hvo = null;
	int hashtag_seq;
	
	String[] content_list = post_content.split(" ");
	for(int i=0; i<content_list.length; i++) {
//-------------------------------------�Ϲ� �ؽ��±� -------------------------------------
		if(content_list[i].charAt(0) == '#') {
			String hashtag_name = content_list[i].substring(1);
			hvo.setHashtag_name(hashtag_name);
			// ������ ��ϵ� �ؽ��±����� Ȯ��
			exist_hvo = dao.hashSelect(hashtag_name);
			// ��ϵ��� �ʾҴٸ� ��� �� ���� ���̺��� ����.
			if(exist_hvo==null) {
				dao.hashInsert(hvo);
				hashtag_seq = dao.getHashtagSeq()-1;
				System.out.println("hashtag_seq: "+hashtag_seq);
			}
			else { // ��ϵ� �ؽ��±׶�� ���� ���̺��� ����.
				hashtag_seq = exist_hvo.getHashtag_seq();
				System.out.println("hashtag_seq: "+hashtag_seq);
			}
				phvo.setPost_seq(post_seq);
				phvo.setHashtag_seq(hashtag_seq);
				dao.postHashInsert(phvo);
				
//-------------------------------------ç���� �ؽ��±� -------------------------------------
				//ç�����ؽ��±�-����Ʈ ���� ���̺� ����
				//����-ç������ �̹� �ִٸ� ������ �ȵ� ���� ���̺�.
		}else if(content_list[i].charAt(0) == '@') {
			String chell_name = content_list[i].substring(1);
			cvo.setChell_name(chell_name);
			// ������ ��ϵ� ç���� �ؽ��±����� Ȯ��
			exist_cvo = dao.challSelect(chell_name);
			// ��ϵ��� �ʾҴٸ� ��� �� ���� ���̺��� ����.
			if(exist_cvo==null) {
				dao.chellInsert(cvo);
				chell_seq = dao.getChellSeq()-1;
				System.out.println("chell_seq: "+chell_seq);
			}
			else { // ��ϵ� ç���� �ؽ��±׶�� ���� ���̺��� ����.
				chell_seq = exist_cvo.getChell_seq();
				System.out.println("chell_seq: "+chell_seq);
			}
				mcvo.setMem_id(mem_id);
				mcvo.setChell_seq(chell_seq);
				dao.memChellInsert(mcvo);
		}
	}
	return "redirect:/main.do"; // �������� �̵��ϰԲ�..
}
}
