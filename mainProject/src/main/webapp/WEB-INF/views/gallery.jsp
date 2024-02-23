<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>파일 업로드</title>
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
        	
        function fileCheck(){
        	let fileVal = $("#file1").val();
        	if(fileVal == ""){
        		alert("파일을 선택하세여");
        		return false;
        	} else {
				let ext = fileVal.split('.').pop().toLowerCase(); // 확장자 분리
				//아래 확장자가 있는지 체크
				if($.inArray(ext,['jpg','jpeg','gif','png'])==-1) {
					alert("jpg, jpeg, png, gif 파일만 업로드 가능합니다");
					return false;
				}
        	}
        }
        </script>
<style type="text/css">
.galleryForm{
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
        <div class="container">
       		<div class="text-center">
            	<h2 class="section-heading text-uppercase">게시판</h2>
        	</div>
	        <div class="row text-center">
		        <table>
		        	<thead>
		        		<tr>
		        			<td>번호</td>
		        			<td>제목</td>
		        			<td>이미지</td>
		        			<td>날짜</td>
		        			<td>좋아요</td>
		        		</tr>
		        	</thead>
		        	<tbody>
		        		<c:forEach items="${list }" var="row">
							<tr>
								<td>${row.gno }</td>
								<td>${row.gtitle }</td>
								<td>
									<img alt="사진" src="./thumbnail/s_${row.gfile }">
								</td>
								<td>${row.gdate }</td>
								<td>${row.glike }</td>
							</tr>        	
		        		</c:forEach>
		        	</tbody>
		        	
		        </table>
	        </div>
        </div>
        
        <!-- login-->
        <section class="page-section" id="my-info">
            <div class="d-flex justify-content-center">
               <div class="text-center">
               		<form action="./galleryInsert" method="post" class="galleryForm" enctype="multipart/form-data" onsubmit="fileCheck()">
	               		<div class="input-group mb-2">
							<span class="input-group-text titleSpan" id="basic-addon1">&ensp; 제&ensp;목 &ensp;</span>
						  	<input type="text" class="form-control titleInput" placeholder="Title" aria-label="Username" aria-describedby="basic-addon1" name ="gtitle">
						</div>
               			<div class="input-group mb-2 rBottom">
						  <input type="file" accept="image/*" class="form-control fileIn" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload" name="file1">
						</div>
						<div class="input-group">
						  	<span class="input-group-text" style="vertical-align: top;" > &ensp;&ensp;본문&ensp;&ensp; </span>
						  	<textarea class="form-control" name="gcontent" aria-label="With textarea" placeholder="본문" style="min-height: 500px;"></textarea>
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
