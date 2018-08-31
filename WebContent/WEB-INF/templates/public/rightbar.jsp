<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>

<div class="clearfix sidebar">
	<div class="clearfix single_sidebar category_items">
		<h2>Danh mục bất động sản</h2>
		<ul>
		<c:forEach items="${listCat }" var="cat">
			<li><a href="${pageContext.request.contextPath }/cat/${cat.cid}">${cat.cname }</a></li>
		</c:forEach>
		</ul>
	</div>

	<div class="clearfix single_sidebar">
		<div class="popular_post">
			<div class="sidebar_title"><h2>Xem nhiều</h2></div>
			<ul>
			<c:forEach items="${listNewsView }" var="NewsView">
			<c:set var="urlDetail" value="${pageContext.request.contextPath}/${slugUtil.makeSlug(NewsView.cname)}/${slugUtil.makeSlug(NewsView.lname) }-${NewsView.lid}.html" ></c:set>
				<li><a href="${urlDetail}">${NewsView.lname}</a></li>
			</c:forEach>
			</ul>
		</div>
	</div>
</div>