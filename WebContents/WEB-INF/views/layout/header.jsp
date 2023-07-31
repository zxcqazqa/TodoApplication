<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="today" value="${sessionScope.today}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js" integrity="sha512-3gJwYpMe3QewGELv8k/BX9vcqhryRdzRMxVfq6ngyWXwo03GFEzjsUm8Q7RZcHPHksttq7/GFoxjCVUjkjvPdw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<script src="${contextPath}/resources/js/todoList.js"></script>

<script>
	const contextPath = "${contextPath}"
	let today = {
		year : "${today.year}",
		month : "${today.month}",
		day : "${today.day}",
		today : "${today.today}"
	}
</script>

</head>
<body>
<div class="jumbotron">
</div>
<div class="container">
	<div class="d-flex justify-content-between">
		<div>
			<a href="${contextPath}/">홈</a>
		</div>
	</div>
	<div class="menu">
		<ul>
			<li><a href="${contextPath}/todoList/${today.year}/${today.month}">투두리스트</a></li>
			<li><a href="#">Link 1</a></li>
			<li><a href="#">Link 2</a></li>
			<li><a href="#">Link 3</a></li>
			<li><a href="#">Link 4</a></li>
		</ul>
	</div>
</div>

