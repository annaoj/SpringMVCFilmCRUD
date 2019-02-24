<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${isFilmUpdated == true}">

        <p>Film successfully updated</p>
    </c:if>
    <c:if test="${isFilmUpdated != true}">
        <p>Failed to update film</p>
    </c:if>


	<a href="index.html">Return to Main Menu</a>

</body>
</html>