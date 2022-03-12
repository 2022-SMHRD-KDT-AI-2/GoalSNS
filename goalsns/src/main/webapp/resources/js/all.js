/*$('#heart').toggle();*/
$(document).on('click','#heart',function(){
	$('.heart').replacewith(document.getElementsById("heart").innerHTML = "<i class='fa-solid fa-heart disheart' style='color:red;'></i>");
	$(this).removeAttr('id');
	$(this).attr('id','disheart');
});
$(document).on('click','#disheart',function(){
	$(".disheart").replacewith(document.getElementsById("disheart").innerHTML = "<i class='fa-regular fa-heart heart'></i>");
	
});

/*$(document).on('click','#heart',function(){
	$(this).text('좋아요취소');
})*/

/*$("heart").click(function(){
document.getElementById("heart").innerHTML = "<i class='fa-solid fa-heart heart'></i>";
});*/

/*말풍선 누르면, 커서 두기*/
$('.cur_focus').click(function(){
	$('#comment_textarea').focus();
	
});



