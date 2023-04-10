<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
window.onload = () => {
	let arr = ['aaa', 'bbb', 'ccc'];
	let obj = {"name" : "aaa",  "num" : 1}; // 객체

	let txt = '{"name" : "aaa", "num" : 1}'; // 문자열
	let obj2 = JSON.parse(txt);
	
	for(let val of arr){
		document.write(val + "<br/>");
	}
	document.write("<br/>");
	
	for(let key in obj){
		document.write(key +"  : " +obj[key]+"<br/>");
	}
	document.write("<br/>");
	
	for(let key in obj2){
		document.write(key + " :"+obj2[key]+"<br/>");
	}
	document.write("<br/>");
	
	for(let key in txt){
		document.write(key + " :"+txt[key]+"<br/>");
	}
}
</script>
</head>
<body>

</body>
</html>