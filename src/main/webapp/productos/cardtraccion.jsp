<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:forEach items="${productos}" var="producto">
	<div class="card mx-5 my-3 col-md-5 shadow-lg bg-success bg-opacity-50 p-0 ">
		<c:choose>
			<c:when test="${producto.esPromo()}">
				  <div class="container-fluid">
     				 <div class="row justify-content-center">
      					  <div class="col-12" >
      					    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" >
        					    <div class="carousel-indicators">
          					    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        				        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
          					    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
          					    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3" aria-label="Slide 4"></button>
          					    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="4" aria-label="Slide 5"></button>
          					 </div>
           					 <div class="carousel-inner">
           						 <div class="carousel-item active">
      								<img src="${producto.refImg}" class=" d-block w-100" >
    							</div>
        						<c:forEach items="${producto.getAtracciones()}" var="atraccion">
									<div class="carousel-item">
      									<img src="${atraccion.refImg}" class=" d-block w-100" >
    								</div>
								</c:forEach>
							</div>
          					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
           						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
           						<span class="visually-hidden">Previous</span>
         					</button>
           					 <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
             					 <span class="carousel-control-next-icon" aria-hidden="true"></span>
             					 <span class="visually-hidden">Next</span>
         					</button>
      					</div>
     				</div>
    			</div>
  			</div> 
			</c:when>
			<c:otherwise>
				<img src="${producto.refImg}" class="card-img-top">
			</c:otherwise>
		</c:choose>
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
				<small class="text-dark"><c:out
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