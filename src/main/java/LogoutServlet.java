import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		Cookie userCookie = new Cookie("user", "");
		userCookie.setMaxAge(0);
		Cookie ageCookie = new Cookie("age", "");
		ageCookie.setMaxAge(0);

		response.addCookie(userCookie);
		response.addCookie(ageCookie);

		response.sendRedirect("index.jsp");
//        out.println("You have been logged out.");
	}
}
