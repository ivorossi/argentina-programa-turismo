<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-success table-striped p-5 ">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Username</th>
			<th scope="col">Nombre</th>
			<th scope="col">Tiempo</th>
			<th scope="col">Monedas</th>
			<th scope="col">Gusto</th>
			<th scope="col">Admin?</th>
			<th scope="col">Editar</th>
			<th scope="col">Borrar?</th>
		</tr>
	</thead>
<%int i = 0;%>
	<tbody>
		<c:forEach items="${usuarios}" var="usuario">
		<%i++;%>
			<tr>
				<td><%=i%></td>
				<td><c:out value="${usuario.usuario}"></c:out></td>
				<td><c:out value="${usuario.nombre}"></c:out></td>
				<td><c:out value="${usuario.tiempoDisponible}"></c:out></td>
				<td><c:out value="${usuario.presupuesto}"></c:out></td>
				<td><c:out value="${usuario.gusto}"></c:out></td>
				<td><c:out value="${usuario.adm}"></c:out></td>
				<td>
					<a href="/argentina-programa-turismo/editarUsuario.do?nombre=${usuario.usuario}" class="btn btn-light rounded-0 " role="button">
						<i class="bi bi-pencil-fill"></i>
					</a>		
				</td>
				<td>
					<a href="/argentina-programa-turismo/eliminarUsuario.do?nombre=${usuario.usuario}" class="btn btn-danger rounded " role="button">
						<i class="bi bi-x-circle-fill"></i>
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>

</table>