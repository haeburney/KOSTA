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

	xhttp.onload = function() {
		let msg = document.getElementById("res");
		msg.innerHTML = xhttp.responseText;
	}

	xhttp.open("GET", "${pageContext.request.contextPath}/ajax/server1.jsp?name=" + f.name.value);
	xhttp.send();
	// send를 해야 요청이 간다
}
</script>
</head>
<body>
<form action="" name="f" >
	<input type="text" name="name">
	<input type="button" value="ajax 요청" onclick="a()" >
</form>
<div id="res"></div>
</body>
</html>