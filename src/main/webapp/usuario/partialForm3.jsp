<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h4 class="text-center">Editar usuario</h4>

<div class="col-md-6">
	<label for="name" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="name" name="name" required
		value="pepe">
</div>
<div class="col-md-6">
	<label for="lastname" class="col-form-label">Apellido:</label> <input
		type="text" class="form-control" id="lastname" name="lastname" required
		value="Juanetes">
</div>
<div class="col-md-6">
	<label for="disabledTextInput" class="form-label">Usuario:</label>
	<input class="form-control" type="text" placeholder="${usuario.usuario}" aria-label="Disabled input example" disabled>

</div>
<div class="col-md-6">
	<label for="password"
		class='col-form-label'>Contraseña:</label>
	<input class="form-control" type="password" id="password"
		name="password" required value="${usuario.contrasenia}"></input>
	<div class="invalid-feedback">
		<c:out value='${usuario.contrasenia}'></c:out>
	</div>
</div>

<div class="col-md-4">
	<label for="monedas"
		class='col-form-label ${usuario.errors.get("presupuesto") != null ? "is-invalid" : "" }'>Monedas:</label>
	<input class="form-control" type="number" id="monedas" name="monedas"
		required value="${usuario.presupuesto}"></input>
	<div class="invalid-feedback">
		<c:out value='${usuario.errors.get("presupuesto")}'></c:out>
	</div>
</div>
<div class="col-md-4">
	<label for="tiempoDisponible"
		class='col-form-label ${usuario.errors.get("tiempo") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" id="tiempoDisponible"
		name="tiempoDisponible" required value="${usuario.tiempoDisponible}"></input>
	<div class="invalid-feedback">
		<c:out value='${usuario.errors.get("tiempo")}'></c:out>
	</div>
</div>
<div class="col-md-4">
	<label for="Gusto" class="col-form-label ">Gusto: *</label> <select
		class="form-select form-select-md " id="gusto" name="gusto">
		<option selected value="aventura">Aventura</option>
		<option value="paisaje">Paisajes</option>
		<option value="degustacion">Degustacion</option>
	</select>
</div>

<div class="col-md-7">
	<label for="Gusto" class="col-form-label ">Es Admin?: *</label> <select
		class="form-select form-select-md " id="adm" name="adm">
		<option selected value="true">SI</option>
		<option value="false">NO</option>
	</select>
</div>


<div class="d-grid gap-2 col-6 mx-auto">
	<button class="btn btn-success " type="submit" >Enviar</button>
</div>