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

<title>注册</title>
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
		两次密码不一致，请重新输入。
	</div>
	<%
		break;
			}
			case 1: {
	%>
	<div class="alert alert-danger alert-dismissable">
		<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">&times;</button>
		用户名密码中包含不可接受的字符，请重新输入。
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
			<h3 class="panel-title">注册</h3>
		</div>
		<div class="panel-body">
			<form role="form" action="toRegist" method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">用户名</label> <input type="text"
						class="form-control" id="registInputUsername" placeholder="请输入用户名"
						name="username">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">密码</label> <input
						type="password" class="form-control" id="registInputPassword"
						placeholder="请输入密码" name="password">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">重复密码</label> <input
						type="password" class="form-control" id="registInputRepeatPass"
						placeholder="请重复输入密码" name="repeatpass">
				</div>
				<button type="submit" class="btn btn-default">注册</button>
				<button type="reset" class="btn btn-default">重置</button>
			</form>
		</div>
	</div>

	<s:include value="/foot.jsp" />
</body>

</html>
