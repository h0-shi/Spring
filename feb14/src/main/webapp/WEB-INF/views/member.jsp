<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버</title>
<style type="text/css">
table {
	text-align: center;
	background-color: black;
	border-color: white;
	color: white;
}
.w1{
	width: 10%;
}
.w2{
	width: 25%;
}
.w3{
	width: 30%;
}
tbody tr:hover{
	background-color: grey;
}

</style>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>회원 번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>가입일</th>
				<th>등급</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="row">
				<tr>
					<td class="w1">${row.mno }</td>
					<td class="w2">${row.mid }</td>
					<td class="w2">${row.mname }</td>
					<td class="w3">${fn:substring(row.mdate,0,19) }</td>
					<td class="w1">${row.mgrade }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>