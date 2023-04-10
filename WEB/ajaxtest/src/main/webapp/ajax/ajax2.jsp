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
		// responseText : ���䰪 
		alert(txt);
		let html = '';
		let arr = JSON.parse(txt);
		// JSON.parse�� []�� ������ �迭�� ���ְ�, {}�� ���� ��ü���� �ϰ� �м��ؼ� ��ȯ���ִ� �۾��̴�. 
		// ���⼭ ������ ���ٸ� json ǥ�⸦ �߸� ���� ���̴�. �׷��� console�̳� alert�� Ȯ���غ��� 
		
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