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


</head>
<body>

    <form method = "post" action="/goalsns/memberDelete.do">        
        <div class="cotainer">
            <div class="item">
                <a href="">프로필 편집</a>
            </div>
            <div>
                <a href="">회원 탈퇴</a>
            </div>
        </div>
        <div class="item">
        <h5>회원탈퇴</h5>	                 
            <div>사용자 이름 
               <input type="text" class="form-control" name="mem_id" value="">  
            </div>           
            <div class="form-group">
             <label for="mem_email">이메일 주소</label>
             <input type="email" class="form-control" name=git"mem_email" id="mem_email"> 
            </div>
            <div>
                <label for="mem_pw">비밀 번호</label>
                <input type="password" name="pw" placeholder="비밀번호">
            </div>
            <div>
             <button type="submit" class="btn btn-info btn-sm">탈퇴하기</button>   			   
            </div>		        
        </div>
    </div>	
</div>
    </form>	
<<<<<<< HEAD
  <jsp:include page="footer.jsp" />       
=======
  <jsp:include page="footer.jsp" />       
=======
   <form method = "post" action="/goalsns/memberDelete.do">
        <h5>회원탈퇴</h5>
		
			<input type="text" name="id" readonly="readonly" value="${memvo.mem_id}">
			<br>
			<input type="password" name="pw" placeholder="비밀번호">
			<br>
			<input type="submit">
		        <!-- 로그인 버튼 없어도 된다고 함  onclick="location.href='index.jsp'"   -->	
    </form>
    
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-2/GoalSNS.git
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-2/GoalSNS.git
</body>
</html>