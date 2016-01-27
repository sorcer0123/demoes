<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<% 
	String one = request.getParameter("one");
	String two = request.getParameter("two");
%>

<div class="am-cf am-padding">
	<div class="am-fl am-cf">
		<strong class="am-text-primary am-text-lg"><%=one %></strong> / <small><%=two %></small>
	</div>
</div>



