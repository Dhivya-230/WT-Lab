import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

public class SProg10 extends HttpServlet {  

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        try {  
            String n = request.getParameter("uname");  
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Fact Quiz - Welcome " + n + "</title>");
            out.println("<style>");
            out.println("body {"
                    + "background: linear-gradient(135deg, #f9f7f7, #b8d5ff);"
                    + "font-family: 'Arial', sans-serif;"
                    + "color: #222;"
                    + "display: flex;"
                    + "justify-content: center;"
                    + "align-items: center;"
                    + "height: 100vh;"
                    + "margin: 0;"
                    + "}");
            out.println(".welcome-box {"
                    + "background: #ffffffcc;"
                    + "padding: 40px 60px;"
                    + "border-radius: 20px;"
                    + "box-shadow: 0 10px 25px rgba(0,0,0,0.1);"
                    + "text-align: center;"
                    + "width: 400px;"
                    + "animation: fadeIn 1.5s ease forwards;"
                    + "}");
            out.println("h2 {"
                    + "color: #2c3e50;"
                    + "margin-bottom: 20px;"
                    + "font-weight: 700;"
                    + "}");
            out.println("p {"
                    + "font-size: 1.1em;"
                    + "margin-bottom: 30px;"
                    + "color: #34495e;"
                    + "}");
            out.println("a {"
                    + "display: inline-block;"
                    + "text-decoration: none;"
                    + "background: #34495e;"
                    + "color: white;"
                    + "padding: 14px 40px;"
                    + "border-radius: 50px;"
                    + "font-weight: 600;"
                    + "transition: background 0.3s ease;"
                    + "}");
            out.println("a:hover { background: #2c3e50; }");
            out.println("@keyframes fadeIn {"
                    + "from {opacity: 0; transform: translateY(20px);}"
                    + "to {opacity: 1; transform: translateY(0);}"
                    + "}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div class='welcome-box'>");
            out.println("<h2>Welcome to the Fact Quiz, " + n + "!</h2>");
            out.println("<p>Ready to test your knowledge with some amazing facts?</p>");
            out.println("<a href='quiz.html'>Start Quiz</a>");
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
