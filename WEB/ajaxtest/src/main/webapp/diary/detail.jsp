<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
img{
	width:200px;
}
</style>
</head>
<body>
<h3>오늘의 일기 내용</h3>
<table border="1">
	<tr>
		<th colspan="3">${vo.date }</th>
	</tr>
	<tr>
		<td><img src="/diary/${vo.pic1 }"></td>
		<td><img src="/diary/${vo.pic2 }"></td>
		<td><img src="/diary/${vo.pic3 }"></td>
	</tr>
	<tr>
		<td colspan="3">
			<textarea cols="60" rows="5" readonly>${vo.content }</textarea>
		</td>
	</tr>
</table>
</body>
</html>