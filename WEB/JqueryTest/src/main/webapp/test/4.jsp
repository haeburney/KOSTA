<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		$('#b1').click(function(){
			$('h3').show();
		});
		$('#b2').click(function(){
			$('h3').hide();
		});
		$('#b3').click(function(){
			$('h3').toggle();
		});
	});
</script>
</head>
<body>
<input type="button" value="show" id="b1"><input type="button" value="hide" id="b2">
<input type="button" value="toggle" id="b3">
<h3>why you calling</h3>
<h3>at 11:30</h3>
<h3>when you only</h3>
<h3>wanna do me dirty</h3>
</body>
</html>