<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp"%>

<div class="content-box-large">
	<div class="row">
		<div class="panel-heading">
			<div class="panel-title ">Quản lý tin</div>
		</div>
	</div>
	<div class="alert alert-info">
	  <strong>Info!</strong> Dữ liệu sẽ bị xóa trong vòng 30 ngày.
	</div>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">
		  <strong>Success!</strong> ${msg }
		</div>
	</c:if>
	<hr>
    <script type="text/javascript">
        $(document).ready(function(){
            $(document).on('change', '.checkall, .checkitem', function(){
                var $_this = $(this);
                document.getElementById("deleteall").style.display = "block";
                if($_this.hasClass('checkall')){
                    $('.checkitem').prop('checked', $_this.prop('checked'));
                }else{
                    var $_checkedall = true;
                    $('.checkitem').each(function(){
                        if(!$(this).is(':checked')){
                            $_checkedall = false;
                        }
                        $('.checkall').prop('checked', $_checkedall);
                    });
                }
                var $_uncheckedall = true;
                $('.checkitem').each(function(){
                    if($(this).is(':checked')){
                        $_uncheckedall = false;
                    }
                    if($_uncheckedall){
                        document.getElementById("deleteall").style.display = "none";
                    }else{
                        document.getElementById("deleteall").style.display = "block";
                    }
                });
            });
        });
    </script>
	<div class="row">
	</div>

	<div class="row">
		<div class="panel-body">
			<form action="${pageContext.request.contextPath}/admin/news/recycle/del" method="post">
			<button class="btn btn-danger" class="btn btn-success" type="submit" class="btn btn-primary" id="deleteall" style="display: none" >
			  <i class="glyphicon glyphicon-remove"></i>&nbsp;Xóa vĩnh viến
			</button>
			<br>
     		<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
				<thead>
					<tr>
						<th width="20%">Delete All<input style="display: inline-block; margin-left: 15px;" type="checkbox" class="checkall"></th>
						<th>Tên Tin</th>
						<th>Danh Mục</th>
						<th>Ngày Đăng</th>
						<th>Lượt Đọc</th>
						<th>Hình Ảnh</th>
						<th width="7%">Hoàn tác</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listNews }" var="news">
					<tr class="odd gradeX">
						<td>
							<input type="checkbox" name="item" value="${news.lid}" class="checkitem" id="chkitem">
						</td>
						<td>${news.lname }</td>
						<td>${news.cname }</td>
						<td><fmt:formatDate value="${news.date_create}" var="dateString" pattern="dd/MM/yyyy" />${dateString}</td>
						<td class="center">${news.count_views }</td>
						<td class="center text-center">
							<c:if test="${not empty news.picture }">
							<img src="${pageContext.request.contextPath}/files/${news.picture}" alt="Không có hình ảnh" width="200" height="150"/>
							</c:if>
						</td>
						<td class="center text-center">
						<a href="${pageContext.request.contextPath}/admin/news/recycle/active/${news.lid}" title="" class="btn btn-primary">
							<span class="glyphicon glyphicon-refresh"></span></a>
						</td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>
			</form>
			<!-- Pagination -->
			<nav class="text-center" aria-label="...">
				<ul class="pagination">
				<c:forEach begin="1" end="${sumpage}" var="i">
				<c:choose>
					<c:when test="${page == i }">
						<li class="active">
						<a href="${pageContext.request.contextPath}/admin/news/${i}">${i } <span class="sr-only">(current)</span></a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
						<a href="${pageContext.request.contextPath}/admin/news/${i}">${i } <span class="sr-only">(current)</span></a>
						</li>
					</c:otherwise>
				</c:choose>
				</c:forEach>
				</ul>
			</nav>
			<!-- /.pagination -->
		</div>
	</div>
	<!-- /.row -->
</div>
<!-- /.content-box-large -->
