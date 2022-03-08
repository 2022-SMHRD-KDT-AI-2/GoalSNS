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
	//이미지가 저장되는 경로
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
	//String mem_id = "test1";//★★★★★★ 현재는 test1. 나중에는 현재 로그인 중인 사용자로 수정해야함.
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
	
	//아래로는 해시태그 구현부.
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
//-------------------------------------일반 해시태그 -------------------------------------
		if(content_list[i].charAt(0) == '#') {
			String hashtag_name = content_list[i].substring(1);
			hvo.setHashtag_name(hashtag_name);
			// 기존에 등록된 해시태그인지 확인
			exist_hvo = dao.hashSelect(hashtag_name);
			// 등록되지 않았다면 등록 후 매핑 테이블에도 삽입.
			if(exist_hvo==null) {
				dao.hashInsert(hvo);
				hashtag_seq = dao.getHashtagSeq()-1;
				System.out.println("hashtag_seq: "+hashtag_seq);
			}
			else { // 등록된 해시태그라면 매핑 테이블에만 삽입.
				hashtag_seq = exist_hvo.getHashtag_seq();
				System.out.println("hashtag_seq: "+hashtag_seq);
			}
				phvo.setPost_seq(post_seq);
				phvo.setHashtag_seq(hashtag_seq);
				dao.postHashInsert(phvo);
				
//-------------------------------------챌린지 해시태그 -------------------------------------
				//챌린지해시태그-포스트 매핑 테이블 생성
				//유저-챌린지에 이미 있다면 넣으면 안됨 매핑 테이블에.
		}else if(content_list[i].charAt(0) == '@') {
			String chell_name = content_list[i].substring(1);
			cvo.setChell_name(chell_name);
			// 기존에 등록된 챌린지 해시태그인지 확인
			exist_cvo = dao.challSelect(chell_name);
			// 등록되지 않았다면 등록 후 매핑 테이블에도 삽입.
			if(exist_cvo==null) {
				dao.chellInsert(cvo);
				chell_seq = dao.getChellSeq()-1;
				System.out.println("chell_seq: "+chell_seq);
			}
			else { // 등록된 챌린지 해시태그라면 매핑 테이블에만 삽입.
				chell_seq = exist_cvo.getChell_seq();
				System.out.println("chell_seq: "+chell_seq);
			}
				mcvo.setMem_id(mem_id);
				mcvo.setChell_seq(chell_seq);
				dao.memChellInsert(mcvo);
		}
	}
	return "redirect:/main.do"; // 메인으로 이동하게끔..
}
}
