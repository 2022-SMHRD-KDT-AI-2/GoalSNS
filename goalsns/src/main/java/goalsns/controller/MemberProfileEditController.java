package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class MemberProfileEditController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");

		ServletContext context = request.getSession().getServletContext();
		System.out.println("context: "+context);
		String path = context.getRealPath("profilePic");
		System.out.println("path: "+path);
		String encType = "UTF-8";
		int uploadFileSizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, 
				path, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
						
		MemberDAO dao=new MemberDAO();
		MemberVO vo=new MemberVO();
		String mem_img;
		if(multi.getFilesystemName("mem_img") !=null )
			mem_img = multi.getFilesystemName("mem_img");
		else
			mem_img = memvo.getMem_img();
		
		String mem_name = multi.getParameter("mem_name");
		String mem_id = memvo.getMem_id();
		String mem_about = multi.getParameter("mem_about");
		String mem_email = multi.getParameter("mem_email");
		
		vo.setMem_img(mem_img);
		vo.setMem_name(mem_name);
		vo.setMem_id(mem_id);
		vo.setMem_about(mem_about);
		vo.setMem_email(mem_email);
		
		System.out.println("mem_img"+mem_img);
		System.out.println("mem_name"+mem_name);
		System.out.println("mem_id"+mem_id);
		System.out.println("mem_about"+mem_about);
		System.out.println("mem_email"+mem_email);
		
		dao.profileEdit(vo);

		return "redirect:/profileEditForm.do";
	}

}
