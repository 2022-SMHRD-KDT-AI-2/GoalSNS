<%@page import="java.util.List"%>
<%@page import="goalsns.entity.PostVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link href="./resources/CSS/postWrite.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="./resources/js/all.js"></script>
</head>
<body>
<jsp:include page="menu.jsp" />


 
 <div class="container_1">
        <form method="post" enctype="multipart/form-data" action="/goalsns/postWrite.do">
        
           <div class="item_1">
             <div class="modal_sumbit">
             <button class="hide_yes" type="submit"></button>
             <div class="sub"><span class="fa-solid fa-arrow-up-from-bracket"></span></div>
           	 </div>
           </div>
           
           <div class="all_row">
	           <div class="all_row_left">
		           <div class="item_2">                            
		  				<img id="View" src="./resources/images/NoImage.jpg" alt="이미지 미리보기" />
		           </div> 
		           <div class="input_2">
		             <label  class="input-file-button" id="myfile">사진업로드</label>
		               <input name="post_file" type='file' id="myFile" />		               
		           </div>  
	          </div>
	          
	             
	          <div class="all_row_right">
		          	<div class="form-group_0">
		          		<img id="peedimg" class="img-circle" src="./profilePic/${memvo.mem_img}" width="50" height="50" >   
		             	<div class="mem_id">${memvo.mem_id}</div>        
		          	</div>
	           		<div class="form-group_1">
	                    <label for="comment"></label>
	                    <textarea name="post_content" class="spark_1" rows="5" id="comment" placeholder="문구 입력..."></textarea>
	                 </div>  
	                <div class="form-group_2">
	                	<details>
	                		<summary>도움말 클릭</summary>     
	                    	<p class="muener_1">일반해시태그를 사용하기 위해선 #기호와 텍스트를 차례로 입력합니다. 색이 남색으로 변합니다. (예: <span class="normal">#꽃</span>)<br>챌린지해시태그를 사용하기 위해선 @기호와 텍스트를 차례로 입력합니다. 색이 주황색으로 변합니다. (예:<span class="special"> @물마시기챌린지</span>)<br> 해시태그에 숫자나 기호를 사용할 수 있지만 공백은 사용할 수 없습니다. 하나의 게시물에 최대 30개의 태그를 사용할 수 있습니다.</p>
	                    </details> 
	                </div>
	           </div>
	           
	          
         </div>
	</form> 
</div>
<jsp:include page="footer.jsp" />
  </body>
  </html>