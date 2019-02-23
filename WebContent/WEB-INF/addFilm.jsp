<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- TODO: Add the @taglib for form -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Film</title>
</head>
<body>
	<!-- TODO: Add registration form -->
	<form:form action="addFilm.do" method="POST" modelAttribute="film">
		<form:label path="title">Title:</form:label>
		<form:input path="title" />
		<form:errors path="title" />
		<br />
		<form:label path="language_id">Language ID:</form:label>
		<form:input path="language_id" />
		<form:errors path="language_id" />
		<br />
		<%-- <form:label path="lastName">Last Name:</form:label>
		<form:input path="lastName" />
		<form:errors path="lastName" />
		<br />
		<form:label path="password">Password:</form:label>
		<form:password path="password" />
		<form:errors path="password" />
		<br />
		<form:label path="age">Age:</form:label>
		<form:input path="age" />
		<form:errors path="age" />
		<input type="submit" value="Register" /> --%>
	</form:form>
</body>
</html>