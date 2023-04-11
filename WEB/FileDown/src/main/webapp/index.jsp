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
<h2>로그인을 해주세요</h2>
<a href="${pageContext.request.contextPath }/member/join.do">회원가입</a><br/>
<a href="${pageContext.request.contextPath }/member/login.do">로그인</a><br/>
</c:if>

<c:if test="${not empty sessionScope.loginId}">
<h2>${sessionScope.loginId }님 로그인중</h2>
<a href="${pageContext.request.contextPath }/member/edit.do?id=${sessionScope.loginId }">내정보확인</a><br/>
<a href="${pageContext.request.contextPath }/member/logout.do?id=${sessionScope.loginId }">로그아웃</a><br/>
<a href="${pageContext.request.contextPath }/member/out.do?id=${sessionScope.loginId }">탈퇴</a><br/>
</c:if>

</body>
</html>