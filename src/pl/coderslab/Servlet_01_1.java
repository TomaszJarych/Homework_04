package pl.coderslab;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_01_1")
public class Servlet_01_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if (Objects.isNull(cookies)) {
			request.setAttribute("language", "Czesc");
		} else {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("language")) {
					request.setAttribute("language", cookie.getValue());
				} 
			}

		}
		getServletContext().getRequestDispatcher("/WEB-INF/views/jsp_01.jsp").forward(request, response);

	}

}
// #### Zadanie 1
//
// W projekcie stwórz servlet `Servlet_01_1` oraz `Servlet_01_2`. Następnie:
// 1. Na pierwszej stronie (`Servlet_01_1`) stwórz formularz z elementem
// `select` oraz opcjami wyboru zgodnymi z kluczami poniższej mapy:
// ```java
// Map<String, String> lang = new HashMap<>();
// lang.put("en", "Hello");
// lang.put("pl", "Cześć");
// lang.put("de", "Ehre");
// lang.put("es", "Hola");
// lang.put("fr", "Bienvenue");
// ```
// 2. Strona ma przesyłać dane za pomocą `POST` do drugiej strony
// (`Servlet_01_2`), która ma ustawić ciasteczko `language` na wartość wybraną
// przez użytkownika.
// 3. Po ponownym wejściu na pierwszą powinna być wyświetlana informacja
// powitalna w wybranym przez użytkownika języku.
// 4. Gdy ciasteczko nie istnieje, wiadomość powitalna powinna być wyświetlana w
// języku polskim.
