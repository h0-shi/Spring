<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>톺아보기</title>
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
<link rel="icon" type="image/png" sizes="192x192" href="assets/android-icon-192x192.png">
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
<link href="css/board.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
function deletePost(){
   Swal.fire({
        title: "삭제하시겠습니까?",
        text: "글를 삭제합니다.",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "삭제",
        cancelButtonText: "취소"
      }).then((result) => {
        if (result.isConfirmed) {
         //java에게 삭제하라고 명령내리겠습니다.
         //가상 form = post
         let vform = $('<form></form>');
         vform.attr('name', 'vform');
         vform.attr('method', 'post');
         vform.attr('action', './galleryDel');
         vform.append($('<input/>', {type:'hidden', name:'no', value:${detail.gno } }));
         vform.appendTo('body');
         vform.submit();
         //Swal.fire("삭제했습니다.","", "success");
        }//end if
      });
}

$(function(){
	$("#commentBtn").click(function(){
		let comment = $(this).parents(".btnArea").siblings(".cArea").children(".commentArea").val();
		if(comment.length <1){
			alert("댓글을 입력해주세요");
		} else if(comment.length > 300) {
			alert("300자 이내로 입력 가능합니다");
		} else {
			$("#commentForm").submit();
		}
	});
	
	$(".commentArea").keyup(function(){
		let comment = $(this).val().length;
		let lengBtn = $(this).parents(".cArea").siblings(".btnArea").children().children();
		lengBtn.text(comment+"/300");
		if(comment > 300){
			lengBtn.css("color","red");
		} else {
			lengBtn.css("color","white");
		}
	});

});
</script>
<style type="text/css">
body{
	font-family: "Gowun Dodum", sans-serif;
	font-weight: 400;
	font-style: normal;
}
.writeBox{
	padding: 10px 5px;
}
.commentArea{
	width: 90%;
	height : 100px;
	padding: 15px;
	margin: 0;
	float: left;
	border-color: skyblue;
	font-size: smaller;
	border-radius: 5px 0px 0px 5px;
	resize: none;
}
#commentBtn{
	width: 10%;
	height : 100px;
	border-radius: 0px 5px 5px 0px;
}
.comment{
	margin: 5px 0px;
	padding: 10px 10px 0px 10px;
	border-top: 0.3px solid skyblue;
}
.id, .ip{
	width: calc(50% - 24px);
	height: 24px;
	padding-left: 1%;
	float: left;
	text-align: left;
}
.date, .like{
	width: calc(50% - 24px);
	height: 24px;
	float: left;
	text-align: right;
}
.date, .ip{
	font-size: smaller;
}
.cText{
	width: 100%;
	height: auto;
	font-style: normal;
	float: left;
	margin: 5px 4px;
}
.commentInfo{
	font-size: smaller;
}
.goBtn{
	border-radius: 5px;
	border: 1px solid black;
}
.writerInfo{
	border-bottom: 1px solid #c0c0c0; 
	border-top: 1px solid #c0c0c0;
}
.edit, .del{
	width: 24px;
	height: 24px;
}
.detailDate{
	font-size: smaller;
}
.userImg{
	width: 48px;
	height: 48px;
	float: left;
}
.user{
	width: 48px;
	height: 48px;
}
.content{
	font-family: "Gowun Dodum", sans-serif;
	font-weight: 400;
	font-style: normal;
}
.title{
	font-family: "Gowun Dodum", sans-serif;
	font-weight: 400;
	font-style: normal;
}
.btns{
	font-family: "Gowun Dodum", sans-serif;
	font-weight: 400;
	font-style: normal;
}
.leng{
	font-size: x-small;
}
.span{
	text-align: right;
	font-size: smaller;
	font-family: "Gowun Dodum", sans-serif;
	font-weight: 400;
}
.span a{
	text-decoration: none;
	color : grey;
}
.span span a:hover{
	color:black;
}
.like a{
	width: 100%;
	text-decoration: none;
	color: black;
}
.image{
	margin-top: 15px;
	width: 100%;
}
.imageWrap{
	width: 100%;
	text-align: center;
}
</style>
</head>
<body id="page-top">
	<!-- Navigation-->
	<c:import url="menu.jsp" />

	<!-- detail -->
	<section class="page-section" id="detail">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">&ensp;</h2>
			</div>
			<div class="card mb-4" style="min-height: 500px;">
				<div class="card-body">
					<div class="h2 title">${detail.gtitle }</div>
					<div class="row p-2 writerInfo">
						<div class="col align-middle text-start">${detail.mname } &ensp;
						<c:if test="${detail.mname eq sessionScope.mname && detail.mid eq sessionScope.mid }">
							<img alt="edit" src="./img/edit.png" class="edit">
							<img alt="del" src="./img/delete.png" class="del" title="글 삭제" onclick="deletePost()">
						</c:if>
						</div>
						<div class="col align-middle text-end detailDate">${detail.gdate }</div>
					</div>
					<div class="imageWrap">
						<img alt="이미지" src="./upfile/${detail.gfile }" class="image">
					</div>
					<div class="mt-4 h-auto content">${detail.gcontent }</div>
				</div>
			</div>
		<button class="btn btn-warning btns" onclick="history.back()">백시판으로</button>
		<button class="btn btn-danger btns" onclick="history.go('-1')">고시판으로</button>
		<hr>
		<div class="writeBox" id="writeBox">
			<form action="./commentWrite" method="post" id="commentForm">
				<input type="hidden" name="no" value="${detail.gno }" >
				<div class="cArea">
					<textarea class="commentArea" id="commentArea" placeholder="예쁘게 써주시요" name="comment"></textarea>
				</div>
				<div class="btnArea">
					<button type="button" class="btn btn-info btns" id="commentBtn">등록
					<div class="leng">0/300</div>
					</button>				
				</div>
				<!-- <button class="commentButton">등록</button> -->
			</form>
		</div>
		</div>
	</section>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
