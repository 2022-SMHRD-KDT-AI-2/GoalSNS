/*
$(document).on('click', '#heart', function(){
 			    $('#i').toggleClass('disheart');
			    $('#i').toggleClass('fa-solid');
 			    $('#i').toggleClass('heart');
 			    $('#i').toggleClass('fa-regular');
=======
/*$(document).on('click', '#heart', function(){
 			    $('#abc').toggleClass('disheart');
			    $('#abc').toggleClass('fa-solid');
 			    $('#abc').toggleClass('heart');
 			    $('#abc').toggleClass('fa-regular');
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-2/GoalSNS.git
 			    $(this).removeAttr('id');
 			    $(this).attr('id', 'disheart');
 			})

 			$(document).on('click', '#disheart', function(){
 				$('#abc').toggleClass('disheart');
			    $('#abc').toggleClass('fa-solid');
 			    $('#abc').toggleClass('heart');
 			    $('#abc').toggleClass('fa-regular');
 			    $(this).removeAttr('id');
 			    $(this).attr('id', 'heart');
 			})*/
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
    alert("'좋아요'가 반영되었습니다!") ; // data중 put한 것의 이름 like
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
function copy_clip(strData) {
clipboardData.setData("Text", strData);
alert("클립보드로 복사되었습니다.");}
