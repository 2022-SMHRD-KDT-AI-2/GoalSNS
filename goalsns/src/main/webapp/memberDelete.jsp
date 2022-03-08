<%@page import="goalsns.entity.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
   <form method = "post" action="/goalsns/memberDelete.do">
        <h5>회원탈퇴</h5>
		
			<input type="text" name="id" readonly="readonly" value="${memvo.test4}">
			<br>
			<input type="password" name="pw" placeholder="비밀번호">
			<br>
			<input type="submit">
		        <!-- 로그인 버튼 없어도 된다고 함  onclick="location.href='index.jsp'"   -->	
    </form>
    
</body>
</html>