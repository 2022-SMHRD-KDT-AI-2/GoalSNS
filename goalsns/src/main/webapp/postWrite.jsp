<%@page import="java.util.List"%>
<%@page import="goalsns.entity.PostVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://kit.fontawesome.com/83edcfd603.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

 
  <script>
    window.onload = function() {
 
    function onClick() {
        document.querySelector('.modal_wrap').style.display ='block';
        document.querySelector('.black_bg').style.display ='block';
    }   
    function offClick() {
        document.querySelector('.modal_wrap').style.display ='none';
        document.querySelector('.black_bg').style.display ='none';
    }
 
    document.getElementById('modal_btn').addEventListener('click', onClick);
    document.querySelector('.modal_close').addEventListener('click', offClick);
 
};
</script>


  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="./resources/CSS/menu.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/postWrite.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="menu.jsp" />

<button type='button' id="modal_btn">모달창아 나와랏</button>
<div class="black_bg"></div>
<div class="modal_wrap">
    <div class="modal_close"><a href="#">close</a></div>

         <div class="container_1">
        <form method="post" enctype="multipart/form-data" action="/goalsns/postWrite.do">
           <div class="item_1">
           <div>
             <div class="modal_sumbit"><a href="#">저장</a></div>
             <a href=""></a>
             <img scr="">
           </div>
           </div>
           <div class="item_2">                             
                <a class="profilePic" target="_self">
                 <img class="postPic_1" src="./resources/images/profile.png" alt="프로필 사진 바꾸기" >	     
                 <!-- <br><span class="picture">프로필 사진 바꾸기</span> -->              
               </a>
              
           </div> 
            <div class="input_1">
               <input class="picture" type="file" name="mem_img">
               </div>
              
          <div class="item_3">
          <div class="form-group_0">
             <img class="postPic_2" src="./resources/images/profile.png">           
             <h5>user1_challin</h5>        
          </div>
           <div class="form-group_1">
                    <label for="comment"></label>
                    <textarea name="post_content" class="spark_1" rows="5" id="comment" placeholder="문구 입력"></textarea>
                   
                 </div>
             
                  
                <div class="form-group_2">       
                    <label for="comment"></label>
                    <textarea name="post_content" class="spark_2" rows="5" id="comment" placeholder="챌린지해시태그를 사용하기 위해선 @기호와 텍스트를 차례로 입력"></textarea>
                   <!--  <button type="submit">생성</button> -->
                     
                 </div>
                   </div>
                  
        </form> 
        </div>
   
<jsp:include page="footer.jsp" />
</body>
</html>