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
    
    },
    error:
    function (request, status, error){
    alert("ajax실패. code:"+request.status+"\n"+"message:"+request.reponseText+"\n"+"error:"+error);
    }
    });
    }