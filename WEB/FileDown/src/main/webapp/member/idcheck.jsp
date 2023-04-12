<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// 이 윈도우가 로드되자마자 실행되는 핸들러
window.onload=function(){
	// request.method : 전송방식 값을 갖는 속성 (GET, POST)
	if('${pageContext.request.method}' == 'GET'){
		ff.id.value = opener.document.f.id.value;
	} else { // POST 일 때
		// id 중복체크를 눌렀을 때
		
		let html = "";
		if('${flag}'=='true'){
			html = "사용가능한 아이디";
			let val = '${id}';
			ff.id.value = val;
			html += "<input type='button' value='아이디사용' onclick='a(\""+val+"\")'>";
		} else{
			html = "사용불가능한 아이디";
		}	
		let div = document.getElementById("res");
		div.innerHTML = html;
		
	}
}
function a(id){
	//opener.document.f.id.value = id;
	close();
}
</script>
</head>
<body>
<h3>ID중복체크</h3>

<form action="${pageContext.request.contextPath }/member/idcheck.do" method="post" name="ff">
id: <input type="text" name="id">
<input type="submit" value="id 중복체크">
</form>
<div id="res">
</div>
</body>
</html>