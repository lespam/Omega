/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LesPam
 */
public class SignUp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/omega;create=true;",
                    "root", "root");
            Statement query = con.createStatement();
            try{
            String QueryString = "create table omega (id int not null, name "
                    + "varchar(25),password varchar(20), primary key(id))";
            query.executeUpdate(QueryString);
            query.executeUpdate("INSERT INTO OMEGA VALUES (1, 'admin', 'admin')");
            
            //Crear el creador de tablas
            QueryString = "create table usertables (id int not null, user_id int,table_id int, primary key(id))";
            query.executeUpdate(QueryString);
            query.executeUpdate("INSERT INTO OMEGA VALUES (1, 'admin', 'admin')");
            }
            catch( SQLException e ) {
                
            }
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            int id = (int)timestamp.getTime();
            out.println();
            
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            con =
            DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/omega",
                    "root",
                    "root");
            
            if(request.getParameter("ADD")!=null){
            query.executeUpdate("INSERT INTO ROOT.OMEGA VALUES ("+id+", '"+name+"', '"+password+"')");
            query.executeUpdate("INSERT INTO ROOT.OMEGA VALUES ("+id+", '"+name+"', '"+password+"')");
            
            }
            
            ResultSet rs = query.executeQuery("SELECT * FROM OMEGA");
            out.println("<p>");
            while (rs.next()) {
                out.println("<BR>Id: " + rs.getInt("id"));
                out.println(" Name: " + rs.getString("name"));
                
            }
            
           con.commit();
           con.close();
           
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
