package pl.coderslab;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.entities.Airport;
import pl.coderslab.entities.Flight;
import pl.coderslab.service.AirportService;

@WebServlet("/Servlet_02")
public class Servlet_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AirportService airportService;
	List<Airport> list;

	public Servlet_02() {
		airportService = new AirportService();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		list = airportService.getAirportList();
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("airports", list);
		getServletContext().getRequestDispatcher("/WEB-INF/views/airportForm.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg = "";
		Airport home = airportService.getAirport(request.getParameter("home"));
		Airport destination = airportService.getAirport(request.getParameter("destination"));
		LocalDateTime localDateTime = LocalDateTime.parse(request.getParameter("departure"));
		int duration = Integer.parseInt(request.getParameter("duration"));
		double price = Double.parseDouble(request.getParameter("price"));
		if (!home.equals(destination) && Objects.nonNull(localDateTime) && Objects.nonNull(duration) && price > 0 ) {
			Flight flight = airportService.getFlight(home, destination, localDateTime, duration, price);
			request.setAttribute("flight", flight);
			getServletContext().getRequestDispatcher("/WEB-INF/views/flightView.jsp").forward(request, response);
		} else {
			msg = "<h1> Bledne dane</h1>";
			response.getWriter().append(msg);
		}
		
	}

}
