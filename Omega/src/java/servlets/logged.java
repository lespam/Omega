/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LBRENESV
 */
public class logged extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet logged</title>");           
            out.println("</head>");
            out.println("<body>");            
            HttpSession mysession = request.getSession();
            if (mysession.getAttribute("name") != null) {
                out.println("<h1>" + mysession.getAttribute("name") + " este es tu perfil</h1>");
                out.println("<hr>");
                out.println("<a href='SignOut'>Cerrar sesión</a><br>");

                //HttpSession mysession = request.getSession();
                //mysession.setAttribute("name", request.getParameter("name"));
                //mysession.setMaxInactiveInterval(20);
                //out.println("<a href='profile.jsp'>Visita tu perfil</a>");
                out.println("<form action=welcome.jsp>");
                out.println("<input type=\"submit\" name=\"create\" value=\"Create\" />");
                String nextJSP;
                RequestDispatcher dispatcher;
                if(request.getParameter("create")!=null){
                nextJSP = "/CreateTable";
                dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                dispatcher.include(request, response);
                }
                out.println("</form>");
                
                out.println("<form action=welcome.jsp>");
                out.println("<input type=\"submit\" name=\"view\" value=\"View\" />");

                if(request.getParameter("view")!=null){
                nextJSP = "/ViewTable";
                dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                dispatcher.include(request, response);
                }
                out.println("</form>");

                out.println("Editar tablas<br>");
                
                nextJSP = "/EditTable";
                dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                dispatcher.include(request, response);
                
                out.println("Eliminar tablas<br>");
                nextJSP = "/DeleteTable";
                dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                dispatcher.include(request, response);

            } else {
                out.println("<h2>Sesión no iniciada</h2>");
                out.println("<a href='index.jsp'>Inicia sesión</a>");
            }
        
            out.println("</body>");
            out.println("</html>");
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
