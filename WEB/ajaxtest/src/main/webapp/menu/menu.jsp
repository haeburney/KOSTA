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
<h3>메뉴</h3>
	<c:if test= "${not empty sessionScope.loginId }">
		<ul>
		<li><a href="${pageContext.request.contextPath }/member/myinfo?id=${sessionScope.loginId}" >내 정보 확인</a></li>
		<li><a href="${pageContext.request.contextPath }/member/logout" >로그아웃</a></li>
		<li><a href="${pageContext.request.contextPath }/member/out?id=${sessionScope.loginId}" >탈퇴</a></li>
		<li><a href="${pageContext.request.contextPath }/diary/add" >일기쓰기</a></li>
		
		<li><a href="${pageContext.request.contextPath }" >게시판</a></li>
		<li><a href="${pageContext.request.contextPath }" >이미지 게시판</a></li>
		
		</ul>
	</c:if>

</body>
</html>