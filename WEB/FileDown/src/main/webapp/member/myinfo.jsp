<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/main.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input{
	border : none;
	border-bottom : 1px solid grey;
}
</style>
</head>
<body>
<h3>${m.id}님의 정보</h3>

<form action="${pageContext.request.contextPath }/member/edit.do?id=${m.id}" method="post">
	id : <input type="text" value="${m.id}" name="id" readonly> <br/>
	pwd : <input type="text" value="${m.pwd}" name="pwd" > <br/>
	name : <input type="text" value="${m.name}" name="name"> <br/>
	email : <input type="text" value="${m.email}" name="email" readonly> <br/>
	<input type="submit" value="수정하기">
	<input type="button" value="취소하기"> 
</form>

<br/>
<a href="${pageContext.request.contextPath }/index.jsp">이전으로 돌아가기</a>

</body>
</html>