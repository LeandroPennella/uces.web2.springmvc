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
<title>Upload avatar form</title>
</head>
<body>
	<h1>Upload de avatar</h1>
	<form:form method="POST" commandName="avatar" action="createAvatar.htm" enctype="multipart/form-data">
		<fmt:message key="label.file" /><br/>
		<form:input type="file" path="source" /><form:errors path="source" cssStyle="color: red" /> <br/>
		<form:button>Submit!</form:button>
	</form:form>
</body>
</html>