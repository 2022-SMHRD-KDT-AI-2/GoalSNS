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
  <link rel="stylesheet" href="font-awesome-animation.min.css">

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="./resources/CSS/menu.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/challReward.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/footer.css" rel="stylesheet" type="text/css">
<!-- 모달 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 모달끝 -->
<script type="text/javascript" src="./resources/js/postunfollow.js"></script>
<script type="text/javascript" src="./resources/js/chart.js"></script>

<!-- chart.js CDN방식으로 불러오기! -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.7.1/dist/chart.min.js"></script>
<script type="text/javascript">
	let today = new Date();
	let date = today.getDate();
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
					<form id="follow_form" class="hide_form">
					<input type="hidden" name="follow_num" value="${mvo.mem_id}">
					<input type="button" class="profile_btn" onclick="return postfollow()">팔로잉&nbsp;<span class="fa-solid fa-user"></span>
					</form>
					</c:if>
					<c:if test="${empty memfo}">
					<form id="follow_form" class="hide_form">
					<input type="hidden" name="follow_num" value="${mvo.mem_id}">
					<input type="button" class="profile_btn follow1" onclick="return postfollow()">팔로우&nbsp;<span class="fa-solid fa-user-plus align-items-center"></span>
					</form>
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

<div class="point"><img class= "point_img" src="./resources/images/reward_icon.png">  챌린지 리워드</div>



<!-- 예지가 적은 멋진차트 나오도록 하는 박스여~ -->
<c:forEach var="reward" items="${rewardList}">

<div class="reward_box">

	<div class="re_box_title">
		@${reward.chell_name}<div class="re_box_month">${month}&ensp;월</div>
	</div>
	
	<div class="re_box_two">
		<div class="re_box_left">
			<div class="re_box_middle">
				<div class="re_color"><i class="fa-solid fa-trophy ${reward.reward1.color}"></i></div>
				<!-- <div class="re_color"><i class="fa-solid fa-trophy yellow"></i></div>
				<div class="re_color"><i class="fa-solid fa-trophy green"></i></div>
				<div class="re_color"><i class="fa-solid fa-trophy blue"></i></div>
				<div class="re_color"><i class="fa-solid fa-trophy rainbow"></i></div> -->
				<div class="sign"> | </div>
				<div class="re_percent">${reward.reward1.rate}%</div>
				<div class="sign"> | </div>
				<div class="re_date">${reward.reward1.cnt}일 성공!</div>
			</div>
			<div class="re_box_bottomtop">-달성표-</div>
			<div  class="re_box_bottom">
			<div class="bottom_flex">
			<c:forEach var="tracker" items="${reward.reward2}" varStatus="status">
			<c:if test="${status.index mod 10 == 0}">
				<div class="habit_tracker">
			</c:if>
			<c:if test="${!empty tracker.success}">
					<div class="tracker_date"></div>
			</c:if>
			<c:if test="${empty tracker.success}">
					<div class="tracker_date nodate"></div>
			</c:if>
			<c:if test="${((status.index+1) mod 10 == 0) || status.last}">
				</div>
			</c:if>
			</c:forEach>
			</div>
			</div>
		</div>
		
		<div class="re_box_right">
			
			<div style="width: 500px;" class="nice_space">
			<canvas id="myChart${reward.chell_seq}"></canvas>
			</div>
			<!-- ---------------------------------------------------------------------- -->
			<script>
			var avgdata${reward.chell_seq} = [];
			var data${reward.chell_seq} = [];
			<c:forEach var="chart" items="${reward.reward3}">
			var rate = (${chart.cnt} / date) * 100;
			data${reward.chell_seq}.push(rate);
			</c:forEach>
			<c:forEach var="avg" items="${reward.avg}">
			var rate2 = ((${avg.cnt} / date) * 100)/${reward.mem_cnt};
			avgdata${reward.chell_seq}.push(rate2);
			</c:forEach>
var chartArea = document.getElementById('myChart'+${reward.chell_seq}).getContext('2d');
var myChart${reward.chell_seq} = new Chart(chartArea, {
    type: 'line',
    data: {
        labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        datasets: [{
            label: '달성률',
            
            data: data${reward.chell_seq},
            
            backgroundColor: 'rgba(246, 118, 0, 1)',
            borderColor: 'rgba(246, 118, 0, 1)',
            borderWidth: 1
        },{
            label: '평균 달성률',
            
            data: avgdata${reward.chell_seq},
            
            backgroundColor: 'rgba(165, 182, 74, 1)',
            borderColor: 'rgba(165, 182, 74, 1)',
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
            	suggestedMax: 100,
                beginAtZero: true,
                ticks: {
                    stepSize: 20
                  }
            }
        }
    }
});
</script>
			<!-- ---------------------------------------------------------------------- -->

		</div>
	</div>
	
</div>

</c:forEach>

<!-- 끝 -->





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
  <div class="modal fade" id="followModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->     
      <div class="modal-content">     
        <div class="modal-box">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <span class="model_title">팔로잉</span>
        </div>       
        <div class="follower-box">
	        <div class="follower_list">
	        	<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="#" name="mem_id" class="mem_id">challin_shot</a>
	        	<button class="unfollow">팔로잉</button>  	
	        </div>
	        <div class="follower_list">
	        	<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        	<a href="#" name="mem_id" class="mem_id">challin_shot</a>
	        	<button class="unfollow">팔로잉</button>  	
	        </div> 
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