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
import model.DAOProduct;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerProductAdView", urlPatterns = {"/ControllerProductAdView"})
public class ControllerProduct extends HttpServlet {

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
            DAOProduct dao = new DAOProduct();
            String action = request.getParameter("action");

            if (action.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String pid = request.getParameter("pid");
                    ResultSet rs2 = dao.getData("select * from Category join Product on Category.cateID=Product.cateID where pid = '" + pid + "'");
                    ResultSet rs = dao.getData("select * from Product where pid = '" + pid + "'");
                    request.setAttribute("rs", rs);
                    request.setAttribute("rs2", rs2);
                    ResultSet rsCate = dao.getData("select * from Category");
                    request.setAttribute("rsCate", rsCate);
                    Dispatcher(request, response, "/ProductUpdate.jsp");
                } else {
                    //code update here
                    String pid = request.getParameter("pid");
                    String pname = request.getParameter("pname");
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    double price = Double.parseDouble(request.getParameter("price"));
                    String image = request.getParameter("img");
                    String des = request.getParameter("description");
                    int status = Integer.parseInt(request.getParameter("sts"));
                    int cateID = Integer.parseInt(request.getParameter("cateID"));

                    if (pid.length() > 30 || pname.length() > 100 || image.length() > 100) {
                        response.sendRedirect("ControllerProductAdView?action=update");
                    } else if (quantity < 0 || price < 0) {
                        response.sendRedirect("ControllerProductAdView?action=update");
                    } else if (pid.equals("") || pid == null || pname.equals("") || pname == null || image.equals("")
                            || image == null || des.equals("") || des == null) {
                        response.sendRedirect("ControllerProductAdView?action=update");
                    }
                    dao.updateProduct(new entity.Product(pid, pname, quantity, price, image, des, status, cateID));
                    response.sendRedirect("ControllerHome?action=listPro");
//                    Dispatcher(request, response, "/ControllerProduct");
                }
            }

            if (action.equals("delete")) {
                String pid = request.getParameter("pid");
                dao.removeProduct(pid);
                response.sendRedirect("ControllerHome?action=listPro");
            }

            if (action.equals("insert")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    ResultSet rsCate = dao.getData("select * from Category");
                    request.setAttribute("rsCate", rsCate);
                    Dispatcher(request, response, "/ProductInsert.jsp");
                } else {
                    String pid = request.getParameter("pid");
                    String pname = request.getParameter("pname");
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    double price = Double.parseDouble(request.getParameter("price"));
                    String image = request.getParameter("img");
                    String des = request.getParameter("description");
                    int status = Integer.parseInt(request.getParameter("status"));
                    int cateID = Integer.parseInt(request.getParameter("cateID"));

                    if (pid.length() > 30 || pname.length() > 100 || image.length() > 100) {
                        response.sendRedirect("ControllerProductAdView?action=insert");
                    } else if (quantity < 0 || price < 0) {
                        response.sendRedirect("ControllerProductAdView?action=insert");
                    } else if (pid.equals("") || pid == null || pname.equals("") || pname == null || image.equals("")
                            || image == null || des.equals("") || des == null) {
                        response.sendRedirect("ControllerProductAdView?action=insert");
                    }
                    dao.insertProduct(new entity.Product(pid, pname, quantity, price, image, des, status, cateID));
                    response.sendRedirect("ControllerHome?action=listPro");
                }
            }

            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerProduct</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerProduct at " + request.getContextPath() + "</h1>");
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
