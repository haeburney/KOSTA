<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>

table{
	border-collapse : collapse;
	margin-left : auto;
	margin-right : auto;
	margin-bottom : 20px;
	background-color : #e6f3fe;
	border-radius : 10px;
	border-shadow: 0 0 0 1px #000;
}
td, th{
	border-bottom : 1px solid skyblue;
}

#image{
	padding : 10px 10px;
}

input {
	background-color : #e6f3fe;
	border-color: #85c3fa;
	border-radius :5px;
}
</style>
<script>
$(document).ready(function(){
	$('.editf').hide();
	
	$(".editbtn").click(function(){
		let num = $(this).attr("num");
		console.log(num);
		$('#editf_'+num).show();
	});
	
	$(".cancel").click(function(){
		let num = $(this).attr("num");
		$('#editf_'+num).hide();
	});
	
	$(".edit").click(function(){
		let num = $(this).attr("num");
		let param = {'num' :num, 'title':$('#eval1_'+num).val(), 'content':$('#eval2_'+num).val()};
		console.log("<param>");
		console.log(param);
		console.log(typeof param);
		
		$.ajax({
			url: '${pageContext.request.contextPath}/imgboard/edit.do',
			type : 'post',
			data : param,
			dataType : 'json',
			success : function(result){
				$('#title_'+num).text(result.title);
				$('#cont_'+num).text(result.content);
				$('#title_'+num).val(result.title);
				$('#cont_'+num).val(result.content);
				$('#editf_'+num).hide();
			},
			error : function(req, status, error){
				console.log(status);
			}
		});
	});
	
	$(".delbtn").click(function(){
		let num = $(this).attr("num");
		
		$.ajax({
			url : '${pageContext.request.contextPath}/imgboard/del.do',
			type : "post",
			data : {'num' :num},
			success : function(result){
				console.log("������");
				//$('#editf_'+num).hide();
				$('#tbl_'+num).remove();
			},
			error : function(req, status, error){
				console.log(status);
			}
		});
	});
	
	$(".cbtn").click(function(){
		let num = $(this).attr("num");
		console.log("Ŭ��");
		let writer = $('#rep_w'+num).val();
		let param = {'num':num, 'content': $('#rep_c'+num).val(), 'writer': writer};
		console.log(param);
		let txt="";
		
		$.ajax({
			url : '${pageContext.request.contextPath}/imgreps/add.do',
			type : 'post',
			data : param,
			dataType : 'json',
			success : function(result){
				let content = result.content;
				let writer = result.writer;
				console.log(result.content);
				
				for(let obj of result){
					console.log(obj);
					console.log(obj.writer);
					txt += "�ۼ��� : " + obj.writer + "  |  ���� : " + obj.content + "</br>";
				}
				//txt += "�ۼ��� : " + writer + "  |  ���� : " + content + "</br>";
				$('#r_'+num).html(txt);
			},
			error : function(req, status, error){
				console.log(status);
			}
		});
	});
});
</script>
</head>
<body>
<h2 style="text-align:center">�� ���</h2>
<div style="text-align:center">���� �α������� ID : 
<span style="text-align:center; font-size:25px; background-color: #ffffcc">${sessionScope.loginId }</span>
</div><br/>

<c:forEach var="f" items="${list }">
	<table id="tbl_${f.num }">
		<tr><th>����</th><td id="image"><img src="${f.path }" style="width:400px"></td></tr>
		<tr><th>��ȣ</th><td>${f.num } <br/> 
			<c:if test="${f.write eq sessionScope.loginId }" >
   				<input type = "button" value = "����" class="editbtn" num="${f.num }">
   				<input type = "button" value = "����" class="delbtn" num="${f.num }" >  <br/> 
   					<form id="editf_${f.num }" class="editf">
  		 				 new title : <input type="text" id="eval1_${f.num }" value="${f.title }" ><br/>
  						 new content : <input type="text" id="eval2_${f.num }" value="${f.content }" ><br/>
  						 <input type="button" value="�����Ϸ�" class="edit" num="${f.num }" >
  						 <input type="button" value="���" class="cancel" num="${f.num }" >
  					 </form>
  			 </c:if>
  		 </td></tr>
  		 <tr><th>�ۼ���</th><td>${f.write }</td></tr>
  		 <tr><th>��¥</th><td>${f.w_date }</td></tr>
		 <tr><th>����</th><td><span id = "title_${f.num}">${f.title }</span></td></tr>
		<tr><th>����</th><td><span id = "cont_${f.num}">${f.content }</span></td></tr> 		
		<tr><th>���</th>
		<td>
			<input type="hidden" id="rep_w${f.num }" num="${f.num }" value="${sessionScope.loginId }"> 
			<input type="text" id="rep_c${f.num }" num="${f.num }">
			<input type="button" value="�ۼ�" class="cbtn" num="${f.num }">
			<div id="r_${f.num }" > 
				<c:forEach var="rep" items="${f.reps }">
				�ۼ��� : ${rep.writer } | ���� : ${rep.content } <br/>
				</c:forEach>
			</div>
		</td>
		</tr>
	</table>
</c:forEach> <br/>

</body>
</html>