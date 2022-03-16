/*profileEdit에서 이미지미리보기*/
$(function() {
    $("#isFile").on('change', function(){
    readURL(this);
    });
});
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
        $('.profilePic_1').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}