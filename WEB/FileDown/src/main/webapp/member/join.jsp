<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function idcheck(){
	let win = open('idcheck.jsp', 'win', 'width=500, height=200, top=300, left=300');
	win.document.ff.id.value = f.id.value;
	// win.close(); // 팝업창 닫음
}
</script>
</head>
<body>
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/member/join.do" method="post" name="f">	
	<table border="1">
		<tr><th>ID</th>
		<td>
			<input type="text" name="id">
			<input type="button" value="id중복체크" onclick="idcheck()">
		</td></tr>
		<tr><th>PWD</th><td><input type="text" name="pwd"></td></tr>
		<tr><th>NAME</th><td><input type="text" name="name"></td></tr>
		<tr><th>EMAIL</th><td><input type="text" name="email"></td></tr>
		<tr><th>가입</th><td><input type="submit" name="가입" value="가입하기"></td></tr>
	</table>
</form>

</body>
</html>