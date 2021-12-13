<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h4 class="text-center">Bienvenido registrate para disfrutar</h4>

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
	<label for="userName"
		class='col-form-label ${user.errors.get("userName") != null ? "is-invalid" : "" }'>Usuario:</label>
	<input class="form-control" type="text" id="userName" name="userName"
		required value="${user.getUsuario}"></input>

</div>
<div class="col-md-6">
	<label for="password"
		class='col-form-label ${user.errors.get("password") != null ? "is-invalid" : "" }'>Contraseña:</label>
	<input class="form-control" type="password" id="password"
		name="password" required value="${user.password}"></input>
	<div class="invalid-feedback">
		<c:out value='${user.errors.get("password")}'></c:out>
	</div>
</div>

<div class="col-md-4">
	<label for="monedas"
		class='col-form-label ${user.errors.get("monedas") != null ? "is-invalid" : "" }'>Monedas:</label>
	<input class="form-control" type="number" id="monedas" name="monedas"
		required value="${user.monedas}"></input>
	<div class="invalid-feedback">
		<c:out value='${user.errors.get("monedas")}'></c:out>
	</div>
</div>
<div class="col-md-4">
	<label for="tiempoDisponible"
		class='col-form-label ${user.errors.get("tiempoDisponible") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" id="tiempoDisponible"
		name="tiempoDisponible" required value="${user.tiempoDisponible}"></input>
	<div class="invalid-feedback">
		<c:out value='${user.errors.get("tiempoDisponible")}'></c:out>
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

<div class="col-md-6">
	<label for="code"
		class='col-form-label ${user.errors.get("code") != null ? "is-invalid" : "" }'>Capchat:</label>
	<input class="form-control" type="text" id="code" name="code" required
		value=""></input>
	<div class="invalid-feedback">
		<c:out value='${user.errors.get("code")}'></c:out>
	</div>
</div>
<div class="col-md-4 py-4">
	<img src="assets/img/capchat.png" >
</div>


<div class="d-grid gap-2 col-6 mx-auto">
	<button class="btn btn-primary " type="submit" >Enviar</button>
</div>