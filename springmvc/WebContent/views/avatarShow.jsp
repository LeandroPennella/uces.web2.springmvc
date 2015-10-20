<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My form</title>
</head>
<body>
	<h1>Avatar creado</h1>
	<h2>Se ha creado el avatar con el id ${idAvatar}</h2>
	Imagen:
	<br />
	<c:url value="/showAvatar.htm" var="url">
		<c:param name="id" value="${idAvatar}" />
	</c:url>
	<br />
	<img alt="Imagen del avatar" src="${url}">
</body>
</html>