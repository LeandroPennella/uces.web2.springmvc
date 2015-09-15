<%@ page language="java" contentType="text/html; charset=ISO-8859-1"     pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Complete el formulario</h1>
	<form:form method="POST" commandName="persona" action="procesar.htm">
		<form:label path="nombre">
			<fmt:message key="label.nombre" />
		</form:label>
		<form:input path="nombre" />
		<form:errors path="nombre" cssStyle="color: red" />
		<br />
		
		<form:label path="edad">
			<fmt:message key="label.edad" />
		</form:label>
		<form:input path="edad"  />
		<form:errors path="edad" cssStyle="color: red" />
		
		<form:button>Submitear!</form:button>
	</form:form>
</body>
</html>