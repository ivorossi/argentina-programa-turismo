<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-6">
	<label for="userName"
		class='col-form-label'>Nombre:</label>
	<input class="form-control" type="text" id="nombre" name="nombre"
			required value="${atraccion.nombreDeProducto}"></input>
</div>

<div class="col-md-4">
	<label for="monedas"
		class='col-form-label ${atraccion.errors.get("costoTotal") != null ? "is-invalid" : "" }'>Costo:</label>
	<input class="form-control" type="number" id="costoTotal" name="costoTotal"
		required value="${atraccion.costoTotal}"></input>
	<div class="invalid-feedback">
		<c:out value='${user2.errors.get("costoTotal")}'></c:out>
	</div>
</div>
<div class="col-md-4">
	<label for="tiempoDisponible"
		class='col-form-label ${atraccio.errors.get("timepoDeProducto") != null ? "is-invalid" : "" }'>Duracion:</label>
	<input class="form-control" type="number" id="tiempoDeProducto"
		name="tiempoDeProducto" required value="${atraccion.timepoDeProducto}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.errors.get("timepoDeProducto")}'></c:out>
	</div>
</div>
<div class="col-md-4">
	<label for="tiempoDisponible"
		class='col-form-label ${atraccio.errors.get("cupo") != null ? "is-invalid" : "" }'>Cupo:</label>
	<input class="form-control" type="number" id="cupo"
		name="cupo" required value="${atraccion.cupo}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.errors.get("cupo")}'></c:out>
	</div>
</div>
<div class="col-md-4">
	<label for="Gusto" class="col-form-label ">tipo De Producto: *</label> <select
		class="form-select form-select-md " id="tipoDeProducto" name="tipoDeProducto">
		<option selected value="aventura">Aventura</option>
		<option value="paisaje">Paisajes</option>
		<option value="degustacion">Degustacion</option>
	</select>
</div>

<div class="col-md-8">
	<label for="userName"
		class='col-form-label'>Descripcion:</label>
	<input class="form-control" type="text" id="descripcion" name="descripcion"
			required value="${atraccion.descripcion}"></input>
</div>
<div class="col-md-6">
	<label for="userName"
		class='col-form-label'>imagen url:</label>
	<input class="form-control" type="text" id="url" name="url"
			required value="${atraccion.refImg}"></input>
</div>
<div class="d-grid gap-2 col-6 mx-auto">
	<button class="btn btn-primary " type="submit" >Enviar</button>
</div>