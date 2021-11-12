<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Account</title>
</head>
<body>

	<p> no : ${dto.mem_no } </p>
	<p> name : ${dto.mem_name} </p>
	<p> phone : ${dto.mem_tel} </p>
	<p> addr : ${dto.mem_addr } </p>
	<p> age : ${dto.mem_age } </p>
	<p> gender : ${dto.mem_gender } </p>
	<p> date : ${dto.mem_reg_date } </p>
	
	
	<a href="/memDelete?mem_no=${dto.mem_no}">delete</a>
	<a href="/editAccount?mem_no=${dto.mem_no}">update</a>
	

</body>
</html>