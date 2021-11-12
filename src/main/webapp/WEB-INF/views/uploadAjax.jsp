<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Upload for Ajax</title>
</head>
<body>

	<div class="uploadDIV">
	
		<input type="file" name="uploadFile" multiple>
		<button id="uploadBtn" onclick="">Ajax upload</button>
	
	</div>


<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<script>

	$(function() {
		
	
		$("#uploadBtn").on("click", function(e) {
			
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files;
			
			console.log(files);
			
			
			for(var i = 0; i < files.length; i++){
				formData.append("uploadFile", files[i]);
			}
			
			
			/* Ajax 사용 */
			$.ajax({
				
				url:'/uploadAjaxAction',
				processData : false,
				contentType : false,
				data : formData,
				type : 'POST',
				success : function(res) {
					alert("File upload success!");
				}
				
				
				
				
			});
			
		});
	});
	
	


</script>

</body>
</html>
