<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js">
<head>
<title>登录</title>
<%@ include file="base.jsp" %>
<jsp:include page="include.jsp"></jsp:include>
<script type="text/javascript">
function login(){
	window.location.href="/admin";	
}
</script>
<style>
.header {
	text-align: center;
}
    
.header h1 {
	font-size: 200%;
	color: #333;
	margin-top: 30px;
}
.header p {
	font-size: 14px;
}

</style>
</head>
<body>
	<div class="header"><!-- 头部 -->
		<div class="am-g">
			<h1>Aotimes </h1>
    		<p>北京傲时代<br/>信息技术有限公司</p>
		</div>
		<hr />
	</div>
	<div class="am-g">
		<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
			<h3>登录</h3>
    		<div class="am-btn-group">
		    	<a href="javascript:void(0);" class="am-btn am-btn-secondary am-btn-sm"><i class="am-icon-github am-icon-sm"></i> Github</a>
		    	<a href="javascript:void(0);" class="am-btn am-btn-success am-btn-sm"><i class="am-icon-google-plus-square am-icon-sm"></i> Google+</a>
		     	<a href="javascript:void(0);" class="am-btn am-btn-primary am-btn-sm"><i class="am-icon-stack-overflow am-icon-sm"></i> stackOverflow</a>
		    </div>
		    <br>
    		<br>
			<form method="post" class="am-form">
				<label for="email">帐号:</label><input type="email" name="" id="email" value="">
				<br>
				<label for="password">密码:</label><input type="password" name="" id="password" value="">
				<br>
				<label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
				<br />
				<div class="am-cf">
					<input type="button" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl" onclick="login();">
        			<input type="button" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">
				</div>
			</form>
			<hr>
    		<p>© 2016 北京傲时代信息技术有限公司 研发项目</p>
		</div>
	</div>
</body>
</html>