<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 쓰기</title>
</head>
<body>
	<h1>공지사항 작성</h1>
	<form action="./noticeWrite" method="post">
		<input type="text" name="ntitle" placeholder="제목">
		<textarea name="ncontent" placeholder="내용"></textarea>
		<button type="submit">글쓰기</button>
	</form>
</body>
</html>