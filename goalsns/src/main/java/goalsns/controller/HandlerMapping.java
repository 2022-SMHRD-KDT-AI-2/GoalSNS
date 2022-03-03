package goalsns.controller;

import java.util.HashMap;

public class HandlerMapping {
	//클라이언트의 어떤 요청에 어떤 POJO를 실행해야하는지 연결해주는 클래스.
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		//예시 - mappings.put("/boardList.do", new BoardListController());
		mappings.put("/postWrite.po", new PostWriteController());
		mappings.put("/postList.po", new PostListController());
		mappings.put("/postContent.po", new PostContentController());	
		mappings.put("/postDelete.po", new PostDeleteController());
		
		mappings.put("/login.do", new MemberLoginController());
		mappings.put("/userRegister.do", new UserRegisterController());
		mappings.put("/main.do", new MainController());
		
		
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
