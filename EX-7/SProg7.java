public import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg7 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();

        try {
            String name = request.getParameter("userName");
            String password = request.getParameter("userPassword");

            // Save in session
            HttpSession session = request.getSession();
            session.setAttribute("uname", name);
            session.setAttribute("upass", password);

            // Output styled HTML with user greeting and link
            pwriter.println("<!DOCTYPE html>");
            pwriter.println("<html>");
            pwriter.println("<head>");
            pwriter.println("<title>Welcome to Fact Quiz</title>");
            pwriter.println("<style>");
            pwriter.println("body {"
                    + "background: linear-gradient(135deg, #89f7fe, #66a6ff);"
                    + "font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;"
                    + "color: white;"
                    + "text-align: center;"
                    + "padding: 50px;"
                    + "}");
            pwriter.println("h2 {"
                    + "font-size: 3em;"
                    + "text-shadow: 2px 2px 6px #004d99;"
                    + "margin-bottom: 20px;"
                    + "}");
            pwriter.println("p {"
                    + "font-size: 1.5em;"
                    + "margin-bottom: 40px;"
                    + "}");
            pwriter.println("a {"
                    + "background: #004d99;"
                    + "color: white;"
                    + "padding: 15px 35px;"
                    + "text-decoration: none;"
                    + "font-size: 1.3em;"
                    + "border-radius: 50px;"
                    + "box-shadow: 0 5px 15px rgba(0,0,0,0.3);"
                    + "transition: background 0.3s ease;"
                    + "}");
            pwriter.println("a:hover { background: #003366; }");
            pwriter.println("</style>");
            pwriter.println("</head>");
            pwriter.println("<body>");
            pwriter.println("<h2>Welcome, " + name + "!</h2>");
            pwriter.println("<p>Your password is securely saved in the session.</p>");
            pwriter.println("<a href='SP8'>View Session Details</a>");
            pwriter.println("</body>");
            pwriter.println("</html>");

        } catch (Exception e) {
            pwriter.println("<p>Something went wrong: " + e.getMessage() + "</p>");
        } finally {
            pwriter.close();
        }
    }
}

 {
    
}
