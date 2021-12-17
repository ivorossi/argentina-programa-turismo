   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
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
                  <img src="assets/img/c1.jpg" class="card-img"  style="max-height: 440px;">
                  <div class="card-img-overlay">
                    <h1 class="card-title ">Aventuras</h1>
                    <h3 class="card-text">
						Increibles aventuras en el agua y en el aire no te lo podes perder.
                    </h3>
                  </div>
                </div>
              </div>
              <div class="carousel-item ">
                 <div class="card bg-dark text-white">
                  <img src="assets/img/c2.jpg" class="card-img"  style="max-height: 440px;">
                  <div class="card-img-overlay">
                    <h1 class="card-title ">Degustaciones</h1>
                    <h3 class="card-text">
						Increibles bodegas y restarurantes no te lo podes perder.
                    </h3>
                  </div>
                </div>
              </div>
              <div class="carousel-item ">
                 <div class="card bg-dark text-white">
                  <img src="assets/img/c3.jpg" class="card-img"  style="max-height: 440px;">
                  <div class="card-img-overlay">
                    <h1 class="card-title ">Paisajes</h1>
                    <h3 class="card-text">
						Increibles lugares con mucho para ver y descubir.
                    </h3>
                  </div>
                </div>
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