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
        <%
            //HttpSession mysession = request.getSession();
            //if( mysession.getAttribute("name")!=null){
            //    out.println("<h1>" + mysession.getAttribute("name") + " este es tu perfil</h1><br>");
            //    out.println("<a href='SignOut'>Cerrar sesión</a>");
            // }
        %>

        <%
            
            HttpSession mysession = request.getSession();
            if( mysession.getAttribute("name")!=null){
                out.println("<h1>" + mysession.getAttribute("name") + " este es tu perfil</h1><br>");
                out.println("<hr>");
                
                out.println("<a href='SignOut'>Cerrar sesión</a>");
            
            
            
            
                //HttpSession mysession = request.getSession();
                //mysession.setAttribute("name", request.getParameter("name"));
                //mysession.setMaxInactiveInterval(20);
                
                
                
                //out.println("<a href='profile.jsp'>Visita tu perfil</a>");
            } else {
                out.println("<h2>Sesión no iniciada</h2>");
                out.println("<a href='index.jsp'>Inicia sesión</a>");
            }
        %>
    </body>
</html>
