<%-- 
    Document   : index
    Created on : 2/03/2018, 04:22:40 PM
    Author     : sdist
--%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h2>Retreive Database Records</h2>
        <form action="DataExtractor">
            <input type="submit" name="Retreive data" />
        </form>
    </body>
</html>
