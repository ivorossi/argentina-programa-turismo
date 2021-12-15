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
		class='col-form-label'>Usuario:</label>
	<input class="form-control" type="text" id="userName" name="userName"
		required value="${user2.usuario}"></input>

</div>
<div class="col-md-6">
	<label for="password"
		class='col-form-label'>Contraseña:</label>
	<input class="form-control" type="password" id="password"
		name="password" required value="${user.contrasenia}"></input>
	<div class="invalid-feedback">
		<c:out value='${user2.contrasenia}'></c:out>
	</div>
</div>

<div class="col-md-4">
	<label for="monedas"
		class='col-form-label ${user2.errors.get("presupuesto") != null ? "is-invalid" : "" }'>Monedas:</label>
	<input class="form-control" type="number" id="monedas" name="monedas"
		required value="${user2.presupuesto}"></input>
	<div class="invalid-feedback">
		<c:out value='${user2.errors.get("presupuesto")}'></c:out>
	</div>
</div>
<div class="col-md-4">
	<label for="tiempoDisponible"
		class='col-form-label ${user2.errors.get("tiempo") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" id="tiempoDisponible"
		name="tiempoDisponible" required value="${user2.tiempoDisponible}"></input>
	<div class="invalid-feedback">
		<c:out value='${user2.errors.get("tiempo")}'></c:out>
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
		class='col-form-label' >Capchat:</label>
	<input class="form-control" type="text" id="code" name="code" required
		value=""></input>
</div>
<div class="col-md-4 py-4">
	<img src="assets/img/capchat.png" >
</div>


<div class="d-grid gap-2 col-6 mx-auto">
	<button class="btn btn-primary " type="submit" >Enviar</button>
</div>