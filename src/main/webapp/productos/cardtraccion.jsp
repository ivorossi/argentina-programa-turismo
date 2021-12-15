<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:forEach items="${productos}" var="producto">
	<div class="card mx-5 my-3 col-md-5 shadow-lg bg-success bg-opacity-25 p-0 ">
		<img src="assets/img/uno.jpg" class="card-img-top">
		<div class="card-body">
			<h5 class="card-title">
				<c:out value="${producto.getNombreDeProducto()}"></c:out>
			</h5>
			<div class="row">
				<div class="col-3 border-end border-5 border-success">
					<p class="card-text text-decoration-underline fw-bold">Duracion: </p>
					
					<p class="card-text">
						<c:out value="${producto.getTimepoDeProducto()}"></c:out> hs.
					</p>
				</div>
				<div class="col-3 border-end border-5 border-success">
					<p class="card-text text-decoration-underline fw-bold">Costo: </p>
					<p class="card-text">
						<c:out value="${producto.costoTotal}"></c:out> monedas.
					</p>
				</div>
				<div class="col-3 border-end border-5 border-success">
					<p class="card-text text-decoration-underline fw-bold">Tipo: </p>
					<p class="card-text">
						 <c:out value="${producto.tipoDeProducto}"></c:out>.
					</p>
				</div>
				<c:choose>
				<c:when test="${!producto.esPromo()}">
				<div class="col-3">
					<p class="card-text text-decoration-underline fw-bold">cupo: </p>
					<p class="card-text">
					<c:out value="${producto.cupo}"></c:out>.
					</p>
				</div>
			</c:when>
			<c:otherwise>
			<div class="col-3">
					<p class="card-text text-decoration-underline fw-bold">Incluye:</p>
					<p class="card-text">
						<c:forEach items="${producto.getAtracciones()}" var="atraccion">
						  <c:out value="${atraccion.getNombreDeProducto()}"></c:out> <br>
						</c:forEach>
					</p>
				</div>
			</c:otherwise>
			</c:choose>	
			</div>

			<p class="card-text">
				<small class="text-muted"><c:out
						value="${producto.descripcion}"></c:out></small>
			</p>
		</div>
		<c:choose>
			<c:when test="${user.loPuedoComprar(producto)}">
				<div class="d-grid gap-2">
					<a href="comprar.do?nombre=${producto.nombreDeProducto}&esPromo=${producto.esPromo()}" class="btn btn-success rounded" role="button">Comprar</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="d-grid gap-2">
					<a href="#" class="btn btn-success rounded disabled" role="button"> Comprar</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</c:forEach>