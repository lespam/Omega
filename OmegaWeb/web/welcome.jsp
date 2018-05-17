<%-- 
    Document   : welcome
    Created on : 28/02/2018, 07:22:15 PM
    Author     : sdist
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDataWeb Wizard</title>
    </head>
    <body>
        HI
        <%
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/mySixthDatabase;create=true;",
                    "root", "root");
            Statement query = con.createStatement();
            String QueryString = "create table MySixthTable (id int not null, name "
                    + "varchar(25),gender varchar(20),address varchar(50),phone varchar(20), primary key(id))";
            query.executeUpdate(QueryString);
            query.executeUpdate("INSERT INTO MySixthTable VALUES (4, 'Jose', 'Male', 'Great Avenue #123', '(55) 1234 1234')");
            ResultSet rs = query.executeQuery("SELECT * FROM MySixthTable");
            out.println("<p>");
            while (rs.next()) {
                out.println("<BR>Id: " + rs.getInt("id"));
                out.println(" Name: " + rs.getString("name"));
            }

            if (request.getParameter("username") != null && request.getParameter("password") != null) {
                if (request.getParameter("password").equals("123")) {
                    HttpSession mysession = request.getSession();
                    mysession.setAttribute("username", request.getParameter("username"));
                    mysession.setMaxInactiveInterval(20);
                    out.println("Bienvenido, " + request.getParameter("username") + "<br>");
                    out.println("<hr>");
                    out.println("<a href='profile.jsp'>Visita tu perfil</a>");
                } else {
                    response.sendRedirect("index.html");
                }
            } else {
                response.sendRedirect("index.html");
            }
        %>
    </body>
</html>
