<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = function(){
	const xhttp = new XMLHttpRequest();
	
	xhttp.onload = function(){
		let txt = xhttp.responseText;
		// responseText : 응답값 
		alert(txt);
		let html = '';
		let arr = JSON.parse(txt);
		// JSON.parse는 []을 만나면 배열로 해주고, {}을 보면 객체구나 하고 분석해서 변환해주는 작업이다. 
		// 여기서 에러가 난다면 json 표기를 잘못 넣은 것이다. 그래서 console이나 alert로 확인해보기 
		
		for(let obj of arr){
			html += "num : " + obj.num + "<br/>";
			html += "name : " + obj.name + "<br/>";
			html += "tel : " + obj.tel + "<br/><br/>";
		}
		let res = document.getElementById("res");
		res.innerHTML = html;
	}
	console.log(`${pageContext.request.contextPath}`);
	xhttp.open("GET", "${pageContext.request.contextPath}/json/test1");
	xhttp.send();
}
</script>
</head>
<body>
<div id="res"></div>
</body>
</html>