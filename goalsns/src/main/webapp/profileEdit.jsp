<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
 
<style type="text/css">
@import url("./resources/CSS/NewFile.css")
</style>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>


<div class="container"></div>
  <h2>챌린샷</h2>
  <div class="panel panel-default">
    <div class="panel-heading">프로필</div>
    <div class="panel-body">
     <form action="/goalsns/profileEdit.do" method="post">
            <div>이름
            <input type="text" class="form-control" name="mem_name" >
               </div>
<<<<<<< HEAD
            <div>사용자 이름 
               <input type="text" class="form-control" name="mem_id" value="">
=======
             <div>사용자 이름 
             <input type="text" class="form-control" readonly="readonly" name="mem_id" value="aaaa"}>
             </div>
             <div>소개  
             <textarea rows="10" class="form-control" name="mem_about"></textarea>
             </div>
            <div class="form-group">
            <label for="email">이메일 주소</label>
            <input type="email" class="form-control" name="mem_email" id="mem_email">
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-2/GoalSNS.git
            </div>
            <div>소개  
              <textarea rows="10" class="form-control" name="mem_about"></textarea>
            </div>
            <div class="form-group">
              <label for="email">이메일 주소</label>
              <input type="email" class="form-control" id="mem_email">
            </div>           
               <button type="submit" class="btn btn-info btn-sm">수정하기</button>          
       </form>
     <div class="panel-footer">UNO</div>
  </div>
</div>


</body>
</html>