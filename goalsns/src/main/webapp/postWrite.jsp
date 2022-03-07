<%@page import="java.util.List"%>
<%@page import="goalsns.entity.PostVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://kit.fontawesome.com/83edcfd603.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="./resources/CSS/menu.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="menu.jsp" />

<form method="post" enctype="multipart/form-data" action="/goalsns/postWrite.do">
    <table>
        <input type="file" name="post_file">
        <div class="form-group">
        <div class="section1"></div>
            <label for="comment"></label>
            <textarea name="post_content" rows="5" id="comment"></textarea>
            <button type="submit">생성</button>
        </div>
	</table>
</form> 

<jsp:include page="footer.jsp" />
</body>
</html>