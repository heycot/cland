<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp"%>

<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý Người dùng</div>
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
		<div class="col-md-8">
			<a href="${pageContext.request.contextPath }/admin/user/add"
				class="btn btn-success"><span class="glyphicon glyphicon-plus"
				aria-hidden="true"></span>&nbsp;Thêm</a>

		</div>
	</div>

	<div class="row">
		<div class="panel-body">
			<form action="${pageContext.request.contextPath}/admin/user/delete" method="post">
			<button class="btn btn-danger" class="btn btn-success" type="submit" class="btn btn-primary" id="deleteall" style="display: none" >
			  <i class="glyphicon glyphicon-remove"></i>&nbsp;Delete All
			</button>
			<br>
     		<table cellpadding="0" cellspacing="0" border="0"
				class="table table-striped table-bordered" id="example">
				<thead>
					<tr>
						<th width="20%">Delete All<input style="display: inline-block; margin-left: 15px;" type="checkbox" class="checkall"></th>
						<th>UserName</th>
						<th>FullName</th>
						<th width="20%">Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listUser }" var="user">
						<tr class="odd gradeX">
							<td>
							<input type="checkbox" name="item" value="${user.id}" class="checkitem" id="chkitem">
							</td>
							<td>${user.username }</td>
							<td>${user.fullname }</td>
							<td class="center text-center">
								<a href="${pageContext.request.contextPath }/admin/user/edit/${user.id}" title="" class="btn btn-primary">
								<span class="glyphicon glyphicon-pencil "></span> Sửa</a> 
								<a href="${pageContext.request.contextPath }/admin/user/delete/${user.id}" title="" class="btn btn-danger" onclick="confirm('Bạn có chắc chán xóa không')">
								<span class="glyphicon glyphicon-trash" ></span> Xóa</a>
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


