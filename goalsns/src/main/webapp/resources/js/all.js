/*$(document).on('click', '#heart', function(){
 			    $('#abc').toggleClass('disheart');
			    $('#abc').toggleClass('fa-solid');
 			    $('#abc').toggleClass('heart');
 			    $('#abc').toggleClass('fa-regular');
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

/*말풍선 누르면, 커서 두기*/
window.onload = function() {
	document.getElementById('def').onclick = function() {
		$('#comment_textarea').focus();
    	};
};


