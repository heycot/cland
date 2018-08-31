<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>

<div class="clearfix content">

    <div class="contact_us">

        <h1>Liên hệ với chúng tôi</h1>
        <p>
            TRUNG TÂM ĐÀO TẠO LẬP TRÌNH VINAENTER EDU<br /> Trụ sở: 154 Phạm Như Xương, Liên Chiểu, Đà Nẵng<br /> Web: <a href="http://vinaenter.edu.vn" title="">www.vinaenter.edu.vn</a>
        </p>
		<br>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">
		  		<strong style="color: indianred; font-size: large;">Success!</strong> ${msg }
			</div>
		</c:if>
        <form action="" method="post">
            <p><input type="text" name="fullname" class="wpcf7-text" placeholder="Họ tên *" /></p>
            <form:errors path="contact.fullname"></form:errors>
						
            <p><input type="text" name="email" class="wpcf7-email" placeholder="Email *" /></p>
            <form:errors path="contact.email"></form:errors>
			<p><input type="text" name="subject" class="wpcf7-text" placeholder="Chủ đề *" /></p>
            <form:errors path="contact.subject"></form:errors>
			<p><textarea class="wpcf7-textarea" name="content" placeholder="Nội dung *"></textarea></p>
            <form:errors path="contact.content"></form:errors>
						<p><input type="Submit" class="wpcf7-submit" value="Gửi liên hệ" /></p>
        </form>

    </div>

</div>