<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- TODO: Add the @taglib for form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film</title>
</head>
<body>
	<!-- Need to make changes to this block -->
	<c:choose>
		<c:when test="${! empty film}">
			<ul>
				<li><strong>Film Id Selected:</strong> ${film.id}</li>
				<li><strong>Title:</strong> ${film.title}</li>
				<li><strong>Language Id:</strong> ${film.language_id}</li>
				<li><strong>Description: </strong>${film.description}</li>
				<li><strong>Release Year: </strong>${film.release_year}</li>
				<li><strong>Rental Duration: </strong>${film.rental_rate}</li>
				<li><strong>Rental Rate: </strong>${film.rental_rate}</li>
				<li><strong>Length: </strong>${film.length}</li>
				<li><strong>Replacement Cost: </strong>${film.replacement_cost}</li>
				<li><strong>Rating: </strong>${film.rating}</li>
				<li><strong>Special Features: </strong>${film.special_features}</li>
				<li><input>Edit</input></li>
				<li>
		<%-- 			<form action="delete" method="post">
						<input type="submit" name="delete_user" value="Delete" /> <input
							type="hidden" name="user" value="<%=rs.getString(1)%>" />
					</form> --%>
					 <!-- 				<input type="submit" value="delete"  >Delete</input>
 -->
 </li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>