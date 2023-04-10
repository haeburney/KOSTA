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
<h3>우릴 위해 불렀던 지나간 노래들이 여전히 위로가 되는지~</h3>

	<c:if test = "${empty sessionScope.loginId }">
		<ul>
		<li><a href="${pageContext.request.contextPath }/member/login">로그인</a></li>
		<li><a href="${pageContext.request.contextPath }/member/join">회원가입</a></li>
		</ul>
	</c:if>
	<c:if test = "${not empty sessionScope.loginId }">
		<h4>${sessionScope.loginId }님 로그인중</h4>
	</c:if>

</body>
</html>