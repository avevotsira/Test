import java.io.IOException;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get user name, age, number of tickets and ticket type from form
		String user = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		int no_of_tickets = Integer.parseInt(request.getParameter("no_of_tickets"));
		String ticket_type = request.getParameter("ticket_type");

		// Define ticket prices
		int ticket_price = ticket_type.equals("front_circle") ? 2 : ticket_type.equals("rear_circle") ? 3 : 4;

		double total_price = ticket_price * no_of_tickets;

		// Apply discounts
		if (age < 30 && no_of_tickets >= 3) {
			total_price *= 0.9; // 10% discount
		} else if (age < 20 && no_of_tickets >= 5) {
			total_price *= 0.8; // 20% discount
		}

		// Create a session and store user, total price, and booking time
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		session.setAttribute("total_price", total_price);
		session.setAttribute("booking_time", LocalDateTime.now());

		// Redirect to SecondServlet
		response.sendRedirect("SecondServlet");
	}
}
