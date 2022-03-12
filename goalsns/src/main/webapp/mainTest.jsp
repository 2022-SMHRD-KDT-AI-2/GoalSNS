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
<link href="./resources/CSS/main.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/footer.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="./resources/js/all.js"></script>


<!-- 모달 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 모달끝 -->
</head>
<body>
<jsp:include page="menu.jsp" />
<!-- 이런식으로 하면 여기만 바꿔서 코딩하면 상단과 하단을 분리해서 쓸 수 있어요 -->
<div id="jb-container">
  <div id="peedbox">
    <div id="peedboxtop" >
        <a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
        <a href="#" name="mem_id" class="mem_id">글쓴아이디</a>
      	<button type="button" class="mybtn" data-toggle="modal" data-target="#myModal"><i class="fa-solid fa-ellipsis"></i></button>
    </div>
    <div name="post_file" id="post_file" >
      <img src="./resources/images/profile.png" class="postfile"width="100%">
    </div>
    <section>
    
    
    <!-- heart hover 시 연하게 바뀜! -->
 		<button id="heart"><i class="fa-regular fa-heart heart"></i></button>
 		
 		
 		
 		<button type="button" class="cutes" data-toggle="modal" data-target="#cute"><i class="fa-regular fa-comment fa-flip-horizontal"></i></button>
    </section>http://localhost:8081/goalsns/mainTest.jsp#
    <div>
      <span name="mem_id" class="post_id">글쓴아이디</span>
      <span class="post_con">포스트컨텐츠
       <!-- 밑의 2줄이 추가 됨.(위의 post_con span태그 안에 넣어야함!!) -->
       <!-- <a href="#" class="hashtag">#일반해시태그</a> -->
       <!-- <a href="#" class="chall_hashtag">@챌린지해시태그</a> -->
      	</span>
   </div>
   <div class="divplus">
      <a href="#" class="plus">댓글 23개 모두 보기</a>
   </div>
   <div>
      <span name="mem_id" class="post_id">idididididididid</span>
      <span class="post_con">안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요</span>
   </div>
   <div name="post_date" class="post_date"><span id="post_date">2022.02.10</span></div>
  
  <div class="textsection">
	  <div class="textsection1"><i class="fa-regular fa-face-smile-wink"></i></div>
      <form action="/goalsns/cmt.do"><div class="textsection2">
      <input type="hidden" name="post_seq" value = "${vo.post_seq}">
      <textarea name="content" id="comment_textarea" cols="1333" rows="1" placeholder="댓글 달기..."></textarea></div>
      <div class="textsection3"><button class="text_bt" type="submit">게시</button></div></form>
  </div>
  
 </div>
 <div id="peedbox">
    <div id="peedboxtop" >
        <a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
        <a href="#" name="mem_id" class="mem_id">글쓴아이디</a>
      	<button type="button" class="mybtn" data-toggle="modal" data-target="#myModal"><i class="fa-solid fa-ellipsis"></i></button>
    </div>
    <div name="post_file" id="post_file" >
      <img src="./resources/images/profile.png" class="postfile"width="100%">
    </div>
    <section>
 		<a><i class="fa-regular fa-heart"></i></a>
 		<button type="button" class="cutes" data-toggle="modal" data-target="#cute"><i class="fa-regular fa-comment fa-flip-horizontal"></i></button>
    </section>
    <div>
      <span name="mem_id" class="post_id">글쓴아이디</span>
      <span class="post_con">포스트컨텐츠 #일반해시태그 @챌린지해시태그</span>
   </div>
   <div class="divplus">
      <a href="#" class="plus">댓글 23개 모두 보기</a>
   </div>
   <div>
      <span name="mem_id" class="post_id">idididididididid</span>
      <span class="post_con">안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요</span>
   </div>
   <div name="post_date" class="post_date"><span id="post_date">2022.02.10</span></div>
  
  <div class="textsection">
	  <div class="textsection1"><i class="fa-regular fa-face-smile-wink"></i></div>
      <form action="/goalsns/cmt.do"><div class="textsection2"><textarea name="comment_textarea" id="comment_textarea" cols="1333" rows="1" placeholder="댓글 달기..."></textarea></div>
      <div class="textsection3"><button class="text_bt" type="submit">게시</button></div></form>
  </div>
  
 </div>



  <div>
    <div id="sidebar">
      <h2>인기 챌린지 해시태그</h2>
      <div class="chell1">#30일_물마시기_챌린지</div>
      <div id="chellcount1">1233명 참여 중</div>
      <div class="chell2">#30일_물마시기_챌린지</div>
      <div id="chellcount2">1233명 참여 중</div>
      <div class="chell3">#30일_물마시기_챌린지</div>
      <div id="chellcount3">1233명 참여 중</div>
      <div class="chell4">#30일_물마시기_챌린지</div>
      <div id="chellcount4">1233명 참여 중</div>
      <div class="chell5">#30일_물마시기_챌린지</div>
      <div id="chellcount5">1233명 참여 중</div>
      <div class="chell6">#30일_물마시기_챌린지</div>
      <div id="chellcount6">1233명 참여 중</div>
    </div>
    <div id="sidebar2">
      <h2>유저랭킹</h2>
      <div class="userrank1">1. Hello_chall</div>
      <div class="userrank2">2. Hello_chall</div>
      <div class="userrank3">3. Hello_chall</div>
      <div class="userrank4">4. Hello_chall</div>
      <div class="userrank5">5. Hello_chall</div>
    </div>
  </div>
  
</div>

<!-- 모달창 -->
<div class="background">
  <div class="window">
    <div class="popup"></div>
</div>

<!-- 모달 -->
<div class="container">
  <!-- Modal -->
  <div class="modal fade" id="cute" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-box">
			여기 안에 프로필화면
        </div>
      </div>
    </div>
  </div>
</div> 
<!-- 모달 끝  -->





<jsp:include page="footer.jsp" />

</body>
</html>