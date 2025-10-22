import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class fq_db1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<title>Facts and Quizzes List</title>");
        // Add some basic CSS styles here
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background: linear-gradient(135deg, #f0f8ff, #dbe9ff); color: #333; padding: 20px; }");
        out.println("h1 { color: #2c3e50; text-align: center; animation: glow 3s ease-in-out infinite; }");
        out.println("@keyframes glow { 0%, 100% { text-shadow: 0 0 10px #3498db; } 50% { text-shadow: 0 0 20px #2980b9; }}");
        out.println("hr { border: none; height: 2px; background-color: #2980b9; margin: 20px 0; border-radius: 3px; }");
        out.println("p.fact { background: #eaf2f8; padding: 15px; border-radius: 10px; box-shadow: 0 4px 8px rgba(41, 128, 185, 0.2); transition: box-shadow 0.3s ease; }");
        out.println("p.fact:hover { box-shadow: 0 8px 16px rgba(41, 128, 185, 0.4); }");
        out.println("b { color: #1f618d; }");
        out.println("h3.success { color: #27ae60; font-weight: bold; }");
        out.println("h3.error { color: #c0392b; font-weight: bold; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<h1>Facts and Quizzes List</h1><hr>");

        Connection conn = null;
        Statement stmt = null;

        try {
            // Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to your new database (update credentials/db name as needed)
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/quiz",
                "root",
                ""
            );

            out.println("<h3 class='success'>✅ Database Connection Successful</h3>");

            // Execute query
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM facts_quizzes");

            // Display results
            while (rs.next()) {
                out.println("<p class='fact'>");
                out.println("<b>ID:</b> " + rs.getString("ID") + "<br>");
                out.println("<b>Title:</b> " + rs.getString("Title") + "<br>");
                out.println("<b>Category:</b> " + rs.getString("Category") + "<br>");
                out.println("<b>Content:</b> " + rs.getString("Content") + "<br>");
                out.println("</p><hr>");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<h3 class='error'>⚠️ Error:</h3>");
            out.println("<pre>" + e.toString() + "</pre>");
        }

        out.println("</body></html>");
    }
}


