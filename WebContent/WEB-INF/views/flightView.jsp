<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flight</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td>Wylot z</td>
				<td>Kod lotniska wylotu</td>
				<td>Lotnisko docelowe</td>
				<td>Kod lotniska docelowego</td>
				<td>Godzina wylotu</td>
				<td>Godzina przylotu</td>
				<td>Czas lotu</td>
				<td>Cena lotu</td>
			</tr>
		</thead>
		<tbody>
			<tr>
			<tr>
				<td>${flight.getDeparture().getName()}</td>
				<td>${flight.getDeparture().getCode()}</td>
				<td>${flight.getArrival().getName()}</td>
				<td>${flight.getArrival().getCode()}</td>
				<td>${flight.getDepartureTime()}</td>
				<td>${flight.getArrivalTime()}</td>
				<td>${flight.getDuration()}</td>
				<td>${flight.getPrice()}</td>
			</tr>


		</tbody>

	</table>

</body>
</html>