import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class fq_db16 extends HttpServlet {

    private static Set<String> uniqueUsers = new HashSet<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String userIP = request.getRemoteAddr();
        uniqueUsers.add(userIP);  // Track by IP

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Facts & Quizzes | Unique Visitors</title>");
        out.println("<style>");
        out.println("body {margin:0; font-family:'Poppins', sans-serif; background:linear-gradient(120deg,#00c6ff,#0072ff); color:#fff; text-align:center; padding:60px;}");
        out.println("h1 {font-size:3em; text-shadow:2px 2px 6px rgba(0,0,0,0.3);}");
        out.println("h2 {font-size:2em; margin-top:15px; color:#ffeb99;}");
        out.println("p {font-size:1.3em; margin-top:20px;}");
        out.println("a {display:inline-block; margin-top:30px; text-decoration:none; background:#fff; color:#0077b6; padding:12px 25px; border-radius:10px; font-weight:bold; transition:0.3s;}");
        out.println("a:hover {background:#ffeb99; color:#2a2a72; transform:scale(1.1);}");
        out.println("@keyframes fadeIn {from{opacity:0; transform:translateY(20px);} to{opacity:1; transform:translateY(0);}}");
        out.println(".container {animation: fadeIn 1.5s ease-in-out;}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<img src='https://cdn-icons-png.flaticon.com/512/3774/3774278.png' width='120' height='120' style='border-radius:50%; box-shadow:0 0 20px rgba(255,255,255,0.3); animation:float 3s ease-in-out infinite;'>");
        out.println("<h1>🧠 Facts & Quizzes Portal</h1>");
        out.println("<h2>Unique Visitor Counter</h2>");
        out.println("<p>Total Unique Visitors: <strong style='color:#ffeb99;'>" + uniqueUsers.size() + "</strong></p>");
        out.println("<p>Your IP Address: <span style='color:#e0f7fa;'>" + userIP + "</span></p>");
        out.println("<a href='FactsHome.html'>← Back to Home</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
