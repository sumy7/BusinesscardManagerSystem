<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String rscode = (String) request.getParameter("id");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录</title>
<s:include value="/head.jsp" />
</head>
<body>
	<s:include value="/top.jsp" />
	<%
		if (rscode != null) {
			switch (Integer.parseInt(rscode)) {
			case 0: {
	%>
	<div class="alert alert-warning alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		用户名或密码错误，请重新输入。
	</div>
	<%
		break;
			}
			case 1: {
	%>
	<div class="alert alert-danger alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		参数错误，请重试。
	</div>
	<%
		break;
			}
			case 2: {
	%>
	<div class="alert alert-success alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		注册成功，请登录。
	</div>
	<%
		break;
			}
			}
		}
	%>
	<div class="panel panel-default"
		style="margin-right:auto;margin-left:auto">
		<div class="panel-heading">
			<h3 class="panel-title">请登录</h3>
		</div>
		<div class="panel-body">
			<form role="form" action="toLogin" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">用户名</label> <input type="text"
						class="form-control" id="loginInputUsername" placeholder="请输入用户名"
						name="user.Username">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">密码</label> <input
						type="password" class="form-control" id="loginInputPassword"
						placeholder="请输入密码" name="user.Password">
				</div>
				<button type="submit" class="btn btn-default">登录</button>
			</form>
		</div>
	</div>
	<br>
	<s:include value="/foot.jsp" />
</body>
</html>