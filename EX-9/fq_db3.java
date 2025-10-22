import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class fq_db3 extends HttpServlet {
   public fq_db3() {
   }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.println("<html><head>");
      out.println("<title>Insert Fact or Quiz</title>");
      out.println("<style>");
      out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #f9fafb, #e0f7fa); color: #222; padding: 20px; }");
      out.println("h2.success { color: #27ae60; text-align: center; }");
      out.println("h2.error { color: #c0392b; text-align: center; }");
      out.println("hr { border: none; height: 2px; background-color: #00acc1; margin: 20px 0; border-radius: 3px; }");
      out.println("p.fact { background: #ffffffcc; border-left: 6px solid #00acc1; padding: 15px 20px; margin-bottom: 20px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0, 172, 193, 0.2); transition: box-shadow 0.3s ease; }");
      out.println("p.fact:hover { box-shadow: 0 8px 20px rgba(0, 172, 193, 0.4); }");
      out.println("b { color: #007c91; }");
      out.println("</style>");
      out.println("</head><body>");

      Connection conn = null;
      Statement stmt = null;

      try {
         // Load MySQL driver (change to com.mysql.cj.jdbc.Driver for MySQL 8+)
         Class.forName("com.mysql.jdbc.Driver");

         // Connect to database
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/quiz", "root", "");

         // Insert new record
         PreparedStatement pstmt = conn.prepareStatement("INSERT INTO facts_quizzes (ID, Title, Category, Content) VALUES (?, ?, ?, ?)");

         pstmt.setString(1, request.getParameter("id"));
         pstmt.setString(2, request.getParameter("title"));
         pstmt.setString(3, request.getParameter("category"));
         pstmt.setString(4, request.getParameter("content"));

         pstmt.executeUpdate();

         out.println("<h2 class='success'>✅ Database Updated Successfully</h2><hr>");

         // Query and display all facts and quizzes
         String sql = "SELECT * FROM facts_quizzes";
         pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();

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
         out.println("<h2 class='error'>⚠️ Error:</h2>");
         out.println("<pre>" + e.toString() + "</pre>");
         e.printStackTrace();
      }

      out.println("</body></html>");
   }
}
