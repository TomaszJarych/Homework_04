package pl.coderslab;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.entities.Airport;
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
		list  = airportService.getAirportList();
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("airports", list);
		getServletContext().getRequestDispatcher("/WEB-INF/views/airportForm.jsp").forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
