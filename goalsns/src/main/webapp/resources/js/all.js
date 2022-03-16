/*좋아요*/
function like(post){
    $.ajax({
    url: "/goalsns/likeTest.do",
    type: "POST",
    cache: false,
    dataType: "json",
    data: $('#like_form'+post).serialize(), //아이디가 like_form인 곳의 모든 정보를 가져와 파라미터 전송 형태(표준 쿼리형태)로 만들어줌
    success:
    function(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data
    let post_seq = '.'+String(data.post_seq);
 	$(post_seq).toggleClass('heart');
    $(post_seq).toggleClass('disheart');
 	$(post_seq).toggleClass('fa-regular');
	$(post_seq).toggleClass('fa-solid');
    // data중 put한 것의 좋아요 개수는 like
    $("#like_result").text(data.like);
    },
    error:
    function (request, status, error){
    alert("ajax실패. code:"+request.status+"\n"+"message:"+request.reponseText+"\n"+"error:"+error);
    }
    });
}

/*말풍선 누르면, 커서 두기*/
window.onload = function() {
	document.getElementById('def').onclick = function() {
		$('#comment_textarea').focus();
    	};
};

/*주소복사하기*/
function clip(){
        var url = '';    // <a>태그에서 호출한 함수인 clip 생성
        var textarea = document.createElement("textarea");  
        //url 변수 생성 후, textarea라는 변수에 textarea의 요소를 생성
        document.body.appendChild(textarea); //</body> 바로 위에 textarea를 추가(임시 공간이라 위치는 상관 없음)
        url = window.document.location.href;  //url에는 현재 주소값을 넣어줌
        textarea.value = url;  // textarea 값에 url를 넣어줌
        textarea.select();  //textarea를 설정
        document.execCommand("copy");   // 복사
        document.body.removeChild(textarea); //extarea 요소를 없애줌
        
        alert("URL이 복사되었습니다.")
    }
   
/*댓글달기*/
function writeCmt(){
    $.ajax({
    url: "/goalsns/cmtTest.do",
    type: "POST",
    cache: false,
    dataType: "json",
    data: $('#comment_form').serialize(), //넘어가는 데이터. 포스트 아이디 : post_seq, 코멘트 내용 : content
    success:
    function(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data
    //화면에서 작성한 댓글이 바로 보이도록하는 건 예지가 작성할겁니당
    alert("댓글작성 성공");
    
    $('.textsection_bt')
			var com = $('textarea').val();
			$('.right_item_middle').prepend('<div class="me_coments"><a href="/goalsns/profile.do?mem_id=${vo.mem_id}"><img id="peedimg" class="img-circle" src="./profilePic/${writerImg}" width="50" height="50" ></a><div><div><a href="/goalsns/profile.do?mem_id=${vo.mem_id}" name="mem_id" class="mem_id">'+data.mem_id+'</a><span class="me_con">'+com+'</span></div><span id="post_date"><fmt:formatDate value="${vo.post_date}"pattern="yyyy.MM.dd HH:mm"/></span></div></div>');	
   		//document.getElementById("comment_textarea").value='';
   	
    },
    error:
    function (request, status, error){
    alert("ajax실패. code:"+request.status+"\n"+"message:"+request.reponseText+"\n"+"error:"+error);
    }
    })
}

/*postWrite 이미지 미리보기*/
$(function() {
    $("#myFile").on('change', function(){
    readURL(this);
    });
});
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
        $('#View').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}


