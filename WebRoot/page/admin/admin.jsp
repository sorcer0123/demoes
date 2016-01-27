<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js">
<head>
<title>后台管理</title>
<%@ include file="../base.jsp" %>
<jsp:include page="../include.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include><!-- 头部 -->
	
	<div class="am-cf admin-main"><!-- 后台管理内容部分，包含左右两边 -->
		
		<jsp:include page="template/left.jsp"></jsp:include><!-- 左侧菜单 -->
	
		<div class="admin-content"><!-- 右边内容部分 -->
			
			<!-- 页面导航 -->
    		<jsp:include page="template/navigator.jsp">
    			<jsp:param value="首页" name="one"/>
    			<jsp:param value="Home" name="two"/>
    		</jsp:include>
    		
    		<!-- help.jsp -->
    		<jsp:include page="template/help.jsp"></jsp:include>
    		
		</div><!-- 右边内容部分结束 -->
	
	</div><!-- 后台管理内容部分，包含左右两边结束 -->
	
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>