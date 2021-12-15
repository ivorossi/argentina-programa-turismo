<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Nombre</th>
			<th scope="col">Tipo De Promo</th>
			<th scope="col">Tipo de producto</th>
			<th scope="col">Costo</th>
			<th scope="col">Duracion</th>
			<th scope="col">Atracciones Incluidas:</th>
		</tr>
	</thead>
<%int i = 0;%>
	<tbody>
		<c:forEach items="${promos}" var="promo">
		<%i++;%>
			<tr>
				<td><%=i%></td>
				<td><c:out value="${promo.nombreDeProducto}"></c:out></td>
				<td><c:out value="${promo.getTipoDePromo()}"></c:out></td>
				<td><c:out value="${promo.tipoDeProducto}"></c:out></td>
				<td><c:out value="${promo.costoTotal}"></c:out></td>
				<td><c:out value="${promo.timepoDeProducto}"></c:out></td>
				<td>
					<c:forEach items="${promo.getAtracciones()}" var="atraccion">
						  _<c:out value="${atraccion.getNombreDeProducto()}"></c:out>_
					</c:forEach>
				</td>
				<td><c:out value="${promo.getDescuento()}"></c:out></td>
				<td>ad</td>
			</tr>
		</c:forEach>
	</tbody>

</table>