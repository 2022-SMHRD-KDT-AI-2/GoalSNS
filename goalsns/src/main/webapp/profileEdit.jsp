<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="C:/Users/smhrd/Desktop/jquery-3.6.0.min.js"></script>

<meta charset="utf-8">
<title>챌린샷</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://kit.fontawesome.com/83edcfd603.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link href="./resources/CSS/menu.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/footer.css" rel="stylesheet" type="text/css">
<link href="./resources/CSS/profileEdit.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
window.onload=function(){
    document.getElementById("sendbtn").onclick =checkit
}
function checkit(){
    var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf|JPG|JPEG|PNG|GIF|BMP|PDF)$/;
    var maxSize = 20 * 1024 * 1024;
    var fileSize;

    if($('#isFile').val() != "" && $('#isFile').val() != null) {
    	fileSize = document.getElementById("isFile").files[0].size;
        
        if(!$('#isFile').val().match(fileForm)) {
        	alert("이미지 파일만 업로드 가능합니다");
            return;
        } else if(fileSize > maxSize) {
        	alert("파일 사이즈는 20MB에 1024*1024입니다");
            return;
        }
    }
	if(document.fo.mem_name.value === "" || isNaN(fo.mem_name.value) === false){ 
        fo.mem_name.focus(); 
      alert("이름이 비어있거나 이름에 숫자만 들어있습니다.");
      return;
 	}
    if (document.fo.mem_name.value.indexOf(" ") >= 0) {
        alert("이름에 공백을 사용할 수 없습니다.")
        document.fo.mem_name.focus();
        return;
    }
    if(fo.mem_name.value.length < 2) {
        fo.mem_name.focus();
          alert("이름은 2글자이상 입력가능합니다.")
          return;
     }
    if(fo.mem_about.value.length>1000) {
        fo.mem_about.focus();
          alert("소개글은 1000자 이내로 입력하세요")
          return;
     }
    var aa=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/; // 표준식
    // a부터 z까지 문자 1개 이상일 경우 and 숫자 0,1,2일 경우에만 / [^a-z, 0,1,2] : ^ 붙이면 부정의 뜻 / 한글은 가-힣
    if(!fo.mem_email.value.match(aa)){
        alert("이메일을 정확히 입력하세요!");
        fo.mem_email.focus();
        return;   
    }
    
    fo.action = "/goalsns/profileEdit.do";
    fo.method = "post";
    fo.submit(); 
}
</script>
</head>
<body>
<jsp:include page="menu.jsp" />


<div class="container_1" >
  <form name="fo" enctype="multipart/form-data">             
       
		<div class="item1">
            <div class="profilEidt_1">
                <div><a class="a_1" href="/goalsns/profileEdit.jsp">프로필 편집</a></div>
            </div>
            <div class="delete">
                <a class="a_2" href="/goalsns/memberDelete.jsp">회원 탈퇴</a>
            </div>
        </div>
     
        <div class="item2">
         <div class="edit_fix">
       <div class="edit_form" name="fileForm">
       <h3>${memvo.mem_id}</h3>
        <div class="edit_fix_1">
        <a class="profilePic" target="_self">
	     <img class="profilePic_1" src="./profilePic/${memvo.mem_img}" alt="프로필 사진 바꾸기" >	     
	     <!-- <br><span class="picture">프로필 사진 바꾸기</span> -->
	   </a><input class="picture" type="file" id="isFile" name="mem_img" accept="image/*">
	   </div>
	    </div>             
          </div>
          </div>
          <div class ="item3">
          <div class="edit_form">
           <div class="pabox">          
            <div class="edit_id"><label for="mem_name"><span class="space">이름</span></label> </div>         
            <input type="text" class="form_impormation" name="mem_name" value="${memvo.mem_name}">               
           </div>
                <p>사람들이 이름,별명 또는 비즈니스 이름 등 회원님의 알려진 이름을 사용하여<br>
                  회원님의 계정을 찾을 수 있도록 도와주세요. </p>           
            </div>   
           
          <div class="edit_form">
           <div class="pabox">          
            <div class="edit_id"><label for="mem_id"><span class="space">사용자 이름 </span></label>  </div>        
            <input type="text" class="form_impormation" name="mem_id" value="${memvo.mem_id}" readonly="readonly">               
           </div>
                <p>자신만의 id이름으로 활동해보세요.</p>           
            </div>           
            
            <div class="edit_form">
            <div>
             <div class="edit_id"><label for="mem_about"><span class="space">소개</span></label></div>
             <textarea rows="5" class="textarea_impormation" name="mem_about">${memvo.mem_about}</textarea>
             </div>
                <strong>개인정보</strong>
                <p>비지니스나 반려동물 등에 사용된 계정인 경우에도 회원님의 개인정보를 입력<br>
                하세요. 공개 프로필에는 포함되지 않습니다.</p>
            </div>
            
             <div class="edit_form">
               
                 <div class="edit_id"><label for="mem_email"><span class="space">이메일 주소</span></label></div>            
                  <div class="pabox">
                 <input type="email" class="form_impormation" name="mem_email" id="mem_email" value="${memvo.mem_email}"> 
               </div>
                <p>가입한 이메일을 확인해주세요.</p>
             </div>
                                
            <div class="btn_1">
             <button type="button" id="sendbtn" class="btn btn-info btn-sm">제출</button>   	
		    </div>
        </div>  
     </form>	     
</div>
  <jsp:include page="footer.jsp" />  
</body>
</html>