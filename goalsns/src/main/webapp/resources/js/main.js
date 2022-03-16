/*댓글달기*/
function writeCmt2(post){
    $.ajax({
    url: "/goalsns/cmtTest.do",
    type: "POST",
    cache: false,
    dataType: "json",
    data: $('#comment_form'+post).serialize(), //넘어가는 데이터. 포스트 아이디 : post_seq, 코멘트 내용 : content
    success:
    function(data){ 
        var con = $('.cmttextarea'+post).val();
        $('.'+post+'cmt').text(con);
    },
    error:
    function (request, status, error){
    alert("ajax실패. code:"+request.status+"\n"+"message:"+request.reponseText+"\n"+"error:"+error);
    }
    })
}

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