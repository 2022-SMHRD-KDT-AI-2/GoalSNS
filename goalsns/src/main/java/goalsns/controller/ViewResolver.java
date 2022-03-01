package goalsns.controller;

public class ViewResolver {
	public static String makeURL(String nextView) {
		return "WEB-INF/member/"+nextView+".jsp";
	}
}
