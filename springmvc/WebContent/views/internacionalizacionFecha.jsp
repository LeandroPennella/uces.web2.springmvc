<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<fmt:setLocale value="en_US" scope="session"/>
<fmt:formatDate value="${fecha}" />
<br/>

<fmt:setLocale value="es_AR" scope="session"/>
<fmt:formatDate value="${fecha}" />
<br/>

<fmt:setLocale value="es_AR_WIN" scope="session"/>
<fmt:setBundle basename="resources.mensajes" var="z"/>
<fmt:message bundle="${z}" key="bienvenida.inicial"/><br/>
<fmt:message bundle="${z}" key="bienvenida.completa">
<fmt:param value="leandro"/>
<fmt:param><fmt:formatDate value="${fecha}" pattern="yyyyMMdd" /></fmt:param> 
</fmt:message>

</body>
</html>