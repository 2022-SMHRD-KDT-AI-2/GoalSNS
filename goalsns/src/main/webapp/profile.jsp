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
<link href="./resources/CSS/profile.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/footer.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function goProfileEdit(){
		location.href="/goalsns/profileEditform.do";
	}
	function goFollow(mem_id){
		location.href="/goalsns/follow.do?mem_id="+mem_id;
	}
</script>
</head>
<body>
<jsp:include page="menu.jsp" />
<!-- 프로필부분  -->
	<div class="profile_box">
		<div class="prof_img">
			<a href="#"><img class="img-circle" src="./resources/images/profile.png" width="200" height="200"></a>
		</div>
		<div class="item1">
			<div class="section1">
				<div class="prof_id">
					<span name="mem_id" class="post_id">${mvo.mem_id}</span>
				</div>
				<div class="prof_edit">
				    <!-- 나의 프로필이라면, 프로필편집버튼 / 다른 사람 프로리필이라면, 팔로우버튼  -->
					<button class="profile_btn" onclick="goProfileEdit()">프로필편집</button>
					<c:if test="${!empty memfo}">
					<a href="/goalsns/follow.do?mem_id=${mvo.mem_id}">언팔로우</a>
					<button class="profile_btn follow1" onclick="goFollow(${mvo.mem_id})">언팔로우&nbsp;<span class="fa-solid fa-user-plus align-items-center"></span></button>
					</c:if>
					<c:if test="${empty memfo}">
					<a href="/goalsns/follow.do?mem_id=${mvo.mem_id}">팔로우테스트</a>
					<button class="profile_btn follow1" onclick="goFollow(${mvo.mem_id})">팔로우&nbsp;<span class="fa-solid fa-user-plus align-items-center"></span></button>
					</c:if>
				</div>
				<div class="prof_reward">
					<button class="profile_btn reward">챌린지 리워드</button>
				</div>
			</div>

			<div class="section2">
				<div class="post">
					<span class="prof_text">게시물 ${postCnt}</span>
				</div>
				<div class="follower">
					<button class="prof_text">팔로워 20</button>
				</div>
				<div class="follow">
					<button class="prof_text">팔로우 19</button>
				</div>
			</div>

			<div class="section3">
				<div class="prof_text_div">
					<p class="prof_text">${mvo.mem_about}</p>
				</div>
			</div>
		</div>
	</div>



<div class="point"><i class="fa-solid fa-table-cells"></i>  게시물</div>

<c:forEach var="post" items="${postList}" varStatus="status">
	<c:if test="${status.index mod 3 == 0}">
		<div class="img_row">	
	</c:if>
		<div class="imgbox"><img src="./postPic/${post.post_file}"></div>
	<c:if test="${((status.index+1) mod 3 == 0) || status.last}">
		</div>
	</c:if>
</c:forEach>
<!-- 사진들 -->
<!-- 
<div class="img_row">
	<div class="imgbox"><img src="./postPic/${post.post_file}"></div>
	<div class="imgbox"><img src="./postPic/${post.post_file}"></div>
	<div class="imgbox"><img src="./postPic/${post.post_file}"></div>
</div>
 --> 

<jsp:include page="footer.jsp" />
</body>
</html>