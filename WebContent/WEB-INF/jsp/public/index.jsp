<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp"%>

<div class="clearfix slider">
<div>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
	    <div class="carousel-inner">
		    <c:forEach items="${listCountView }" var="news">
		    <c:set var="urlDetail" value="${pageContext.request.contextPath}/${slugUtil.makeSlug(news.cname)}/${slugUtil.makeSlug(news.lname) }-${news.lid}.html" > </c:set>
			<c:choose>
			    <c:when test="${news.lid == active }">
			     <div class="item active">
			        <a href= "${urlDetail }"><img width="100%" src="${pageContext.request.contextPath }/files/${news.picture}" alt="${news.lname }" data-description="${news.lname }"  /> </a>
			    </div>
			    </c:when>
			    <c:otherwise>
			     <div class="item">
			        <a href= "${urlDetail }"><img width="100%" src="${pageContext.request.contextPath }/files/${news.picture}" alt="${news.lname }" data-description="${news.lname }"  /></a>
			    </div>
			    </c:otherwise>
		    </c:choose>
		    </c:forEach>
	    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
	      <span class="glyphicon glyphicon-chevron-left"></span>
	      <span class="sr-only">Previous</span>
	    </a>
	    <a class="right carousel-control" href="#myCarousel" data-slide="next">
	      <span class="glyphicon glyphicon-chevron-right"></span>
	      <span class="sr-only">Next</span>
	    </a>
	    </div>
    </div>
    </div>
</div>
	

<div class="clearfix content">
    <div class="content_title">
        <h2>Bài viết mới</h2>
    </div>
	<c:forEach items="${listNews }" var="news">
	    <div class="clearfix single_content">
	        <div class="clearfix post_date floatleft">
	            <div class="date">
	            	<h3><fmt:formatDate value="${news.date_create}" var="ngay" pattern="dd" />${ngay}</h3>
	                <p><fmt:formatDate value="${news.date_create}" var="thangnam" pattern="MM/yyyy" />Tháng ${thangnam}</p>
	            </div>
	        </div>
	        <div class="clearfix post_detail">
	        <c:set var="urlDetail" value="${pageContext.request.contextPath}/${slugUtil.makeSlug(news.cname)}/${slugUtil.makeSlug(news.lname) }-${news.lid}.html" > </c:set>
	            <h2><a href="${urlDetail}" >${news.lname}</a></h2>
	            <div class="clearfix post-meta">
	                <p><span><i class="fa fa-clock-o"></i> Địa chỉ: ${news.address}</span> <span><i class="fa fa-folder"></i> Diện tích: ${news.area } m2</span></p>
	            </div>
	            <div class="clearfix post_excerpt">
	                <img src="${pageContext.request.contextPath }/files/${news.picture}" alt="${news.lname }" />
	                <p> ${slugUtil.substringWord(news.description, 300)}</p>
	            </div>
	            <a href="${urlDetail}">Đọc thêm</a>
	        </div>
	    </div>
	</c:forEach>
</div>

<div class="pagination">
   <nav class="text-center" aria-label="...">
				<ul class="pagination">
				<c:forEach begin="1" end="${sumpage}" var="i">
				<c:choose>
					<c:when test="${page == i }">
						<li class="active" >
						<a style="background: #ffd500" href="${pageContext.request.contextPath}/${i}">${i }&nbsp;&nbsp; <span class="sr-only">&nbsp;</span></a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
						<a href="${pageContext.request.contextPath}/${i}">${i }&nbsp;&nbsp; <span class="sr-only">&nbsp;</span></a>
						</li>
					</c:otherwise>
				</c:choose>
				</c:forEach>
				</ul>
			</nav>
</div>