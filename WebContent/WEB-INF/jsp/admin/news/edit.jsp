<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp"%>
    
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Thêm tin</div>
		</div>
		
		<c:if test="${not empty error }">
			<div class="alert alert-danger">
			  <strong>Error!</strong> ${error }
			</div>
		</c:if>
		<div class="content-box-large box-with-header">
			<div>
			<form action="" method="post" enctype="multipart/form-data" >
				<div class="row mb-10"></div>

				<div class="row">
					<div class="col-sm-12">
						<div class="form-group">
							<label for="name">Tên tin</label> 
							<input type="text" name="lname" value="${newsEdit.lname }" class="form-control" placeholder="Nhập tên tin">
						<form:errors path="news.lname"></form:errors>
						</div>

						<div class="form-group">
							<label>Danh mục tin</label> 
							<select class="form-control" name="cid">
								<c:forEach items="${listCat }" var="cat">
									<option value="${cat.cid }">${cat.cname }</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-group">
							<label for="name">Diện tích</label> 
							<input type="text" name="area" value="${newsEdit.area }" class="form-control" placeholder="Nhập diện tích đất">
						<form:errors path="news.area"></form:errors>
						</div>
						
						
						<div class="form-group">
							<label for="name">Địa chỉ</label> 
							<input type="text" name="address" value="${newsEdit.address }" class="form-control" placeholder="Nhập địa chỉ">
						<form:errors path="news.address"></form:errors>
						</div>

						<div class="form-group">
							<label>Thêm hình ảnh</label> 
							<input type="file" name="hinhanh" class="btn btn-default" id="exampleInputFile1">
							<p class="help-block">
								<em>Định dạng: jpg, png, jpeg,...</em>
							</p>
						</div>

						<div class="form-group">
							<label>Mô tả</label>
							<textarea class="form-control" id="description" name="description" value="${newsEdit.description }" rows="3" placeholder="Nhập mô tả"></textarea>
						<form:errors path="news.description"></form:errors>
						</div>

					</div>
				</div>

				<hr>

				<div class="row">
					<div class="col-sm-12">
						<input type="submit" value="Sửa" class="btn btn-success" /> <input
							type="reset" value="Nhập lại" class="btn btn-default" />
					</div>
				</div>
				</form>
			</div><script src="${pageContext.request.contextPath }/libraries/ckeditor/ckeditor.js"></script>
				<script src="${pageContext.request.contextPath }/libraries/ckfinder/ckfinder.js"></script>
				<script>
					CKEDITOR
							.replace(
									'description',
									{
										filebrowserBrowseUrl : 'ckfinder/ckfinder.html',
										filebrowserImageBrowseUrl : 'ckfinder/ckfinder.html?type=Images',
										filebrowserFlashBrowseUrl : 'ckfinder/ckfinder.html?type=Flash',
										filebrowserUploadUrl : 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
										filebrowserImageUploadUrl : 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
										filebrowserFlashUploadUrl : 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'
									});
					</script>
		</div>
	</div>
</div>
<!-- /.row col-size -->
