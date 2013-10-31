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
	您已经成功【注销登录】。
	<br>
	<br>
	<a href="index.jsp">返回首页</a>
	<br>
	<br>
	<a href="login.jsp">重新登录</a>
	<br>
	<br>
	<s:include value="/foot.jsp" />
</body>
</html>
