<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Board List</title>
</head>
<body>

<p> 번호 : ${dto.bod_no } <p>
<p> 번호 : ${dto.bod_title} <p>
<p> 번호 : ${dto.bod_content } <p>
<p> 번호 : ${dto.bod_writer } <p>
<p> 번호 : ${dto.bod_reg_date } <p>

<a href="/delete?bod_no=${dto.bod_no}">삭제하기 </a>
<a href="/edit?bod_no=${dto.bod_no}">수정하기</a>

</body>
</html>
