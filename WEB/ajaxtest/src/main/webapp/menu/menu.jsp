<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�޴�</h3>
	<c:if test= "${not empty sessionScope.loginId }">
		<ul>
		<li><a href="${pageContext.request.contextPath }/member/myinfo?id=${sessionScope.loginId}" >�� ���� Ȯ��</a></li>
		<li><a href="${pageContext.request.contextPath }/member/logout" >�α׾ƿ�</a></li>
		<li><a href="${pageContext.request.contextPath }/member/out?id=${sessionScope.loginId}" >Ż��</a></li>
		<li><a href="${pageContext.request.contextPath }/diary/add" >�ϱ⾲��</a></li>
		
		<li><a href="${pageContext.request.contextPath }" >�Խ���</a></li>
		<li><a href="${pageContext.request.contextPath }" >�̹��� �Խ���</a></li>
		
		</ul>
	</c:if>

</body>
</html>