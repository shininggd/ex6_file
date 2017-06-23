<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var count = 0;

		$("#add").click(function() {
			if(count<5){
				count++;
				$("#file").append("<p><input type='file' name='f"+count+"' ><span class='del'>x</span> </p>");			
			}else {
				alert("5개까지만 가능합니다.");
			}
			
		});
		
		
		$("#file").on("click",".del", function() {
			$(this).parent().remove();
			count--;
			
		});
	
	
	});

</script>
</head>
<body>
	<form action="fileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<button>전송</button>
	</form>
	<hr>
	<form action="multiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f2">
		<button>전송</button>
	</form>
	<hr>
	<form action="sameMultiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f1">
		<button>전송</button>
	</form>
	<hr>
	<hr>
	<hr>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<div id="file">
			
		</div>
		<input type="button" id="add" value="파일추가">
		<button>전송</button>
	</form>
	
	
	
</body>
</html>