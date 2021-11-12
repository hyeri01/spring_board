<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Board List</title>
</head>
<body>

<table border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>등록일</td>
		<td>delete</td>
	</tr>
	
	<c:forEach var="bod" items="${boardList}">
	<tr>
		<td>${bod.bod_no}</td>
		<td><a href="/boardContent?bod_no=${bod.bod_no}">${bod.bod_title}</a></td>
		<td>${bod.bod_writer}</td>
		<td>${fn:substring(bod.bod_reg_date, 0, 11)}</td>
		<td><a href="/delete?bod_no=${bod.bod_no}">삭제하기</a></td>
	</tr>
	</c:forEach>

</table>



<div class="pageInfo">
	
	<!-- 이전 페이지 -->
	<c:if test="${viewPage.prev}">
		<li><a href="${viewPage.startPage - 1}">이전</a></li>
	</c:if>

	<c:forEach var="num" begin="${viewPage.startPage}" end="${viewPage.endPage }">
		<li><a href="${num}">${num}</a></li>
	</c:forEach>
	
	<!-- 다음 페이지 -->
	<c:if test="${viewPage.next}">
		<li><a href="${viewPage.endPage + 1}">다음</a></li>
	</c:if>

</div>



<form method="get" class="moveForm">
	<input type="hidden" name="pageNum" value="${viewPage.cri.pageNum}">
	<input type="hidden" name="amount" value="${viewPage.cri.amount}">
</form>


<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<script>

	$(function() {
		
		var moveForm = $(".moveForm");
		
		
		$(".pageInfo a").on("click", function(e) {
			
			e.preventDefault();
			moveForm.find("input[name='pageNum']").val($(this).attr("href"));
			moveForm.attr("action", "/boardList");
			moveForm.submit();
			
		});
	});

</script>

</body>
</html>
