package goalsns.controller;

import java.util.HashMap;

public class HandlerMapping {
	//클라이언트의 어떤 요청에 어떤 POJO를 실행해야하는지 연결해주는 클래스.
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		//예시 - mappings.put("/boardList.do", new BoardListController());
		
		mappings.put("/postWrite.do", new PostWriteController());
		mappings.put("/login.do", new MemberLoginController());
		mappings.put("/main.do", new MainController());
		mappings.put("/postContent.do", new PostContentController());	
		mappings.put("/postDelete.do", new PostDeleteController());
		mappings.put("/userRegister.do", new UserRegisterController());
		mappings.put("/postContent.po", new PostContentController());	
		mappings.put("/memberDelete.do", new MemberDeleteController());	
		mappings.put("/logout.do", new MemberLogoutController());
		mappings.put("/profileEdit.do", new MemberProfileEditController());
		mappings.put("/profile.do", new ProfileDefaultController());
		mappings.put("/follow.do", new FollowController());
		mappings.put("/profileEditform.do", new ProfileEditController());
		mappings.put("/cmt.do", new CmtController());
		mappings.put("/search.do", new SearchResultController());
		mappings.put("/like.do", new LikeController());
		mappings.put("/following.do", new FollowDefaultController());
		mappings.put("/likeDelete.do", new LikeDeleteController());
		mappings.put("/cmtDelete.do", new CmtDeleteController());
		mappings.put("/followList.do", new FollowListController());

		
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
