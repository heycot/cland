<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
    
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Sửa Thông tin user</div>
		</div>
		<div class="content-box-large box-with-header">
			<div>
			<form action="" method="post">
				<div class="row mb-10"></div>

				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="name">Tên user</label> 
							<input type="text" class="form-control" name="username" value="${userEdit.username }" disabled="none" placeholder="Nhập username" >
							<form:errors path="user.username"></form:errors>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="name">Fullname</label> 
							<input type="text" class="form-control" name="fullname" value="${userEdit.fullname }" placeholder="Nhập fullname">
							<form:errors path="user.fullname"></form:errors>
						</div>

					</div>
				</div>
				<%-- 

				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="name">Password</label> 
							<input type="password" class="form-control" name="password" value="${userEdit.password }" placeholder="Nhập password">
							<form:errors path="user.password"></form:errors>
						</div>

					</div>
				</div>	
				 --%>
				
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="name">Role</label>
							<select class="form-control"  name="role_id">
								<c:forEach items="${listRole }" var="role">
									<c:if test="${role.role_id } == ${userEdit.role_id }">
										<option value="${role.role_id}" selected="true">${role.role_name}</option>
									</c:if>
									<option value="${role.role_id}">${role.role_name}</option>
								</c:forEach>
							</select> 
							<form:errors path="cat.cname"></form:errors>
						</div>

					</div>
				</div>
											
				
				<!-- <input type="hidden" name="cid" value="${catEdit.cid }"> -->
				<hr>
				<div class="row">
					<div class="col-sm-12">
						<input type="submit" value="Sửa" class="btn btn-success" /> <input
							type="reset" value="Nhập lại" class="btn btn-default" />
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>
<!-- /.row col-size -->
