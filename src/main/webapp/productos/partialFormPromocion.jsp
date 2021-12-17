<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-md-8">
	<h5 Class=" text-center">Elija el tipo de Promocion</h5><br>
	<div class="form-check">
 	 	<input class="form-check-input" type="radio" name="tipoDePromo" Value= "absoluta">
 	 	<label class="form-check-label" for="flexRadioDefault1"> Absoluta </label>
	</div>
	<br>
	<div class="form-check">
  		<input class="form-check-input" type="radio" name="tipoDePromo" value="AxB" checked>
 		 <label class="form-check-label" for="flexRadioDefault2"> AxB </label>
	</div>
	<br>
	<div class="form-check">
  		<input class="form-check-input" type="radio" name="tipoDePromo" value="porcentual" checked>
 		 <label class="form-check-label" for="flexRadioDefault2"> Porcentual </label>
	</div>
</div>
<br>
<br>
<div class="col-md-8">
	<h5 Class=" text-center">Elija el tipo del producto</h5><br>
	<div class="form-check">
 	 	<input class="form-check-input" type="radio" name="tipoDeProducto" Value= "aventura">
 	 	<label class="form-check-label" for="flexRadioDefault1"> Aventura </label>
	</div>
	<br>
	<div class="form-check">
  		<input class="form-check-input" type="radio" name="tipoDeProducto" value="paisaje" checked>
 		 <label class="form-check-label" for="flexRadioDefault2"> Paisaje </label>
	</div>
	<br>
	<div class="form-check">
  		<input class="form-check-input" type="radio" name="tipoDeProducto" value="degustacion" checked>
 		 <label class="form-check-label" for="flexRadioDefault2"> Degustacion </label>
	</div>
</div>
<br>
<br>
<div class="d-grid gap-2 col-6 mx-auto">
	<button class="btn btn-primary " type="submit" >Siguiente</button>
</div>
