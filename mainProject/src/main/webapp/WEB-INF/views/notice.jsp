<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>게시판</title>
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="css/styles.css" rel="stylesheet" />
	<link href="css/board.css" rel="stylesheet" />
	
	<link href="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/css/suneditor.min.css" rel="stylesheet">
	<!-- <link href="https://cdn.jsdelivr.net/npm/suneditor@latest/assets/css/suneditor.css" rel="stylesheet"> -->
	<!-- <link href="https://cdn.jsdelivr.net/npm/suneditor@latest/assets/css/suneditor-contents.css" rel="stylesheet"> -->
	<script src="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/suneditor.min.js"></script>
	<!-- languages (Basic Language: English/en) -->
	<script src="https://cdn.jsdelivr.net/npm/suneditor@latest/src/lang/ko.js"></script>
	
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
	function writeCheck(){
		let title = document.querySelector("#title");
		let content = document.querySelector("#content");
		if(title.value.length < 4){
			alert("제목 이상");
			title.focus();
			return false;
		}
		if(content.value.length < 10){
			alert("컨텐츠 이상");
			content.focus();
			return false;
		}
	}
	
	function detail(no){
		//title, text, icon, buttton
		//swal("Good Job!","상세보기입니다.","success");
      	/*
		swal({
			title: ""+no,
			text: "이거이 번호랑께요",
			icon: "success", 
			button: "close"	
		});
		*/
		let detailModal = new bootstrap.Modal('#detail', {});	//{옵션}
		$.ajax({
			url:"/restDetail",
			type:"post",
			dataType: "json",
			data: {'no':no},
			success : function(data){
				//alert(data.board_title);
				$("#modalTitle").text(data.board_title);
				$("#modalContent").text(data.board_content);
		    	detailModal.show();
			},
			error : function(error){
				alert(error);
			}
		})
	}
	
function linkPage(pageNo){
	location.href = "/board?pageNo="+pageNo;
}	

</script>
</head>
    <body id="page-top">
        <!-- Navigation-->
        <%-- <c:import url="menu.jsp"/> --%>
        <%@ include file="menu.jsp" %>
        
        <!-- 게시판 -->
        <section class="page-section" id="services">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">공지사항</h2>
                </div>
                <div class="row text-center">
                    <table class="table table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>날짜</th>
								<th>읽음</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="row">
							<tr>
								<td onclick="detail(${row.nno})" class="w1">${row.nno }</td>
								<td class="title" ><a href='/detail?no=${row.nno }'>${row.ntitle }</a></td>
								<%-- <c:if test="${row.comment ne 0}"><span class="badge">${row.comment }</span></c:if></a></td> --%>
								<td class="w2">관리자</td>
								<td class="w1">${row.ndate }</td>
								<td class="w1">${row.ncount }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- 페이징 --><%-- 
					<div class="pagings" >
						<ui:pagination paginationInfo="${paginationInfo }" type="image" jsFunction="linkPage"/>
					</div>
					<c:if test="${sessionScope.mid ne null }">
					<button type="button" class="btn btn-info writeBtn" data-bs-toggle="modal" data-bs-target="#write">글쓰기</button>
					</c:if> --%>
					<%-- <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#detail">디테일</button> --%>
                </div>
            </div>
        </section>      
		<!-- 글쓰기 모달 만들기 -->
		<c:if test="${sessionScope.mid ne null }">
		<div class="modal" id="write">
			<div class="modal-dialog modal-xl">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title">글쓰기 창 입니다.</h3>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>
					<div class="modal-body">
						<div class="">
							<form action="./write" method="post" onsubmit="return writeCheck()" name="frm">
								<input type="text" id="title" name="title" class="form-control mb-2" placeholder="제목" required="required">
								<textarea name="content" id="content" class="form-control mb-2 vh-500" placeholder="내용" required="required"></textarea>
								<button type="submit" class="btn btn-info" style="width:100%;">글쓰기</button>
							</form>
						</div>
					</div>
					<div class="modal-footer">
						2024-02-19 웹표준 기술 / RESTAPI / RESTFULL
					</div>
				</div>
			</div>
		</div> 
		</c:if>
		<!-- 톺아보기 modal -->
		<div class="modal" id="detail">
			<div class="modal-dialog modal-xl">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title" id="modalTitle">톺아보기</h3>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>
					<div class="modal-body">
						<div class="mt-2" id="modalContent">
							제목<br>
							본문내용
						</div>
					</div>
					<div class="modal-footer">
						 톺아보기 모달 푸터
						 
					</div>
				</div>
			</div>
		</div> 
		
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
        <script type="text/javascript">
        /**
        * ID : 'suneditor_sample'
        * ClassName : 'sun-eidtor'
        */
        // ID or DOM object
        const editor = SUNEDITOR.create((document.getElementById('sample') || 'sample'),{
            // All of the plugins are loaded in the "window.SUNEDITOR" object in dist/suneditor.min.js file
            // Insert options
            // Language global object (default: en)
            height: '400',
            lang: SUNEDITOR_LANG['ko']
        });
        </script>
    </body>
</html>
