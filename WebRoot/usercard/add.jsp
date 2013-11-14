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

<title>添加新的名片</title>
<s:include value="/head.jsp" />
<script type="text/javascript" src="js/uploadpreview.js"></script>
</head>
<body>
	<s:include value="/top.jsp" />
	<div class="panel panel-default"
		style="margin-right:auto;margin-left:auto">
		<div class="panel-heading">
			<h3 class="panel-title">添加名片</h3>
		</div>
		<div class="panel-body">
			<form role="form" action="toAddCard" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="Input1">姓名</label> <input type="text"
						class="form-control" id="addCardInputName" placeholder="请输入名片姓名"
						name="usercard.name">
				</div>
				<div class="form-group">
					<label for="Input2">职务</label> <input type="text"
						class="form-control" id="addCardInputPosition" placeholder="请输入职务"
						name="usercard.positon">
				</div>
				<div class="form-group">
					<label for="Input3">电话</label> <input type="text"
						class="form-control" id="addCardInputTel" placeholder="请输入电话"
						name="usercard.tel">
				</div>
				<div class="form-group">
					<label for="Input4">邮箱-email</label> <input type="text"
						class="form-control" id="addCardInputEmail" placeholder="请输入电子邮箱"
						name="usercard.email">
				</div>
				<div class="form-group">
					<label for="Input5">住址</label> <input type="text"
						class="form-control" id="addCardInputAddress" placeholder="请输入住址"
						name="usercard.address">
				</div>
				<div class="form-group">
					<label for="modifyCardInputFile">选择头像</label> <input type="file"
						id="upload" name="upload">
					<p class="help-block">留空则使用默认头像。</p>
					<div id="imgDiv"></div>
				</div>
				<button type="submit" class="btn btn-default">添加</button>
				<button type="reset" class="btn btn-default">重填</button>
			</form>
		</div>
	</div>
	<br>
	<s:include value="/foot.jsp" />
</body>
</html>
