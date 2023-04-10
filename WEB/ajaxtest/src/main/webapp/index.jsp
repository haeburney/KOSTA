<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css?after">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css?after">
</head>
<body>
<h3>복습 사이트</h3>
<table border="1">
<tr><td colspan="2" style="height:150px"><h3><%@ include file="/menu/header.jsp" %></h3></td></tr>
<tr style="height:400px" ><td style="width:150px"><%@ include file="/menu/menu.jsp" %></td>
<td style="width:400px">

	${msg }
	<c:if test="${not empty view }">
		<jsp:include page="${view }"/>
	</c:if>
	<c:if test="${not empty join }">
		<jsp:include page="${join }"/>
	</c:if>
<%-- 	<c:if test="${not empty myinfo }"> --%>
<%-- 		<jsp:include page=${myinfo }/> --%>
<%-- 	</c:if> --%>
	
</td></tr>
</table>

<%@ include file="/menu/tail.jsp" %>
</body>
</html>