<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<link rel="shortcut icon" type="image/x-icon" href="assets/favicon.ico" />
	<link rel="apple-touch-icon" sizes="57x57" href="assets/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="assets/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="assets/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="assets/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="assets/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="assets/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="assets/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="assets/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="assets/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="assets/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="assets/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="assets/favicon-16x16.png">
	<link rel="manifest" href="assets/manifest.json">
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">
	<!-- Font Awesome icons (free version)-->
	<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
	<!-- Google fonts-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
	
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Diphylleia&family=Gowun+Dodum&family=Nanum+Gothic&family=Nanum+Myeongjo&display=swap" rel="stylesheet">>

<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Diphylleia&family=Gowun+Dodum&family=Nanum+Gothic&family=Nanum+Myeongjo&display=swap" rel="stylesheet">>
<head>
<style type="text/css">
body{
	font-family: "Gowun Dodum", sans-serif;
	font-weight: 400;
	font-style: normal;
}
</style>
</head>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark" id="mainNav">
	<div class="container">
		<a class="navbar-brand" href="./index"><img src="assets/apple-icon-152x152.png" alt="logo" /></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			Menu<i class="fas fa-bars ms-1"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
			<li class="nav-item"><a class="nav-link" href="./board">게시판</a></li>
			<li class="nav-item"><a class="nav-link" href="./file">파일</a></li>
			<li class="nav-item"><a class="nav-link" href="./gallery">Gallery</a></li>
			<li class="nav-item"><a class="nav-link" href="./notice">공지</a></li>
			<c:choose>
				<c:when test="${sessionScope.mname eq null && sessionScope.mid eq null }">
					<li class="nav-item"><a class="nav-link" href="./login">로그인</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link" href="./mail">메일</a></li>			
					<li class="nav-item"><a class="nav-link" href="./myInfo@${sessionScope.mid }">${sessionScope.mname }님</a></li>
					<li class="nav-item"><a class="nav-link" href="./logout">로그아웃</a></li>			
				</c:otherwise>			
			</c:choose>
			
		</ul>
		</div>
	</div>
</nav>