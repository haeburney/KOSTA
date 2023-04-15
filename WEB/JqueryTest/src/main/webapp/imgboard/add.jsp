<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>${sessionScope.loginId } 님의 글 작성 </h2>

<form action="${pageContext.request.contextPath }/imgboard/add.do" method="post" enctype="multipart/form-data">
<table border="1">
<tr><td>작성자</td><td><input type="text" name="writer" value="${sessionScope.loginId }"></td></tr>
<tr><td>제목</td><td><input type="text" name="title"></td></tr>
<tr><td>글내용</td><td><textarea rows="10" cols="30" name="content"></textarea></td></tr>
<tr><td>사진</td><td><input type="file" name="file"></td></tr>
<tr><td>작성</td><td><input type="submit" value="작성하기"></td></tr>
</table>
</form>
</body>
</html>