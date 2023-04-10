<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" charset="euc-kr">
	function a() {
		const xhttp = new XMLHttpRequest();

		xhttp.onload = function() {
			let res = document.getElementById("res");
			res.innerHTML = decodeURI(xhttp.responseText);
		}

		let param = "?name=" + f.name.value;
		xhttp.open("GET", "${pageContext.request.contextPath}/ajaxtest/gettest"+ param);
		xhttp.send();
	}
	function b() {
		const xhttp = new XMLHttpRequest();

		xhttp.onload = function() {
			let res = document.getElementById("res");
			res.innerHTML = decodeURI(xhttp.responseText);
		}

		let param = "name=" + f.name.value;
		xhttp.open("POST", "${pageContext.request.contextPath}/ajaxtest/gettest");
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		// post 방식 enctype을 application으로 설정
		xhttp.send(param);
	}
	// POST를 보내는 두 가지 방법
	// ① application 일반 폼방식 ② multi part 파일 업로드 방식
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/ajaxtest/gettest"
		name="f">
		<input type="text" name="name"><br /> <input type="button"
			value="ajax get 요청" onclick="a()"> <input type="button"
			value="ajax post 요청" onclick="b()"> <input type="submit"
			value="동기 요청">
	</form>
	<div id="res"></div>
</body>
</html>