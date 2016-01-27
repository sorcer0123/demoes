<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html class="no-js">
<head>
<title>后台管理</title>
<%@ include file="../base.jsp" %>
<jsp:include page="../include.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	
	$table($("#projectTable"), {
		url : "<%=basePath%>admin/projectTable",
		postData : {
			
		},
		colTitle : ['ID', '名称', '备注', '创建日期'],
		colModel : [
			{colName : "id"},
			{colName : "name"},
			{colName : "content"},
			{colName : "createtime"}
		],
		checkbox : true,
		isEditCol : true
	});
	
});
</script>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include><!-- 头部 -->
	
	<div class="am-cf admin-main"><!-- 后台管理内容部分，包含左右两边 -->
		
		<jsp:include page="template/left.jsp"></jsp:include><!-- 左侧菜单 -->
	
		<div class="admin-content"><!-- 右边内容部分 -->
			
			<!-- 页面导航 -->
			<jsp:include page="template/navigator.jsp">
				<jsp:param value="项目管理" name="one"/>
				<jsp:param value="Project" name="two"/>
			</jsp:include>
			
			<!-- 搜索 -->
			<div class="am-g">
				<div class="am-u-sm-12"><!-- 表格上方搜索部分 -->
					<div class="am-input-group am-input-group-sm">
						<input type="text" class="am-form-field">
						<span class="am-input-group-btn">
							<button class="am-btn am-btn-default" type="button">搜索</button>
						</span>
					</div>
				</div><!-- 表格上方搜索部分 end -->
			</div>
			
			<!-- 按钮组 -->
			<div class="am-g">
				<div class="am-u-sm-12">
					<div class="am-btn-toolbar"><!-- 表格上方的按钮组 -->
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
							<button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
							<button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
						</div><!-- 表格上方的按钮组 end -->
					</div>
				</div>
			</div>
			
			<!-- 表格 -->
			<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form">
						<table id="projectTable"></table>
					</form>
				</div>
			</div>
			
			
		</div><!-- 右边内容部分结束 -->
	
	</div><!-- 后台管理内容部分，包含左右两边结束 -->
	
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>