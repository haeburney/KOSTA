<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/main.css" />
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty sessionScope.loginId}">
<h2>�α����� ���ּ���</h2>
<a href="${pageContext.request.contextPath }/member/join.do">ȸ������</a><br/>
<a href="${pageContext.request.contextPath }/member/login.do">�α���</a><br/>
</c:if>

<c:if test="${not empty sessionScope.loginId}">
<h2>${sessionScope.loginId }�� �α�����</h2>
<a href="${pageContext.request.contextPath }/member/edit.do?id=${sessionScope.loginId }">������Ȯ��</a><br/>
<a href="${pageContext.request.contextPath }/member/logout.do?id=${sessionScope.loginId }">�α׾ƿ�</a><br/>
<a href="${pageContext.request.contextPath }/member/out.do?id=${sessionScope.loginId }">Ż��</a><br/>
</c:if>

</body>
</html>