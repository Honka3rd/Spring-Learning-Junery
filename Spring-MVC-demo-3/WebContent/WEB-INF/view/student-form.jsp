<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>student survey</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName"/>
		<br/>
		<br/>
		Last name: <form:input path="lastName"/>
		<br/>
		<br/>
		<form:select path="country">
			<form:options items="${countries}"></form:options>
		</form:select>
		<br/>
		<br/>
		Favorite programming language
		<br/>
			<form:radiobuttons path="lang" items="${student.langs }"/>
		<br/>
		<br/>
			<form:checkboxes path="favos" items="${student.os }" />
		<br/>
		<input type="submit" value="submit"/>
	</form:form>
</body>
</html>