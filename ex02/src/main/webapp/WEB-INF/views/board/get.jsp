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
				
					<div class="form-group">
						<label>Bno</label> <input class="form-control" name='bno' 
							value='<c:out value = "${board.bno }"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title" 
							value='<c:out value = "${board.title }"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
						<label>TextArea</label> <textarea readonly="readonly" class="form-control" name="content" rows="3"
							><c:out value = "${board.content } " /></textarea>
					</div>
					
					
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer" 
							value='<c:out value = "${board.writer }"/>' readonly="readonly">
					</div>
					
					<button data-oper='modify' class="btn btn-default"
					 onclick="location.href='/board/modify?bno=<c:out value = "${board.bno }"/>'">
						Modify
					</button>
					<button data-oper='list'  class="btn btn-info" 
					 onclick="location.href='/board/list'">
						List
					</button>
					<form id="operForm" action="/board/modify" method="get">
						<input type="hidden" id="bno" name="bno" value='<c:out value = "${board.bno }"/>'>
						<input type="hidden" name="pageNum" value='<c:out value = "${cri.pageNum }"/>'>
						<input type="hidden" name="amount" value='<c:out value = "${cri.amount }"/>'>
						<input type="hidden" name="keyword" value='<c:out value = "${cri.keyword }"/>'>
						<input type="hidden" name="type" value='<c:out value = "${cri.type }"/>'>

					</form>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-6 -->
	</div>
	<!-- /.row -->
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
<!--				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i> Reply
				</div>-->
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i> Reply
					<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
				</div>

				<!-- /.panel-heading -->
				<div class="panel-body">
					<ul class="chat">
						<li class="left clearfix" data-rno="2">
							<div>
								<div class="header">
									<strong class="primary-font">user00</strong>
									<small class="pull-right text-muted">2022-01-01 13:13</small>
								</div>
								<p>Good job!</p>
							</div>
						</li>
					</ul>
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

					<!-- 모달 입력 -->
					<div id="myModal" class="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label>Reply</label>
										<input class="form-control" name="reply" value="NewReply!!!!">
									</div>
									<div class="form-group">
										<label>Replyer</label>
										<input class="form-control" name="replyer" value="replyer">
									</div>
									<div class="form-group">
										<label>Reply Date</label>
										<input class="form-control" name="replyDate" value="">
									</div>

								</div>
								<div class="modal-footer">
									<button id="modalModBtn" type="button" class="btn btn-warning">Modify</button>
									<button id="modalRemoveBtn" type="button" class="btn btn-danger">Close</button>
									<button id="modalCloseBtn" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									<button id="modalClassBtn" type="button" class="btn btn-default" data-dismiss="modal">Close</button>

									<button id="modalBtn" type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>

								</div>
							</div>
						</div>
					</div>
<script type="text/javascript" src="/resources/js/reply.js"></script>



<script type="text/javascript">
$(document).ready(function() {
	var operForm = $("operForm");
	
	$("button[data-oper='modify']").on("click",function(e){
		operForm.attr('action','/board/modify').submit();
	});
	$("button[data-oper='list']").on("click",function(e){
		operForm.find("#bno").remove();
		operForm.attr('action','/board/list');
		operForm.submit();
	});
});
</script>

<script type="text/javascript">
	console.log(replyService);
	
	var bnoVal = '<c:out value="${board.bno}"/>';
	var replyUL = $(".chat");

	showList(1);

	function showList(page){
		replyService.getList({bno:bnoVal, page:1},function(list){
	
			var str="";
			if(list == null || list.length == 0){
				replyUL.html("");
			}
			
			for(var i = 0, len =list.length||0; i < len; i++){
				str += "<li class='left clearfix' data-rno='" + list[i].rno + "'>";
				str += "	<div><div class='header'><strong class='primary-font'>" + list[i].replyer + "</strong>";
				str += "		<small class='pull-right text-muted'>" + list[i].replyDate2 + "</small></div>";
				str+= "			<p>" + list[i].reply + "</p></div></li>";
			}

			replyUL.html(str);
		})

	}

	var modal = $('.modal');
	var InputReply = modal.find(input[name='reply']);
	var InputReplyer = modal.find(input[name='replyer']);
	var InputReplyDate = modal.find(input[name='replyDate']);

	var modalModBtn = $('#modalModBtn');
	var modalRemoveBtn = $('#modalRemoveBtn');
	var modalRegisterBtn = $('#modalBtn');


	/*
	replyService.add(
	{reply:"JS Test", replyer:"tester", bno:bnoVal},
		function(result){
			alert("result: " + result);
		}
	);*/
	

	
/*
	replyService.remove(23,function(count){
		if(count === "success")
			alert("REMOVED");
	}, function(err){
		alert("error");
	});

	replyService.update({rno : 20, bno : bnoVal, reply : "madified Reply"},
		function(result){
			alert("수정완료");
	});
	*/
</script>


<%@include file="../includes/footer.jsp"%>