<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/main.css?after">
</head>
<body>
<h3>�츱 ���� �ҷ��� ������ �뷡���� ������ ���ΰ� �Ǵ���~</h3>

	<c:if test = "${empty sessionScope.loginId }">
		<ul>
		<li><a href="${pageContext.request.contextPath }/member/login">�α���</a></li>
		<li><a href="${pageContext.request.contextPath }/member/join">ȸ������</a></li>
		</ul>
	</c:if>
	<c:if test = "${not empty sessionScope.loginId }">
		<h4>${sessionScope.loginId }�� �α�����</h4>
	</c:if>

</body>
</html>