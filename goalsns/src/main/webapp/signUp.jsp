<%@page import="goalsns.entity.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset="utf-8">
<link href="./resources/CSS/signUp.css" rel="stylesheet" type="text/css">
<title>챌린샷</title>
<script type="text/javascript">
	
window.onload=function(){
    document.getElementById("sendbtn").onclick =checkit
}
function checkit(){
	var aa=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/; // 표준식
    // a부터 z까지 문자 1개 이상일 경우 and 숫자 0,1,2일 경우에만 / [^a-z, 0,1,2] : ^ 붙이면 부정의 뜻 / 한글은 가-힣
    if(!fo.email.value.match(aa)){
        alert("이메일을 정확히 입력하세요!");
        fo.email.focus();
        return;   
    }
    if(document.fo.name.value === "" || isNaN(fo.name.value) === false){ 
        fo.name.focus(); 
      alert("이름이 비어있거나 숫자가 들어있습니다.");
      return;
 }
    if (document.fo.name.value.indexOf(" ") >= 0) {
        alert("이름에 공백을 사용할 수 없습니다.")
        document.fo.name.focus();
        return;
    }
    if(fo.name.value.length < 2) {
        fo.name.focus();
          alert("이름은 2글자이상 입력가능합니다.")
          return;
     }
    if (fo.id.value == "") {
        alert("아이디를 입력하지 않았습니다.")
        fo.id.focus();
        return;
    }
 
    for (var i = 0; i < document.fo.id.value.length; i++) {
        ch = document.fo.id.value.charAt(i)
        if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')&&!(ch=='.')&&!(ch=='_')) {
            alert("아이디는 영문 대소문자, 숫자, 특수문자(.,_)만 입력가능합니다.")
            document.fo.id.focus();
            return;
        }
    }
    if (document.fo.id.value.indexOf(" ") >= 0) {
        alert("아이디에 공백을 사용할 수 없습니다.")
        document.fo.id.focus();
        return;
    }
    if(fo.id.value.length < 4||fo.id.value.length>29) {
        fo.id.focus();
          alert("아이디는 4글자 이상 30자미만이여만 합니다!")
          return;
     }
    if (document.fo.pw.value == "") {
        alert("비밀번호를 입력하지 않았습니다.")
        document.fo.pw.focus();
        return;
    }
    if (fo.pw.value == fo.id.value) {
        alert("아이디와 비밀번호가 같습니다.")
        document.fo.pw.focus();
        return;
    }
    if (document.fo.pw.value.indexOf(" ") >= 0) {
        alert("비밀번호에 공백을 사용할 수 없습니다.")
        document.fo.pw.focus();
        return;
    }
    for (var i = 0; i < document.fo.pw.value.length; i++) {
        ch = document.fo.pw.value.charAt(i)
        if (!(ch >= '!' && ch <= '~')) {
            alert("비밀번호는 영문 대소문자, 숫자와 특수문자만 입력가능합니다.")
            document.fo.pw.focus();
            return;
        }
    }
    if(fo.pw.value.length < 4||fo.pw.value.length>29) {
        fo.pw.focus();
          alert("비밀번호는 4글자 이상 30자미만이여만 합니다!")
          return;
     }
    
          fo.action = "/goalsns/userRegister.do";
          fo.method = "post";
          fo.submit(); 
 
 
 }   
	    
	function idcheck(){
		let id=document.getElementById('id').value;
		location.href="/goalsns/idCheck.do?id="+id;
	}
</script>
</head>
<body>
   
  <div class="container">
  
   <form name="fo">
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
        <br>
        <div>
         <input type="password" class="boxs_1"  name="pw" placeholder="비밀번호">
        </div>
        <br>
       <div class="btn_1">
        <button type="button" id="sendbtn" class="btn btn-primary">가입</button>
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