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
