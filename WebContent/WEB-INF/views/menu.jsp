<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Menu</h2>

<sec:authorize access="!isAuthenticated()">
iniciar seccion por favor
</sec:authorize>

<sec:authorize access="isFullyAuthenticated()">
Hola :
<sec:authentication property="principal" var="db"/>
<c:set var="e" value="${db}" />
<c:out value="${e}"></c:out>
<br>
<a href="<c:url  value='/logout'/>">Cerrar session</a>
</sec:authorize>
<sec:authorize access="isRememberMe()">
Hola :
<sec:authentication property="principal" var="db"/>
<c:set var="e" value="${db.username}" />
<c:out value="${e}"></c:out>
<br>
<a href="<c:url  value='/logout'/>">Cerrar session</a>
</sec:authorize>
<a href='<c:url value="/usuario" />'>Registrar Usuario</a>
