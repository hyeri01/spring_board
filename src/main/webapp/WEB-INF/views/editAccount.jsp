<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Account</title>
</head>
<body>
	
		<form action="/memUpdate" method="post">
	
		no : <input type="text" name="mem_no" value="${dto.mem_no}" readonly="readonly"><br>
		name : <input type="text" name="mem_name" value="${dto.mem_name}"><br>
		phone : <input type="text" name="mem_tel" value="${dto.mem_tel}"><br>
		addr : <input type="text" name="mem_addr" value="${dto.mem_addr}"><br>
		age : <input type="text" name="mem_age" value="${dto.mem_age}"><br>
		gender : <select name="mem_gender">
			<option>남</option>
			<option>여</option>
		</select><br>
		date : <input type="text" name="mem_reg_date" value="${dto.mem_reg_date}">
		
		<input type="submit" value="submit">
	</form>
	
	
	
</body>
</html>