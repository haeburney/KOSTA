<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>${sessionScope.loginId }�� �α��� ��!</h3>
<a href="${pageContext.request.contextPath }/member/logout.do">�α׾ƿ�</a><br/>
<a href="${pageContext.request.contextPath }/member/myinfo.do?id=${sessionScope.loginId}">�� ���� Ȯ��</a><br/>
<a href="${pageContext.request.contextPath }/member/out.do?id=${sessionScope.loginId}">Ż��</a><br/>
</body>
</html>