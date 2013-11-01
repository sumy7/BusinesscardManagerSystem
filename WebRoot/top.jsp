<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="index.jsp">名片管理系统</a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav navbar-right">
			<s:if test="#session.visitor != null">
				<li><p class="navbar-text">
						欢迎你，用户【
						<s:property value="#session.visitor.username" />
						】
					</p></li>
			</s:if>
			<s:else>
				<li><a href="register.jsp">注册</a>
				</li>
			</s:else>
			<s:if test="#session.visitor != null">
				<li><a href="logout.jsp">注销退出</a></li>
			</s:if>
			<s:else>
				<li><a href="login.jsp">登录</a>
				</li>
			</s:else>
		</ul>
	</div>
</nav>

<div style="margin: 0 20px;">
	<div style="float:left;width:215px; ">
		<div class="list-group">
			<a href="index.jsp" class="list-group-item"> 主页 </a> <a
				href="toListCard_list" class="list-group-item">浏览</a> <a
				href="toInputCard" class="list-group-item">添加名片</a>
				<a
				href="toSearchCard" class="list-group-item">搜索名片</a>
				 <a
				href="toListCard_recycle" class="list-group-item">回收站</a>
		</div>
	</div>
	<div style="float:right;margin:0 0 0 -215px; width:100%">
		<div style="margin:0 0 0 230px;">