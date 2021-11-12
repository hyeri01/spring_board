<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<form action="/update" method="post">
	
		<input type="text" name="bod_no" value="${dto.bod_no}" readonly="readonly"><br>
		<input type="text" name="bod_title" value="${dto.bod_title}">
		<input type="text" name="bod_writer" value="${dto.bod_writer}" readonly="readonly">
		<input type="text" name="bod_password" value="${dto.bod_password}">
		<input type="text" name="bod_content" value="${dto.bod_content}">
		
		<input type="submit" value="submit">
	</form>

</body>
</html>