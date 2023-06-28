<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../includes/header.jsp"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Tables</h1>
		</div>
		
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Board List Page <button id="regBtn" type="button" class="btn btn-primary btn-xs pull-right"> 등 록 </button></div>
				
				<!-- /.panel-heading -->
				<div class="panel-body">
					<!-- 테이블 시작 -->
					<table width="100%"
						class="table table-striped table-bordered table-hover"
						id="dataTables-example">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
							</tr>
						</thead>

						<c:forEach items="${list }" var="board">
							<tr>
								<td><c:out value="${board.bno }" /></td>
								<td><a href="/board/get?bno=<c:out value="${board.bno }" />"><c:out value="${board.title }" /></a></td>
								<td><c:out value="${board.writer }" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.regDate }" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.updateDate }" /></td>

							</tr>

						</c:forEach>

					</table>
					<!-- /.table-responsive -->
					<!-- 모달 입력 -->
					<div id="myModal" class="modal" tabindex="-1" role="dialog">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title">Modal title</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<p>처리를 완료했습니다.</p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					<!-- 모달 입력 끝-->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-6 -->
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->
<SCRIPT>
	$(document).ready(function() {
		var result = '<c:out value = "${result}"/>';

		checkModal(result);

		history.replaceState({},null,null);
		
		function checkModal(result) {
			if (result === '' || history.state) {
				return;
			}
				if (parseInt(result) > 0) {
					$(".modal-body").html("게시물 " + parseInt(result) + " 번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}
	});
	
	$("#regBtn").on("click", function() {
		self.location="/board/register";
	});	
</SCRIPT>

<%@include file="../includes/footer.jsp"%>