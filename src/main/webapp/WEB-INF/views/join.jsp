<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Join</title>
</head>
<body>
	
	<form action="/join" method="post">
		이름 <input type="text" name="mem_name"> <br>
		전화번호 <input type="text" name="mem_tel"> <br>
		주소 <input type="text" name="mem_addr"> <br>
		나이 <input type="text" name="mem_age"> <br>
		성별 <select name="mem_gender">
			<option>남</option>
			<option>여</option>
		</select>
		
		<input type="submit" value="submit">	
	</form>

</body>
</html>