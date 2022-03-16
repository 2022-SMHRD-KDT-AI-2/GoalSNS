package com.smhrd.controller;

public class ViewResolver {
	public static String makeURL(String nextView) {
		return "WEB-INF/"+nextView+".jsp";
	}
}
