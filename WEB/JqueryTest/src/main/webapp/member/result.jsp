<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>${sessionScope.loginId }님 로그인 완!</h3>
<a href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a><br/>
<a href="${pageContext.request.contextPath }/member/myinfo.do?id=${sessionScope.loginId}">내 정보 확인</a><br/>
<a href="${pageContext.request.contextPath }/member/out.do?id=${sessionScope.loginId}">탈퇴</a><br/>
</body>
</html>