<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
    
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Thêm Tài khoản</div>
		</div>
		<div class="content-box-large box-with-header">
			<div>
			<form action="" method="post">
				<div class="row mb-10"></div>

				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="name">Username</label> 
							<input type="text" class="form-control" value="" name="username" placeholder="Nhập tên tài khoản">
							<form:errors path="user.username"></form:errors>
						</div>

					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="name">Fullname</label> 
							<input type="text" class="form-control" value="" name="fullname" placeholder="Nhập họ tên đầy đủ">
							<form:errors path="user.fullname"></form:errors>
						</div>

					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="name">Password</label> 
							<input type="password" class="form-control" value="" name="password" placeholder="Nhập danh mục">
							<form:errors path="user.password"></form:errors>
						</div>

					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="name">Role</label>
							<select class="form-control"  name="role_id">
								<c:forEach items="${listRole}" var="role">
									<option value="${role.role_id}">${role.role_name}</option>
								</c:forEach>
							</select> 
							<form:errors path="cat.cname"></form:errors>
						</div>

					</div>
				</div>

				<hr>

				<div class="row">
					<div class="col-sm-12">
						<input type="submit" value="Thêm" class="btn btn-success" /> <input
							type="reset" value="Nhập lại" class="btn btn-default" />
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>
<!-- /.row col-size -->