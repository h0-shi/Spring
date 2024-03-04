<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 관리</title>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link href="./css/board.css" rel="stylesheet" />
<script type="text/javascript">
function linkPage(pageNo){
	location.href = "./board?&pageNo="+pageNo+"&search=${search}&searchTitle=${searchTitle}";
}	
$(function(){	
	$("#perPage").change(function(){
		location.href="./board?pageNo=${pageNo}&perPage="+$('#perPage').val();
	});
	
	$('#searchBtn').click(function(){
		location.href="./board?pageNo=${pageNo}&perPage=${perPage}&search="+$('#search').val()+"&searchTitle="+$('#searchTitle').val();
	});
	
	$('#reset').click(function(){
		location.href="./board"
	});
	
	$('.del').click(function(){
		const bno = $(this).siblings('.bno').text();
		const dno = $(this).children('.dno');
		const line = $(this).parents('.line');
		let del = $(this);
		 $.ajax({
			url: './delStatus',
			type: 'post',
			data: {"board_no":bno, "board_del":dno.val()},
			dataType: "json",
			success: function(result){
				if(dno.val()=="1"){
					alert("글이 삭제 처리 되었습니다.");
					del.html('<i class="fa fa-eye-slash" aria-hidden="true"></i> 삭제됨 <input type="hidden" class="dno" value="0">');
					line.css("background-color","#CCCCCC");
				} else {
					alert("글이 공개 처리 되었습니다.");
					del.html('<i class="fa fa-eye" aria-hidden="true"></i> 게시됨 <input type="hidden" class="dno" value="1">');
					line.css("background-color","white");
				}
			},
			error: function(request, status, error){
				alert("에러 발생");
			}
		}); 
	});
});

</script>
</head>
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
					<div class="m-2 row">
						<select name="perPage" id="perPage" class="form-control col-2">
							<option value="1"
							<c:if test="${perPage eq 1 }">selected="selected" </c:if>
							>10개씩 보기</option>
							
							<option value="2" 
							<c:if test="${perPage eq 2 }">selected="selected" </c:if>
							>20개씩 보기</option>
							
							<option value="3"
							<c:if test="${perPage eq 3 }">selected="selected" </c:if>
							>30개씩 보기</option>
							
							<option value="4"
							<c:if test="${perPage eq 4 }">selected="selected" </c:if>
							>40개씩 보기</option>
							
							<option value="5"
							<c:if test="${perPage eq 5 }">selected="selected" </c:if>
							>50개씩 보기</option>
							
							<option value="10"
							<c:if test="${perPage eq 10 }">selected="selected" </c:if>
							>100개씩 보기 </option>
						</select>
						<div class="input-group col-6">
							<select name="searchTitle" id="searchTitle" class="form-control col-3">
								<option value="1"
								<c:if test="${searchTitle eq 1 }">selected="selected" </c:if>
								>제목</option>
								<option value="2"
								<c:if test="${searchTitle eq 2 }">selected="selected" </c:if>
								>본문</option>
								<option value="3"
								<c:if test="${searchTitle eq 3 }">selected="selected" </c:if>
								>작성자</option>
							</select>
							<input type="text" name="search" id="search" class="form-control" value=${search }>
							<button type="button" class="btn btn-secondary col-2" id="searchBtn" style="border-top-left-radius: 0px; border-bottom-left-radius: 0px; ">검색</button>
						</div>
						<button class="btn btn-info col-1" id="reset">초기화</button>
					</div>
                    <table class="table table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>날짜</th>
								<th>읽음</th>
								<th>게시상태</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="row">

							<c:set var="today"><fmt:formatDate value="<%=new java.util.Date()%>" pattern="yy-MM-dd" /></c:set>
							<fmt:parseDate var="dateString" value="${row.board_date }" pattern="yyyy-MM-dd HH:mm:ss" />
							<tr <c:if test="${row.board_del eq 0 }">style="background-color:#CCCCCC"</c:if> class="line">
								<td class="w1 bno">${row.board_no }</td>
								<td class="title" >
									<c:if test="${LocalDate.now() lt row.board_date}"><span class="badge text-bg-info">N</span></c:if>
									<a href='/detail?no=${row.board_no }'>${row.board_title } 
									<c:if test="${row.comment ne 0}"><span class="comments"> [${row.comment }]</span></c:if></a></td>
								<td class="w2">
									<a href="./board?searchTitle=3&search=${row.mname }">${row.mname }</a>
								</td>
								<td class="w1">
									<fmt:formatDate  value="${dateString }" pattern="YY-MM-dd HH:mm" />
								</td>
								<td class="w1">${row.board_count }</td>
								<td class="w1 del" >
									<c:if test="${row.board_del eq 1}">
									<i class="fa fa-eye" aria-hidden="true"></i> 게시됨</c:if>
									<c:if test="${row.board_del eq 0}">
									<i class="fa fa-eye-slash" aria-hidden="true"></i> 삭제됨</c:if>
									<input type="hidden" value="${row.board_del }" class="dno">
								</td>
							</tr>
							
							</c:forEach>
						</tbody>
					</table>
					<!-- 페이징 -->
					<div class="paging">
						<ui:pagination paginationInfo="${paginationInfo }" type="image" jsFunction="linkPage"/>
					</div>
					<c:if test="${sessionScope.mid ne null }">
					<button type="button" class="btn btn-info writeBtn" data-bs-toggle="modal" data-bs-target="#write">글쓰기</button>
					</c:if>
					<%-- <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#detail">디테일</button> --%>
                </div>
            </div>
					
				</div>
		</div>
</body>
</html>