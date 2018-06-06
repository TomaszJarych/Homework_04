<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!String msg = "<form action=\"./newsletter\" method=\"post\"><label>Name<input type=\"text\" name=\"person\"/></label><label>E-mail<input type=\"email\" name=\"email\"/></label><input type=\"submit\" value=\"Wyslij\"></form>";%>
	<h1>Lorem ipsum</h1>
	<h4>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
		ac tellus mauris. Aliquam a fringilla elit. Aenean facilisis diam
		felis, in porta felis posuere vitae. Vivamus accumsan ipsum dictum,
		imperdiet leo ac, luctus lorem. Maecenas posuere id dolor eget
		eleifend. In tristique, nunc in facilisis vehicula, felis nisi
		imperdiet quam, nec dictum urna augue at nisi. Nulla fermentum
		ultricies ipsum. Curabitur eu velit sapien. Ut quis mi lacus. Morbi
		volutpat orci a rhoncus pulvinar.</h4>
	<% Cookie[] cookies = request.getCookies();
	if(cookies == null){
		out.print(msg);
	}%>
	
</body>
</html>