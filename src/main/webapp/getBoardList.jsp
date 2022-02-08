<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page import="com.springbook.biz.board.BoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	/* 	List<BoardVO> boardList = (List<BoardVO>)session.getAttribute("boardList"); */
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1><spring:message code="message.board.list.mainTitle"/></h1>
		<a href="getBoardList.do?lang=en"><spring:message code="message.user.login.language.en"></spring:message></a>
		&nbsp;&nbsp;
		<a href="getBoardList.do?lang=ko"><spring:message code="message.user.lo	gin.language.ko"></spring:message></a>
		<h3>
			${userName}<spring:message code="message.board.list.welcomeMsg"/><a href="logout.do"></a>
		</h3>
		<a href="logout.do">Log-out</a>
		<!-- 검색 시작 -->


		<!-- 검색 ㄱ -->
		<form action="getBoardList.do" method="post">
			<table border="1" width="700">
				<tr>
					<td align="right"><select name="searchCondition">
							<c:forEach items="${conditionMap}" var="option">
								<option value=${option.value}>${option.key}
							</c:forEach>
					</select> <input type="text" name="searchKeyword"> <input
						type="submit" value='<spring:message code="message.board.list.search.condition.btn"/>'></td>
			</table>
		</form>





		<!-- 게시판 목록 출력 -->
		<table border="1" cellpading="0" cellspacing="0" width="700">
			<tr>
				<th><spring:message code="message.board.list.table.head.seq"/></th>
				<th><spring:message code="message.board.list.table.head.title"/></th>
				<th><spring:message code="message.board.list.table.head.writer"/></th>
				<th><spring:message code="message.board.list.search.condition.content"/></th>
				<th><spring:message code="message.board.list.table.head.regDate"/></th>
				<th><spring:message code="message.board.list.table.head.cnt"/></th>
			</tr>
			<c:forEach items="${boardList}" var="list">
				<tr>
					<td>${list.seq}</td>
					<td><a href="getBoard.do?seq=${list.seq}">${list.title}</a></td>
					<td>${list.writer}</td>
					<td>${list.content}</td>
					<td>${list.regdate}</td>
					<td>${list.cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>
	</center>

	<%-- <center>
		<h1>글 목록</h1>
		<h3>
			${userName}님 환영합니다.... <a href="logout.do"></a>
		</h3>
		<a href="logout.do">Log-out</a>
		<!-- 검색 시작 -->
		
		
		<!-- 검색 ㄱ -->
		<form action="getBoardList.do" method="post">
			<table border="1" width="700">
				<tr>
					<td align="right">
						<select name="searchCondition">
							<c:forEach items="${conditionMap}" var="option">
								<option value=${option.value}>${option.key}
							</c:forEach>
						</select>
						<input type="text" name="searchKeyword">
						<input type="submit" value="검색">
					</td>
			</table>
		</form>
		
		
		
		
		
		<!-- 게시판 목록 출력 -->
		<table border="1" cellpading="0" cellspacing="0" width="700">
			<tr><th>번호</th><th>제목</th><th>글쓴이</th><th>내용</th><th>등록일</th><th>조회수</th></tr>
			<c:forEach items="${boardList}" var="list">
			<tr>
				<td>${list.seq}</td>
				<td><a href="getBoard.do?seq=${list.seq}">${list.title}</a> </td>
				<td>${list.writer}</td>
				<td>${list.content}</td>
				<td>${list.regdate}</td>
				<td>${list.cnt}</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<a href="insertBoard.jsp">새 글 등록</a>
	</center> --%>

</body>
</html>