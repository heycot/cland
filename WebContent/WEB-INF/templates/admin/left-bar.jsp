<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
<ul class="nav">
    <!-- Main menu -->
    <li class="current"><a href="${pageContext.request.contextPath }/admin"><i class="glyphicon glyphicon-home"></i> Trang chủ</a></li>
    <li><a href="${pageContext.request.contextPath }/admin/cats"><i class="glyphicon glyphicon-list"></i> Danh mục</a></li>
    <li><a href="${pageContext.request.contextPath }/admin/news"><i class="glyphicon glyphicon-book"></i> Tin tức</a></li>
    <c:if test="${userInfo.role_id == 1 }">
    <li><a href="${pageContext.request.contextPath }/admin/user"><i class="glyphicon glyphicon-user"></i> Người dùng</a></li>
    </c:if>
    <li><a href="${pageContext.request.contextPath }/admin/contact"><i class="glyphicon glyphicon-envelope"></i> Liên hệ</a></li>
    <li>
    	<a href="${pageContext.request.contextPath }/admin/recycleBin"><i class="glyphicon glyphicon-trash"></i>Thùng rác</a>
    </li> 
</ul>