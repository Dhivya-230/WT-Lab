import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
  
public class SProg9 extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        try {  
            String n = request.getParameter("userName");  
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Fact Quiz - Welcome</title>");
            out.println("<style>");
            out.println("body {"
                    + "background: linear-gradient(120deg, #74ebd5, #ACB6E5);"
                    + "font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;"
                    + "color: #333;"
                    + "display: flex;"
                    + "justify-content: center;"
                    + "align-items: center;"
                    + "height: 100vh;"
                    + "margin: 0;"
                    + "}");
            out.println(".container {"
                    + "background: white;"
                    + "border-radius: 15px;"
                    + "box-shadow: 0 8px 20px rgba(0,0,0,0.1);"
                    + "padding: 30px 50px;"
                    + "text-align: center;"
                    + "width: 360px;"
                    + "}");
            out.println("h2 {"
                    + "color: #34495e;"
                    + "margin-bottom: 25px;"
                    + "}");
            out.println("input[type=submit] {"
                    + "background: #34495e;"
                    + "color: white;"
                    + "border: none;"
                    + "padding: 14px 40px;"
                    + "font-size: 1.1em;"
                    + "border-radius: 50px;"
                    + "cursor: pointer;"
                    + "transition: background 0.3s ease;"
                    + "}");
            out.println("input[type=submit]:hover {"
                    + "background: #2c3e50;"
                    + "}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Welcome, " + n + "!</h2>");
            out.println("<p>Let's continue your Fact Quiz journey.</p>");

            // Form with hidden input to pass username to next servlet
            out.println("<form action='SP10' method='POST'>");
            out.println("<input type='hidden' name='uname' value='" + n + "'>");
            out.println("<input type='submit' value='Go to Quiz'>");
            out.println("</form>");
            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch(Exception e) {
            System.out.println(e);
            out.println("<p>Error: " + e.getMessage() + "</p>");
        } finally {
            out.close();
        }  
    }  
}
