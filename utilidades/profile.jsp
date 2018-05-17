<%-- 
    Document   : profile
    Created on : 28/02/2018, 07:21:58 PM
    Author     : sdist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            HttpSession mysession = request.getSession();
            if( mysession.getAttribute("name")!=null){
                out.println("<h1>" + mysession.getAttribute("name") + " este es tu perfil</h1><br>");
                out.println("<a href='SignOut'>Cerrar sesión</a>");
            }
        %>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
