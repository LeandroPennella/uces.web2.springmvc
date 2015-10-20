<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home de la aplicacion</title>
	</head>
	<body>
		<h1>Home</h1>
		<h2>Simple</h2>
		<a href="/test.htm">sarasa</a>
		<c:url value="/sarasa.ht" var="r"/>
		<a href="${r}">sarasa</a>
		<a href='<c:url value="/test.htm" />'>A test</a><br/>
		<a href='<c:url value="/form.htm" />'>Form example</a><br/>
		<h2>Persistence</h2>
		<a href='<c:url value="/createSomething.htm" />'>Create Something</a><br/>
		<a href='<c:url value="/services/find?id=7" />'>Find id 7</a><br/>
		<a href='<c:url value="/services/get/7" />'>Get id 7</a><br/>
		<a href='<c:url value="/views/jquery.jsp" />'>JQuery Test</a><br/>
		<a href='<c:url value="formAvatar.htm" />'>Crear Avatar</a><br/>
		<c:out value="<li>hola1</li>"></c:out>
		
		&lt;li&gt;hola2&lt;/li&gt;
		<%
		String y ="<li>hola3</li>";
		request.setAttribute("x",y);
		%>
		<c:out value="${x}"></c:out>
		<c:if test=""></c:if>
		
	</body>
</html>