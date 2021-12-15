<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
	<header>
		<jsp:include page="partials/navbar.jsp"></jsp:include>
	</header>
	<h1 class="text-center">Ah comprar</h1>
	<div class="row container-fluid">
		<jsp:include page="productos/cardtraccion.jsp"></jsp:include>
	</div>
</body>
</html>
	