<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<style type="text/css">
.writerInfo{
	border-bottom: 1px solid #c0c0c0; 
	border-top: 1px solid #c0c0c0;
}
.detailDate{
	text-align: right;
	font-size: smaller;
}
.card-body{
	height: auto;
	color: black;
	border: 1px solid #c0c0c0;
	border-radius: 10px;
}
</style>
</head>
<body>
<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<%@ include file="menu.jsp" %>
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
					<%@ include file="toolbar.jsp" %>
				<!-- Begin Page Content -->
				<div class="container-fluid">
				<!-- 여기부터 -->
				<section class="page-section" id="detail">
		<div class="container">
			<div class="card mb-4" style="min-height: 500px;">
				<div class="card-body">
					<div class="h2 title">${detail.board_title }</div>
					<div class="row p-2 writerInfo">
						<div class="col align-middle text-start">${detail.mname } &ensp;
						<c:if test="${detail.mname eq sessionScope.mname && detail.mid eq sessionScope.mid }">
							<img alt="edit" src="./img/edit.png" class="edit">
							<img alt="del" src="./img/delete.png" class="del" title="글 삭제" onclick="deletePost()">
						</c:if>
						</div>
						<div class="col align-middle text-end detailDate">
						<fmt:parseDate var="dateString" value="${detail.board_date }" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate  value="${dateString }" pattern="YYYY-MM-dd HH:mm" />
						</div>
					</div>
					<div class="mt-4 h-auto content">${detail.board_content }</div>
				</div>
			</div>
		</div>
	</section>
				<!-- 여기까지 -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>