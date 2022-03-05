<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%><!-- 이걸 붙여야 제대로 나온다... -->
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
  <div class="panel panel-default">
    <div class="panel-heading">Panel Heading</div>
    <div class="panel-body">

    	<c:forEach var="vo" items="${list}">
    	<!-- 프로필 이미지 경로 -->
    		<p>${vo.mem_id}</p>
    		<p>${vo.post_file}</p>
    		<p>${vo.post_content}</p>
    		<p>${vo.post_date}</p>
    		<br>
    	</c:forEach>
    </div>
  </div>
</div>

</body>
</html>