<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
function idcheck(){
	// �˾�â ���� ��ư
	// open(param1, param2, para3) �� �����츦 ����
	// param1 : �� â�� ��� ������
	// param2 : �� ������ �̸�
	// param3 : �� â�� ���� ���� ���� (������ ����)
	// ���ϰ� : ������ ������ ��ü. 
	let win = open('idcheck.jsp', 'win', 'width=500, height=200, top=300, left=300');
	// ù��° �Ķ���� : ��â�� url/ �ι�° �Ķ���� : ����° �Ķ���� : �� â�� ���� ���� ���� 
	// top=300, left=300�� ���κ��� 300������, �������κ��� 300������ ���� �˾�â ���� ��
	win.document.ff.id.value = f.id.value;
	
	// win.close(); // �˾�â ����
}
</script>
</head>
<body>
join.jsp������
<h3>ȸ������</h3>
<form action="${pageContext.request.contextPath }/member/join.do" method="post" name="f">	
	<table border="1">
		<tr><th>ID</th>
		<td>
			<input type="text" name="id">
			<input type="button" value="id�ߺ�üũ" onclick="idcheck()">
		</td></tr>
		<tr><th>PWD</th><td><input type="text" name="pwd"></td></tr>
		<tr><th>NAME</th><td><input type="text" name="name"></td></tr>
		<tr><th>EMAIL</th><td><input type="text" name="email"></td></tr>
		<tr><th>����</th><td><input type="submit" name="����" value="�����ϱ�"></td></tr>
	</table>
</form>

</body>
</html>