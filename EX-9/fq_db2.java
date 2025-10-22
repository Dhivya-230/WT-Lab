
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class fq_db2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String category = request.getParameter("category");

        out.println("<html><head>");
        out.println("<title>Facts and Quizzes - Category: " + category + "</title>");
        out.println("<style>");
        out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #e0f7fa, #b2ebf2); color: #222; padding: 20px; }");
        out.println("h1 { text-align: center; color: #006064; animation: pulse 3s infinite; }");
        out.println("@keyframes pulse { 0%, 100% { color: #006064; text-shadow: 0 0 10px #0097a7; } 50% { color: #00acc1; text-shadow: 0 0 20px #00acc1; } }");
        out.println("hr { border: none; height: 2px; background-color: #00bcd4; margin: 25px 0; border-radius: 4px; }");
        out.println("p.fact { background: #ffffffcc; border-left: 6px solid #00bcd4; padding: 15px 20px; margin-bottom: 20px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0, 188, 212, 0.2); transition: box-shadow 0.3s ease; }");
        out.println("p.fact:hover { box-shadow: 0 8px 20px rgba(0, 188, 212, 0.4); }");
        out.println("b { color: #007c91; }");
        out.println("h3.error { color: #d32f2f; font-weight: bold; }");
        out.println("</style>");
        out.println("</head><body>");

        out.println("<h1>Facts and Quizzes - Category: " + category + "</h1><hr>");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Load MySQL driver (if using MySQL 8+, use com.mysql.cj.jdbc.Driver)
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/quiz", "root", "");

            String sql = "SELECT * FROM facts_quizzes WHERE Category = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, category);

            ResultSet rs = pstmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                out.println("<p class='fact'>");
                out.println("<b>ID:</b> " + rs.getString("ID") + "<br>");
                out.println("<b>Title:</b> " + rs.getString("Title") + "<br>");
                out.println("<b>Category:</b> " + rs.getString("Category") + "<br>");
                out.println("<b>Content:</b> " + rs.getString("Content") + "<br>");
                out.println("</p><hr>");
            }
            
            if (!found) {
                out.println("<p style='text-align:center; color:#555;'>No facts or quizzes found for this category.</p>");
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<h3 class='error'>⚠️ Error fetching data by category</h3>");
            out.println("<pre>" + e.toString() + "</pre>");
        }

        out.println("</body></html>");
    }
}




