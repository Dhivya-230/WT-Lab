import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Retrieve form parameters
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");

        PrintWriter out = response.getWriter();
        String title = "User Info Submitted - Facts & Quiz Arena";

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>" + title + "</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    background: linear-gradient(to right, #fbc2eb, #a6c1ee);");
        out.println("    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
        out.println("    color: #333;");
        out.println("    display: flex;");
        out.println("    flex-direction: column;");
        out.println("    align-items: center;");
        out.println("    justify-content: center;");
        out.println("    height: 100vh;");
        out.println("    text-align: center;");
        out.println("    padding: 20px;");
        out.println("}");

        out.println("h1 { font-size: 2.5rem; color: #222; }");
        out.println("h3 { font-size: 1.5rem; margin-bottom: 20px; }");
        out.println("ul { list-style-type: none; padding: 0; }");
        out.println("li { font-size: 1.2rem; margin: 10px 0; }");

        out.println(".btn {");
        out.println("    margin-top: 30px;");
        out.println("    padding: 10px 20px;");
        out.println("    background-color: #fff;");
        out.println("    color: #333;");
        out.println("    border-radius: 25px;");
        out.println("    text-decoration: none;");
        out.println("    font-weight: bold;");
        out.println("    transition: all 0.3s ease;");
        out.println("}");

        out.println(".btn:hover { background-color: #333; color: #fff; }");

        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>" + title + "</h1>");
        out.println("<h3>Welcome to the Facts & Quiz Arena!</h3>");

        out.println("<ul>");
        out.println("<li><b>First Name:</b> " + (firstName != null ? firstName : "Nivi") + "</li>");
        out.println("<li><b>Last Name:</b> " + (lastName != null ? lastName : "Divi") + "</li>");
        out.println("</ul>");

        out.println("<a class='btn' href='sprgm2.html'>Go to Home</a>");

        out.println("</body>");
        out.println("</html>");
    }
}
