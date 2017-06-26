<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../resources/js/memo.js"></script>
<script type="text/javascript">
	$(function() {
		getList(1, "%", "%");
		
		$("#btn").click(function() {
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			memoWrite(writer, contents);
			
			
		});
		$("#btnView").click(function () {
			memoView(695);
		})
		
		
		
		
	});
	
</script>
</head>
<body>
	<div>
		<form action="">
			<h2>작성자 | <input type="text" id="writer"></h2>
			<h2>내용 | <textarea rows="" cols="" id="contents"></textarea> </h2>
			<input type="button" value="전송" id="btn">
		</form>
		
	</div>

	<div id="result">
		
		
	</div>
	<button id="btnView">View</button>
	
	
	
	
	


</body>
</html>