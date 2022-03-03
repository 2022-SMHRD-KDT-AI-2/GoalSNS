
<%@ page import="goalsns.entity.MemberVO"%>

  
<%@page import="java.util.List"%>
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
</head>
<body>
 
<div class="container">
  <h2>梨�由곗��</h2>
  <div class="panel panel-default">
    <div class="panel-heading">
    <form class="form-inline" action="goalsns/" method="post">
  <div class="form-group">
    <label for="email">�대��� 二쇱��:</label>
    <input type="text" class="form-control" id="mem_id">
  </div><br>
  <div class="form-group">
    <label for="pwd">鍮�諛�踰���:</label>
    <input type="password" class="form-control" id="mem_pw">
  </div><br>
  <div class="checkbox">
    <label><input type="checkbox"> 湲곗�듯��湲�</label>
  </div>
  <button type="submit" class="btn btn-primary">濡�洹몄��</button>
  
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
    