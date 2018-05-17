<%-- 
    Document   : scroll
    Created on : 5/03/2018, 07:35:25 PM
    Author     : sdist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scrolling Database</title>
    </head>
    <body>
        <h1>Scrolling Database records</h1>

        Scrolling Database records
        <%
            out.println("<form action='/scroll.jsp' method='POST'>");
            HttpSession mySession = request.getSession();
            int row = Integer.parseInt(mySession.getAttribute("row").toString());
            Object[][] myResultSet = (Object[][])mySession.getAttribute("resultSet");
            
            out.println("ID: "+ myResultSet[row][0]);
            out.println("NAME: "+ myResultSet[row][1]); 
            out.println("<hr>");
            out.println("<input type='submit' value='<' name='back' disabled='disabled'/>");
            
            if(request.getParameter("back")!=null)
                mySession.setAttribute("row", row - 1);
            if(request.getParameter("next")!=null)
                out.println("loool");
            
            
            out.println("<input type='submit' value='>' name='next' />");
            out.println("</form>");
        %>        
        
    </body>
</html>
