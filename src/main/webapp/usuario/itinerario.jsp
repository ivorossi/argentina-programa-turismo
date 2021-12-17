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
	
	<div class="container-fluid  col-md-7 px-5 py-5 border border-5 rounded-pill border-dark shadow-lg bg-success bg-opacity-25">
		<h4 class="text-center">Itinerario de: <c:out value="${usuario.nombre}" />.</h4>
		<div Class="container-fluid col-md-11">
		<table class="table table-success table-striped p-5 ">
			<thead>
					<tr>
						<th scope="col">Producto</th>
						<th scope="col">Tipo de producto</th>
						<th scope="col">Costo</th>
						<th scope="col">Duracion</th>
					</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuario.getItinerario().getProductosDelUsuario()}" var="producto">
					<tr>
						<td><c:out value="${producto.nombreDeProducto}"></c:out></td>
						<td><c:out value="${producto.tipoDeProducto}"></c:out></td>
						<td><c:out value="${producto.costoTotal}"></c:out> monedas</td>
						<td><c:out value="${producto.timepoDeProducto}"> horas</c:out></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
				<td>Total:</td>
				<td>       </td>
				<td><c:out value="${usuario.getItinerario().costoTotal()}"></c:out> monedas</td>
				<td><c:out value="${usuario.getItinerario().tiempoTotal()}"></c:out> horas</td>
				</tr>
			</tfoot>
		</table>
	</div>	
	</div>
</body>
</html>