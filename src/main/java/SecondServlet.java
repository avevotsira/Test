import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SecondServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// Get session from request
		HttpSession session = request.getSession(false);

		// Initialize variables to store session values
		String user = "";
		double total_price = 0.0;
		String booking_time = null;

		if (session != null) {
			user = (String) session.getAttribute("user");
			total_price = (Double) session.getAttribute("total_price");
			LocalDateTime dateTime = (LocalDateTime) session.getAttribute("booking_time");

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
			booking_time = dateTime.format(formatter);
		}

		out.println("<p>");
		out.println("Hello, " + user + "!<br/>");
		out.println("Your tickets have been booked at a total price of $" + total_price + ".<br/>");
		out.println("Booking time: " + booking_time + "<br/>");
		out.println("<a href='LogoutServlet'> LogOut <a/>");
		out.println("</p>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
