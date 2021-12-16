<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%int i = 0;%>

<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Nombre</th>
			<th scope="col">Tipo de producto</th>
			<th scope="col">Costo</th>
			<th scope="col">Duracion</th>
			<th scope="col">Cupo</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${atracciones}" var="atraccion">
		<%i++;%>
			<tr>
				<td><%=i%></td>
				<td><c:out value="${atraccion.nombreDeProducto}"></c:out></td>
				<td><c:out value="${atraccion.tipoDeProducto}"></c:out></td>
				<td><c:out value="${atraccion.costoTotal}"></c:out></td>
				<td><c:out value="${atraccion.timepoDeProducto}"></c:out></td>
				<td><c:out value="${atraccion.cupo}"></c:out></td>
				<td>
					<a href="/argentina-programa-turismo/editarAtraccion.do?nombre=${atraccion.nombreDeProducto}" class="btn btn-light rounded-0 " role="button">
						<i class="bi bi-pencil-fill"></i>
					</a>		
				</td>
				<td>
					<a href="/argentina-programa-turismo/eliminarAtraccion.do?nombre=${atraccion.nombreDeProducto}" class="btn btn-danger rounded " role="button">
						<i class="bi bi-x-circle-fill"></i>
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>

</table>