<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	session.removeAttribute("visitor");
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注销登录</title>
<s:include value="/head.jsp" />
</head>
<body>
	<s:include value="/top.jsp" />
	<p class="lead">您已经成功【注销登录】。</p>
	<p><a type="button" class="btn btn-primary" href="index.jsp">返回首页</a></p>
	<p><a type="button" class="btn btn-default" href="login.jsp">重新登录</a></p>
	<br>
	<br>
	<s:include value="/foot.jsp" />
</body>
</html>
