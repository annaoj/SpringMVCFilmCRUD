<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- TODO: Add the @taglib for form -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/cards.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film</title>

</head>
<body>
	<!-- Need to make changes to this block -->

	<div class="container">
		<div class="row pt-5 m-auto">

			<c:choose>
				<c:when test="${! empty film}">

					<div class="col-10 mx-auto pb-3">
						<div class="card card-custom bg-white border-white border-0">
					<div class="card-custom-img"
									style="background-image: url(http://venturestrategic.com/wp-content/uploads/2017/02/oscars-1488147067.jpg);"></div>
								<div class="card-custom-avatar">
									<img class="img-fluid"
										src="https://pbs.twimg.com/profile_images/413132656776200192/pzh8kdnn.jpeg"
										alt="Avatar" />
								</div>
							<div class="card-body" style="overflow-y: auto">
								<h4 class="card-title"> <strong>Title:</strong> ${film.title}</h4>
									<p class="card-text">
										<strong>Description: </strong>${film.description}
									</p>
					<ul>
<%-- 						<li><strong>Film Id Selected:</strong> ${film.id}</li>
 --%>						<%-- <li><strong>Title:</strong> ${film.title}</li> --%>
						<li><strong>Language</strong> ${film.language}</li>
<%-- 						<li><strong>Description: </strong>${film.description}</li>
 --%>						<li><strong>Release Year: </strong>${film.release_year}</li>
						<li><strong>Rental Duration: </strong>${film.rental_rate}</li>
						<li><strong>Rental Rate: </strong>${film.rental_rate}</li>
						<li><strong>Length: </strong>${film.length}</li>
						<li><strong>Replacement Cost: </strong>${film.replacement_cost}</li>
						<li><strong>Rating: </strong>${film.rating}</li>
						<li><strong>Special Features: </strong>${film.special_features}</li>


						<c:catch var="exception">
							<c:if test="${(empty exception) and (not empty film.laCast )}">

								<li><strong>Actors </strong> <c:forEach var="actor"
										items="${film.laCast}">
										<span>${actor.first_name} ${actor.last_name}, </span>
									</c:forEach></li>
							</c:if>
						</c:catch>

						<c:catch var="exception">
							<c:if test="${(empty exception) and (not empty film.category )}">

								<li><strong>Category </strong> <c:forEach var="category"
										items="${film.category}">
										<span>${category.name} </span>
									</c:forEach></li>
							</c:if>
						</c:catch>



					</ul>
								</p>
							</div>
				<div class="card-footer"
									style="background: inherit; border-color: inherit;">
									<div class="row">
										<form action="editFilm.do" method="GET">
											<input type="hidden" name="filmId" value="${film.id}" /> <input
												class="btn btnResult btn-primary" type="submit" value="EDIT" />
										</form>
										<form action="deleteFilm.do" method="POST" name="filmId">
											<input type="hidden" name="filmId" value="${film.id}" /> <input
												type="submit" name="filmId" class=" btnResult btn btn-outline-primary"
												value="DELETE" />
										</form>
									</div>
								</div>
						</div>
					</div>
			
				</c:when>
				<c:when test="${! empty filmList}">
					<c:forEach var="film" items="${filmList }">
						<div class="col-md-6 col-lg-4 pb-3">
							<div class="card card-custom bg-white border-white border-0">
								<div class="card-custom-img"
									style="background-image: url(http://venturestrategic.com/wp-content/uploads/2017/02/oscars-1488147067.jpg);"></div>
								<div class="card-custom-avatar">
									<img class="img-fluid"
										src="https://pbs.twimg.com/profile_images/413132656776200192/pzh8kdnn.jpeg"
										alt="Avatar" />
								</div>
								<div class="card-body" style="overflow-y: auto">
									<h4 class="card-title">${film.title}</h4>
									<p class="card-text">
										<strong>Description: </strong>${film.description}
									</p>
									<ul>
<%-- 										<li><strong>Film Id Selected:</strong> ${film.id}</li>
 --%>										<!--  -->
<%-- 										<li><strong>Title:</strong> ${film.title}</li>
 --%>										<li><strong>Language:</strong> ${film.language}</li>
										<li><strong>Release Year: </strong>${film.release_year}</li>
										<li><strong>Rental Duration: </strong>${film.rental_rate}</li>
										<li><strong>Rental Rate: </strong>${film.rental_rate}</li>
										<li><strong>Length: </strong>${film.length}</li>
										<li><strong>Replacement Cost: </strong>${film.replacement_cost}</li>
										<li><strong>Rating: </strong>${film.rating}</li>
										<li><strong>Special Features: </strong>${film.special_features}</li>
										<li><strong>Actors </strong> <c:forEach var="actor"
												items="${film.laCast}">
												<span>${actor.first_name} ${actor.last_name}, </span>
											</c:forEach></li>
										<li><strong>Category </strong> <c:forEach var="category"
												items="${film.category}">
												<span>${category.name} </span>
											</c:forEach></li>
									</ul>
								</div>
								<div class="card-footer"
									style="background: inherit; border-color: inherit;">
									<div class="row">
										<form action="editFilm.do" method="GET">
											<input type="hidden" name="filmId" value="${film.id}" /> <input
												class="btn btnResult btn-primary" type="submit" value="EDIT" />
										</form>
										<form action="deleteFilm.do" method="POST" name="filmId">
											<input type="hidden" name="filmId" value="${film.id}" /> <input
												type="submit" name="filmId" class=" btnResult btn btn-outline-primary"
												value="DELETE" />
										</form>
									</div>
								</div>
							</div>
						</div>

					</c:forEach>
				</c:when>
				<c:when test="${removed}">
				 <div class="col-12">
					<h3><i class="fas fa-check" style="font-size:34px;color:green"></i> Movie is removed</h3><br>
					</div><div class="row">
					<a href="index.html">Return to Main Menu</a></div>
					
				</c:when>
				<c:otherwise>
				 <div class="col-12">

				
					<h3>				
					<i class="fa fa-exclamation-triangle" aria-hidden="true" style="font-size:34px;color:red"></i>
					No Film found</h3><br/></div>
					<div class="row">
					<a href="index.html">Return to Main Menu</a>
					</div>
					
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>