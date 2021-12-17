<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-6">
	<label for="userName" class='col-form-label'>Nombre de la promocion:</label>
	<input class="form-control" type="text" id="nombre" name="nombre"
			required value="${promocion.nombreDeProducto}"></input>
</div>

<div class="col-md-6">
<label for="userName" class='col-form-label'>Atracciones que desea incluir:</label>
		<c:forEach items= "${atracciones}" var = "atraccion">
            <div class="form-check">
  				<input class="form-check-input" type="checkbox" value="${atraccion.nombreDeProducto}" id="idAtraccion" name="idAtraccion">
  				<label class="form-check-label" for="flexCheckDefault"><c:out value = "${atraccion.nombreDeProducto}"/></label>
			</div>
         </c:forEach>
</div>
<c:choose>
	<c:when test = '${tipoDePromo.equalsIgnoreCase("AxB")}'>
		<div class="col-md-6">
			<label for="userName" class='col-form-label'>Descuento:</label>
			<input class="form-control" type="text" id="descuento" name="descuento" required value="${promocion.descuento}"></input>
		</div>	
   	</c:when>
         
	<c:when test = '${tipoDePromo.equalsIgnoreCase("absoluta")}'>
		<div class="col-md-4">
			<label for="tiempoDisponible" class='col-form-label '>Descuento:</label>
			<input class="form-control" type="number" id="descuento" name="descuento" required value="${promocion.descuento}"></input>
			<div class="invalid-feedback">
			</div>
		</div>
	</c:when>
         
	<c:otherwise>
		<div class="col-md-4">
			<label for="tiempoDisponible" class='col-form-label '>Descuento:</label>
			<input class="form-control" type="number" id="descuento" name="descuento" required value="${promocion.descuento}"></input>
			<div class="invalid-feedback">
			</div>
		</div>
	</c:otherwise>
</c:choose>


<div class="col-md-8">
	<label for="userName"
		class='col-form-label'>Descripcion:</label>
	<input class="form-control" type="text" id="descripcion" name="descripcion"
			required value="${Promocion.descripcion}"></input>
</div>
<div class="col-md-6">
	<label for="userName"
		class='col-form-label'>imagen url:</label>
	<input class="form-control" type="text" id="url" name="url"
			required value="${Promocion.refImg}"></input>
</div>
<div class="d-grid gap-2 col-6 mx-auto">
	<button class="btn btn-primary " type="submit" >Enviar</button>
</div>