<<<<<<< HEAD
<%@ page import="goalsns.entity.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
=======
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-2/GoalSNS.git
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>챌린샷</h2>
  <div class="panel panel-default">
    <div class="panel-heading">
    <form class="form-inline" action="goalsns/" method="post">
  <div class="form-group">
    <label for="email">이메일 주소:</label>
    <input type="text" class="form-control" id="mem_id">
  </div><br>
  <div class="form-group">
    <label for="pwd">비밀번호:</label>
    <input type="password" class="form-control" id="mem_pw">
  </div><br>
  <div class="checkbox">
    <label><input type="checkbox"> 기억하기</label>
  </div>
  <button type="submit" class="btn btn-primary">로그인</button>
  
</form>
   </div> 
    
<script>
    function data(){
    	let txt=document.getElementById("mem_id").value;
    	let txt1=document.getElementById("mem_pw").value;
    	document.write(txt)
    	document.write("<br>")
    	document.write(txt1)  	
    }
</script>

</body>
</html>
    