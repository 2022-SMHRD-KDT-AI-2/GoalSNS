package goalsns.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import goalsns.entity.MemberVO;
import goalsns.model.MemberDAO;

public class IdCheckController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mem_id=request.getParameter("id");
		MemberVO vo=new MemberVO();
		MemberDAO dao=new MemberDAO();
		vo.setMem_id(mem_id);
		int idck=dao.idCheck(vo);
		
		JSONObject obj = new JSONObject();
		obj.put("idck",idck);
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);
		return "signUp";
	}

}
