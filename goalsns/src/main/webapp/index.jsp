<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
</head>
<body>
 
<div class="container">
  <h2>챌린샷</h2>
  <div class="panel panel-default">
    <div class="panel-heading">
    <form class="form-inline" action="/action_page.php">
  <div class="form-group">
    <label for="email">이메일 주소:</label>
    <input type="email" class="form-control" id="email">
  </div><br>
  <div class="form-group">
    <label for="pwd">비밀번호:</label>
    <input type="password" class="form-control" id="pwd">
  </div><br>
  <div class="checkbox">
    <label><input type="checkbox"> 기억하기</label>
  </div>
  <button type="submit" class="btn btn-default">로그인</button>
</form>
    </div>
    <div class="panel-body">
   
  </div>
<div class="panel-footer"> 
</div>
</div >

</body>
</html>
    