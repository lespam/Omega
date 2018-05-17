<%-- 
    Document   : index
    Created on : 14-may-2018, 17:19:01
    Author     : LesPam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DataWeb Wizard</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
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