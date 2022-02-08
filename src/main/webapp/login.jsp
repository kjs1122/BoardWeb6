<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1><spring:message code="message.user.login.title"></spring:message></h1>
		<a href="login.do?lang=en"><spring:message code="message.user.login.language.en"></spring:message></a>
		&nbsp;&nbsp;
		<a href="login.do?lang=jp"><spring:message code="message.user.login.language.jp"></spring:message></a>
		&nbsp;&nbsp;
		<a href="login.do?lang=ko"><spring:message code="message.user.login.language.ko"></spring:message></a>
		<hr>
		<form action="login.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange"><spring:message code="message.user.login.id"></spring:message></td>
					<td><input type="text" name="id" value="${userVO.id }" /></td>
				</tr>
				<tr>
					<td bgcolor="orange"><spring:message code="message.user.login.password"></spring:message></td>
					<td><input type="password" name="password" value="${userVO.password }" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="<spring:message code="message.user.login.loginBtn"></spring:message>" /></td>
				</tr>
			</table>
		</form>
		<hr>
	
	   <!--  ============================================= -->
	
		<%-- <h1>로그인</h1>
		<hr>
		<form action="login.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange">아이디</td>
					<td><input type="text" name="id" value="${userVO.id }" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">비밀번호</td>
					<td><input type="password" name="password" value="${userVO.password }" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="로그인" /></td>
				</tr>
			</table>
		</form>
		<hr> --%>
	</center>
</body>
</html>