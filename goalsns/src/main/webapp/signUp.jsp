<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
   <form action="데이터보낼주소">
        <h5>현재의 자신보다 더 나은 나를 원한다면 가입하세요</h5>

        <input type="text" name="mem_email" placeholder="이메일 주소">
        <br>
        <input type="text" name="mem_name" placeholder="성명">
        <br>
        <input type="text" name="mem_id" placeholder="사용자 이름">
        <br>
        <input type="password" name="mem_pw" placeholder="비밀번호">
        <br>
        <input type="submit" onclick="location.href='index.jsp'">
        <!-- 로그인 버튼 없어도 된다고 함 -->
        <!--  -->
    </form>
</body>
</html>