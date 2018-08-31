<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp"%>

<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý danh mục</div>
		</div>
	</div>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">
		  <strong>Success!</strong> ${msg }
		</div>
	</c:if>
	<hr>
    <script type="text/javascript">
        $(document).ready(function(){
            $(document).on('change', '.checkall, .checkitem', function(){
                var $_this = $(this);
                document.getElementById("deleteall").style.display = "block";
                if($_this.hasClass('checkall')){
                    $('.checkitem').prop('checked', $_this.prop('checked'));
                }else{
                    var $_checkedall = true;
                    $('.checkitem').each(function(){
                        if(!$(this).is(':checked')){
                            $_checkedall = false;
                        }
                        $('.checkall').prop('checked', $_checkedall);
                    });
                }
                var $_uncheckedall = true;
                $('.checkitem').each(function(){
                    if($(this).is(':checked')){
                        $_uncheckedall = false;
                    }
                    if($_uncheckedall){
                        document.getElementById("deleteall").style.display = "none";
                    }else{
                        document.getElementById("deleteall").style.display = "block";
                    }
                });
            });
        });
    </script>
	<div class="row">
	</div>

	<div class="row">
		<div class="panel-body">
			<form action="${pageContext.request.contextPath }/admin/contact/delete"  method="post">
			<button class="btn btn-danger" class="btn btn-success" type="submit" class="btn btn-primary" id="deleteall" style="display: none" >
			  <i class="glyphicon glyphicon-remove"></i>&nbsp;Chuyển vào thùng rác
			</button>
			<br>
     		 <table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="example">
				<thead>
					<tr>
						<th width="10%">Remove<input style="display: inline-block; margin-left: 15px;" type="checkbox" class="checkall"></th>
						<th>Liên hệ với người dùng</th>
						<th>Trả lời</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listContact }" var="contact">
						<tr class="odd gradeX">
							<td>
								<input type="checkbox" name="item" value="${contact.cid}" class="checkitem" id="chkitem">
							</td>
							<td>
								<div style="display: block; background-color: #428bca;font-size: x-large;">
								  <strong style="color: white">${contact.subject }</strong> 
								</div>
								<div style="display: block"><span style="font-size: initial; font-weight: bold;">${contact.fullname}</span><span style="padding-left: 5px">${contact.email }</span></div>
								<br>
							    <p>${contact.content }</p>
							    <br>
							    <c:forEach items="${listReply }" var="reply">
							    	<c:if test="${ reply.contact_id == contact.cid }">
										<label for="name"> Trả lời</label>
							    		<div style="display: block"><span style="font-size: initial; font-weight: bold;">${reply.username}</span></div>
										<br>
							    		<p>${reply.content }</p>
							    	</c:if>
							    </c:forEach>
							<td><a href="${pageContext.request.contextPath }/admin/contact/reply/${contact.cid}" title="" class="btn btn-primary">
								<span class="glyphicon glyphicon-send "></span></a> 
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</form>
		</div>
	</div>
	<!-- /.row -->
</div>
<!-- /.content-box-large -->


