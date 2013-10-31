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
					</p>
				</li>
			</s:if>
			<s:else>
				<li><a href="register.jsp">注册</a></li>
			</s:else>
			<s:if test="#session.visitor != null">
				<li><a href="logout.jsp">注销退出</a>
				</li>
			</s:if>
			<s:else>
				<li><a href="login.jsp">登录</a></li>
			</s:else>
		</ul>
	</div>
</nav>
