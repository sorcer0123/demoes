<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<script src="//cdn.bootcss.com/jquery/1.10.0/jquery.min.js"></script>

<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript" charset="utf-8" src="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/js/amazeui.js"></script>

<script type="text/javascript" charset="utf-8" src="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/js/app.js"></script>

<script type="text/javascript" charset="utf-8" src="<%=basePath%>jsLib/utils/ajax.js"></script>

<script type="text/javascript" charset="utf-8" src="<%=basePath%>jsLib/utils/date.js"></script>

<script type="text/javascript" charset="utf-8" src="<%=basePath%>jsLib/utils/table.js"></script>

<link rel="icon" type="image/png" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/i/favicon.png">

<link rel="icon" sizes="192x192" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/i/app-icon72x72@2x.png">

<link rel="apple-touch-icon-precomposed" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/i/app-icon72x72@2x.png">

<link type="text/css" rel="stylesheet" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/css/amazeui.css" >

<link rel="stylesheet" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/css/amazeui.min.css">
<link rel="stylesheet" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/css/app.css">
<link rel="stylesheet" href="<%=basePath%>jsLib/AmazeUI-2.5.1/assets/css/admin.css">

<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/bootstrap-table.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/bootstrap-table.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/locale/bootstrap-table-zh-CN.min.js"></script>


