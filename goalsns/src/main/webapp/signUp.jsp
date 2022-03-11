<%@page import="goalsns.entity.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <input id = "id" type="text" name="id" placeholder="사용자 이름">
        <button id = "idCheck" type ="button" class = "btn btn-primary btn-sm" onclick="resultJSON()">ID중복체크</button>
        <span id = "idResult">아이디 중복체크 결과</span>
        <br>
        <input type="password" name="pw" placeholder="비밀번호">
        <br>
        <input type="submit">
        <!-- 로그인 버튼 없어도 된다고 함  onclick="location.href='index.jsp'"   -->
    </form>
   
   
   
    <script>
    	$('#idCheck').click(function(){
    		var id = $('#id').val();
    		$.ajax({
    			url : "idCheck.do",
    			type : 'GET',
    			data : {'id',id},
    			dataType : 'JSON',
    			success : resultJSON,
    			error : function(){
    				alert('error');
    			} // error
    		});   // .ajax
    	});  	  // .click
    	
    	function resultJSON(data) {
    		if(data.check == 'true') {
    			$('#idResult').test('사용할 수 있는 아이디 입니다.');
    			$('#idResult').css('color','blue');
    		} else {
    			$('#idResult').test('사용할 수 없는 아이디 입니다.');
    			$('#idResult').css('color','red');
    		}
    	}
    </script>
</body>
</html>