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

<title>搜索名片</title>
<s:include value="/head.jsp" />
</head>
<body>
	<s:include value="/top.jsp" />
	<form class="form-inline" role="form" action="toSearchCard" method="get">
		<div class="form-group">
			<label class="sr-only" for="exampleInputEmail2">关键字</label>
			<input type="text" class="form-control" id="searchInput"
				placeholder="请输入要搜索的关键字" name="keyword" value="<s:property value='keyword'/>">
		</div>
		<button type="submit" class="btn btn-default">搜索</button>
	</form>
	<br>
		<table class="table table-hover">
		<tr>
			<td>#</td>
			<td>姓名</td>
			<td>职务</td>
			<td>电话</td>
			<td>电子邮箱</td>
			<td>住址</td>
			<td>修改</td>
			<td>删除</td>
		</tr>
		<s:iterator value="cardlist" id="iter" status="st">
			<tr>
				<td><s:property value="#st.getIndex()+1" /></td>
				<td><s:property value="#iter.name" /></td>
				<td><s:property value="#iter.positon" /></td>
				<td><s:property value="#iter.tel" /></td>
				<td><s:property value="#iter.email" /></td>
				<td>wo<s:property value="#iter.address" /></td>
				<s:url id="modifyurl" action="toModifyCard">
					<s:param name="cardid">
						<s:property value="#iter.id" />
					</s:param>
				</s:url>
				<td><a class="btn btn-primary" role="button" href="<s:property value='modifyurl' />">修改</a></td>
								<s:url id="delurl" action="toDelCard">
					<s:param name="cardid">
						<s:property value="#iter.id" />
					</s:param>
				</s:url>
				<td><a class="btn btn-danger" role="button" href="<s:property value='delurl' />">删除</a></td>
			</tr>
		</s:iterator>
	</table>
	<s:include value="/foot.jsp" />
</body>
</html>
