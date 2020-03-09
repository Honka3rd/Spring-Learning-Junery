<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Survey form</title>
<style type="text/css">
.error {
	color: red
}
</style>
</head>
<body>
	<form:form action="processForm" modelAttribute="customer">
		First name: <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error"/>
		<br />
		<br />
		Last name: <form:input path="lastName" />
		<br />
		<br />
		Free passes <form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"/>
		<br />
		<br />
		postal code: <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		<br />
		<br />
		<input type="submit" value="submit" />
	</form:form>
</body>
</html>