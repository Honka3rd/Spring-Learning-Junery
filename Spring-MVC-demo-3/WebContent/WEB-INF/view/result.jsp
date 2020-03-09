<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Confirmation</title>
</head>
<body>
	${student.firstName}
	<br/>
	${student.lastName}
	<br/>
	${student.country}
	<br/>
	${student.lang}
	<br/>
	<ul>
		<c:forEach var="os" items="${student.favos}">
			<li>${os}</li>
		</c:forEach>
		
	</ul>
	<br/>
</body>
</html>