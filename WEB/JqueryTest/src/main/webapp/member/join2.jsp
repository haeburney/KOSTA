<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	$('#idcheck').click(function(){
		// ajax 요청을 보내야 하겠죠?!
		$.ajax({
			url:'${pageContext.request.contextPath}/member/Idcheck.do',
			type : 'post',
			data : {'id':$('#id').val()},
			dataType: 'json',
			success:function(result){
				let html = '<h4 style="color:';
				
				if(result.flag){
					html += 'blue">사용 가능한 아이디 </h4>';
				} else {
					html += 'red">사용 불가능한 아이디 </h4>'
				}
				$('#res').html(html);
			},
			error:function(req, status){
				console.log("error :"+status+" / req :"+req);
			}
		});
		
	});
});

</script>
</head>
<body>
join2.jspㄹㄹㄹㄹ
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/member/join.do" method="post" name="f">	
	<table border="1">
		<tr><th>ID</th>
		<td>
			<input type="text" name="id" id="id">
			<input type="button" value="id중복체크" id="idcheck">
			<span id="res"></span>
		</td></tr>
		<tr><th>PWD</th><td><input type="text" name="pwd"></td></tr>
		<tr><th>NAME</th><td><input type="text" name="name"></td></tr>
		<tr><th>EMAIL</th><td><input type="text" name="email"></td></tr>
		<tr><th>가입</th><td><input type="submit" name="가입" value="가입하기"></td></tr>
	</table>
</form>
</body>
</html>