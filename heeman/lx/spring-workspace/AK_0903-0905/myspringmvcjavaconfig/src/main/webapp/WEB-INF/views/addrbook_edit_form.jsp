<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="addrbook_error.jsp"
	import="lx.edu.springmvc.*"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addrbook.css" type="text/css" media="screen" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:수정화면</title>
</head>

<jsp:useBean id="ab" scope="request" class="lx.edu.springmvc.vo.AddrBookVO" />

<body>
	<div align="center">
		<H2>주소록:수정화면</H2>
		<HR>
		[<a href="/addrbook_list.do">주소록 목록으로</a>]
		<p>
			ab_id : ${ab.abId} <br>
		<form name=form1 method=post action=/addrbook_list.do>
			<input type=hidden name="ab_id" value="${ab.abId}"> 
			<table border="1">
				<tr>
					<th>이 름</th>
					<td><input type="text" name="abName" value="${ab.abName}">
					</td>
				</tr>

				<tr>
					<th>email</th>
					<td><input type="text" name="abEmail" value="${ab.abEmail}">
					</td>
				</tr>

				<tr>
					<th>전화번호</th>
					<td><input type="text" name="abTel" value="${ab.abTel}">
					</td>
				</tr>

				<tr>
					<th>생 일</th>
					<td><input type="date" name="abBirth" value="${ab.abBirth}">
					</td>
				</tr>

				<tr>
					<th>회 사</th>
					<td>
						<input type="text" name="abComdept"	value="${ab.abComdept}">
					</td>
				</tr>

				<tr>
					<th>메 모</th>
					<td>
						<input type="text" name="abMemo" value="${ab.abMemo}">
					</td>
				</tr>

				<tr>
					<td colspan=2 align=center>
						<input type=submit value="저장" onclick="updateCheck(${ab})">
						<input type=reset value="취소"> 
						<input type="button"value="삭제" onClick="deleleCheck()">
					</td>
				</tr>
			</table>
		</form>

	</div>
</body>
<script type="text/javascript">
	function updateCheck(ab) {
		document.location.href ="/update.do?ab="+ab;
	}
	
	function deleleCheck() {
		result = confirm("정말로 삭제하시겠습니까 ?");
	
		if (result == true) {
			document.location.href = "/delete.do/${ab.abId}";
			document.form1.submit();
		} else
			return;
	}
	
</script>
</html>