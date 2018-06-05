package pl.coderslab.DAO;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import pl.coderslab.entities.Airport;
import pl.coderslab.entities.Flight;

public class FlightDao {
	
	public Flight getflight(Airport home, Airport destination, LocalDateTime localDateTime, int duration, double price){
		ZoneId timeZoneHome = ZoneId.of(home.getTimezone());
		ZoneId timeZoneDestination = ZoneId.of(destination.getTimezone());
		ZonedDateTime arrivalTime = ZonedDateTime.of(localDateTime, timeZoneDestination).plusHours(duration);
		Flight flight = new Flight();
		flight.setArrival(home);
		flight.setDeparture(destination);
		flight.setArrivalTime(arrivalTime);
		flight.setPrice(price);
		flight.setDepartureTime(localDateTime);
		flight.setDuration(duration);
		return flight;
	}

}
