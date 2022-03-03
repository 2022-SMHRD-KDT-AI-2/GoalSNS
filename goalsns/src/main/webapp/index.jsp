<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <form class="form-inline" action="goalsns/index" method="post">
  <div class="form-group">
    <label for="mem_id">아이디</label>
    <input type="text" class="form-control" id="mem_id">
  </div><br>
  <div class="form-group">
    <label for="mem_pw">비밀번호</label>
    <input type="password" class="form-control" id="mem_pw">
  </div><br>
  <div class="checkbox">
    <label><input type="checkbox">아이디기억</label>
  </div>
  <button type="submit" class="btn btn-primary">로그인</button>
  
</form>
   </div> 
</div>
</body>
</html>
    