<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
window.onload = function(){
	const xhttp = new XMLHttpRequest();
	
	xhttp.onload = function(){
	}
	
	xhttp.open("get", "${pageContext.request.contextPath}/diary/add" );
	xhttp.send();
}

</script>
</head>
<body>
<h3> ! �� �� �� �� ! </h3>
${sessionScope.loginId }
<form action="${pageContext.request.contextPath }/diary/add" method="post" enctype="multipart/form-data">
	<input type="hidden" name="writer" value="${sessionScope.loginId }">
	<!-- ���� ���̵�� hidden���� ������ �����ֱ�  -->
	<table border="1">
		<tr>
			<th>������ �ϱ�</th>
			<td><textarea rows="5" cols="30" name="content"></textarea></td>
		</tr>
		<tr>
			<th>���� ����</th>
			<td>
				<input type="file" name="pic1" >
				<input type="file" name="pic2" >
				<input type="file" name="pic3" >
			</td>
		</tr>
		<tr>
			<th>����</th>
			<td>
				<input type="submit" value="����">
			</td>
		</tr>
	</table>
</form>
</body>
</html>