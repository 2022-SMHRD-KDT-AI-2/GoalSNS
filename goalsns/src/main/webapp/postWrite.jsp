<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data">
    <table>
        <input type="file" name="post_file">
        <div class="form-group">
        <div class="section1"></div>
            <label for="comment"></label>
            <textarea name="post_content" rows="5" id="comment"></textarea>
            <button type="submit">생성</button>
        </div>
	</table>
</form> 
</body>
</html>