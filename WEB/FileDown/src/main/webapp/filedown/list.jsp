<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><th>번호</th><th>작성자</th><th>제목</th><th>다운수</th></tr>

<c:forEach var="list" items="${list }">
	<tr>
		<td>${list.num }</td>
		<td>${list.writer }</td>
		<td><a href="${pageContext.request.contextPath }/filedown/detail.do?num=${list.num}">${list.title }</a></td>
		<td>${list.cnt }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>