<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Trinity Company - My info</title>
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
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
        <script type="text/javascript">
        const Toast = Swal.mixin({
        	  toast: true,
        	  position: 'center-center',
        	  showConfirmButton: false,
        	  timer: 3000,
        	  timerProgressBar: true,
        	  didOpen: (toast) => {
        	    toast.onmouseenter = Swal.stopTimer;
        	    toast.onmouseleave = Swal.resumeTimer;
        	  }
        	});
        
        function emailAuth(){
        	$.ajax({
        		url  : './emailAuth',
        		type : 'post',
        		dataType : 'text',
        		success : function(result){
        			if(result == 1){
	        			//Swal.fire("전송했습니다.","결과 : " + result, "success");
	        			Toast.fire('전송했습니다','결과 : ' + result, 'success');
        				
        			} else {
            			//Swal.fire("문제 발생","문제가 발생했습니다", "info");
            			Toast.fire('통신문제','통신문제가 발생했습니다.','info');
        			}
        		},
        		error : function(request, status, error){
        			//Swal.fire("Ooops.","문제가 발생했습니다 : " + error, "Error");
        			Toast.fire('Ooops','문제가 발생했습니다.' + error, 'error');
        		}
        	});
        }
        </script>
<style type="text/css">
.titleSpan{
	background-color: skyblue;
}        
.mailForm{
	width: 800px;; 
	margin: 10px 0px;
}
.submitBtn{
	margin: 10px 0px;
	width: 100%;
} 

</style>
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <%@ include file="menu.jsp" %>
        
        <section class="page-section" id="my-info">
            <div class="d-flex justify-content-center">
               <div class="text-center">
               	<h1>메일을 써봅니다.</h1>
               		<form action="./mail"  method="post" class="mailForm">
               		<div class="input-group mb-3">
					  <span class="input-group-text titleSpan" id="basic-addon1">받는 사람</span>
					  <input type="email" class="form-control titleInput" placeholder="Email Address" aria-label="Username" aria-describedby="basic-addon1" name ="email">
					</div>
               		<div class="input-group mb-3">
					  <span class="input-group-text" id="basic-addon1">&ensp;&ensp;제 목&ensp;&ensp;</span>
					  <input type="text" class="form-control" placeholder="Title" aria-label="Username" aria-describedby="basic-addon1" name ="title">
					</div>
					<div class="input-group">
					  <span class="input-group-text" style="vertical-align: top;" > &ensp;&ensp;본 문&ensp;&ensp; </span>
					  <textarea class="form-control" name="content" aria-label="With textarea" placeholder="본문" style="min-height: 500px;"></textarea>
					</div>
						<button type="submit" class="btn btn-success submitBtn">보내기</button>
               		</form>
               		
					
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
