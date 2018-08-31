<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp"%>
		
		<section id="content_area">
			<div class="clearfix wrapper main_content_area">
			
				<div class="clearfix main_content floatleft">
				
					
					<div class="clearfix content">
						<div class="content_title"><h2>Our Works</h2></div>
						
						<div class="clearfix single_work_container">
							<c:forEach items="${listNewsSameCat }" var="news">
							<c:set var="urlDetail" value="${pageContext.request.contextPath}/${slugUtil.makeSlug(news.cname)}/${slugUtil.makeSlug(news.lname) }-${news.lid}.html" > </c:set>
	            
							<div class="clearfix single_work">
								<img class="img_top" src="images/work1.png" alt=""/>
								<img class="img_bottom" src="images/work_bg2.png" alt=""/>
								<a href="${urlDetail}"></a><h2>${news.lname }</h2></a>
								<a href="${urlDetail}">
								<p class="caption">${news.description }</p>
								</a>
							</div>
							</c:forEach>
							
							<div class="clearfix work_pagination">
								<div class="pagination">
								   <nav class="text-center" aria-label="...">
										<ul class="pagination">
										<c:forEach begin="1" end="${sumpage}" var="i">
										<c:choose>
											<c:when test="${page == i }">
												<li class="active">
												<a style="background: #ffd500" href="${pageContext.request.contextPath}/cat/${i}">${i }&nbsp;&nbsp; <span class="sr-only">&nbsp;</span></a>
												</li>
											</c:when>
											<c:otherwise>
												<li>
												<a href="${pageContext.request.contextPath}/cat/${i}">${i }&nbsp;&nbsp; <span class="sr-only"></span></a>
												</li>
											</c:otherwise>
										</c:choose>
										</c:forEach>
										</ul>
									</nav>
								</div>
							</div>

						</div>
					</div>
					
				</div>
<div class="clearfix sidebar_container floatright">
				</div>
			</div>
		</section>
		
