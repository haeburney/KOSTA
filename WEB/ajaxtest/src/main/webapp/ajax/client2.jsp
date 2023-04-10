<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
function a(){
	const xhttp = new XMLHttpRequest();
	
	xhttp.open("GET", "${pageContext.request.contextPath}/ajax/server2.jsp");
	xhttp.send();
	let html='';

	xhttp.onload = function() {
		let obj = JSON.parse(xhttp.responseText);
		for(let v in obj){
			html += v + ": " + obj[v] + "<br/>";
		}
		document.getElementById("res").innerHTML = html;
	}
}

function b(){
	const xhttp = new XMLHttpRequest();
	let html = '';
	xhttp.open("GET", "${pageContext.request.contextPath}/ajax/server3.jsp");
	xhttp.send();

	xhttp.onload = function() {
		let val = xhttp.responseText;
		let arr = JSON.parse(val);
		
		for(let obj of arr){
			html += "name : "+ obj.name + "<br/>";
			html += "num : "+ obj.num + "<br/><br/>";
		}
		
		document.getElementById("res").innerHTML = html;
	}
}
</script>
</head>
<body>
<input type="button" value="ajax요청" onclick="a()" > 
<input type="button" value="ajax요청" onclick="b()" > 
<div id="res"></div>
</body>
</html>