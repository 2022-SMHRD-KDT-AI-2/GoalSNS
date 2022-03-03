<%@page import="java.util.List"%>
<%@page import="goalsns.entity.PostVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
    	List<PostVO> list = (List<PostVO>)request.getAttribute("list");
    %>
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
<link href="./NewFile.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="menu.jsp" />
<!-- 이런식으로 하면 여기만 바꿔서 코딩하면 상단과 하단을 분리해서 쓸 수 있어요 -->
<%for(int i=0; i<list.size(); i++){
    			PostVO vo =list.get(i); %>
	    		<%= vo.getPost_content() %>
	    		<%= vo.getMem_id() %>
	    		<%= vo.getPost_date() %>
	    		<img src="postPic/<%= vo.getPost_file() %>">
    		<% } %>
<jsp:include page="footer.jsp" />
</body>
</html>