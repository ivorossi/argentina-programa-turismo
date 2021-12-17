
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<nav class="navbar navbar-expand-md navbar-light  border-dark shadow-lg bg-success bg-opacity-100 mb-4 fixed-top ">
		<div class="container-fluid ">
			<button class="navbar-toggler " type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse " id="navbarSupportedContent">
				<ul class="navbar-nav  mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link h4 text-dark" href="index.jsp"><i class="bi bi-house-fill"></i>  Inicio</a>
					</li>
					<li class="nav-item">
						<a class="nav-link h4 text-dark" href="lugar.jsp"> <i class="bi bi-geo-alt-fill"></i>  hacerca de </a>
						
					</li>
					<li class="nav-item">
						<a class="nav-link h3 text-dark" href="contacto.jsp"><i class="bi bi-chat-text-fill"></i>  contacto</a>
					</li>
					<c:if test="${!user.isNull() && user != null}">
						<li class="nav-item">
							
							<a class="nav-link h4 text-dark"  href="productolist.do"><i class="bi bi-cart-fill"></i>  Tienda</a>
						</li>
					</c:if>
					<c:if test="${user.isAdm()}">
						<li class="nav-item">
							<a class="nav-link h4 text-dark" href="admin.do"><i class="bi bi-briefcase"></i>  Administracion</a>
						</li>
					</c:if>
				</ul>
			</div>
			<ul class="navbar-nav ">
				<c:choose>
					<c:when test = "${!user.isNull() && user != null}">
						<li class="nav-item dropdown container-fluid ">
							<a class="nav-link dropdown-toggle justify-self-end h4 text-dark"
								id="navbarDropdown" role="button" data-bs-toggle="dropdown"
								aria-expanded="false"><i class="bi bi-person"></i>   <c:out value = "${user.getNombre()}"/> </a>
							<ul class="dropdown-menu dropdown-menu-end px-3 mx-2 my-2 bg-success bg-opacity-75"
								aria-labelledby="navbarDropdown">
								<div class="d-grid ">
									<a href="itinerario.do?username=${user.usuario}" class="btn btn-primary btn-lg h3 text-dark" role="button">Itinerario</a>
								</div>
								<li>
									<a class="dropdown-item disabled" style="color: black;"> Monedas: 
										<c:out value="${user.presupuesto}"></c:out>
										<i title="monedas" style="color: gold;" class="bi bi-coin"></i> 
									</a>
								</li>
								<li>
									<a class="dropdown-item disabled" style="color: black;">Tiempo: 
										 <c:out value="${user.tiempoDisponible}h"></c:out>
										 <i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i>
									</a>
								</li><div class="dropdown-divider"></div>
								<div class="d-grid gap-2">
									<a href="/argentina-programa-turismo/logOutServlet" class="btn btn-danger btn-lg h3 text-dark" 
										role="button">Salir</a>
								</div>
							</ul>
						</li>
					</c:when>
					<c:otherwise>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle justify-self-end h4 text-dark"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"><i class="bi bi-person"></i>  indentificarme </a>
							<ul class="dropdown-menu dropdown-menu-end px-3 mx-2 my-2 bg-success bg-opacity-75"
							aria-labelledby="navbarDropdown">
									<div class="container-fluid">
										<c:if test="${flash != null}">
											<div class="alert alert-danger">
												<h6>
													<c:out value="${flash}" />
												</h6>
											</div>
										</c:if>
									</div>
									<form class="px-4 py-3" action="loguinServlet" method="post">
										<div class="mb-3">
											<label for="username" class="form-label h3 text-dark ">Usuario: </label> 
											<input name="username" class="form-control" placeholder="juanperalta021">
										</div>
										<div class="mb-3">
											<label for="exampleDropdownFormPassword1" class="form-label h3 text-dark ">Contraseña: </label> 
											<input name="password" type="password" class="form-control"
												id="exampleDropdownFormPassword1" placeholder="Password">
										</div>
										<button type="submit" class="btn btn-primary h3 text-dark">Sign in</button>
									</form>
								<div class="dropdown-divider"></div>
								<div class="d-grid gap-2">
									<a href="/argentina-programa-turismo/registro.jsp" class="btn btn-danger btn-lg h3 text-dark " role="button">Registrarme</a>
								</div>
							</ul>
						</li>
         			</c:otherwise>
				</c:choose>
			</ul>

		</div>
	</nav>
	<div class="container my-4  py-3" ></div>
