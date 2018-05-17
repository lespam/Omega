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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sdist
 */
public class DataExtractor extends HttpServlet {
    private Object[][] ResultSetToArray(ResultSet rs) {
        Object data[][]=null;
        try{
        rs.last();
        ResultSetMetaData rsmd = rs.getMetaData();
        int numCols = rsmd.getColumnCount();
        int numRows =rs.getRow();
        data=new Object[numRows][numCols];
        int j = 0;
        rs.beforeFirst();
        while (rs.next()){
        for (int i=0;i<numCols;i++){
        data[j][i]=rs.getObject(i+1);
        }
        j++;
        }
        }
        catch(Exception e){
        System.out.println(e);
        }
        return data;
    }
    
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
            HttpSession mySession = request.getSession();
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con =
            DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/myfirstdatabase",
                    "root",
                    "root");
            
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
            
            ResultSet rs = st.executeQuery("SELECT * FROM APP.CUSTOMERS");
            
           
            
            Object myResultSet[][] = ResultSetToArray(rs);
            mySession.setAttribute("resultSet", myResultSet);
            
            //String next = "/scroll.jsp";

            //RequestDispatcher dispatcher =
            //getServletContext().getRequestDispatcher(next);

            //dispatcher.forward(request,response);
            
            //out.println("ID: "+ myResultSet[0][0]);
            //out.println("NAME: "+ myResultSet[0][1]); 
                        
            mySession.setAttribute("row", 0);
            con.commit();
            con.close();
            
            String next = "/scroll.jsp";

            RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(next);

            dispatcher.forward(request,response);

            
            /*rs.previous();
            rs.first();
            rs.isFirst();
            rs.last();
            rs.isLast();
            rs.next();
            //rs.absolute(int row);
            rs.getRow();
            //rs.getColumnCount() ;
            */
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataExtractor.class.getName()).log(Level.SEVERE, null, ex);
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


