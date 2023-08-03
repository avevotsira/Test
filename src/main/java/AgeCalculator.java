import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AgeCalculator")
public class AgeCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AgeCalculator() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get user input from the form
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");

		// Parse the birthday into a LocalDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate birthDate = LocalDate.parse(birthday, formatter);

		// Calculate the age
		LocalDate now = LocalDate.now();
		Period period = Period.between(birthDate, now);
		int age = period.getYears();

		if (age > 5) {
			// Forward the request to HelloWorldServlet
			request.setAttribute("name", name);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/HelloWorld");
			dispatcher.forward(request, response);
		} else {
			response.getWriter().append("Hello " + name + ", you are " + age + " years old.");
		}
		// Send the response back to the user

	}
}
