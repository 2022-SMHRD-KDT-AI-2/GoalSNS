<%@ page import="goalsns.entity.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
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
</head>
<body onload="noback();"onpageshow="if(event.persisted) noback();"onunload="index.jsp">
 
<div class="container">
  <h2>챌린샷</h2>
  <div class="panel panel-default">  
    <div class="panel-heading">
    <form class="form-inline" action="/goalsns/login.do" method="post">
  <div class="form-group">
    <label for="mem_id">아이디:</label>
    <input type="text" class="form-control" name="mem_id" id="mem_id">
  </div>
  <br>
  <div class="form-group">
    <label for="mem_pw">비밀번호:</label>
    <input type="password" class="form-control" name="mem_pw" id="mem_pw">
  </div><br>
  <button type="submit" class="btn btn-primary">로그인</button>
  </form>
  <button class="btn" onclick="location.href='signUp.jsp'">회원가입</button>
</div>
</div>
</div>

</body>
</html>
    