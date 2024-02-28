<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>회원가입</title>
    <!-- Favicon-->
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
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<!-- xeicon -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<style type="text/css">
body{
	background-image: url('./img/blueBackground.jpg');
	background-size: cover;
	height: 100vh;
	font-family: "Gowun Dodum", sans-serif;
	font-weight: 400;
	font-style: normal;
}
.joinBtn{
	padding: 0;
	margin: 5px 0px;
}
.pwIn, .idIn{
	width: 100%;
	vertical-align: center;
	border: none;
	background-color: transparent; 
	color: white;
	margin: 0px 10px;
}
input{
	border: none;
    background-color: #transparent;  
    color: #ffffff;
}
input::placeholder {
    color: #ffffff;
}
input:focus {
	outline: none;
}
.inputLine{
	width: calc(80% + 40px );
	border-bottom: 1px solid white;
	text-align: center;
	margin-bottom: 20px;
}
.pwLine{
	width: calc(80% + 40px );
	text-align: center;
	margin-bottom: 20px;
}
.pwInput1, .pwInput2 {
	height: 37px;
	border-bottom: 1px solid white;
}
.pwInput1{
	float: left;
}
.pwInput2{
	float: right;
}
.icon{
	width: auto;
	color: #ffffff;
	text-align: right;
	font-size: x-large;
	float: left; 
	margin: 0px 5px;
}
.inputArea{
	width: 50%;
	display: flex;
	text-align: center;
	float: left;
}
.pwArea{
	width: 80%;
	display: flex;
	text-align: center;
	float: left;
}
.pwArea2{
	width: 100%;
	display: flex;
	text-align: center;
	float: left;
}
.submit{
	height: 32px;
	width: 250px;
	border-radius: 2px;
	background-color: rgba(0,0,0,0.3);
	color: white;
	border: 1px solid white;
}
.submit:hover {
	background-color: rgba(0,0,0,0.45);
}
.joinDiv{
	width : 500px;
	height: 620px;
	background-color: rgba(192, 192, 192, 0.4);
	border-radius: 20px;
	display: flex;
    flex-direction: column;
    align-items: center;
}
.check{
	width: 30%;
	float: right;
	margin-right: 10px;
	border-radius: 5px;
	background-color: rgba(0, 0, 0, 0.3);
	border: 1px solid white;
	color: white;
}
.check:hover{
	background-color: rgba(0, 0, 0, 0.45);
}
.greeting{
	margin: 30px 0px;
	text-align: center;
	font-size: x-large;
	font-weight: bold;
	color: white;
}
.registerImg{
	margin-top: 50px;
	margin-bottom: 20px;
}
.pwCheck{
	text-shadow: 0.5px 0.5px black;
	float: right;
	margin-right: 10px;
	margin-top: 5px;	
}
</style>
<script type="text/javascript">
$(function(){
	
	let idCheckBool = false;
	let emailCheckBool = false;
	let pwCheckBool = false;
	
	
	$('#pw2').keyup(function(){
			let span = $('.pwCheck');
		if( $('#pw2').val().length !=0 && $('#pw1').val()==$('#pw2').val() ){
			span.text("암호가 일치합니다.");
			span.css("color","green");
			pwCheckBool = true;
		} else {
			span.text("암호가 일치하지 않습니다.");
			span.css("color","red");
			pwCheckBool = false;
		}
	});
	
	$('#idCheck').click(function(){
		let id = $('#id').val();
		if(id.length > 0){
			$.ajax({
				url : "/idCheck",
				type : "post",
				dataType: "json",
				data : {'id':id},
				success : function(result){
					if(result==0){
						alert("사용 가능한 ID입니다.");	
						idCheckBool = true;
					} else {
						alert("이미 사용중인 ID입니다.");
						idCheckBool = false;
					}
				},
				error: function(request, status, error){ //통신오류
					alert("에러 발생");
				}
			});
		} else {
			alert("ID를 입력해주세요");
		}
	});
	
	$('#emailCheck').click(function(){
		let email = $('#email').val();
		let pattern = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
		//alert(pattern.test(email));
		
		if(email.length > 0 && pattern.test(email)){
			$.ajax({
				url : "/emailCheck",
				type : "post",
				dataType: "json",
				data : {'email':email},
				success : function(result){
					if(result==0){
						alert("사용 가능한 email입니다.");	
					} else {
						alert("이미 사용중인 email입니다.");
					}
				},
				error: function(request, status, error){ //통신오류
					alert("에러 발생");
				}
			});
		} else {
			alert("이메일 형식을 확인해주세요.");
		}
	});
	
	$('#join').click(function(){
		let id = $('#id').val();		
		let pw1 = $('#pw1').val();		
		let pw2 = $('#pw2').val();		
		let name = $('#name').val();		
		let email = $('#email').val();		
		
		
		let loginForm = $('<form></form>');
		loginForm.attr('name','login');
		loginForm.attr('method','post');
		loginForm.attr('action','./join');
		
		loginForm.append($('<input>', {'type':'hidden', 'name':'mid', 'value':id}) );
		loginForm.append($('<input>', {'type':'hidden', 'name':'mpw', 'value':pw1}) );
		loginForm.append($('<input>', {'type':'hidden', 'name':'mname', 'value':name}) );
		loginForm.append($('<input>', {'type':'hidden', 'name':'memail', 'value':email}) );
		
		loginForm.appendTo('body');
		loginForm.submit();
	});
});
</script>
</head>
    <body id="page-top">
        <!-- Navigation-->
        <c:import url="menu.jsp"/>
        
        <!-- login-->
        <section class="page-section" id="login">
            <div class="d-flex justify-content-center">
               <div class="text-center joinDiv">
               		<img class="registerImg" alt="사진" src="/img/register.png" width="400px;">
					<div class="inputLine">
						<span class="icon"><i class="xi-user-o"></i></span>
						<div class="inputArea">
							<input type="text" class="idIn" id="id" placeholder="아이디를 입력하세요" name="id">
						</div>
							<button class="check" type="button" id="idCheck">중복 검사</button>
					</div>
					<div class="pwLine">
						<div class="pwInput1">
							<span class="icon"><i class="xi-lock-o"></i></span>
							<div class="pwArea">
								<input type="password" class="pwIn" id="pw1" placeholder="암호를 입력하세요" name="pw1">
							</div>
						</div>
						<div class="pwInput2">
							<div class="pwArea2">
								<input type="password" class="pwIn" id="pw2" placeholder="암호를 입력하세요" name="pw2">
							</div>
						</div>
						<span class="pwCheck"></span>
					</div>
					<div class="inputLine">
						<span class="icon"><i class="xi-mail-o"></i></span>
						<div class="inputArea">
							<input type="email" class="idIn" id="email" placeholder="이메일을 입력하세요" name="email" >
						</div>
							<button class="check" type="button" id="emailCheck">중복 검사</button>
					</div>
					<div class="inputLine">
						<span class="icon"><i class="xi-emoticon-cool-o"></i></span>
						<div class="inputArea">
							<input type="text" class="pwIn" id="name" placeholder="이름을 입력하세요" name="name">
						</div>
					</div>
					<div class="mb-3 row">
						<div class="">
							<button type="button" id="join" class="submit">회원가입</button>
						</div>
					</div>
            	</div>
            </div>
        </section>
        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
