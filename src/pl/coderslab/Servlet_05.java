package pl.coderslab;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.service.Newsletterservice;
@WebServlet("/newsletter")
public class Servlet_05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Newsletterservice newsletterservice;
	
	public Servlet_05() {
		newsletterservice = new Newsletterservice();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/views/jsp_05.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("person");
		String email = request.getParameter("email");
		Cookie cookie = new Cookie("newsletter", "signed");
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		newsletterservice.savePerson(name, email);
		
		getServletContext().getRequestDispatcher("/WEB-INF/views/jsp_05.jsp").forward(request, response);

	}

}
