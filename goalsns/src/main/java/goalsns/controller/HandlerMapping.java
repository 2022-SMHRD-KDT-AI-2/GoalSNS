package goalsns.controller;

import java.util.HashMap;

public class HandlerMapping {
	//Ŭ���̾�Ʈ�� � ��û�� � POJO�� �����ؾ��ϴ��� �������ִ� Ŭ����.
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		//���� - mappings.put("/boardList.do", new BoardListController());
		mappings.put("/postWrite.do", new PostWriteController());
	}
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
