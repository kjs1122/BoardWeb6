<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page import="com.springbook.biz.board.BoardVO"%>
<%
/* 	BoardDAO boardDAO = new BoardDAO();
	BoardVO vo = new BoardVO();
	int seq = Integer.parseInt(request.getParameter("seq"));
	vo.setSeq(seq);

	BoardVO board = new BoardVO();
	board = boardDAO.getBoard(vo); */
	
	/* BoardVO board = (BoardVO)session.getAttribute("board"); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<center>
	<h1>상세 조회</h1>
	<a href="logout.do">Log-out</a>
	<hr>
	<br>
	<form action="updateBoard.do" method="post">
		<table border="1" cellpading="0" cellspacing="0">
			<input type="hidden" name="seq" value="${board.seq}">
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input type="text" name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">작성자</td>
				<td align="left"><input type="text" name="writer" value="${board.writer}"></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">내용</td>
				<td align="left"><input type="text" name="content" value="${board.content}"></td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">등록일</td>
				<td align="left">${board.regdate}</td>
			</tr>
			<tr>
				<td bgcolor="orange" width="70">조회수</td>
				<td align="left">${board.cnt}</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="글 수정"></td>
		</table>
	</form>
	<hr/>
	<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard.do?seq=${board.seq}">글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do">글 목록</a>
	
	</center>
</body>
</html>

