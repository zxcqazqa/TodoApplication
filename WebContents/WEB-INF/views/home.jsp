<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<div class="container">
	<h1>제목</h1>
	<div>
		<spring:message code="home.greeting" arguments="${name},${welcome}"/>
	</div>
</div>
<%@ include file="layout/footer.jsp" %>


