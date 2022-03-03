<%@page import="goalsns.entity.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%
   MemberVO vo = (MemberVO)request.getAttribute("vo");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
   <form method = "post" action="데이터를저장할공간">
        <h5>현재의 자신보다 더 나은 나를 원한다면 가입하세요</h5>

        <input type="text" name="mem_email" placeholder="이메일 주소" value="<%=vo.getMem_email()%>">
        <br>
        <input type="text" name="mem_name" placeholder="성명" value="<%=vo.getMem_name()%>">
        <br>
        <input type="text" name="mem_id" placeholder="사용자 이름" value="<%=vo.getMem_id()%>">
        <br>
        <input type="password" name="mem_pw" placeholder="비밀번호" value="<%=vo.getMem_pw()%>">
        <br>
        <input type="submit">
        <!-- 로그인 버튼 없어도 된다고 함  onclick="location.href='index.jsp'"   -->
    </form>
</body>
</html>