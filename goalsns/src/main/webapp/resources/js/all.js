/*$('#heart').toggle();*/
$(document).on('click','#heart',function(){
	$('.heart').replacewith(document.getElementById("heart").innerHTML = "<i class='fa-solid fa-heart disheart' style='color:red;'></i>");
	$("#heart").prop('id','disheart');
});
$(document).on('click','#disheart',function(){
	$(".disheart").replacewith(document.getElementById("disheart").innerHTML = "<i class='fa-regular fa-heart heart'></i>");
	
});


/*$(document).on('click','#heart',function(){
	$(this).text('좋아요취소');
})*/

/*$("heart").click(function(){
document.getElementById("heart").innerHTML = "<i class='fa-solid fa-heart heart'></i>";
});*/

