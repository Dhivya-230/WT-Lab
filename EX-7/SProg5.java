import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg5 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Get the fact from the form
        String fact = request.getParameter("userFact");

        // Create a cookie with the submitted fact
        Cookie factCookie = new Cookie("UserFact", fact);
        factCookie.setMaxAge(60 * 60); // 1 hour expiry
        response.addCookie(factCookie);

        // Styled HTML response
        out.println("<html><head><title>Fact Saved</title></head>");
        out.println("<body style='background-color:#e6f2ff; font-family: Arial; text-align:center;'>");
        out.println("<h2 style='color:#4CAF50;'>Thank you!</h2>");
        out.println("<p style='font-size:18px;'>Your submitted fact:</p>");
        out.println("<p style='font-weight:bold; font-size:20px; color:#333;'>" + fact + "</p>");
        out.println("<p><a href='SProg6.html' style='text-decoration:none; color:#0066cc;'>Click here to view your saved fact</a></p>");
        out.println("</body></html>");

        out.close();
    }
}

