<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/main.css" />
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/main.css?after">
<style>
input{
	border : none;
	border-bottom : 1px solid grey;
}
</style>
</head>
<body>
<%-- ${} : elǥ����  --%>
<!-- �� el�� �ڹٿ��� ���� ������ �����ͼ� ������������ �� �� �ִ�. -->
<!-- m.getId() ��� ���� �ʰ� m.id��� �ᵵ get�� �ν��ؼ� getter�� ȣ���ؼ� ���� �����´�. -->
<!-- �׷��� getter setter �ۼ��� ���ؾ��Ѵ�. ���ϸ� �� ���� �������� ���� -->


<h3>${m.id}���� ����</h3>
<form action="${pageContext.request.contextPath }/member/edit.do?id=${m.id}" method="post">
id : <input type="text" value="${m.id}" name="id" readonly> <br/>
pwd : <input type="text" value="${m.pwd}" name="pwd" > <br/>
name : <input type="text" value="${m.name}" name="name"> <br/>
email : <input type="text" value="${m.email}" name="email" readonly> <br/>
<input type="submit" value="�����ϱ�">
</form>
<a href="${pageContext.request.contextPath }/index.jsp">�������� ���ư���</a>

</body>
</html>