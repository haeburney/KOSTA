<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/main.css" />
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/main.css?after">
<style>
input{
	border : none;
	border-bottom : 1px solid grey;
}
</style>
</head>
<body>
<%-- ${} : el표현식  --%>
<!-- 이 el은 자바에서 쓰던 변수를 가져와서 뷰페이지에서 쓸 수 있다. -->
<!-- m.getId() 라고 하지 않고 m.id라고만 써도 get을 인식해서 getter을 호출해서 값을 가져온다. -->
<!-- 그래서 getter setter 작성을 잘해야한다. 안하면 저 값을 가져오지 못함 -->


<h3>${m.id}님의 정보</h3>
<form action="${pageContext.request.contextPath }/member/edit.do?id=${m.id}" method="post">
id : <input type="text" value="${m.id}" name="id" readonly> <br/>
pwd : <input type="text" value="${m.pwd}" name="pwd" > <br/>
name : <input type="text" value="${m.name}" name="name"> <br/>
email : <input type="text" value="${m.email}" name="email" readonly> <br/>
<input type="submit" value="수정하기">
</form>
<a href="${pageContext.request.contextPath }/index.jsp">이전으로 돌아가기</a>

</body>
</html>