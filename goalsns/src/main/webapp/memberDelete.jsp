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
<link href="./resources/CSS/memberDelete.css" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="menu.jsp" />


<div class="container_1" >
  <form method = "post" action="/goalsns/memberDelete.do">             
       
		<div class="item1">
            <div class="profilEidt_1">
                <a href="">프로필 편집</a>
            </div>
            <div class="delete">
                <a href="">회원 탈퇴</a>
            </div>
        </div>
     
        <div class="item2">
        <h3>회원탈퇴</h3><br>	                 
           
          <div class="form-group">
           <div class="pabox">          
            <!-- <label for="mem_id"> 사용자 이름 </label>   -->
            <div class="test"><label for="mem_id"> 사용자 이름 </label></div>        
            <input type="text" class="form-control" name="mem_id" value="">               
           </div>
                <p>가입한 회원님의 계정을 확인해 주세요.</p>           
            </div>           
            
             <div class="form-group">
             <div class="pabox">
             <label for="mem_email">이메일 주소</label>             
             <input type="email" class="form-control" name="mem_email" id="mem_email"> 
               </div>
                <p>가입한 이메일을 확인해주세요.</p>
               </div>
            
          
            <div class="form-group">   
            <div class="pabox">        
                <label for="mempwd">비밀 번호</label>               
                <input type="password" class="form-control" name="memPwd">     
                </div>             
                 <p>가입한 비밀번호를 입력해주세요.</p>
           </div>
          
            <div class="btn_1">
             <button type="submit" class="btn btn-info btn-sm">탈퇴하기</button>   	
		    </div>
        </div>  
     </form>	     
</div>
  <jsp:include page="footer.jsp" />  
</body>
</html>