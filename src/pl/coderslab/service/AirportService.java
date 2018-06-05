package pl.coderslab.service;

import java.util.List;

import pl.coderslab.DAO.AirportDao;
import pl.coderslab.entities.Airport;

public class AirportService {
	AirportDao airportDao;

	public AirportService() {
		airportDao = new AirportDao();
	}

	public List<Airport> getAirportList() {
		return airportDao.getList();
	}
}
