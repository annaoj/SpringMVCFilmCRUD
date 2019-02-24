<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Film</title>
</head>
<body>
	<form action="saveFilm.do" method="POST" name="filmId">
		<input type="text" name="filmId" value="${film.id}" />
		Title
		 <input
			type="text" name="title" value="${film.title}"/> 
			<br> 
			Description
			<br> 
			<input
			type="text" name="description" value="${film.description}"/> 
			<br> Release Year<br> 
			<input type="text" name="releaseYear" value="${film.release_year}"/> 
			<br> 
			<select name="language_id" value="${film.language_id}">
			
			<!-- <option selected>Language Id</option> -->
			<option value="1">English</option>
			<option value="2">Italian</option>
			<option value="3">Japanese</option>
			<option value="4">Mandarin</option>
			<option value="5">French</option>
			<option value="6">German</option>
		</select> <br> <input type="submit" name="filmId" value="UPDATE" />
	</form>
</body>
</html>