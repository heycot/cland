<%@include file="/templates/taglib.jsp" %>
<div class="clearfix content">
						
						<h1>${newsDe.lname }</h1>
						<div class="clearfix post-meta">
							<p><span><i class="fa fa-clock-o"></i> Địa chỉ: ${newsDe.address }</span> <span><i class="fa fa-folder"></i> Diện tích: ${newsDe.area } m2</span></p>
						</div>
						
						<div class="vnecontent">
							<img style="width: 100%" src="${pageContext.request.contextPath }/files/${newsDe.picture}" alt="" >
							<br>
							<br>
							<p>${newsDe.description }</p>
						</div>
						<c:if test="${newsDe.lid != minId }">
						<c:set var="urlDetailbef" value="${pageContext.request.contextPath}/${slugUtil.makeSlug(newsDe.cname)}/${slugUtil.makeSlug(newsDe.lname) }-${newsDe.lid}/bef.html" > </c:set>
	            
						<a class="btn" href="${urlDetailbef}">Bài trước</a>
						</c:if>
						<c:if test="${newsDe.lid != maxId }">
						<c:set var="urlDetailaft" value="${pageContext.request.contextPath}/${slugUtil.makeSlug(newsDe.cname)}/${slugUtil.makeSlug(newsDe.lname) }-${newsDe.lid}/aft.html" > </c:set>
	            
						<a class="btn" href="${urlDetailaft}">Bài kế</a>
						</c:if>
					</div>
					
						<div class="more_themes">
							<h2>Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i></h2>
							<div class="more_themes_container">
								<c:forEach items="${moreitem }" var="news">
								<c:set var="urlDetail" value="${pageContext.request.contextPath}/${slugUtil.makeSlug(news.cname)}/${slugUtil.makeSlug(news.lname) }-${news.lid}.html" > </c:set>
	            
								<div class="single_more_themes floatleft">
									<img src="${pageContext.request.contextPath }/files/${news.picture}" alt=""/>
									<a href="${urlDetail }"><h2>${news.lname }</h2></a>
								</div>
								</c:forEach>
								
							</div>
						</div>