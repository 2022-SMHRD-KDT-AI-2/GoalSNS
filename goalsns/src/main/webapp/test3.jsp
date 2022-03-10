<%@ page import="java.util.List" %>
<%@ page import="goalsns.entity.FollowVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% List<FollowVO> flist=(ArrayList<FollowVO>)request.getAttribute("flist"); %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%for(int i=0;i<flist.size();i++){ FollowVO vo=flist.get(i);%>
	<a href="profile.do"><%=vo.getTo_mem() %></a>
	<%} %>
</body>
</html>