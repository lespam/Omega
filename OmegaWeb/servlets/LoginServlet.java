package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sdist
 */
public class LoginServlet extends HttpServlet {

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
//            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DataPresenter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Checking...");
//            String nextJSP = "/link.html";
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//            dispatcher.include(request, response);
//            
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            
//            
//            if(request.getParameter("password").equals("abc")){
//                //Send to welcome
//                out.println("You're successfully logged in!");
//                out.println("Welcome "+request.getParameter("name"));
//
//            }
//            else{
//                out.println("Sorry! Wrong username or password! Try again");
//                
//                nextJSP = "/login.html";
//                dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//                dispatcher.include(request, response);
//                
//            }
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Class.forName("org.apache.derby.jdbc.ClientDriver");

            Connection con
                    = DriverManager.getConnection(
                            "jdbc:derby://localhost:1527/omega",
                            "root",
                            "root");

            Statement query = con.createStatement();

            ResultSet rs = query.executeQuery("SELECT * FROM ROOT.USERS WHERE USERNAME = '" + username + "'");
            out.println("buscando");

            if (!rs.next()) {
                out.println("nuexiste");
            } else {
                if (rs.next()) {
                    out.println("siexiste");
                    String db_username = rs.getString("USERNAME");
                    String db_password = rs.getString("PASSWORD");
                    out.println("Userame: " + db_username);
                    out.println("Password: " + db_password);
                }
            }
            out.println("</body>");
            out.println("</html>");
            //String next = "/welcome.jsp";

            //RequestDispatcher dispatcher
            //        = getServletContext().getRequestDispatcher(next);
            //dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
