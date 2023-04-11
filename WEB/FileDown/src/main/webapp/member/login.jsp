<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/main.css" />
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/main.css?after">
</head>
<body>
<h3>LOGIN</h3>
${msg }<br/>
<form action="${pageContext.request.contextPath }/member/login.do" method="post" name="f">
<table border="1">
<tr><th>ID</th><td><input type="text" name="id"></td></tr>
<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
<tr><th>LOGIN</th>
	<td><input type="submit" value="로그인">
	<a href="${pageContext.request.contextPath }/member/join">회원가입</a>	
</td></tr>
</table>
</form>
</body>
</html>