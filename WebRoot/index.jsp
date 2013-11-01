<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>首页</title>
<s:include value="/head.jsp" />
</head>
<body>
	<s:include value="/top.jsp" />
	<div class="jumbotron">
		<h1>欢迎你，小伙伴。</h1>
		<p>要使用功能，可是要登录的呀。</p>
		<p>
			<a class="btn btn-primary btn-lg" role="button">单击左侧以开始</a>
		</p>
	</div>
	<br>
	<s:include value="/foot.jsp" />
</body>
</html>
