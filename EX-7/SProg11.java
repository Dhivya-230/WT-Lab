
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

public class SProg11 extends HttpServlet {    

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  

        try {  
            String userName = request.getParameter("userName");  
            String quizTopic = request.getParameter("quizTopic");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome to Fact Quiz</title>");
            out.println("<style>");
            out.println("body { background: linear-gradient(135deg, #89f7fe, #66a6ff); font-family: Arial, sans-serif; color: #333; text-align: center; padding: 50px; }");
            out.println("h2 { color: #004d99; margin-bottom: 20px; }");
            out.println("a { display: inline-block; margin-top: 30px; padding: 15px 40px; background-color: #004d99; color: white; text-decoration: none; border-radius: 50px; font-weight: bold; transition: background-color 0.3s ease; }");
            out.println("a:hover { background-color: #003366; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h2>Welcome, " + userName + "!</h2>");
            out.println("<p>You have chosen the quiz topic: <strong>" + quizTopic + "</strong></p>");

            // Passing both userName and quizTopic via URL rewriting (query string)
            out.println("<a href='SP12?uname=" + userName + "&topic=" + quizTopic + "'>Proceed to Quiz Instructions</a>");

            out.println("</body>");
            out.println("</html>");

        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
            e.printStackTrace();
        } finally {
            out.close();
        }
    }   
}

