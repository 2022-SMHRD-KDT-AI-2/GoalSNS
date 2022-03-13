<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("chell", "@"); %>
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

<!-- 모달창  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 모달창 끝  -->
<script type="text/javascript" src="./resources/js/all.js"></script>
</head>
<script type="text/javascript">
	function goContent(post_seq){
		location.href="/goalsns/postContent.do?post_seq="+post_seq;
	}
	function goLike(post_seq){
		location.href="/goalsns/like.do?post_seq="+post_seq;
	}
	function goDeleteLike(post_seq){
		location.href="/goalsns/likeDelete.do?post_seq="+post_seq;
	}
	//function goDeleteContent(post_seq){
	//	location.href="/goalsns/cmtDelete.do?post_seq="+post_seq;
	//}
	
	
</script>
<body>
<jsp:include page="menu.jsp" />
<!-- 이런식으로 하면 여기만 바꿔서 코딩하면 상단과 하단을 분리해서 쓸 수 있어요 -->
<div id="jb-container">
<c:forEach var="vo" items="${list}" varStatus="statusNm">
  <div id="peedbox">
    <div id="peedboxtop" >
    <c:forEach var="memImages" items="${memImages}" begin="${statusNm.index}" end="${statusNm.index}">
        <a href="/goalsns/profile.do?mem_id=${vo.mem_id}"><img id="peedimg" class="img-circle" src="./profilePic/${memImages}" width="50" height="50" ></a>
       </c:forEach>
        <a href="/goalsns/profile.do?mem_id=${vo.mem_id}" name="mem_id" class="mem_id">${vo.mem_id}</a>
      	<button type="button" class="mybtn" data-toggle="modal" data-target="#myModal"><i class="fa-solid fa-ellipsis"></i></button>
    </div>
    <div name="post_file" id="post_file" >
      <img src="./postPic/${vo.post_file}" class="postfile"width="100%">
    </div>
    <section>
    <c:forEach var="isLike" items="${likeCheck}" begin="${statusNm.index}" end="${statusNm.index}">
    <c:if test="${isLike.lseq eq 0}">
    	    <form id="like_form${vo.post_seq}">
			<input type="hidden" name="board_num" value="${vo.post_seq}"> <!-- 게시글넘버 -->
			<input type="button" onclick="return like(${vo.post_seq})"><span class="fa-regular fa-heart heart ${vo.post_seq}"></span>
 	</form>
    </c:if>
    <c:if test="${isLike.lseq ne 0}">
    	    <form id="like_form${vo.post_seq}">
			<input type="hidden" name="board_num" value="${vo.post_seq}"> <!-- 게시글넘버 -->
			<input type="button" onclick="return like(${vo.post_seq})"><span class="fa-solid fa-heart disheart ${vo.post_seq}"></span>
 	</form>
    </c:if>
    </c:forEach>

 		<a></a>
 		<!--<a><i class="fa-regular fa-heart" onclick="goDeleteLike(${vo.post_seq})"></i></a>-->
 		<a href="/goalsns/postContent.do?post_seq=${vo.post_seq}"><i class="fa-regular fa-comment fa-flip-horizontal"></i></a>
 		<!-- <a><i class="fa-regular fa-comment fa-flip-horizontal" onclick="goDeleteContent(${vo.post_seq})"></i></a> -->
    </section>
    <div>
      <span name="mem_id" class="post_id">${vo.mem_id}</span>
      <c:forEach var="f" items="${fn:split(vo.post_content,' ')}" >
      <c:if test="${fn:contains(f,'#')}">
      <a href="#" class="hashtag">${f}</a>
      </c:if>
      <c:if test="${fn:contains(f,'@')}">
      <a href="#" class="chall_hashtag">${f}</a>
      </c:if>
      <c:if test="${not fn:contains(f,'@')&&not fn:contains(f,'#')}">
      <span>${f}</span>
      </c:if>
      </c:forEach>
   </div>
   <div class="divplus">
      <a href="#" class="plus">댓글 23개 모두 보기</a>
   </div>
   <div>
      <span name="mem_id" class="post_id">123213</span>
      <span class="post_con">ddddddddd</span>
   </div>
   <div name="post_date" class="post_date"><span id="post_date">${vo.post_date}</span></div>
  
  <div class="textsection">
	  <div class="textsection1"><i class="fa-regular fa-face-smile-wink"></i></div>
      <form action="/goalsns/cmt.do"><div class="textsection2">
      <input type="hidden" name="post_seq" value = "${vo.post_seq}">
      <textarea name="content" id="comment_textarea" cols="1333" rows="1" placeholder="댓글 달기..."></textarea></div>
      <div class="textsection3"><button class="text_bt" type="submit">게시</button></div></form>
  </div>

 </div>
 </c:forEach>



  <div>
    <div id="sidebar">
      <h2>인기 챌린지 해시태그</h2>
      <c:forEach var="t" items="${trend}" varStatus="i">
      <div class="chell1"><a href="/goalsns/search.do?search=${t.chell_name}">@${t.chell_name}</a></div>
      <div id="chellcount1">${t.cnt}명 참여 중</div>
      </c:forEach>
<!--       <div class="chell1">#30일_물마시기_챌린지</div>
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
      <div id="chellcount6">1233명 참여 중</div> -->
    </div>
    <div id="sidebar2">
      <h2>유저랭킹</h2>
      <c:forEach var="mem" items="${rank}" varStatus="i">
      <div class="userrank1"><a href="/goalsns/profile.do?mem_id=${mem}">${i.count}. ${mem}</a></div>
<!--       <div class="userrank1">1. Hello_chall</div>
      <div class="userrank2">2. Hello_chall</div>
      <div class="userrank3">3. Hello_chall</div>
      <div class="userrank4">4. Hello_chall</div>
      <div class="userrank5">5. Hello_chall</div> -->
      </c:forEach>
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
<!-- 모달 끝 -->
<jsp:include page="footer.jsp" />
</body>
</html>