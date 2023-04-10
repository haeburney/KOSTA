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
<h3>일기 목록</h3>
<table border="1">
<tr><th>날짜</th></tr>

<c:forEach var="vo" items="${list }">
	<tr><td><a href="${pageContext.request.contextPath }/diary/detail?num=${vo.num}" >${vo.date }</a>
</c:forEach>
</table>
</body>
</html>