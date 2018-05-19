/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stuff;

import java.util.logging.Level;
import java.util.logging.Logger;
import webservicecli.ClassNotFoundException_Exception;


/**
 *
 * @author LesPam
 */
public class pruebaSoap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("probando");
        //String query = "create table tabla2 (id int, amigos varchar(25),  primary key(id))";
        
            //System.out.println(createTable(query)+"");
            String query = "LesPam";
            
            System.out.println(hello(query));
        query = "create table prue2ebdeiTa2 (id int, amigos varchar(25),  primary key(id))";
        System.out.println(createTable(query)+"");
        String tableName= "OMEGA";
        int id =1827967288;
        System.out.println(deleteRow(id, tableName)+"");
        String name = tableName;
        try {
            System.out.println(showTable(name, tableName));
        } catch (ClassNotFoundException_Exception ex) {
            Logger.getLogger(pruebaSoap.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("errores");
        }
        
        System.out.println("probando");
    }

    private static Boolean createTable(java.lang.String tableStructure) {
        webservicecli.MyWebService_Service service = new webservicecli.MyWebService_Service();
        webservicecli.MyWebService port = service.getMyWebServicePort();
        return port.createTable(tableStructure);
    }

    private static String hello(java.lang.String name) {
        webservicecli.MyWebService_Service service = new webservicecli.MyWebService_Service();
        webservicecli.MyWebService port = service.getMyWebServicePort();
        return port.hello(name);
    }

    private static Boolean deleteRow(int id, java.lang.String tableName) {
        webservicecli.MyWebService_Service service = new webservicecli.MyWebService_Service();
        webservicecli.MyWebService port = service.getMyWebServicePort();
        return port.deleteRow(id, tableName);
    }

    private static String showTable(java.lang.String name, java.lang.String tableName) throws ClassNotFoundException_Exception {
        webservicecli.MyWebService_Service service = new webservicecli.MyWebService_Service();
        webservicecli.MyWebService port = service.getMyWebServicePort();
        return port.showTable(name, tableName);
    }

    


    
    
}
