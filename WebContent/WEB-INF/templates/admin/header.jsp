<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
    
<%@include file="/templates/taglib.jsp" %>
<html>
  <head>
    <title>Bootstrap Admin Theme v3</title>
    <link rel="shortcut icon" type="image/ico" href="images/icon-180x180.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${defines.urlAdmin }/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- styles -->
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
    <link href="${defines.urlAdmin }/css/style1.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]--> 
    <script src="<%= request.getContextPath()%>/templates/admin/js/jquery-3.3.1.min.js"></script>
	
  </head>
  <body>
  	<div class="header">
	     <div class="container">
	        <div class="row">
	           <div class="col-md-5">
	              <!-- Logo -->
	              <div class="logo">
	                 <h1><a href="${pageContext.request.contextPath }/admin">VNE-Admin</a></h1>
	              </div>
	           </div>
	           <div class="col-md-5">
	              <div class="row">
	                <div class="col-lg-12"></div>
	              </div>
	           </div>
	           <div class="col-md-2">
	              <div class="navbar navbar-inverse" role="banner">
	                  <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
	                    <ul class="nav navbar-nav">
	                      <li class="dropdown">
	                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${userInfo.fullname}<b class="caret"></b></a>
	                        <c:if test="${not empty userInfo}">
	                        <ul class="dropdown-menu animated fadeInUp">
	                          <li><a href="${pageContext.request.contextPath }/profile/${userInfo.id}">Profile</a></li>
	                          <li><a href="${pageContext.request.contextPath }/logout">Logout</a></li>
	                        </ul>
	                        </c:if>
	                      </li>
	                    </ul>
	                  </nav>
	              </div>
	           </div>
	        </div>
	     </div>
	</div>