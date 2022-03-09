<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
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
<link href="./resources/CSS/footer.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/searchResult.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="menu.jsp" />

<div class="top_space">
	<div><span class="search_title">${search}</span></div>
	<div><span class="search_count">게시물 ${postCnt}</span></div>
	<div><span class="search_popular">인기 게시물</span></div>
</div>

<c:forEach var="post" items="${list}" varStatus="status">
	<c:if test="${status.index mod 3 == 0}">
		<div class="img_row">	
	</c:if>
		<div class="imgbox"><img src="./postPic/${post.post_file}"></div>
	<c:if test="${((status.index+1) mod 3 == 0) || status.last}">
		</div>
	</c:if>
</c:forEach>


<jsp:include page="footer.jsp" />
</body>
</html>