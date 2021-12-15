<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="partials/navbar.jsp"></jsp:include>
	
    <div class="container-fluid">
      <div class="row justify-content-center">
        <div class="col-12" >
          <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" >
            <div class="carousel-indicators">
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
              <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <div class="card bg-dark text-white">
                  <img src="assets/img/dos.jpg" class="card-img"  style="max-height: 440px;">
                  <div class="card-img-overlay">
                    <h3 class="card-title">Card title</h3>
                    <h5 class="card-text">
                      This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                    </h5>
                  </div>
                </div>
              </div>
              <div class="carousel-item">
                <img src="assets/img/dos.jpg" class= "img-fluid w-100"  style="max-height: 440px;">
              </div>
              <div class="carousel-item">
                <img src="assets/img/dos.jpg" class= "img-fluid w-100"  style="max-height: 440px;">
              </div>
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
   <div class="container">
    <p> ah re</p>
   </div>


  </body>
</html>