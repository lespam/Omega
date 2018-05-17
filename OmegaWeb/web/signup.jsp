<%-- 
    Document   : index
    Created on : 14-may-2018, 17:19:01
    Author     : LesPam
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DataWeb Wizard</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/omega;create=true;",
                    "root", "root");
            Statement query = con.createStatement();
            String QueryString = "create table omega (id int not null, name "
                    + "varchar(25),password varchar(20), primary key(id))";
            query.executeUpdate(QueryString);
            query.executeUpdate("INSERT INTO omega VALUES (1, 'admin', 'admin')");
            ResultSet rs = query.executeQuery("SELECT * FROM omega");
            out.println("<p>");
            while (rs.next()) {
                out.println("<BR>Id: " + rs.getInt("id"));
                out.println(" Name: " + rs.getString("name"));
            }
        %>
        <form action="SignUp">
            <table border="1">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th><input type="text" name="username" value="username" /></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="123" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Sign Up" name="ADD"/></td>
                    </tr>
                </tbody>
            </table>
        </form>
        
    </body>
</html>