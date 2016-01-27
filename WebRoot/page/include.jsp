<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<link type="text/css" rel="stylesheet" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/css/amazeui.css" >

<script type="text/javascript" charset="utf-8" src="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/js/jquery.min.js"></script>

<script type="text/javascript" charset="utf-8" src="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/js/amazeui.js"></script>

<script type="text/javascript" charset="utf-8" src="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/js/app.js"></script>

<script type="text/javascript" charset="utf-8" src="<%=basePath%>jsLib/ajax.js"></script>

<script type="text/javascript" charset="utf-8" src="<%=basePath%>jsLib/table.js"></script>

<link rel="icon" type="image/png" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/i/favicon.png">

<link rel="icon" sizes="192x192" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/i/app-icon72x72@2x.png">

<link rel="apple-touch-icon-precomposed" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/i/app-icon72x72@2x.png">

<link rel="stylesheet" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/css/amazeui.min.css">
<link rel="stylesheet" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/css/app.css">
<link rel="stylesheet" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/css/admin.css">
