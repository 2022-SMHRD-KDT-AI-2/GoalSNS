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
<link href="./resources/CSS/profileEdit.css" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="menu.jsp" />


<div class="container_1" >
  <form method = "post" action="/goalsns/memberDelete.do">             
       
		<div class="item1">
            <div class="profilEidt_1">
                <a class="a_1" href="">프로필 편집</a>
            </div>
            <div class="delete">
                <a class="a_2" href="">회원 탈퇴</a>
            </div>
        </div>
     
        <div class="item2">
        <h3>challin_shot</h3>
       <div class="form-group">
        <a class="profilePic" target="_self">
	     <img class="profilePic_1" src="./resources/images/profile.png" alt="프로필 사진 바꾸기" >
	     
	     <span class="picture">프로필 사진 바꾸기</span>
	   </a>
	    </div>             
          
          <div class="form-group">
           <div class="pabox">          
            <div class="test"><label for="mem_name"> 이름 </label>         
            <input type="text" class="form-control" name="mem_name" value="">               
           </div>
                <p>사람들이 이름,별명 또는 비즈니스 이름 등 회원님의 얄려진 이름을 사용하여<br>
                  회원님의 계정을 찾을 수 있도록 도와주세요. </p>           
            </div>   
           
          <div class="form-group">
           <div class="pabox">          
            <div class="test"><label for="mem_id"> 사용자 이름 </label>         
            <input type="text" class="form-control" name="mem_id" value="">               
           </div>
                <p>자신만의 id이름으로 활동해보세요.</p>           
            </div>           
            
            <div class="form-group">
            <div>
             <div class="test"><label for="mem_about">소개 </label> 
             <textarea rows="5" class="form-control" name="mem_about"></textarea>
             </div>
                <strong>개인정보</strong>
                <p>비지니스나 반려동물 등에 사용된 계정인 경우에도 회원님의 개인정보를 입력<br>
                하세요. 공개 프로필에는 포함되지 않습니다.</p>
            </div>
            
             <div class="form-group">
                <div class="pabox">
                 <label for="mem_email">이메일 주소</label>             
                 <input type="email" class="form-control" name="mem_email" id="mem_email"> 
               </div>
                <p>가입한 이메일을 확인해주세요.</p>
             </div>
                                
            <div class="btn_1">
             <button type="submit" class="btn btn-info btn-sm">제출</button>   	
		    </div>
        </div>  
     </form>	     
</div>
  <jsp:include page="footer.jsp" />  
</body>
</html>