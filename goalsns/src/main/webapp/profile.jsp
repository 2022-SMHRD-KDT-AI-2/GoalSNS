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
					<c:if test="${memvo.mem_id!=mvo.mem_id}">
					<c:if test="${!empty memfo}">
					<a href="/goalsns/follow.do?mem_id=${mvo.mem_id}">언팔로우</a>
					<!-- 팔로우 버튼을 누른다면, 팔로잉으로 바뀌기! / 팔로잉을 누르면, 다시 팔로우 버튼으로! -->
					<button class="profile_btn follow1" onclick="goFollow(${mvo.mem_id})">언팔로우&nbsp;<span class="fa-solid fa-user-plus align-items-center"></span></button>
					</c:if>
					<c:if test="${empty memfo}">
					<a href="/goalsns/follow.do?mem_id=${mvo.mem_id}">팔로우테스트</a>
					<button class="profile_btn follow1" onclick="goFollow(${mvo.mem_id})">팔로우&nbsp;<span class="fa-solid fa-user-plus align-items-center"></span></button>
					</c:if>
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
					<button class="prof_text prof_follower" data-toggle="modal" data-target="#myModal">팔로워 20</button>
				</div>
				<div class="follow">
					<button class="prof_text prof_follow" data-toggle="modal" data-target="#myModal">팔로우 19</button>
				</div>
			</div>

			<div class="section3">
				<div class="prof_text_div">
					<p class="prof_text">${mvo.mem_about}</p>
				</div>
			</div>
		</div>
	</div>



<div class="point"><img class="point_img" src="./resources/images/grid_icon.png">  게시물</div>

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


<!-- 팔로워 모달창 -->
<div class="background">
  <div class="window">
    <div class="popup"></div>
</div>
<!-- 모달 -->
<div class="container">
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      
      <div class="modal-content">
      
        <div class="modal-box">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <span class="model_title">팔로워</span>
        </div>
        
        <div class="follower-box">
	        <div class="follower_list">
	        	<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="#" name="mem_id" class="mem_id">challin_shot</a>
	        </div>
	        <div class="follower_list">
	        	<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="#" name="mem_id" class="mem_id">challin_shot</a>
	        </div>
	        <div class="follower_list">
	        	<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="#" name="mem_id" class="mem_id">challin_shot</a>
	        </div>
	        <div class="follower_list">
	        	<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="#" name="mem_id" class="mem_id">challin_shot</a>
	        </div>
	        <div class="follower_list">
	        	<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="#" name="mem_id" class="mem_id">challin_shot</a>
	        </div>
	        <div class="follower_list">
	        	<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="#" name="mem_id" class="mem_id">challin_shot</a>
	        </div>
	        <div class="follower_list">
	        	<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="#" name="mem_id" class="mem_id">challin_shot</a>
	        </div>
	        <div class="follower_list">
	        	<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="#" name="mem_id" class="mem_id">challin_shot</a>
	        </div>
	        
        </div>
        
      </div>
      
    </div>
  </div>
</div>
</div>
<!-- 팔로워 모달 끝 -->

<!-- 팔로우 모달창 -->
<div class="background">
  <div class="window">
    <div class="popup"></div>
</div>
<!-- 모달 -->
<div class="container">
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-box">
        <c:if test="${memvo.mem_id == vo.mem_id}">
        	<a href="/goalsns/postDelete.do" class="modal-red">게시글 삭제</a>
        </c:if>
          <!-- 내 게시물이라면? 게시글 삭제,
           상대방 게시물(팔로잉)이라면? 팔로우 취소, 상대방 게시물(팔로우안함)이라면? 팔로우 -->
          <a href="#" class="modal-red">팔로우 취소</a>
          <!-- <a href="#" class="modal-red">게시글 삭제</a> -->
          <!-- <a href="#" class="modal-blue">팔로우</a> -->
        </div>
        <div class="modal-box">
          <a href="#" class="black">링크복사</a>
        </div>
        <div class="modal_cancel">
          <button class="canbtn" data-dismiss="modal">취소</button>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
<!-- 팔로우 모달 끝 -->



<jsp:include page="footer.jsp" />
</body>
</html>