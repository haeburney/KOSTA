<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
function idcheck(){
	// 팝업창 띄우는 버튼
	// open(param1, param2, para3) 새 윈도우를 생성
	// param1 : 이 창을 띄울 페이지
	// param2 : 새 윈도우 이름
	// param3 : 새 창에 대한 세부 설정 (윈도우 설정)
	// 리턴값 : 생성된 윈도우 객체. 
	let win = open('idcheck.jsp', 'win', 'width=500, height=200, top=300, left=300');
	// 첫번째 파라미터 : 새창의 url/ 두번째 파라미터 : 세번째 파라미터 : 새 창에 대한 세부 설정 
	// top=300, left=300은 위로부터 300떨어진, 왼쪽으로부터 300떨어진 곳에 팝업창 띄우는 것
	win.document.ff.id.value = f.id.value;
	
	// win.close(); // 팝업창 닫음
}
</script>
</head>
<body>
join.jsp룰루랄라
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