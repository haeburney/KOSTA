<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#mine{
	margin-top : 300px;
}
.table1{
	margin-bottom : 100px;
}
</style>
</head>
<body>
<c:if test="${not empty sessionScope.loginId }">
	<table border="1" class="table1">
		<tr><td colspan="3"><h3>자료실</h3></td></tr>
		<tr>
			<td><a href="${pageContext.request.contextPath }/member/edit.do?id=${sessionScope.loginId }">내정보확인</a></td>
			<td><a href="${pageContext.request.contextPath }/member/logout.do">로그아웃</a></td>
			<td><a href="${pageContext.request.contextPath }/member/out.do?id=${sessionScope.loginId }">탈퇴</a><br/>
		</tr>
		<tr>
			<td><a href="${pageContext.request.contextPath }/filedown/add.do?id=${sessionScope.loginId }">올리기</a><br/>
			<td><a href="${pageContext.request.contextPath }/filedown/list.do?id=${sessionScope.loginId }">리스트</a><br/>
			<td><a href="${pageContext.request.contextPath }/filedown/.do?id=${sessionScope.loginId }">올리기</a><br/>
		</tr>
	</table>	
</c:if>

<c:if test="${empty sessionScope.loginId }">
	<table border="1" class="table1">
		<tr><td colspan="2"><h3>자료실</h3></td></tr>
		<tr>
			<td><a href="${pageContext.request.contextPath }/member/join.do">회원가입</a><br/>
			<td><a href="${pageContext.request.contextPath }/member/login.do">로그인</a><br/></td>
		</tr>
	</table>
</c:if>


<div id="body">
	<c:if test = "${not empty view }">
		<jsp:include page="${view }"/>
	</c:if>
</div>

</body>
</html>