import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

public class SProg12 extends HttpServlet {    

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  

        try {  
            // Retrieve parameters from URL
            String userName = request.getParameter("uname");  
            String quizTopic = request.getParameter("topic");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Quiz Instructions</title>");
            out.println("<style>");
            out.println("body { background: linear-gradient(135deg, #b8d5ff, #f9f7f7); font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; color: #222; text-align: center; padding: 60px; }");
            out.println(".content { background: #fff; padding: 40px 50px; border-radius: 20px; box-shadow: 0 10px 30px rgba(0,0,0,0.1); max-width: 600px; margin: auto; }");
            out.println("h2 { color: #004d99; margin-bottom: 20px; }");
            out.println("p { font-size: 1.2em; margin-bottom: 40px; }");
            out.println("a { text-decoration: none; background: #004d99; color: white; padding: 15px 45px; border-radius: 50px; font-weight: 600; transition: background 0.3s ease; }");
            out.println("a:hover { background: #003366; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='content'>");
            out.println("<h2>Hello, " + userName + "!</h2>");
            out.println("<p>You are about to start the quiz on <strong>" + quizTopic + "</strong>.</p>");
            out.println("<p>Make sure you are ready to test your knowledge on some amazing facts.</p>");
            out.println("<a href='quiz.html'>Start Quiz</a>");
            out.println("</div>");

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
