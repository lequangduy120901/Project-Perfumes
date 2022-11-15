/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOCategory;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerCategory", urlPatterns = {"/ControllerCategory"})
public class ControllerCategory extends HttpServlet {

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
            DAOCategory dao = new DAOCategory();
            String action = request.getParameter("action");
            if (action == null) {
                action = "listAll";
            }

            if (action.equals("listAll")) {
                ResultSet rs = dao.getData("select * from Category");
                String title = "Category List";
                request.setAttribute("rs", rs);
                request.setAttribute("title", title);
                Dispatcher(request, response, "/CategoryView.jsp");
            }

            if (action.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String id = request.getParameter("cateID");
                    ResultSet rs = dao.getData("Select * from Category where cateID = '" + id + "'");
                    request.setAttribute("rs", rs);
                    Dispatcher(request, response, "CategoryUpdate.jsp");
                } else {
                    String id = request.getParameter("cateID");
                    String name = request.getParameter("cateName");
                    int status = Integer.parseInt(request.getParameter("status"));
                    if (name == null || name.equals("") || name.length() > 50) {
                        response.sendRedirect("ControllerCategory");
                    }
                    dao.UpdateCategory(new entity.Category(Integer.parseInt(id), name, status));
                    response.sendRedirect("ControllerCategory");
                }
            }

            if (action.equals("delete")) {
                String id = request.getParameter("cateID");
                dao.removeCategory(Integer.parseInt(id));
                response.sendRedirect("ControllerCategory");
            }

            if (action.equals("insert")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    Dispatcher(request, response, "CategoryInsert.jsp");
                } else {
                    String cateName = request.getParameter("cateName");
                    int status = Integer.parseInt(request.getParameter("status"));

                    if (cateName == null || cateName.equals("") || cateName.length() > 50) {
                        response.sendRedirect("ControllerCategory");
                    } else {
                        dao.insertCategory(new entity.Category(1, cateName, status));
                        response.sendRedirect("ControllerCategory");
                    }
                }
            }

            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerCategory</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerCategory at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        }
    }

    public void Dispatcher(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
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
