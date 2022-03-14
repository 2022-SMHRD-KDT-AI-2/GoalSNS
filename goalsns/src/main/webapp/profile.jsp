<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 
<title>챌린샷</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://kit.fontawesome.com/83edcfd603.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="./resources/CSS/menu.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/profile.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/footer.css" rel="stylesheet" type="text/css">
<!-- 모달 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 모달끝 -->
<script type="text/javascript">
	function goProfileEdit(){
		location.href="/goalsns/profileEditForm.do";
	}
	function goFollow(mem_id){
		location.href="/goalsns/follow.do?mem_id="+mem_id;
	}
	function goUnFollow(mem_id){
		location.href="/goalsns/unfollow.do?mem_id="+mem_id;
	}
	function goReward(mem_id){
		location.href="/goalsns/challreward.do?mem_id="+mem_id;
	}
</script>
</head>
<body>
<jsp:include page="menu.jsp" />
<!-- 프로필부분  -->
	<div class="profile_box">
		<div class="prof_img">
			<a href="/goalsns/profile.do?mem_id=${memvo.mem_id}"><img class="img-circle" src="./profilePic/${mvo.mem_img}" width="200" height="200"></a>
		</div>
		<div class="item1">
			<div class="section1">
				<div class="prof_id">
					<span name="mem_id" class="post_id">${mvo.mem_id}</span>
				</div>
				<div class="prof_edit">
				    <!-- 나의 프로필이라면, 프로필편집버튼 / 다른 사람 프로리필이라면, 팔로우버튼  -->
				    <c:if test="${memvo.mem_id==mvo.mem_id}">
					<button class="profile_btn" onclick="goProfileEdit()">프로필편집</button>
					</c:if>
					<c:if test="${memvo.mem_id!=mvo.mem_id}">
					<c:if test="${!empty memfo}">
					<!-- 팔로우 버튼을 누른다면, 팔로잉으로 바뀌기! / 팔로잉을 누르면, 다시 팔로우 버튼으로! -->
					<button class="profile_btn" onclick="goUnFollow('${mvo.mem_id}')">팔로잉&nbsp;<span class="fa-solid fa-user"></span></button>
					</c:if>
					<c:if test="${empty memfo}">
					<button class="profile_btn follow1" onclick="goFollow('${mvo.mem_id}')">팔로우&nbsp;<span class="fa-solid fa-user-plus align-items-center"></span></button>
					</c:if>
					</c:if>
				</div>
				<div class="prof_reward">
					<button class="profile_btn reward" onclick="goReward('${mvo.mem_id}')">챌린지 리워드</button>
				</div>
			</div>

			<div class="section2">
				<div class="post">
					<span class="prof_text">게시물 ${postCnt}</span>
				</div>
				
				<div class="follower">
					<button class="prof_text prof_follower" data-toggle="modal" data-target="#followermodal">팔로워 ${fn:length(tofollowlist)}</button>
				</div>
				<div class="follow">
					<button class="prof_text prof_follow" data-toggle="modal" data-target="#followModal">팔로우 ${fn:length(tofollowedlist)}</button>
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
		<div class="imgbox"><a href="/goalsns/postContent.do?post_seq=${post.post_seq}"><img src="./postPic/${post.post_file}"></a></div>
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
  <div class="modal fade" id="followermodal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->   
      <div class="modal-content">    
        <div class="modal-box">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <span class="model_title">팔로워</span>
        </div>
        <div class="follower-box">
        
	    
	    <c:forEach var="tofled" items="${tofollowlist}">
	        <div class="follower_list">
	        	<a href="/goalsns/followedprofile.do?mem_id=${tofled.from_mem}"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="/goalsns/followedprofile.do?mem_id=${tofled.from_mem}" name="mem_id" class="mem_id">${tofled.from_mem}</a> 
	        </div>
	        </c:forEach>
	      
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
  <div class="modal fade" id="followModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->     
      <div class="modal-content">     
        <div class="modal-box">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <span class="model_title">팔로잉</span>
        </div>       
        <div class="follower-box">
        <c:if test="${memvo.mem_id==mvo.mem_id}">
	        <c:forEach var="fl" items="${followlist}">
	        <div class="follower_list">
	        	<a href="/goalsns/followprofile.do?mem_id=${fl.to_mem}"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="/goalsns/followprofile.do?mem_id=${fl.to_mem}" class="mem_id">${fl.to_mem}</a>
	        	<button class="unfollow">팔로잉</button>  
	        </div>
	        </c:forEach>
	         </c:if>
	        <c:if test="${memvo.mem_id!=mvo.mem_id}">
        	<c:forEach var="tofled" items="${tofollowedlist}">
	        <div class="follower_list">
	        	<a href="/goalsns/followprofile.do?mem_id=${tofled.to_mem}"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="/goalsns/followprofile.do?mem_id=${tofled.to_mem}" class="mem_id">${tofled.to_mem}</a>
	        	<button class="unfollow">팔로잉</button> 
	        </div>
	        </c:forEach>
	    </c:if>
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