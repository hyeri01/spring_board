<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 테이블</title>
</head>
<body>

<table border="1">
	<tr>
		<td>회원 번호</td>
		<td>이름</td>
		<td>등록일</td>
	</tr>
	
	<c:forEach var="mem" items="${memberList}">
	<tr>
		<td>${mem.mem_no}</td>
		<td><a href="/memberAccount?mem_no=${mem.mem_no}">${mem.mem_name}</a></td>
		<td>${fn:substring(mem.mem_reg_date, 0, 11)}</td>
	</tr>
	</c:forEach>


</table>

</body>
</html>