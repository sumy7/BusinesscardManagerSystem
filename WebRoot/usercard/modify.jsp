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

<title>修改名片</title>
<s:include value="/head.jsp" />
<script type="text/javascript" src="js/uploadpreview.js"></script>
</head>
<body>
	<s:include value="/top.jsp" />
	<div class="panel panel-default"
		style="margin-right:auto;margin-left:auto">
		<div class="panel-heading">
			<h3 class="panel-title">修改名片</h3>
		</div>
		<div class="panel-body">
			<form role="form" action="toUpdateCard" method="post"
				enctype="multipart/form-data">
				<s:hidden name="usercard.id" value="%{usercard.id}"></s:hidden>
				<s:hidden name="usercard.photopath" value="%{usercard.photopath}"></s:hidden>
				<s:hidden name="usercard.owner" value="%{usercard.owner}"></s:hidden>
				<div class="form-group">
					<label for="Input1">姓名</label> <input type="text"
						class="form-control" id="modifyCardInputName"
						placeholder="请输入名片姓名" name="usercard.name"
						value="<s:property value='usercard.name' />">
				</div>
				<div class="form-group">
					<label for="Input2">职务</label> <input type="text"
						class="form-control" id="modifyCardInputPosition"
						placeholder="请输入职务" name="usercard.positon"
						value="<s:property value='usercard.positon' />">
				</div>
				<div class="form-group">
					<label for="Input3">电话</label> <input type="text"
						class="form-control" id="modifyCardInputTel" placeholder="请输入电话"
						name="usercard.tel" value="<s:property value='usercard.tel' />">
				</div>
				<div class="form-group">
					<label for="Input4">邮箱-email</label> <input type="text"
						class="form-control" id="modifyCardInputEmail"
						placeholder="请输入电子邮箱" name="usercard.email"
						value="<s:property value='usercard.email' />">
				</div>
				<div class="form-group">
					<label for="Input5">住址</label> <input type="text"
						class="form-control" id="modifyCardInputAddress"
						placeholder="请输入住址" name="usercard.address"
						value="<s:property value='usercard.address' />">
				</div>
				<div class="form-group">
					<label for="modifyCardInputFile">选择头像</label> <input type="file"
						id="upload" name="upload">
					<p class="help-block">要保留原头像，请留空。</p>
					<div id="imgDiv"></div>
				</div>
				<button type="submit" class="btn btn-default">修改</button>
				<button class="btn btn-default" onclick="history.go(-1)">取消</button>
			</form>
		</div>
	</div>
	<br>
	<s:include value="/foot.jsp" />
</body>
</html>
