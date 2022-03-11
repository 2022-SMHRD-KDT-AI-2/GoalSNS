<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="reward" items="${rewardList}">
	<p>${reward.chell_seq}번 해시태그인데 이름이 나오도록 바꿔야겠네.</p>
	<p>
		${reward.reward1.cnt} / ${reward.reward1.rate} / ${reward.reward1.color}<br>
	</p>
	<p><c:forEach var="tracker" items="${reward.reward2}">
	<%-- <c:if test="${!empty tracker.success}"> --%>
		${tracker.monthly} -> ${tracker.sysc_check}<br>
	<%-- </c:if> --%>
	</c:forEach></p>
	<hr>
</c:forEach>
</body>
</html>