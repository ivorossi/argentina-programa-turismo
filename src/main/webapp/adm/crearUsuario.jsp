<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../partials/head.jsp"></jsp:include>
</head>
<body>
	<header>
		<jsp:include page="../partials/navbar.jsp"></jsp:include>
	</header>
	<div class="container-fluid  col-md-8 px-5 py-5 border border-5 rounded-pill border-dark shadow-lg bg-success bg-opacity-25">
		<form class="row g-3 needs-validation mx-5 px-5" action="/argentina-programa-turismo/crearUsuario.do" method="post">
			<jsp:include page="../usuario/partialForm2.jsp"></jsp:include>
		</form>
		<c:if test="${user != null && !user.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al crear la el usuario.</p>
			</div>
		</c:if>
	</div>
</body>
</html>