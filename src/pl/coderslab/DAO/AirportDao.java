package pl.coderslab.DAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entities.Airport;

public class AirportDao {

	public List<Airport> getList() {
		Path path = Paths.get("/home/tj/workspace/Homework_04/airports.txt");
		List<Airport> airportsList = new ArrayList<>();
		try {
			for (String line : Files.readAllLines(path)) {
				String[] airportsToStringArray = line.split(";");
				Airport airport = new Airport();
				airport.setName(airportsToStringArray[0]);
				airport.setCode(airportsToStringArray[1]);
				airport.setTimezone(airportsToStringArray[2]);
				airportsList.add(airport);
			}
			return airportsList;
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

	}
}
