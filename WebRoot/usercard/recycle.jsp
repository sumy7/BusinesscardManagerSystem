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

<title>回收站</title>
<s:include value="/head.jsp" />
</head>
<body>
	<s:include value="/top.jsp" />
	<div class="container">
		<s:iterator value="cardlist" id="iter" status="st">
			<s:if test="#st.getIndex()%2==0">
				<div class="row">
			</s:if>
			<div class="col-sm-6 col-md-6 bussiness-card-over">
				<div class="bussiness-card">
					<div class="row">
						<div class="col-sm-4 col-md-4">
							<img src="<s:property value="#iter.photopath" />" alt=""
								class="img-rounded img-responsive" />
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
								<s:url id="recycleurl" action="toRecycleCard">
									<s:param name="cardid">
										<s:property value="#iter.id" />
									</s:param>
								</s:url>
								<a class="btn btn-primary" role="button"
									href="<s:property value='recycleurl' />">还原</a>
								<s:url id="destroyurl" action="toDestroyCard">
									<s:param name="cardid">
										<s:property value="#iter.id" />
									</s:param>
								</s:url>
								<a class="btn btn-danger" role="button"
									href="<s:property value='destroyurl' />">彻底删除</a>

							</p>
						</div>
					</div>
				</div>
			</div>
			<s:if test="#st.getIndex()%2==1">
	</div>
	</s:if>
	</s:iterator>
	<s:include value="/foot.jsp" />
</body>
</html>
