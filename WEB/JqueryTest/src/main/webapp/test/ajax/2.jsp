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
			$.ajax({
				url : 'server1.jsp',
				type : 'post',
				dataType : 'text',
				success : function(result){
					$('#d1').text(result);
					console.log(result);
				},
				error : function(req, status, error){
					console.log(status);
				}
			});
		});
		
		$('#b2').click(function(){
			$.ajax({
				url : 'server2.jsp',
				type : 'post',
				dataType : 'json',
				success : function(result){
					console.log("<result>");
					console.log(result);
					let txt='';
					for(let obj of result){
						for(let key in obj){
							txt += key + ": "+ obj[key] + "<br/>";
							console.log(key + " / "+obj[key]);
						}
					}
					
					for(let apple of result){
						for(let banana in apple){
							console.log(banana+ " "+apple[banana]);
						}
					}
					
					$('#d2').html(txt);
				},
				error : function(req, status, error){
					console.log(status);
				}
			});
		});
		
		$('#b3').click(function(){
			$.ajax({
				url : 'server3.jsp',
				type : 'post',
				data : {'name' : $('#name').val(), 'tel':$('#tel').val()},
				dataType : 'text',
				success:function(result){
					console.log(name)
					console.log(result);
					$('#d3').text(result);
				},
				error : function(req, status){
					console.log(status);
				}
					
			});
		});
		
		$('#b4').click(function(){
			// 폼데이터 : 폼 안의 입력 양식 값을 "키:값"으로 자동으로 변환
			let formData = $('#f1').serialize();
			console.log(formData);
			
			$.ajax({
				url:'server3.jsp',
				type : 'post',
				// processData:false,
				// true : 데이터를 url 뒤에 붙여서 전송, false : 데이터를 패킷 헤더에 담아서 전송
				// contentType:true,
				// true : application 전송, false:multipart 전송
				data:formData,
				dataType:'text',
				success:function(result){
					console.log(result);
					$('#d3').text(result);
				},
				error:function(req, status){
					console.log(status);
				}
			});
		});
	});
</script>
</head>
<body>
	<div id="d1"></div>
	<div id="d2"></div>
	<div id="d3"></div>
	<input type="button" id="b1" value="데이터로드1">
	<input type="button" id="b2" value="데이터로드2"><br/><br/>
	<form id="f1">
		name:<input type="text" id="name" name="name"><br/>
		tel:<input type="text" id="tel" name="tel"><br/>
		<input type="button" id="b4" value="파람테스트">
	</form>
	<input type="button" id="b3" value="데이터로드3">
</body>
</html>