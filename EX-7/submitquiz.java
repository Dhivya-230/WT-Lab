
// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitQuiz extends HttpServlet {
   public SubmitQuiz() {
   }

   protected void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      var2.setContentType("text/html");
      PrintWriter var3 = var2.getWriter();

      try {
         String var4 = var1.getParameter("q1");
         String var5 = var1.getParameter("q2");
         String var6 = "Mount Everest";
         String var7 = "Paris";
         int var8 = 0;
         if (var6.equalsIgnoreCase(var4)) {
            ++var8;
         }

         if (var7.equalsIgnoreCase(var5)) {
            ++var8;
         }

         var3.println("<!DOCTYPE html>");
         var3.println("<html>");
         var3.println("<head>");
         var3.println("<title>Quiz Results</title>");
         var3.println("<style>");
         var3.println("body {background: linear-gradient(135deg, #89f7fe, #66a6ff);font-family: Arial, sans-serif;color: #222;text-align: center;padding: 50px;}");
         var3.println("h2 { color: #003366; }");
         var3.println(".score {font-size: 2em;margin-top: 20px;font-weight: bold;}");
         var3.println("</style>");
         var3.println("</head>");
         var3.println("<body>");
         var3.println("<h2>Your Quiz Results</h2>");
         var3.println("<p>You scored <span class='score'>" + var8 + "</span> out of 2!</p>");
         if (var8 == 2) {
            var3.println("<p>Excellent! You know your facts well.</p>");
         } else if (var8 == 1) {
            var3.println("<p>Good try! Keep learning!</p>");
         } else {
            var3.println("<p>Better luck next time! Keep practicing.</p>");
         }

         var3.println("<a href='quiz.html'>Try Again</a>");
         var3.println("</body>");
         var3.println("</html>");
      } catch (Exception var12) {
         var3.println("<p>Error processing quiz: " + var12.getMessage() + "</p>");
      } finally {
         var3.close();
      }

   }

   protected void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
      this.doPost(var1, var2);
   }
}
