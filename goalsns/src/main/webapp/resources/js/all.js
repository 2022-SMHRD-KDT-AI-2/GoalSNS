$(document).on('click', '#heart', function(){
 			    $('#i').toggleClass('disheart');
			    $('#i').toggleClass('fa-solid');
 			    $('#i').toggleClass('heart');
 			    $('#i').toggleClass('fa-regular');
 			    $(this).removeAttr('id');
 			    $(this).attr('id', 'disheart');
 			})

 			$(document).on('click', '#disheart', function(){
 				$('#i').toggleClass('disheart');
			    $('#i').toggleClass('fa-solid');
 			    $('#i').toggleClass('heart');
 			    $('#i').toggleClass('fa-regular');
 			    $(this).removeAttr('id');
 			    $(this).attr('id', 'heart');
 			})

/*말풍선 누르면, 커서 두기*/
$('.cur_focus').click(function(){
	$('#comment_textarea').focus();
	
});



