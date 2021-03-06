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
<script type="text/javascript" src="js/jquery.textSearch-1.0.js"></script>
</head>
<body>
	<s:include value="/top.jsp" />
	<form class="form-inline" role="form" action="toSearchCard"
		method="get">
		<div class="form-group">
			<label class="sr-only" for="exampleInputEmail2">关键字</label> <input
				type="text" class="form-control" id="searchInput"
				placeholder="请输入要搜索的关键字" name="keyword"
				value="<s:property value='keyword'/>">
		</div>
		<button type="submit" class="btn btn-default">搜索</button>
	</form>
	<br>
	<div class="container">
		<s:iterator value="cardlist" id="iter" status="st">
			<s:if test="#st.getIndex()%2==0">
				<div class="row">
			</s:if>
			<div class="col-sm-6 col-md-6 bussiness-card-over">
				<div class="bussiness-card">
					<div class="row">
						<div class="col-sm-4 col-md-4">
							<img src="<s:property value="#iter.photopath" />"
								class="img-rounded img-responsive"></img>
						</div>
						<div class="col-sm-8 col-md-8">
							<blockquote>
								<p>
									<s:property value="#iter.name" />
								</p>
								<small><cite title="Source Title"><s:property
											value="#iter.positon" /> </cite> </small>
							</blockquote>
							<p>
								<i class="glyphicon glyphicon-phone-alt"></i>
								<s:property value="#iter.tel" />
								<br /> <i class="glyphicon glyphicon-envelope"></i>
								<s:property value="#iter.email" />
								<br /> <i class="glyphicon glyphicon-map-marker"></i>
								<s:property value="#iter.address" />
							</p>
							<p>
								<s:url id="modifyurl" action="toModifyCard">
									<s:param name="cardid">
										<s:property value="#iter.id" />
									</s:param>
								</s:url>
								<a class="btn btn-primary" role="button"
									href="<s:property value='modifyurl' />">修改</a>

								<s:url id="delurl" action="toDelCard">
									<s:param name="cardid">
										<s:property value="#iter.id" />
									</s:param>
								</s:url>
								<a class="btn btn-danger" role="button"
									href="<s:property value='delurl' />">删除</a>

							</p>
						</div>
					</div>
				</div>
			</div>
			<s:if test="#st.getIndex()%2==1">
	</div>
	</s:if>
	</s:iterator>
	</div>
	<script>
		$(".bussiness-card").textSearch($("#searchInput").val());
	</script>
	<s:include value="/foot.jsp" />
</body>
</html>
