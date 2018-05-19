/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author LBRENESV
 */
@WebService(serviceName = "MyWebService")
@Stateless()
public class MyWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertRow")
    public Boolean insertRow(@WebParam(name = "tableName") String tableName, @WebParam(name = "content") String content) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/omega", "root", "root");
            DatabaseMetaData meta = con.getMetaData();
            Statement query = con.createStatement();
            query.executeUpdate("INSERT INTO " + tableName + " VALUES=" + content + "");
            con.commit();
            con.close();
            return true;
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(MyWebService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(MyWebService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @WebMethod(operationName = "updateRow")
    public Boolean updateRow(@WebParam(name = "id") int id, @WebParam(name = "tableName") String tableName, @WebParam(name = "param") String param, @WebParam(name = "content") String content) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/omega", "root", "root");
            DatabaseMetaData meta = con.getMetaData();
            Statement query = con.createStatement();
            query.executeUpdate("UPDATE " + tableName + " SET " + param + "= " + content + " WHERE ID=" + id);
            con.commit();
            con.close();
            return true;
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(MyWebService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(MyWebService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createTable")
    public Boolean createTable(@WebParam(name = "tableStructure") String tableStructure) {
        try {
            //TODO write your implementation code here:
            //TODO write your implementation code here:

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con;

            con = DriverManager.getConnection("jdbc:derby://localhost:1527/omega",
                    "root", "root");

            Statement query = con.createStatement();

            String QueryString = tableStructure;
            query.executeUpdate(QueryString);

            //Crear el creador de tablas
            //INSERT
            System.out.println(QueryString);

            con.commit();
            con.close();
            return true;
            //query.executeUpdate(QueryString);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyWebService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteRow")
    public Boolean deleteRow(@WebParam(name = "id") int id, @WebParam(name = "tableName") String tableName) {
        //TODO write your implementation code here:
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/omega", "root", "root");
            DatabaseMetaData meta = con.getMetaData();
            Statement query = con.createStatement();
            query.executeUpdate("DELETE FROM " + tableName + " where ID=" + id + "");
            con.commit();
            con.close();

            return true;
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(MyWebService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(MyWebService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showTable")
    public String showTable(@WebParam(name = "name") String name, @WebParam(name = "tableName") String tableName) throws ClassNotFoundException {
        //TODO write your implementation code here:
        try {
            Object data;
            String result = "";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/omega", "root", "root");
            DatabaseMetaData meta = con.getMetaData();
            Statement query = con.createStatement();
            ResultSet rs = query.executeQuery("SELECT * FROM " + tableName);
            //rs.last();
            //ResultSetMetaData rsmd = rs.getMetaData();
            //int columnsNumber = rsmd.getColumnCount();
           
            while (rs.next()) {
                result = result+" Id: " + rs.getInt("id");
                
                result = result+" Name: " + rs.getString("name");
                }
            con.commit();
            con.close();
            System.out.println("done");
            return result;
                
            } catch (SQLException ex) {
            Logger.getLogger(MyWebService.class.getName()).log(Level.SEVERE, null, ex);
            return false+"";
        }   
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public String operation(@WebParam(name = "parameter") String parameter, @WebParam(name = "parameter1") String parameter1, @WebParam(name = "parameter2") String parameter2) {
        //TODO write your implementation code here:
        return "";
    }
}
