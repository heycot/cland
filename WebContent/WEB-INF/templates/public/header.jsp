<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/taglib.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<title>CLand | VinaEnter Edu</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!--Oswald Font -->
		<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/css/tooltipster.css" />
		<!-- home slider-->
		<link href="<%=request.getContextPath() %>/templates/public/css/pgwslider.css" rel="stylesheet">
    	<!-- Font Awesome -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/font-awesome.min.css">
		<link href="<%=request.getContextPath() %>/templates/public/style.css" rel="stylesheet" media="screen">	
		<link href="<%=request.getContextPath() %>/templates/public/responsive.css" rel="stylesheet" media="screen">		
	
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    	
	</head>

	<body>
		<section id="header_area">
			<div class="wrapper header">
				<div class="clearfix header_top">
					<div class="clearfix logo floatleft">
						<a href="index.php"><h1><span>C</span>Land</h1></a>
					</div>
				</div>
				<div class="header_bottom" style="height: 50px">
					<nav>
						<ul id="nav">
							<li><a href="${pageContext.request.contextPath }">Trang chủ</a></li>
							<li id="dropdown"><a href="javascript:void(0)">Bất động sản</a>
								<ul>
									<c:forEach items="${listCat }" var="cat">
									<li><a href="${pageContext.request.contextPath }/cat/${cat.cid}">${cat.cname }</a></li>
									</c:forEach>
								</ul>
							</li>
							<li><a href="${pageContext.request.contextPath }/contact">Liên hệ</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</section>