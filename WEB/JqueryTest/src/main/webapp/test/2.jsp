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
		$('h2').click(function(){
			$(this).hide();
		});
		
		// mouseover, mouseout 합친 이벤트 : hover
		$('h3').hover(function(){ // 마우스가 올라가면
			$(this).css('background', 'pink');
		}, 
		function(){ // 마우스가 내려가면 
			$(this).css('background', 'skyblue');
		});
		
		$(':text').focus(function(){
			$(this).css('background-color', 'orange');
		});
		$(':text').blur(function(){
			$(this).css('background-color', 'white');
		});
		
		$(':button').focus(function(){
			console.log($(this).val() + "버튼이 클릭됨");
		});
		
		$('#h4').on('click', function(){
			console.log($(this).text());
		});
		$('h1').on({click:function(){ console.log($(this).text());},
			mouseenter:function(){ $(this).css('background-color', 'azure');},
			mouseleave:function(){ $(this).css('background-color', 'snow');}
		});
	});
</script>
</head>
<body>
	<h3>jquery 이벤트 처리</h3>
	<h1>You just want attention, you don't want my heart</h1>
	<h4 id='h4'>자유로운 우리를 봐 자유로워</h4>
	<input type="text" id="t1"><br/>
	<input type="text" id="t2"><br/>
	<input type="button" id="b1" value="Click Here1"><br/>
	<input type="button" id="b2" value="Click Here2"><br/>
	<h2>aaa</h2>
	<h2>bbb</h2>
	<h2>ccc</h2>
	<h2>ddd</h2>
	<h2>eee</h2>
</body>
</html>