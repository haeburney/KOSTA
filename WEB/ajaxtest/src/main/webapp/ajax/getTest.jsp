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
		// post ��� enctype�� application���� ����
		xhttp.send(param);
	}
	// POST�� ������ �� ���� ���
	// �� application �Ϲ� ����� �� multi part ���� ���ε� ���
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/ajaxtest/gettest"
		name="f">
		<input type="text" name="name"><br /> <input type="button"
			value="ajax get ��û" onclick="a()"> <input type="button"
			value="ajax post ��û" onclick="b()"> <input type="submit"
			value="���� ��û">
	</form>
	<div id="res"></div>
</body>
</html>