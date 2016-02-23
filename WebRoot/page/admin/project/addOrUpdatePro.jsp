<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html class="no-js">
<head>
<script type="text/javascript">
$(function(){
	$("#addOrUpdateProForm").validate({
		submitHandler:function(form){
			$ajax({
				url:"/project/savePro",
				data:$formParams("addOrUpdateProForm"),
				success:function(r){
					if(r && r.success) {
						$msgDialog(r.msg);
						$reloadTable("projectTable");
						dialog.get("editProDialog").close();
					}
				}
			});
		}
	});
});
</script>
</head>
<body>
	<form class="am-form am-form-horizontal" id="addOrUpdateProForm">
		<input type="hidden" name="id" value="${project.id }" />
		<div class="am-form-group">
			<label for="name" class="am-u-sm-2 am-form-label">名称:</label>
			<div class="am-u-sm-10">
				<input type="text" id="name" name="name" placeholder="输入项目名称" class="required" maxlength="100" value="${project.name }">
			</div>
		</div>
		<div class="am-form-group">
			<label for="content" class="am-u-sm-2 am-form-label">备注:</label>
			<div class="am-u-sm-10">
				<textarea rows="5" cols="20" name="content" placeholder="输入备注" maxlength="200">${project.content }</textarea>
			</div>
		</div>
		<div class="am-form-group">
			<label for="content" class="am-u-sm-2 am-form-label"></label>
			<div class="am-u-sm-10">
				<input type="submit" class="am-btn am-btn-default" value="确定">
			</div>
		</div>
	</form>
</body>
</html>