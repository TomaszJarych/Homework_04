package pl.coderslab;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.entities.GuestBookEntry;
import pl.coderslab.service.GuestBookService;

@WebServlet(urlPatterns = { "/guest-book" }, initParams = { @WebInitParam(name = "connection", value = "jdbc:mysql://localhost:3306/?useSSL=false"),
		@WebInitParam(name = "user", value = "root"), @WebInitParam(name = "password", value = "coderslab") })
public class Servlet_06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String connection;
	private String user;
	private String password;
	private GuestBookService guestBookService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		connection = config.getInitParameter("connection");
		user = config.getInitParameter("user");
		password = config.getInitParameter("password");
		guestBookService = new GuestBookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<GuestBookEntry> allEntry = guestBookService.allEntry(connection, user, password);
		request.setAttribute("allEntry",allEntry);
		getServletContext().getRequestDispatcher("/WEB-INF/views/jsp_06.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("person");
		String description = request.getParameter("description");
		GuestBookEntry bookEntry = new GuestBookEntry();
		if (Objects.nonNull(name) && Objects.nonNull(description)) {
			bookEntry.setName(name);
			bookEntry.setDescription(description);
			guestBookService.insertIntoDB(bookEntry, connection, user, password);
		}
		doGet(request, response);

	}

}
//#### Zadanie 6 
//
//Celem zadania jest udostępnienie funkcjonalności księgi gości.
//
//1. Utwórz servlet wyświetlający listę wpisów z księgi gości. Ma być dostępny pod adresem **/guest-book**
//2. Wyświetlane mają być wpisy w kolejności od najnowszego do najstarszego.
//3. Informacje o wpisach mają być pobierane z bazy danych.
//4. Zapytania tworzące tabele w bazie danych umieść w pliku `query.sql`.
//5. Dane dostępowe do bazy danych umieść w parametrach inicjalizacji dla całej aplikacji.
//6. Na stronie nad wpisami umieść formularz umożliwiający dodawanie nowego wpisu (nazwa oraz opis). 