<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Insert 예제</title>
</head>
<body>


	<form action="/register" method="post">
	
		<input type="text" name="bod_title">
		<input type="text" name="bod_writer">
		<input type="text" name="bod_password">
		<input type="text" name="bod_content">
		
		<input type="submit" value="submit">
	</form>
	

</body>
</html>
