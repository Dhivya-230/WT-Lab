
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg8 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();

        try {
            HttpSession session = request.getSession(false);

            pwriter.println("<!DOCTYPE html>");
            pwriter.println("<html>");
            pwriter.println("<head>");
            pwriter.println("<title>Your Fact Quiz Session Details</title>");
            pwriter.println("<style>");
            pwriter.println("body {"
                    + "background: linear-gradient(135deg, #74ebd5, #ACB6E5);"
                    + "font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;"
                    + "color: #333;"
                    + "display: flex;"
                    + "flex-direction: column;"
                    + "justify-content: center;"
                    + "align-items: center;"
                    + "height: 100vh;"
                    + "margin: 0;"
                    + "}");
            pwriter.println(".session-box {"
                    + "background: white;"
                    + "border-radius: 15px;"
                    + "box-shadow: 0 8px 20px rgba(0,0,0,0.1);"
                    + "padding: 30px 50px;"
                    + "text-align: center;"
                    + "width: 350px;"
                    + "}");
            pwriter.println("h2 {"
                    + "color: #34495e;"
                    + "margin-bottom: 25px;"
                    + "}");
            pwriter.println("p {"
                    + "font-size: 1.2em;"
                    + "margin: 12px 0;"
                    + "color: #2c3e50;"
                    + "}");
            pwriter.println("a {"
                    + "margin-top: 20px;"
                    + "display: inline-block;"
                    + "text-decoration: none;"
                    + "color: white;"
                    + "background: #34495e;"
                    + "padding: 12px 30px;"
                    + "border-radius: 50px;"
                    + "font-weight: 600;"
                    + "box-shadow: 0 4px 12px rgba(52,73,94,0.4);"
                    + "transition: background 0.3s ease;"
                    + "}");
            pwriter.println("a:hover { background: #2c3e50; }");
            pwriter.println("</style>");
            pwriter.println("</head>");
            pwriter.println("<body>");

            pwriter.println("<div class='session-box'>");
            pwriter.println("<h2>Session Details</h2>");

            if (session != null && session.getAttribute("uname") != null && session.getAttribute("upass") != null) {
                String name = (String) session.getAttribute("uname");
                String password = (String) session.getAttribute("upass");

                pwriter.println("<p><strong>Name:</strong> " + name + "</p>");
                pwriter.println("<p><strong>Password:</strong> " + password + "</p>");
            } else {
                pwriter.println("<p>No session found or session expired!</p>");
            }

            pwriter.println("<a href='Sessionlogin.html'>Go back to Login</a>");
            pwriter.println("</div>");

            pwriter.println("</body>");
            pwriter.println("</html>");
        } catch (Exception e) {
            System.out.println(e);
            pwriter.println("<p>Error occurred: " + e.getMessage() + "</p>");
        } finally {
            pwriter.close();
        }
    }
}
