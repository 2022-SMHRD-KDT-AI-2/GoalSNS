<%@page import="goalsns.entity.MemberVO"%>
<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
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
<body onload="noback();"onpageshow="if(event.persisted) noback();"onunload="index.jsp">

 
 
 
<div class="container">
 
 
  <div class="panel panel-default">  
    <div class="panel-heading">
    <form class="form-inline" action="/goalsns/login.do" method="post">
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
  <button type="submit" class="btn btn-primary">로그인</button>
</div>
</div>


  </div>  
   </form>
 
 
   <div class="item_2">
  
   <div  class="form-group">
   <div class="item_text">
  <strong>계정이 없으신가요?</strong>
  <a href="#" onclick="location.href='signUp.jsp'">가입하기</a>
  </div>
  </div>
 
   </div>
   
  </div>
  
  
</div>
</div>

</body>
</html>
    