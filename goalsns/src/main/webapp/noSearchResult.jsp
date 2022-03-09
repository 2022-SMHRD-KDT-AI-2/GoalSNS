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
<link href="./resources/CSS/noSearchResult.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="menu.jsp" />


<div class="all_sorry">
	<div><span class="oops">Oops!</span></div>
	<div><i class="fa-regular fa-face-sad-tear"></i></div>
	<div><span class="canyou">'검색결과'에 대한 검색 결과를 찾을 수가 없어요.</span></div>
	<div><span class="canyou">다른 검색어로 검색을 해보시겠어요?</span></div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>