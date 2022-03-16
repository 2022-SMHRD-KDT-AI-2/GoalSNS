package com.smhrd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.entity.MemberVO;
import com.smhrd.model.MemberDAO;

public class ProfileEditController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memvo");
		//String id=(String)memvo.getMem_id();

		//이미지가 저장되는 경로
		//C:\aiweb\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\goalsns\profilePic
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
		//vo.setMem_id(id);
		//MemberVO mem_vo=dao.getByMemId(id);
		
		String mem_img = multi.getFilesystemName("mem_img");
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
		/*
		 * request.setAttribute("mem_vo", mem_vo); 
		 * request.setAttribute("memvo", memvo);
		 * request.setAttribute("vo", vo); 
		 * System.out.println(id);
		 */
		return "main.do";
	}

}
