<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>글쓴이</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="row">
			<tr>
				<td>${row.board_no }</td>
				<td>${row.board_title }</td>
				<td>${row.board_date }</td>
				<td>${row.count }</td>
				<td>${row.board_write }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>