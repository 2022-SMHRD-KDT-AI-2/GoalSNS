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
</head>
<body>
	<table>
	    <button id='like'>Like!♥</button><span>0</span>
	    <br>
	    
	    <input type="text"><button class='writeCom'>댓글작성</button>
	    <br>
	    <div id="com">
	        <p>첫댓글<button class='removeCom'>삭제</button></p>
	    </div>  
    </table>
    <script>
      
    
        $(document).on("click","#like",function(e){  //e 
            var like = Number($('#like+span').text())
            $('#like+span').text(like+1)

            $(this).text('좋아요 취소')
            $(this).removeAttr('id','like')
            $(this).attr('id','dislike')
        });

        $(document).on("click","#dislike",function(e){ //e
            var like = Number($('#dislike+span').text())
            $('#dislike+span').text(like-1)

            $(this).text('좋아요')
            $(this).removeAttr('id','dislike')
            $(this).attr('id','like')
        });


        $('.writeCom').click(function(){
            var com = $('input[type=text]').val()
            $('#com').prepend('<p>'+com+'<button class="removeCom">삭제</button></p>')
            $('input[type=text]').val("")
        })

        $('.removeCom').click(function(){
            $(this).parent().remove()
        })

        $("#com").on("click",".removeCom",function(e){ //e
            $(this).parent().remove()
        });

        

    </script>
</body>
</html>