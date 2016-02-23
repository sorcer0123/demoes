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
<%@ include file="../../base.jsp" %>
<jsp:include page="../../include.jsp"></jsp:include>
<script type="text/javascript">
$(function(){

	$table("projectTable", {
		url:"<%=basePath%>project/projectTable",
		columns:[
			{field:'id',title:'ID',idField:true,visible:false}, 
			{field:'name',title:'项目名称'},
			{field:'content',title:'备注'},
			{field:'createtime',title:'创建日期',formatter:dateFormatter},
			{field:'handler',title:"操作",formatter:handlerFormatter,width:80}
		],
		sortName:"createtime"
	});
});

/**
 * 跳转到增加或者修改页面
 */
function addOrUpdateProject(){
	
	$formDialog({
		title:"新增项目"
	},"editProDialog", "/project/addOrUpdatePro", {
		id:""
	});
	
}

function updateData(id){
	
	$formDialog({
		title:"修改项目"
	},"editProDialog", "/project/addOrUpdatePro", {
		id:id
	});
}

/**
 * 删除项目
 */
function deleteData(id){
	$confirm("确定要删除吗？", {
		ok:function(){
			$ajax({
				url:"/project/deletePro",
				data:{
					id:id
				},
				success:function(r){
					if(r && r.success) {
						$msgDialog(r.msg);
						$reloadTable("projectTable");
					}
				}
			});
		}
	});
}

</script>
</head>
<body>
	<jsp:include page="../template/header.jsp"></jsp:include><!-- 头部 -->
	
	<div class="am-cf admin-main"><!-- 后台管理内容部分，包含左右两边 -->
		
		<jsp:include page="../template/left.jsp"></jsp:include><!-- 左侧菜单 -->
	
		<div class="admin-content"><!-- 右边内容部分 -->
			
			<!-- 页面导航 -->
			<jsp:include page="../template/navigator.jsp">
				<jsp:param value="项目管理" name="one"/>
				<jsp:param value="Project" name="two"/>
			</jsp:include>
			
			<!-- 增加按钮 -->
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-6">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" onclick="addOrUpdateProject();" class="am-btn am-btn-default"><span class="am-icon-plus"></span>新增</button>
						</div>
					</div>
				</div>
			</div>
			
			<!-- 表格 -->
			<div class="am-g">
				<div class="am-u-sm-12">
					<table id="projectTable"></table>
				</div>
			</div>
			
			<!-- 表单 -->
			<div id="editProDialog" style="display: none;"></div>
			
		</div><!-- 右边内容部分结束 -->
	
	</div><!-- 后台管理内容部分，包含左右两边结束 -->
	
	<jsp:include page="../template/footer.jsp"></jsp:include>
</body>
</html>