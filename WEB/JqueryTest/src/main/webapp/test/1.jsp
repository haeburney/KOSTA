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
		let txt = $('p').text();
		let txt2 = $('#test').text();
		$('#d1').text(txt+" <br/> "+txt2);
		$('#d2').html(txt+" <br/> "+txt2);
		// text와 html의 차이 : 태그 인식
		
		$('#btn1').click(function(){
			let txt = $("#text1").val();
			console.log("input text : "+txt+" / Button Clicked!!");
		});
		
		// idx : 인덱스, item : 요소
		txt = '';
		$("h3").each(function(idx, item){ 
			console.log("idx : "+idx+" / item : "+ item);
			txt += idx + "번째 요소 txt : "+$(item).text() + "</br>";
		});
		$("#d3").html(txt);
		
		txt='';
		$("h3.c1").each(function(idx, item){
			txt += idx + "번째 요소 txt : "+$(item).text() + "</br>";
		});
		$("#d4").html(txt);
	});

</script>
</head>
<body>
	<h2>JQuery</h2>
	<div id='d1' style="border:1px solid pink"></div><br/>
	<div id='d2' style="border:1px solid black"></div><br/>
	<div id='d3' style="border:1px solid skyblue"></div><br/>
	<div id='d4' style="border:1px solid orange"></div><br/>
		
	<br/><br/>	
	<h2>내용</h2>
	<p>~가나다라마바사~</p>
	<h3 class="c1">너무 완벽하지 않아도~</h3>
	<h3 id="test">걱정마</h3>
	<h4 class="c1">네맘을</h4>
	<h3>조금알것같애</h3>
	<h3 class="c1">네게 좀 더 다가서 볼까</h3>
	<h3>고민해 매일 밤</h3>
	
	<h2>INPUT</h2>
	<input type="text" id="text1">
	<input type="button" id="btn1" value="Click Here!">
</body>
</html>