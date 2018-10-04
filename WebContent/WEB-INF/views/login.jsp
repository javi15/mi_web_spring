<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mi login desde login.jsp</title>
</head>
<body>
<h1>Mi login desde login.jsp</h1>
<c:if test="${param.error != null}">
<samp style="color:red">Error de autenticacion</samp>
</c:if>
	<form name='f' action="/27-springWebSecurity-5/j_spring_security_check" method='POST'>
<%-- <form action="<c:url value="/j_spring_security_check"></c:url>" method="post"> --%>
		<table>
			<tr>
				<td>Usuario:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Contraseña:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td>Recordarme:</td>
				<td><input type='checkbox' name='_spring_security_remember_me' checked="checked" /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="Accesar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>