<%@page import="goalsns.entity.MemberVO"%>
<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>챌린샷</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
window.history.forward();
function noBack(){window.history.forward();}
</script>
<link href="./resources/CSS/index.css" rel="stylesheet" type="text/css">
</head>
<body onload="noback();" onpageshow="if(event.persisted) noback();" onunload="index.jsp">
<script type="text/javascript">
window.onload=function(){
    document.getElementById("sendbtn").onclick =checkit
}
function checkit(){
    if (fo.mem_id.value == "") {
        alert("아이디를 입력하지 않았습니다.")
        fo.id.focus();
        return;
    } else if (document.fo.mem_id.value.indexOf(" ") >= 0) {
        alert("아이디에 공백을 사용할 수 없습니다.")
        document.fo.mem_id.focus();
        return;
    } else if(fo.mem_id.value.length < 4||fo.mem_id.value.length>29) {
        fo.mem_id.focus();
          alert("아이디는 4글자 이상 30자미만이여만 합니다!")
          return;
     }
 
    for (var i = 0; i < document.fo.mem_id.value.length; i++) {
        ch = document.fo.mem_id.value.charAt(i)
        if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')&&!(ch=='.')&&!(ch=='_')) {
            alert("아이디는 영문 대소문자, 숫자, 특수문자(.,_)만 입력가능합니다.")
            document.fo.mem_id.focus();
            return;
        }
    }
    
    if (document.fo.mem_pw.value == "") {
        alert("비밀번호를 입력하지 않았습니다.")
        document.fo.mem_pw.focus();
        return;
    } else if (fo.mem_pw.value == fo.mem_id.value) {
        alert("아이디와 비밀번호가 같습니다.")
        document.fo.mem_pw.focus();
        return;
    } else if (document.fo.mem_pw.value.indexOf(" ") >= 0) {
        alert("비밀번호에 공백이 포함되어 있습니다.")
        document.fo.mem_pw.focus();
        return;
    }
    
    if(fo.mem_pw.value.length < 4||fo.mem_pw.value.length>29) {
        fo.mem_pw.focus();
          alert("비밀번호는 4글자 이상 30자미만이여만 합니다!")
          return;
     }
    
          fo.action = "/goalsns/login.do"
          fo.method = "post";
          fo.submit(); 
 
 }
</script>
 
 
 
<div class="container">
 
 
  <div class="panel panel-default">  
    <div class="panel-heading">
    <form class="form-inline" name="fo">
  <img src="./resources/images/logo.png" alt="프로필 사진 바꾸기" >	
  <div class="item_1">
  <table>
 <tr>
  <td>
  <div class="form-group">
    <label for="mem_id"></label>
    <input type="text" class="form-control" name="mem_id" id="mem_id" placeholder="사용자 이름">
  </div>
  </td>
  </tr>
 <tr>
 <td>
  <div class="form-group">
    <label for="mem_pw"></label>
    <input type="password" class="form-control" name="mem_pw" id="mem_pw" placeholder="비밀번호">
  </div><br>
  </td>
  </tr>
   </table>
  <div  class="form-group">
  <div class="btn_1">
  <button type="button" id="sendbtn" class="btn btn-primary">로그인</button>
</div>
</div>


  </div>  
   </form>
 
 
   <div class="item_2">
  
   <div  class="form-group">
   <div class="item_text">
  <strong>계정이 없으신가요?</strong>
  <a href="signUp.jsp">가입하기</a>
  </div>
  </div>
 
   </div>
   
  </div>
  
  
</div>
</div>

</body>
</html>
    