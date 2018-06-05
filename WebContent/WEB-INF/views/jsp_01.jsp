<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zadanie1</title>
</head>
<body>
	<h1>${language }</h1>
	<form action="./Servlet_01_2" method="post">
		<label> Jezyk/language: <select name="language">
				<option value="Hello">en</option>
				<option value="Czesc">pl</option>
				<option value="Ehre">de</option>
				<option value="Hola">es</option>
				<option value="Bienvenue">fr</option>
		</select></label> <input type="submit" value="Wybierz">

	</form>

</body>
</html>