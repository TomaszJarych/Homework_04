package pl.coderslab.service;

import java.time.LocalDateTime;
import java.util.List;

import pl.coderslab.DAO.AirportDao;
import pl.coderslab.DAO.FlightDao;
import pl.coderslab.entities.Airport;
import pl.coderslab.entities.Flight;

public class AirportService {
	AirportDao airportDao;
	FlightDao flightDao;

	public AirportService() {
		airportDao = new AirportDao();
		flightDao = new FlightDao();
	}

	public List<Airport> getAirportList() {
		return airportDao.getList();
	}
	public Airport getAirport (String airportData){
		return airportDao.getAirport(airportData);
	}
	
	public Flight getFlight(Airport home, Airport destination, LocalDateTime localDateTime, int duration, double price){
		return flightDao.getflight(home, destination, localDateTime, duration, price);
	}
}
