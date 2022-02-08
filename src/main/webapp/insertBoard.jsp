<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>글 등록</h1>
		<hr>
		<br>
		<form action="insertBoard.do" method="post" enctype="multipart/form-data">
			<table border="1" cellpading="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">작성자</td>
					<td align="left"><input type="text" name="writer"></td>
				</tr>
				<tr>

					<td bgcolor="orange" width="70">내용</td>
					<td align="left"><textarea name="content" cols="50" rows="20"></textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">업로드</td>
					<td align="left"><input type="file" name="uplodaFile"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 등록"></td>
			</table>
		</form>
		<hr />
		<a href="getBoardList.do">글 목록</a>
	</center>
</body>
</html>