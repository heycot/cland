<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
    
<div class="row">
	<div class="col-md-12 panel-info">
		<div class="content-box-header panel-heading">
			<div class="panel-title ">Gửi trả lời</div>
		</div>
		<div class="content-box-large box-with-header">
			<div>
				<div class="row mb-10"></div>

				<div class="row">
					<div class="col-sm-12">
						<div class="form-group">
							<label for="name">Người Nhận</label> 
							<input disabled type="text" class="form-control" value="${contact.fullname }" name="cname" placeholder="Họ tên người nhận">
							<form:errors path="contact.fullname"></form:errors>
						</div>
						<div class="form-group">
							<label for="name">Email người nhận</label> 
							<input disabled type="text" class="form-control" value="${contact.email }" name="cname" placeholder="Email người nhận">
							<form:errors path="contact.email"></form:errors>
						</div>
						<div class="form-group">
							<label for="name">Chủ đề</label> 
							<input disabled type="text" class="form-control" value="${contact.subject }" name="cname" placeholder="Chủ đề">
							<form:errors path="contact.email"></form:errors>
						</div>
						<div class="form-group">
							<label for="name">Nội dung</label> 
							<input disabled type="text" class="form-control" value="${contact.content }" name="cname" placeholder="Nội dung">
							<form:errors path="contact.email"></form:errors>
						</div>
						<div>
						<form action="" method="post">
							<div class="form-group">
							<label>Nội dung gửi</label>
							<textarea class="form-control" name="content" id="content" rows="3" placeholder="Nhập nội dung thư"></textarea>
						</div>
							
							<div class="row">
								<div class="col-sm-12">
									<input type="submit" value="Gửi" class="btn btn-success" /> <input
										type="reset" value="Nhập lại" class="btn btn-default" />
								</div>
							</div>
							</form>
						</div>
					</div>
				</div>
				<script src="${pageContext.request.contextPath }/libraries/ckeditor/ckeditor.js"></script>
				<script src="${pageContext.request.contextPath }/libraries/ckfinder/ckfinder.js"></script>
				<script>
					CKEDITOR
							.replace(
									'content',
									{
										filebrowserBrowseUrl : 'ckfinder/ckfinder.html',
										filebrowserImageBrowseUrl : 'ckfinder/ckfinder.html?type=Images',
										filebrowserFlashBrowseUrl : 'ckfinder/ckfinder.html?type=Flash',
										filebrowserUploadUrl : 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
										filebrowserImageUploadUrl : 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
										filebrowserFlashUploadUrl : 'ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'
									});
					</script>
				<hr>
			</div>
		</div>
	</div>
</div>
<!-- /.row col-size -->