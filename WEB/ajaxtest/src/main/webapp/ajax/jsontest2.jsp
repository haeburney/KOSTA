<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
let txt = '[{"num":1, "name" : "aaa", "tel": "111"}, {"num":2, "name" : "bbb", "tel": "222"}, {"num":3, "name" : "bbb", "tel": "333"}]'

let arr = JSON.parse(txt);
console.log(arr);
for(let obj of arr){
	document.write("num : "+obj.num+"<br/>");
	document.write("name : "+obj.name+"<br/>");
	document.write("tel : "+obj.tel+"<br/><br/>");
}

</script>
</head>
<body>
<div id="res"></div>
</body>
</html>