<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
    <head>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f5f5f5;
                text-align: center;
                padding: 20px;
            }
            h1 {
                color: #2e3d49;
            }
            table {
                margin: auto;
                border-collapse: collapse;
                width: 80%;
            }
            th, td {
                border: 1px solid #4CAF50;
                padding: 10px;
                text-align: center;
            }
            th {
                background-color: #4CAF50;
                color: white;
            }
            tr:nth-child(even) {
                background-color: #eafaf1;
            }
        </style>
    </head>
    <body>
        <h1>Facts and Quiz</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Fact</th>
                    <th>Quiz Question</th>
                    <th>Answer</th>
                </tr>
            </thead>
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
