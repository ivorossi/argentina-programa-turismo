
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<nav class="navbar navbar-expand-md navbar-dark bg-black mb-4">
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
						<a class="nav-link " href="#">home</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">hacerca de </a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="#">contacto</a>
					</li>
					<c:if test="${!user.isNull() && user != null}}">
						<li class="nav-item">
							<a class="nav-link" href="#">Productos</a>
						</li>
					</c:if>
					<c:if test="${user.isAdm()}">
						<li class="nav-item">
							<a class="nav-link" href="#">Administracion</a>
						</li>
					</c:if>
				</ul>
			</div>
			<ul class="navbar-nav ">
				<c:choose>
					<c:when test = "${!user.isNull() && user != null}">
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle justify-self-end "
								id="navbarDropdown" role="button" data-bs-toggle="dropdown"
								aria-expanded="false"> <c:out value = "${user.getNombre()}"/> </a>
							<ul class="dropdown-menu dropdown-menu-end"
								aria-labelledby="navbarDropdown">
								<div class="dropdown-divider"></div>
								<div class="d-grid gap-2">
									<a href="/argentina-programa-turismo/logOutServlet" class="btn btn-danger btn-lg" 
										role="button">Salir</a>
								</div>
							</ul>
						</li>
					</c:when>
					<c:otherwise>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle justify-self-end "
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> indentificarme </a>
							<ul class="dropdown-menu dropdown-menu-end"
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
											<label for="username" class="form-label">Usuario: </label> 
											<input name="username" class="form-control" placeholder="juanperalta021">
										</div>
										<div class="mb-3">
											<label for="exampleDropdownFormPassword1" class="form-label">Contraseña: </label> 
											<input name="password" type="password" class="form-control"
												id="exampleDropdownFormPassword1" placeholder="Password">
										</div>
										<div class="mb-3">
											<div class="form-check">
												<input type="checkbox" class="form-check-input" id="dropdownCheck">
												<label class="form-check-label" for="dropdownCheck">Recordarme: </label>
											</div>
										</div>
										<button type="submit" class="btn btn-primary">Sign in</button>
									</form>
								<div class="dropdown-divider"></div>
								<div class="d-grid gap-2">
									<a href="/argentina-programa-turismo/registro.jsp" class="btn btn-danger btn-lg" role="button">Registrarme</a>
								</div>
							</ul>
						</li>
         			</c:otherwise>
				</c:choose>
			</ul>

		</div>
	</nav>