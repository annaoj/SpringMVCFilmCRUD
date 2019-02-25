<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Film</title>
</head>
<body>
	<div class="mainsection justify-content-center">
		<div class="headerSection text-center">
			<h3 class="header">Edit Film</h3>
		</div>
		<div class="searchForm">
	
		<form action="saveFilm.do" method="POST" name="filmId">
	
			<label>Film ID:</label>
				<input type="text" name="filmId" value="${film.id}" />
				<br/>
			<label>Title:</label>
				 <input	type="text" name="title" value="${film.title}"/> 
				<br>  
			<label>Description:</label>
				<input class="textbox" type="text" name="description" value="${film.description}"/>
				 <br>
			<label>Release Year:</label>
				<input type="text" name="releaseYear" value="${film.release_year}"/> 
			<%-- 	<p>Formatted Date (2): <fmt:formatDate type = "date" 
         value = "${film.release_year}" /></p> --%>
				<br> 
					<label>Rental Rate:</label>
				<input type="text" name="rentalRate" value="${film.rental_rate}"/> 
				<br> 
			<label>Rental Duration:</label>
				<input type="text" name="rental_duration" value="${film.rental_duration}"/> 
				<br> 
			<label>Length:</label>
				<input type="text" name="length" value="${film.length}"/> 
				<br> 
			<label>Replacement Cost:</label>
				<input type="text" name="replacementCost" value="${film.replacement_cost}"/> 
				<br> 
			<label>Rating:</label>
				<input type="text" name="rating" value="${film.rating}"/> 
				<br> 
			<%-- <label>Actors:</label>
			<input type="text" name="laCast" value="${film.laCast}"/> 
			<br>  --%>
			 <%-- <label>Category:</label>
			<input type="text" name="category" value="${film.category}"/> 
			<br>  --%>
			<label>Language:</label>
				<input type="text" name="language" value="${film.language}"/>  
				<br/>  
			<label>Language ID:</label>
			<select name="language_id" value="${film.language_id}"> 
			<!-- <option selected>Language Id</option> -->
				<option value="1">English</option>
				<option value="2">Italian</option>
				<option value="3">Japanese</option>
				<option value="4">Mandarin</option>
				<option value="5">French</option>
				<option value="6">German</option> 
			</select> 
			
			
			<br> 
			<input type="submit" name="filmId" value="UPDATE" />
			</form>
			</div>


	</div>
	</body>
</html>