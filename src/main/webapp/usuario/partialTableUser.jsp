<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Username</th>
			<th scope="col">Nombre</th>
			<th scope="col">Tiempo</th>
			<th scope="col">Monedas</th>
			<th scope="col">Gusto</th>
			<th scope="col">Admin?</th>
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
				<td>ad</td>
			</tr>
		</c:forEach>
	</tbody>

</table>