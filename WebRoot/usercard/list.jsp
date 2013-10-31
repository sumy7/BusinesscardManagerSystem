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

<title>显示名片</title>
<s:include value="/head.jsp" />
</head>
<body>
	<s:include value="/top.jsp" />
	<table>
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
				<td><s:property value="#iter.address" /></td>
				<s:url id="modifyurl" action="toModifyCard">
					<s:param name="cardid">
						<s:property value="#iter.id" />
					</s:param>
				</s:url>
				<td><s:a href="%{modifyurl}">修改</s:a></td>
				<td>删除</td>
			</tr>
		</s:iterator>
	</table>
	<s:include value="/foot.jsp" />
</body>
</html>
