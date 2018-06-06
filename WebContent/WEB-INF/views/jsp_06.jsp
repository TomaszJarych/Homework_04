<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guest book</title>
</head>
<body>
	<form action="./guest-book" method="post">
		<label> Name <input type="text" name="person" />
		</label> <label> Description <input type="text" name="description"
			size="50" />
		</label> <input type="submit" value="Wyslij">
	</form>

	<h1>Wpisy:</h1>
	<c:forEach items="${allEntry }" var="entry">
		<div>Imię i nazwisko: ${entry.getName() } Opis:
			${entry.getDescription() }</div>
	</c:forEach>


</body>
</html>