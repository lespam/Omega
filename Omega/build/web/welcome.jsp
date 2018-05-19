<%-- 
    Document   : welcome
    Created on : 28/02/2018, 07:22:15 PM
    Author     : sdist
--%>

<%@page import="java.sql.DatabaseMetaData"%>
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
            var html = 'Fieldname: <input type="text" name="field' + fieldId + '" />'
                    + ' Type <select name="type' + fieldId + '">'
                    + '<option value="varchar(25)">Varchar</option><option value="int">int</option>'
                    + '</select>'
                    + ' PK <input type="checkbox" name="PK' + fieldId + '" value="ON" />'
                    + '<a href="" onclick="javascript:removeElement(' + coml.concat("field", fieldId, coml) + '); return false;">Remove</a>';
            addElement('fields', 'p', 'field' + fieldId, html);
            //alert("Hello! I am an alert box!!");
            
            }

            function removeElement(elementId) {
            // Removes an element from the document
            var element = document.getElementById(elementId);
            element.parentNode.removeChild(element);
            }

            //global variable
            var query;
            function createTable(parentId)
            {
            alert("in");
            var inputs = document.getElementById(parentId).getElementsByTagName('input');
            var tablename = document.getElementById("tableName").value;
            var selects = document.getElementById(parentId).getElementsByTagName('select');
            query = "create table " + tablename + " (";
            for (var i = 0; i < inputs.length; i++) {
            //alert(i);
            var entero;
            if (inputs[i].type.toLowerCase() === "text") {
            entero = Math.floor((i + 1) / 2);
            query = query + inputs[i].value + " " + selects[entero].options[selects[entero].selectedIndex].value + ", ";
            //alert(query + "query");
            }
            //alert("sale");
            }

            //alert("entra");
            for (var j = 0; j < inputs.length; j++) {
            //alert("entra");
            if (inputs[j].type.toLowerCase() === "checkbox") {
            if (inputs[j].checked == true) {
            //alert("primary key("+inputs[i-1].value+")");
            query = query + " primary key(" + inputs[j - 1].value + ")";
            }
            }
            }
            //alert("END");
            query = query + ")";
            alert(query);
            var coml = "'";
            //document.getElementById("tableStructure").innerHTML = query;
            callRESTfulWebService(parentId,'POST','http://localhost:8080/Omega/webresources/MyPath?tableStructure='+query,'');

            }
            
            function postTablaHandler(xhr) {
        var xmlDoc = xhr.responseXML;
        console.log(xmlDoc);
        var root = xmlDoc.getElementsByTagName("username")[0].childNodes[0].nodeValue;
        document.getElementById("demo").innerHTML = root;
    }
            

var postTabla = function(params, types) {
                /*
                var genders = document.getElementsByName("gender");
                var i = 0;
                while(!genders[i].checked)
                    i++;
                var selected = genders[i].value;
        */
                var data = {
                    params: '',
                    types: '',
                    name: document.getElementById("nombretablas").value,
                    username: document.getElementById("usuario").innerHTML
                };
                
                for(var p in params){
                    data.params += params[p] + ',' ;
                    data.types += types[p] + ',';
                }
                data.params = data.params.substring(0, data.params.length -1);
                data.types = data.types.substring(0, data.types.length -1);
                /*
                var data = {
                    username: document.getElementById("username").value,
                    name: document.getElementById("name").value,
                    gender: selected,
                    pass: document.getElementById("pass").value,
                    phone: document.getElementById("phone").value
                };
                */
                //console.log(data);
                sendData("/Omega/webresources/MyPath", postTablaHandler, data, "POST");
            }

            function postTablaHandler(xhr) {
        var xmlDoc = xhr.responseXML;
        console.log(xmlDoc);
        var root = xmlDoc.getElementsByTagName("username")[0].childNodes[0].nodeValue;
        document.getElementById("demo").innerHTML = root;
    }

function sendData(url, handler, data, type) {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        handler(xhttp);
                    }
                };
                
                url = url + "?";
                for(var key in data){
                    url = url + key + "=" + data[key] + "&";
                }
                url = url.substring(0, url.length - 1);
                console.log(url);
                xhttp.open(type, url, true);
                xhttp.setRequestHeader("Content-type", "text/html");
                xhttp.send();
    }

            function callRESTfulWebService(id, method, target, msg) {
//                alert("entro");
            var ajaxRequest;
            if (window.XMLHttpRequest) {
            ajaxRequest = new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
            } else {
            ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
            }

            ajaxRequest.onreadystatechange = function () {
            //alert(ajaxRequest.readyState);
            //alert(ajaxRequest.status);

            if (ajaxRequest.readyState == 4 && (ajaxRequest.status == 200 || ajaxRequest.status == 204)) {


            //amount = (double)document.getElementById("amount").value;

            //rate = (double)document.getElementById("to").value / (double)document.getElementById("from").value;
            //alert(ajaxRequest.responseText);
            document.getElementById(id).innerHTML = ajaxRequest.responseText;
            }
            }
            ajaxRequest.open(method, target, true /*async*/);
            ajaxRequest.setRequestHeader("Content-Type", "text/html");
            ajaxRequest.send();
            }


        </script>

        <script>
            function callRESTfulWebService(id, method, target, msg) {
            var ajaxRequest;
            if (window.XMLHttpRequest) {
            ajaxRequest = new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
            } else {
            ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
            }
            ajaxRequest.onreadystatechange = function () {
            alert(ajaxRequest.readyState);
            if (ajaxRequest.readyState == 4 &&
                    (ajaxRequest.status == 200 || ajaxRequest.status == 204)) {
            alert("ajax ready");
            document.getElementById(id).innerHTML = ajaxRequest.responseText;
            }
            }
            ajaxRequest.open(method, target, true /*async*/);
            ajaxRequest.setRequestHeader("Content-Type", "text/html");
            ajaxRequest.send(msg);
            }
        </script>

        <br>
        <h3>Crear</h3>

        <br>
        Table name: <input type="text" name="input" id="tableName" value="" />
        <br><br>
        <div id="fields">
            <p id="field0">
                Fieldname: <input type="text" name="field0"/>
                Type
                <select name="type0">
                    <option value="varchar(25)">Varchar</option>
                    <option value="int">int</option>
                </select>
                PK
                <input type="checkbox" name="PK0" value="ON" />
            </p>
        </div>
        <input type="submit" value="Añadir forma" onclick="addFile();" />

        <br><br>
        <input type="submit" value="crear" onclick="createTable('fields');"/>

        <br>
        <br>
        <%

        %>

        <h4>Ver tablas </h4>
        <select name="tablasNombres">
            <%    Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/omega", "root", "root");
                DatabaseMetaData meta = con.getMetaData();
                ResultSet res = meta.getTables(null, null, null, new String[]{"TABLE"});
                System.out.println("List of tables: ");
                while (res.next()) {
                    out.println("<option value='" + res.getString("TABLE_NAME") + "'>" + res.getString("TABLE_NAME") + "</option>");
                }
                res.close();
            %>
        </select>

        <script>
            function showTable(parentId){
            alert("entra");
            var e = document.getElementById(parentId);
            var strUser = e.options[e.selectedIndex].text;
            var MySixthTable = strUser;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/omega",
                    "root", "root");
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT * FROM " + MySixthTable + ");

                    
                    int k = 0;
                    var columna = rs.getArray(k);
                var html = "";
            while (rs.next()) {
                
                for (var i = 0; i < columna.length; i++) {
                    html = html+rs.getObject(i);", ";
                }
                alert(html);
                k++;
                addElement('VistaTabla', 'p', 'fieldShown', html);
            }
            
           
        </script>
        <input type="submit" value="Ver tabla" onclick="showTable('tablasNombres');" />
        <div id="VistaTabla">

        </div>
        <%
            } else {
                out.println("<h2>Sesión no iniciada</h2>");
                out.println("<a href='index.jsp'>Inicia sesión</a>");
            }
        %>
    </body>
</html>
