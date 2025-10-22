import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg1 extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // Initialization message
        message = "Welcome to the Facts & Quiz Arena!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Facts & Quiz Arena</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background: linear-gradient(to right, #74ebd5, #acb6e5);");
        out.println("    color: #333;");
        out.println("    text-align: center;");
        out.println("    padding: 50px;");
        out.println("}");

        out.println("h1 {");
        out.println("    font-size: 3rem;");
        out.println("    color: #fff;");
        out.println("    margin-bottom: 20px;");
        out.println("}");

        out.println("p {");
        out.println("    font-size: 1.2rem;");
        out.println("    color: #f9f9f9;");
        out.println("}");

        out.println("a.button {");
        out.println("    display: inline-block;");
        out.println("    margin-top: 30px;");
        out.println("    padding: 12px 25px;");
        out.println("    background-color: #ffffff;");
        out.println("    color: #333;");
        out.println("    text-decoration: none;");
        out.println("    border-radius: 25px;");
        out.println("    font-weight: bold;");
        out.println("    transition: all 0.3s ease;");
        out.println("}");

        out.println("a.button:hover {");
        out.println("    background-color: #333;");
        out.println("    color: #fff;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>" + message + "</h1>");
        out.println("<p>Get ready to test your brain and learn amazing facts along the way!</p>");
        out.println("<p>Explore quizzes on science, history, space, technology, and more.</p>");

        out.println("<a href='http://localhost:8080/factservlets/sprgm1.html' class='button'>Go Back</a>");

        out.println("</body>");
        out.println("</html>");
    }

    public void destroy() {
        // Cleanup if needed
    }
}
