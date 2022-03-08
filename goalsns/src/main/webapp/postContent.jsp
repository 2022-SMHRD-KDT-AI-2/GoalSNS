<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="C:/Users/smhrd/Desktop/jquery-3.6.0.min.js"></script>
    <title>Document</title>

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
<body>
<jsp:include page="menu.jsp" />
<div class="containerbox">

	<div name="post_file" id="post_file" class="left_item">
	      <img src="./resources/images/postfile.jpg" class="postfile">
	</div>
	<div class="right_item">
		<!--첫번째 줄 -->
		<div id="right_item_top" >
        	<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
        	<a href="#" name="mem_id" class="mem_id">didididididid</a>
        	<!-- 내가 상대방을 팔로우 했다면, 팔로잉보여지게(클릭X),
        	 팔로우를 하지 않았다면, 팔로우 클릭 시 팔로잉이 되도록(클릭O) -->
        	<span class="follow following">• 팔로잉</span>
        	<!-- <span class="follow follow_click"><a href="#">• 팔로우</a></span> -->
      		<button type="button" class="btn" data-toggle="modal" data-target="#myModal"><i class="fa-solid fa-ellipsis"></i></button>
    	</div>

		<!-- 두번째 줄(댓글공간) -->
		<div class="right_item_middle">
			<div class="me_coments">
				<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
        		<div>
        			<div>
        				<a href="#" name="mem_id" class="mem_id">didididididid</a>
        				<span class="me_con">안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요</span>
        			</div>
        			<span id="post_date">2022.02.10</span>
        		</div>
			</div>
			
			<!-- 댓글 많이 추가함(지워도 됌) -->
			<div class="me_coments">
				<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
        		<div>
        			<div>
        				<a href="#" name="mem_id" class="mem_id">didididididid</a>
        				<span class="me_con">안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요</span>
        			</div>
        			<span id="post_date">2022.02.10</span>
        		</div>
			</div>
			<div class="me_coments">
				<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
        		<div>
        			<div>
        				<a href="#" name="mem_id" class="mem_id">didididididid</a>
        				<span class="me_con">안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요</span>
        			</div>
        			<span id="post_date">2022.02.10</span>
        		</div>
			</div>			
			<div class="me_coments">
				<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
        		<div>
        			<div>
        				<a href="#" name="mem_id" class="mem_id">didididididid</a>
        				<span class="me_con">안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요</span>
        			</div>
        			<span id="post_date">2022.02.10</span>
        		</div>
			</div>				
			<div class="me_coments">
				<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
        		<div>
        			<div>
        				<a href="#" name="mem_id" class="mem_id">didididididid</a>
        				<span class="me_con">안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요</span>
        			</div>
        			<span id="post_date">2022.02.10</span>
        		</div>
			</div>			
			<div class="me_coments">
				<a href="#"><img id="peedimg" class="img-circle" src="./resources/images/profile.png" width="50" height="50" ></a>
        		<div>
        			<div>
        				<a href="#" name="mem_id" class="mem_id">didididididid</a>
        				<span class="me_con">안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요</span>
        			</div>
        			<span id="post_date">2022.02.10</span>
        		</div>
			</div>
			<!-- 여기까지 댓글 추가 -->
				
		</div>
		
		<!-- 세번째 줄(좋아요, 대화상자 아이콘) -->
		<div>
			<a><i class="fa-regular fa-heart"></i></a>
 			<a><i class="fa-regular fa-comment fa-flip-horizontal"></i></a>
		</div>
		
		<!-- 네번째 줄(좋아요 몇개) -->
		<div class="like_count"><span>좋아요 60,200개</span></div>
		
		<!-- 다섯번째 줄(게시글 작성 날짜) -->
		<div name="post_date" class="post_date_div"><span id="post_date">2022.02.10</span></div>
		
		<!-- 여섯번째 줄(댓글달기상자) -->
		<div class="textsection">
			<div class="textsection1"><i class="fa-regular fa-face-smile-wink"></i></div>
        	<form action=""><div class="textsection2"><textarea name="comment_textarea" id="comment_textarea" cols="1333" rows="1" placeholder="댓글 달기..."></textarea></div>
        	<div class="textsection3"><button class="textsection_bt" type="submit">게시</button></div></form>
		</div>
		
		
	</div>

</div>

<!-- 모달 -->
<div class="container">
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
</div> 





<jsp:include page="footer.jsp" />
</body>
</html>