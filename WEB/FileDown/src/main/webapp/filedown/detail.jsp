<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>자료내용</h3>
<a href="${pageContext.request.contextPath }/filedown/list.do">자료목록으로</a>

<table border="1">
	<tr><th>글번호</th><td>${vo.num }</td></tr>
	<tr><th>제목</th><td>${vo.title }</td></tr>
	<tr><th>작성자</th><td>${vo.writer }</td></tr>
	<tr><th>작성일</th><td>${vo.w_date }</td></tr>
	<tr><th>제목</th><td>${vo.title }</td></tr>
	<tr><th>내용</th><td>${vo.content }</td></tr>
	<tr><th>파일네임</th><td>${vo.fname }
			<form action="${pageContext.request.contextPath }/filedown/detail.do" method="post">
				<input type="hidden" name="num" value="${vo.num }">
				<input type="submit" value="다운로드">
			</form>	
	</td></tr>
	<tr><th>다운수</th><td id="cnt">${vo.cnt }</td></tr>
</table>
</body>
</html>