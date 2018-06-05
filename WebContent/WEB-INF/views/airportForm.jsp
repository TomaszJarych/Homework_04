<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Airport</title>
</head>
<body>
<form action="" method="post">
<div>
		<label> Home airport: <select name="home">
		 <c:forEach items="${airports }" var="airport">
				<option value="${airport.getName()};${airport.getCode()};${airport.getTimezone()}">${airport.getName()}</option>		 
		 </c:forEach></select></label> 
</div>
<div>
		 <label> Destination airport: <select name="destination">
		 <c:forEach items="${airports }" var="airport">
				<option value="${airport.getName()};${airport.getCode()};${airport.getTimezone()}">${airport.getName()}</option>		 
		 </c:forEach></select></label> 
</div>
<div><label>Godzina wylotu: <input type="datetime-local" name="departure" /></label></div>
<div><label>Czas lotu <input name="duration" type="number" min="0" step="1"></label></div>
<div><label>Cena biletu <input name="price" type="number" min="0.0" step="0.01"></label></div>
		<input type="submit" value="Wybierz">
	

	</form>

</body>
</html>