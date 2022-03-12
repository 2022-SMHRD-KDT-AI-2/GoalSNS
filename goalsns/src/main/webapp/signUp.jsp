<%@page import="goalsns.entity.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="./resources/CSS/signUp.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
<script type="text/javascript">
	function idcheck(){
		let id=document.getElementById('id').value;
		location.href="/goalsns/idCheck.do?id="+id;
	}
</script>
</head>
<body>
   
  <div class="container">
  
   <form method = "post" action="/goalsns/userRegister.do">
       <div class="item">
         <img src="./resources/images/logo.png" alt="프로필 사진 바꾸기" >	
        <h5>현재의 자신보다 더 나은 나를 <br>원한다면 가입하세요</h5>
      <div class="item_1">
        <div>
         <input type="text" class="boxs_1" name="email" placeholder="이메일 주소" >
        </div>
        <br>
        <div>
         <input type="text" class="boxs_1" name="name" placeholder="성명" >
        </div>
        <br>
        <div>
         <input id = "id" type="text" class="boxs_1" name="id" placeholder="사용자 이름">
        </div>
        <div class="btn_0">
         <button method = "post" id = "idCheck" type ="button" class = "btn btn-primary btn-sm" onclick="idcheck()">ID중복체크</button>
        </div>
        <c:if test="${null ne idck}">
    <p>aaaaa</p>
    </c:if>
   	<c:if test="${null eq idck}">
    <p>aaaaad</p>
    </c:if>
        <br>
        <div>
         <input type="password" class="boxs_1"  name="pw" placeholder="비밀번호">
        </div>
        <br>
       <div class="btn_1">
        <button type="submit" class="btn btn-primary">가입</button>
         </div>
        <!-- 로그인 버튼 없어도 된다고 함  onclick="location.href='index.jsp'"   -->              
        </div>
        </div>
    </form>
    
    <div class="item_2">  
     <div class="form-group">
      <div class="item_text">
        <strong>계정이 있으신가요?</strong>
        <a href="index.jsp" onclick=>로그인</a>
      </div>
     </div>
    </div>
   
   </div>
   
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