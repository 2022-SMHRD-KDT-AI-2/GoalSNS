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
   <form method = "post" action="/goalsns/userRegister.do">
        <h5>현재의 자신보다 더 나은 나를 원한다면 가입하세요</h5>

        <input type="text" name="email" placeholder="이메일 주소" >
        <br>
        <input type="text" name="name" placeholder="성명" >
        <br>
        <input type="text" name="id" placeholder="사용자 이름">
        <input type ="button" value = "ID중복체크" onclick="idCheck()">
        <span id = "sp"></span>
        <br>
        <input type="password" name="pw" placeholder="비밀번호">
        <br>
        <input type="submit">
        <!-- 로그인 버튼 없어도 된다고 함  onclick="location.href='index.jsp'"   -->
    </form>
    
</body>
</html>