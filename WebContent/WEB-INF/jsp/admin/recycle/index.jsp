<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp"%>

<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Thùng rác</div>
		</div>
	</div>
	<hr>
	<div class="row">
	<div class="col-md-12 panel-info">
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label for="name">
							<a href="${pageContext.request.contextPath }/admin/news/recycle">Tin Tức</a>
							</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
						<label for="name">
							<a href="${pageContext.request.contextPath }/admin/contact/recycle">Liên Hệ</a>
						</label>
						</div>
					</div>
				</div>
				<c:if test="${userInfo.role_id == 1 }">
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
						<label for="name">
							<a href="${pageContext.request.contextPath }/admin/user/recycle">Người Dùng</a>
							</label>
						</div>
					</div>
				</div>
				</c:if>
			</div>
		</div>
	</div>
<!-- /.content-box-large -->


