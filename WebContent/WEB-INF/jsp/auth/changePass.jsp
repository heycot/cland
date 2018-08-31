<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<%@include file="/templates/taglib.jsp" %>
<tiles:insertAttribute name="header"></tiles:insertAttribute>
<form action="${pageContext.request.contextPath }/changePass" method="post">
    <div class="page-content container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-wrapper">
                    <div class="box">
                        <div class="content-wrap">
                            <img width="100px" height="100px" class="img-circle" src="${defines.urlAdmin}/images/icon-180x180.png">

                            <div class="form-group">
                                <label class="text-left pull-left" for="username">Tên đăng nhập</label>
                                <input class="form-control" type="text" name="username" placeholder="Username">
                            </div>

                            <div class="action">
                                <input type="submit" class="btn btn-primary signup btn-block" value="Lấy lại mật khẩu" >
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</form>
<tiles:insertAttribute name="footer"></tiles:insertAttribute>
    
    