import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg6 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Get cookies from the request
        Cookie[] cookies = request.getCookies();
        String userFact = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("UserFact".equals(cookie.getName())) {
                    userFact = cookie.getValue();
                }
            }
        }

        // Styled HTML output
        out.println("<html><head><title>View Saved Fact</title></head>");
        out.println("<body style='background-color:#fffacd; font-family: Arial; text-align:center;'>");
        out.println("<h2 style='color:#d2691e;'>Retrieved Fact from Cookie:</h2>");

        if (userFact != null) {
            out.println("<p style='font-size:20px; font-weight:bold; color:#444;'>" + userFact + "</p>");
        } else {
            out.println("<p style='color:red;'>No fact found in cookies.</p>");
        }

        out.println("</body></html>");

        out.close();
    }
}
