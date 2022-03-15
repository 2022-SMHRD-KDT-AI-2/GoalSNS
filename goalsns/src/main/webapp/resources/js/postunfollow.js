function postfollow(){
    $.ajax({
    url: "/goalsns/postFollow.do",
    type: "POST",
    cache: false,
    dataType: "json",
    data: $('#follow_form').serialize(), //아이디가 like_form인 곳의 모든 정보를 가져와 파라미터 전송 형태(표준 쿼리형태)로 만들어줌
    success:
    function(data){ //ajax통신 성공시 넘어오는 데이터 통째 이름 =data
    //alert(data.followcnt)
    //alert(data.followercnt)
    //alert("성공") ; // data중 put한 것의 이름 like
     //id값이 like_result인 html을 찾아서 data.like값으로 바꿔준다.
 	$('.fol_no').toggleClass('modal-red');
    $('.fol_no').toggleClass('modal-blue');
    $('.modal-blue').text('팔로우');
    $('.modal-red').text('팔로우 취소');
    
 	$('.fal_yes').toggleClass('fa-user');
	$('.fal_yes').toggleClass('fa-user-plus');
	$('.profile_btn').toggleClass('follow1');
	$('.profile_btn').toggleClass('fo_2');
	$('.inner_text').toggleClass('inner_text1');
	$('.inner_text').toggleClass('inner_text2');
	$('.inner_text1').text('팔로잉 ');
	$('.inner_text2').text('팔로우 ');
    
    if(data.follow == 0){
    	$('.following').text(' ');
    	$('#follower').text('팔로워 '+data.followercnt);
    	$('#follow').text('팔로우 '+data.followcnt);
    	}
    else{
    	$('.following').text('• 팔로잉');
    	$('#follower').text('팔로워 '+data.followercnt);
    	$('#follow').text('팔로우 '+data.followcnt);
    	}
    },
    error:
    function (request, status, error){
    alert("ajax실패. code:"+request.status+"\n"+"message:"+request.reponseText+"\n"+"error:"+error);
    }
    });
    }