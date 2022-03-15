<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>
<%@ page errorPage="index.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<script type="text/javascript" src="./resources/js/all.js"></script>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://kit.fontawesome.com/83edcfd603.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="./resources/CSS/menu.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/footer.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/postContent.css" rel="stylesheet" type="text/css">
<!-- 모달 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 모달끝 -->
</head>
<script type="text/javascript">
	function goContent(post_seq){
		location.href="/goalsns/postContent.do?post_seq="+post_seq;
	}
	function goLike(post_seq){
		location.href="/goalsns/postLike.do?post_seq="+post_seq;
	}
</script>
<script type="text/javascript" src="./resources/js/postunfollow.js"></script>
<script type="text/javascript" src="./resources/js/all.js"></script>
<body>
<jsp:include page="menu.jsp" />
<div class="containerbox">

	<div name="post_file" id="post_file" class="left_item">
	      <%-- <img src="./postPic/${vo.post_file}" class="postfile"> --%>
	      <img src="./resources/images/small.jpg" class="postfile">
	</div>
	<div class="right_item">
		<!--첫번째 줄 -->
		<div id="right_item_top" >
        	<a href="#"><img id="peedimg" class="img-circle" src="./profilePic/${memvo.mem_img}" width="50" height="50" ></a>
        	<a href="#" name="mem_id" class="mem_id">${vo.mem_id}</a>
        	<!-- 내가 상대방을 팔로우 했다면, 팔로잉보여지게(클릭X),
        	 팔로우를 하지 않았다면, 팔로우 클릭 시 팔로잉이 되도록(클릭O) -->
        	<span class="follow following">• 팔로잉</span>
        	<!-- <span class="follow follow_click"><a href="#">• 팔로우</a></span> -->
      		<button type="button" class="mybtn" data-toggle="modal" data-target="#myModal"><i class="fa-solid fa-ellipsis"></i></button>
    	</div>

		<!-- 두번째 줄(댓글공간) -->
		<div class="right_item_middle">
			<div class="me_coments">
				<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
        		<div>
        			<div>
        				<a href="#" name="mem_id" class="mem_id">${vo.mem_id}</a>
        				<span class="me_con">${vo.post_content}</span>
        			</div>
        			<span id="post_date"><fmt:formatDate value="${vo.post_date}" pattern="yyyy.MM.dd HH:mm"/></span>
        		</div>
			</div>
			
			<!-- 댓글 많이 추가함(지워도 됌) -->
			<c:forEach var="c" items="${list}" varStatus="i">
				<div class="me_coments">
					<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
	        		<div>
        			<div>
        				<a href="#" name="mem_id" class="mem_id">${c.mem_id}</a>
        				<span class="me_con">${c.cmt_content}</span>
        			</div>
        			<span id="post_date"><fmt:formatDate value="${c.cmt_date}" pattern="yyyy.MM.dd HH:mm"/> </span>
        		</div>
				</div>
			</c:forEach>
			<!--<div class="me_coments">
				<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
        		<div>
        			<div>
        				<a href="#" name="mem_id" class="mem_id">didididididid</a>
        				<span class="me_con">안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요</span>
        			</div>
        			<span id="post_date">2022.02.10</span>
        		</div>
			</div>	
			 여기까지 댓글 추가 -->
				
		</div>
		
		<!-- 세번째 줄(좋아요, 대화상자 아이콘) -->
		<div>
		<c:if test="${isLike eq null}">
			<form id="like_form${vo.post_seq}" class="hide_form">
			<input type="hidden" name="board_num" value="${vo.post_seq}"> <!-- 게시글넘버 -->
			<input type="button" onclick="return like(${vo.post_seq})" class="hide_input"><span class="fa-regular fa-heart heart ${vo.post_seq}"></span></form>
		</c:if>
		<c:if test="${isLike ne null}">
			<form id="like_form${vo.post_seq}" class="hide_form">
			<input type="hidden" name="board_num" value="${vo.post_seq}"> <!-- 게시글넘버 -->
			<input type="button" onclick="return like(${vo.post_seq})" class="hide_input"><span class="fa-solid fa-heart disheart ${vo.post_seq}"></span></form>
		</c:if>
			<!-- 아래를 클릭 시, 검색칸의 커서가 켜져야 한다. -->
 			<button id="def"><i class="fa-regular fa-comment fa-flip-horizontal"></i></button>
		</div>
		
		<!-- 네번째 줄(좋아요 몇개) -->
		<div class="like_count"><span>좋아요 <span id="like_result">${likecnt}</span>개</span></div>
		
		<!-- 다섯번째 줄(게시글 작성 날짜) -->
		<div name="post_date" class="post_date_div"><span id="post_date"><fmt:formatDate value="${vo.post_date}" pattern="yyyy.MM.dd HH:mm"/></span></div>
		
		<!-- 여섯번째 줄(댓글달기상자) -->
		<div class="textsection">
			<div class="textsection1"><i class="fa-regular fa-face-smile-wink"></i></div>
        	<form id="comment_form"><input type="hidden" name="post_seq" value="${vo.post_seq}"><div class="textsection2"><textarea name="content" id="comment_textarea" cols="1333" rows="1" placeholder="댓글 달기..."></textarea></div>
        	<div class="textsection3"><input type="button" onclick="writeCmt()" class="textsection_bt">게시</div></form>
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
        <div class="modal-box${vo.post_seq}">
        <input type="hidden" name="board_num" value="${vo.post_seq}">
        <c:if test="${memvo.mem_id == vo.mem_id}">
        	<a href="/goalsns/postDelete.do" class="modal-red">게시글 삭제</a>
        </c:if>
          <!-- 내 게시물이라면? 게시글 삭제,
           상대방 게시물(팔로잉)이라면? 팔로우 취소, 상대방 게시물(팔로우안함)이라면? 팔로우 -->
          <c:if test="${memvo.mem_id != vo.mem_id}">
          <c:if test="${vo.mem_id==tfvo.to_mem }">
          <form id="follow_form" class="hide_form">
          <input type="hidden" name="follow_num" value="${vo.mem_id}">
          <input type="button" onclick="return postfollow()" class="fol_input_hide"><span class="fol_no modal-red">팔로우 취소</span>
          </form>
          </c:if>
          <!-- <a href="#" class="modal-red">게시글 삭제</a> -->
          <c:if test="${empty tfvo.to_mem}">
          <form id="follow_form" class="hide_form">
          <input type="hidden" name="follow_num" value="${vo.mem_id}">
          <input type="button" onclick="return postfollow()" class="fol_input_hide"><span class="fol_no modal-blue">팔로우</span>
          </form>
          </c:if>
          </c:if>
        </div>
        <div class="modal-box">
          <a href="#" class="black" title="새창" onclick="clip(); return false;">링크복사</a>
        </div>
        <div class="modal_cancel">
          <button class="canbtn" data-dismiss="modal">취소</button>
        </div>
      </div>
      
    </div>

  </div>
  
</div>

</div> 
<!-- 모달 끝  -->
<jsp:include page="footer.jsp" />

</body>
</html>