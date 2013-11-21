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
			<s:if test="#session.visitor == null"> <a class="btn btn-primary btn-lg" role="button" href="login.jsp">登录</a></s:if>
			<s:else><a class="btn btn-primary btn-lg" role="button">欢迎用户【<s:property value="#session.visitor.username" />】O(∩_∩)O~~</a></s:else>
		</p>
	</div>
	<br>
	<s:include value="/foot.jsp" />
</body>
</html>
