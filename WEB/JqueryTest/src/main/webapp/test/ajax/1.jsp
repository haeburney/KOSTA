<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		$('#b1').click(function(){
			$('#d1').load('server1.jsp');
		});
		$('#b2').click(function(){
			// load('url', 핸들러 : 비동기 요청의 응답이오면 자동 호출될 함수)
			$('#d2').load('server2.jsp', function(res, stat, xhr){
				// res : 서버로부터 받은 값, stat : 상태, xhr : 비동기 객체
				if(stat=='success'){
					console.log("res :" + res);
					console.log("stat :" + stat);
					console.log("xhr :" + xhr);
					let arr = JSON.parse(res);
					console.log("arr :" + arr);
					
					let txt = '';
					for(let obj of arr){
						console.log("for1 :" + obj);
						for(let key in obj){
							txt += key + ": "+ obj[key] + "<br/>";
						}
					}
					$(this).html(txt);
					console.log("txt : "+txt);
				} else {
					console.log('error');
				}
			});
		});
		
		$('#b3').click(function(){
			// load('url', 서버로 전송할 데이터, 핸들러 : 비동기 요청의 응답이오면 자동 호출될 함수)
			let param = '';
			// let param = {'name':$('name').val(), 'tel':$('#tel').val()};
			param += 'name=' + $('#name').val();
			param += '&tel=' + $('#tel').val();
			console.log(param);
			$('#d3').load('server3.jsp',param);
		});
	});
</script>
</head>
<body>
	<div id="d1"></div>
	<div id="d2"></div>
	<div id="d3"></div>
	<input type="button" id="b1" value="데이터로드1">
	<input type="button" id="b2" value="데이터로드2"><br/>
	<input type="text" id="name">
	<input type="text" id="tel">
	<input type="button" id="b3" value="데이터로드3">
</body>
</html>