<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.w1{
	width: 10%;
}
.w2{
	width: 20%;
}
.w4{
	width: 40%;
	text-align: left;
}
table{
	text-align: center;
}
</style>
</head>
<body>
	<h1>보드입니다.</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="row">
				<tr>
					<td class="w1">${row.board_no }</td>
					<td class="w4">
					<a href="./detail?no=${row.board_no }">
					${row.board_title } <c:if test="${row.comment ne 0 }">[${row.comment }]</c:if></a></td>
					<td class="w2">${row.board_write }</td>
					<td class="w2">${row.board_date }</td>
					<td class="w1">${row.board_count }</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>

</body>
</html>