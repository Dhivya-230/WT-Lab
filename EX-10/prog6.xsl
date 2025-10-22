<?xml version="1.0" encoding="UTF-8"?>  
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">     

   <xsl:template match="/">   
      <html>   
         <head>
            <style>
               body {
                  font-family: Arial, sans-serif;
                  background-color: #f0f8ff;
                  text-align: center;
                  padding: 20px;
               }
               h2 {
                  color: #2e3d49;
               }
               table {
                  margin: auto;
                  border-collapse: collapse;
                  width: 80%;
               }
               th, td {
                  border: 1px solid #9acd32;
                  padding: 10px;
                  text-align: center;
               }
               th {
                  background-color: #9acd32;
               }
               tr:nth-child(even) {
                  background-color: #e6f2ff;
               }
            </style>
         </head>
         <body>  
            <h2>Facts and Quiz</h2>   
            <table>   
               <tr>   
                  <th>ID</th>   
                  <th>Fact</th>   
                  <th>Quiz Question</th>   
                  <th>Answer</th>   
               </tr>   
              <xsl:for-each select="quiz/item">   
                  <tr>   
                     <td><xsl:value-of select="@id"/></td>   
                     <td><xsl:value-of select="fact"/></td>   
                     <td><xsl:value-of select="question"/></td>   
                     <td><xsl:value-of select="answer"/></td>     
                  </tr>   
               </xsl:for-each>   
            </table>   
         </body>   
      </html>   
   </xsl:template>    
</xsl:stylesheet>
