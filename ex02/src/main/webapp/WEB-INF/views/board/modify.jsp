<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../includes/header.jsp"%>

<div id="page-wrapper">
	<!-- 제이쿼리 -->
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Board Register Page</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Board Read Page</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<form role="form"  action="/board/modify" method="post">
						<input type="hidden" name="pageNum" value='<c:out value = "${cri.pageNum }"/>'>
						<input type="hidden" name="amount" value='<c:out value = "${cri.amount }"/>'>
						<input type="hidden" name="keyword" value='<c:out value = "${cri.keyword }"/>'>
						<input type="hidden" name="type" value='<c:out value = "${cri.type }"/>'>
						
						<div class="form-group">
							<label>Bno</label> <input class="form-control" name='bno' 
								value='<c:out value = "${board.bno }"/>' readonly="readonly">
						</div>
						
						<div class="form-group">
							<label>Title</label> <input class="form-control" name="title" 
								value='<c:out value = "${board.title }"/>'>
						</div>
						
						<div class="form-group">
							<label>TextArea</label> <textarea class="form-control" name="content" rows="3"
								><c:out value = "${board.content } " /></textarea>
						</div>
						
						
						<div class="form-group">
							<label>Writer</label> <input class="form-control" name="writer" 
								value='<c:out value = "${board.writer }"/>' >
						</div>

						<div class="form-group">
							<label>RegDate</label> <input class="form-control" name="regDate" 
								value='<fmt:formatDate pattern="yyyy/MM/dd" value = "${board.regDate }"/>' readonly="readonly" >
						</div>
						<div class="form-group">
							<label>UpdateDate</label> <input class="form-control" name="regDate" 
								value='<fmt:formatDate pattern="yyyy/MM/dd" value = "${board.updateDate }"/>' readonly="readonly" >
						</div>

						<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
						<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
						<button type="submit" data-oper='list'  class="btn btn-info" >List</button>
					</form>
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

<script type="text/javascript">
	$(document).ready(function() {
		var form = $("form");
		
		$('button').on("click",function(e){
			e.preventDefault();
			
			var operation = $(this).data('oper');


			if(operation === 'remove'){
				form.attr("action","/board/remove")
			} else if(operation === 'list'){
				form.attr("action","/board/list").attr("method","get");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var keywordTag = $("input[name='pageNum']").clone();
				var typeTag = $("input[name='amount']").clone();

				form.empty();
				
				form.append(pageNumTag);
				form.append(amountTag);
				form.append(keywordTag);
				form.append(typeTag);

			} 
			
			form.submit()	
		});
		
	});
</script>

<%@include file="../includes/footer.jsp"%>