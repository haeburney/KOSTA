<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		let arr=[
			{"name" : "daum", "addr" : "http://www.daum.net"},
			{"name" : "naver", "addr" : "http://www.naver.com"},
			{"name" : "google", "addr" : "http://www.google.com"},
		];
		
		let txt='';
		$.each(arr, function(idx, item){
			txt += '<a href="' + item.addr + '">' + item.name + '</a><br/>' ;
		});
		$("#d1").html(txt);
	});
	
	$(document).ready(function(){
		let txt='';
		$('td').each(function(idx, item){
			var text = $(item).text();
			console.log("idx : "+idx+" / text: "+text);
			txt+=text+"<br/>";
		});
		console.log(txt);
		$("#d2").html(txt);
		
	
	});
</script>
</head>
<body>
	<div id="d1"></div><br/>
	<div id="d2"></div><br/>
	<table border="1" id="table">
		<tr><td>aaa</td><td>bbb</td><td>ccc</td></tr>
		<tr><td>ddd</td><td>eee</td><td>fff</td></tr>
	</table>
</body>
</html>