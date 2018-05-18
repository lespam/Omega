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
            if (mysession.getAttribute("name") != null) {
                out.println("<h1>" + mysession.getAttribute("name") + " este es tu perfil</h1>");
                out.println("<hr>");
                out.println("<a href='SignOut'>Cerrar sesión</a>");

                //HttpSession mysession = request.getSession();
                //mysession.setAttribute("name", request.getParameter("name"));
                //mysession.setMaxInactiveInterval(20);
                //out.println("<a href='profile.jsp'>Visita tu perfil</a>");%>


        <script>
            var fieldId = 0;

            function addElement(parentId, elementTag, elementId, html) {

                // Adds an element to the document
                var p = document.getElementById(parentId);
                var newElement = document.createElement(elementTag);
                newElement.setAttribute('id', elementId);
                newElement.innerHTML = html;
                p.appendChild(newElement);
            }

            function addFile() {
                var coml = "'";
                fieldId++; // increment fileId to get a unique ID for the new element
                var html = 'Fieldname: <input type="text" name="field'+fieldId+'" />'
                +' Type <select name="type'+fieldId+'">'
                +'<option value="varchar(25)">Varchar</option><option value="int">int</option>'
                +'</select>'
                +' PK <input type="checkbox" name="PK" value="ON" />'
                +'<a href="" onclick="javascript:removeElement('+coml.concat("field",fieldId,coml)+'); return false;">Remove</a>';
                        addElement('fields', 'p', 'field'+fieldId, html);
                        //alert("Hello! I am an alert box!!");
            }

            function removeElement(elementId) {
                // Removes an element from the document
                var element = document.getElementById(elementId);
                element.parentNode.removeChild(element);
            }
        </script>

        %>

        <br>
        <h3>Crear</h3>
        <br>
        Table name: <input type="text" name="input" value="" />
        <br><br>
        <div id="fields">
            Fieldname: <input type="text" name="field0"/>
            Type
            <select name="type0">
                <option value="varchar(25)">Varchar</option>
                <option value="int">int</option>
            </select>
            PK
            <input type="checkbox" name="PK" value="ON" />

        </div>
                    <input type="submit" value="Añadir forma" onclick="addFile();" />

        <br><br>
        <input type="submit" value="crear" />
        <br>
        <br>

        

        Ver<br>
        Editar<br>
        Eliminar<br>

        <%             
            } else {
                out.println("<h2>Sesión no iniciada</h2>");
                out.println("<a href='index.jsp'>Inicia sesión</a>");
            }
        %>
    </body>
</html>
