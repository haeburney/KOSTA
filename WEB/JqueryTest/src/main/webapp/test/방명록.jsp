<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div{
	border: 1px solid black;
	margin : 10px 10px;
	pading : 5px 5px;
}
</style>
<script>
	$(document).ready(function(){
		let cnt = 1;
		$("#editForm").hide();
		$("#btn1").click(function(){
			let pwd = $('#pwd').val();
			let txt = '<div id=div_' + cnt + ' pwd=' + $('#pwd').val() + '>';
			txt += '<h4 id=writer_' + cnt + '>writer : '+$('#writer').val() + '</h4>';
			txt += '<h4 id=content_' + cnt + '>content : '+$('#content').val() + '</h4>';
			txt += '<input type="button" value="수정하기" onclick="editForm('+cnt+')" >';
		//	txt += '<input type="button" value="삭제하기" onclick="del('+pwd+','+cnt+')" >';
			txt += '<input type="button" value="삭제하기" onclick="del('+cnt+')" >';
			txt += '</div>';
			console.log(txt);
			$("#list").append(txt);
			$("#writer").val("");
			$("#pwd").val("");
			$("#content").val("");
			cnt++;
		});
		
		$("#cancelbtn").click(function(){
			$('#editcont').val('');
			$('body').append($('#editForm'));
			$('#editForm').hide();
		});
		
		$("#editbtn").click(function(){
			let num = $(this).attr("num");
			console.log("num : "+num);
			
			$('#content_'+num).text('content : '+$('#editcont').val());
			
			//$('#editcont').val();
			console.log($('#editcont').val());
			$('#editcont').val('');
			$('body').append($('#editForm'));
			$('#editForm').hide();
		})
	});
	
	function editForm(num){
		let pwd = prompt("비밀번호 입력", "");
		let pwd2 = $('#div_' + num).attr('pwd');
		console.log(pwd);
		console.log(pwd2);
		if(pwd == pwd2){
			$('#div_'+num).append($('#editForm'));
			let c = $('#content_'+num).text().split(":")[1];
			$('#editcont').val(c);
			$('#editbtn').attr("num", num + "");
			$("#editForm").show();
		} else {
			alert("비밀번호 오류. 삭제 취소");
		}
	}

	
	// 쌤 코드
	function del(num){
		let pwd = prompt("비밀번호 입력", "");
		let pwd2 = $('#div_' + num).attr('pwd');
		if(pwd == pwd2){
			$('#div_'+num).remove();
		} else {
			alert("비밀번호 오류. 삭제 취소");
		}
	}
	
	
	
	// 내가 한거
	function del2(num,cnt){
		let div = 'div_'+cnt;
		console.log(num +"번글 삭제");
		var pwd = prompt("비밀번호 입력","");
		if(pwd==num){
			console.log("비밀번호 일치");
			document.getElementById(div).remove();
		} else {
			console.log("비밀번호 불일치");
		}
	}

</script>
</head>
<body>

	<h3>방명록</h3>
	<table border="1">
		<tr><th>작성자</th><td><input type="text" id="writer"></td></tr>
		<tr><th>글비밀번호</th><td><input type="password" id="pwd"></td></tr>
		<tr><th>내용</th><td><input type="text" id="content"></td></tr>
		<tr><th>작성</th><td><input type="button" value="제출하기" id="btn1"></td></tr>
	</table>
	
	<table border="1" id="editForm">
		<tr><th>내용</th><td><input type="text" id="editcont"></td></tr>
		<tr><th>수정</th>
			<td>
				<input type="button" value="수정하기" id="editbtn" num="">
				<input type="button" value="취소하기" id="cancelbtn">
			</td>
		</tr>
	</table>


	<div id="list"></div>
	
</body>
</html>