<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인뎅스입니다.</h1>
	서버에서 온 메세지 : ${test }
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="row">
				<tr>
					<td>${row.board_no }</td>
					<td>${row.board_title }</td>
					<td>${row.board_write }</td>
					<td>${row.board_date }</td>
					<td>${row.board_count }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>