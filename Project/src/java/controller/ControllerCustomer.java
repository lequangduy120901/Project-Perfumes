/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOCustomer;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerCustomer", urlPatterns = {"/ControllerCustomer"})
public class ControllerCustomer extends HttpServlet {

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
            DAOCustomer dao = new DAOCustomer();
            String action = request.getParameter("action");
            if (action == null) {
                action = "listAll";
            }

            if (action.equals("listAll")) {
                ResultSet rs = dao.getData("select * from Customer");
                String title = "Customer List";
                request.setAttribute("rs", rs);
                request.setAttribute("title", title);
                Dispatcher(request, response, "/CustomerView.jsp");
            }

            if (action.equals("login")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    Dispatcher(request, response, "Login.jsp");
                } else {
                    String user = request.getParameter("user");
                    String pass = request.getParameter("pass");
                    ResultSet rs = dao.getData("select * from Customer where username='" + user + "'");
                    if (dao.login(user, pass)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("us", user);
                        if (rs.next()) {
                            Customer cus = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                            session.setAttribute("user", cus);
                        }
                        response.sendRedirect("ControllerProductCusView");
                    } else {
                        String mess = "Username or password is incorrect";
                        request.setAttribute("mess", mess);
                        Dispatcher(request, response, "/Login.jsp");
                    }
                }
            }

            if (action.equals("logout")) {
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("ControllerProductCusView");
            }
            
            if (action.equals("changepassword")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    Dispatcher(request, response, "/ForgetPassword.jsp");
                } else {
                    String newpass = request.getParameter("newpass");
                    String repass = request.getParameter("renewpass");
                    String user = request.getParameter("user");
                    if (newpass.equals("") || newpass == null || repass.equals("") || repass == null) {
                        response.sendRedirect("ControllerCustomer?action=changepassword");
                    } else if (!newpass.equals(repass)) {
                        response.sendRedirect("ControllerCustomer?action=changepassword");
                    } else {
                        dao.UpdatePassword(user, newpass);
                        response.sendRedirect("ControllerCustomer?action=login");
                    }
                }
            }

            if (action.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String cid = request.getParameter("cid");
                    ResultSet rs = dao.getData("Select * from Customer where cid = '" + cid + "'");
                    request.setAttribute("rs", rs);
                    Dispatcher(request, response, "/CustomerUpdate.jsp");
                } else {
                    String cid = request.getParameter("cid");
                    String cname = request.getParameter("cname");
                    String cphone = request.getParameter("phone");
                    String cAddress = request.getParameter("add");
                    String username = request.getParameter("user");
                    String password = request.getParameter("pass");
                    int status = Integer.parseInt(request.getParameter("status"));

                    if (cname.equals("") || cname == null || username.equals("") || username == null
                            || password.equals("") || password == null) {
                        response.sendRedirect("ControllerCustomer");
                    }
                    if (dao.checkUnique1(username) == false) {
                        response.sendRedirect("ControllerCustomer");
                    }
                    if (cname.length() > 30 || cphone.length() > 30 || cAddress.length() > 100
                            || username.length() > 30 || password.length() > 32 || password.length() < 8) {
                        response.sendRedirect("ControllerCustomer");
                    }
                    entity.Customer obj = new entity.Customer(Integer.parseInt(cid), cname, cphone, cAddress, username, password, status);
                    dao.updateCustomer(obj);
                    response.sendRedirect("ControllerHome?action=listCus");
                }
            }

            if (action.equals("delete")) {
                int cid = Integer.parseInt(request.getParameter("cid"));
                dao.removeCustomer(cid);
                response.sendRedirect("ControllerHome?action=listCus");
            }

            if (action.equals("insert")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    Dispatcher(request, response, "/CustomerInsert.jsp");
                } else {
                    String cname = request.getParameter("cname");
                    String cphone = request.getParameter("phone");
                    String cAddress = request.getParameter("add");
                    String username = request.getParameter("user");
                    String password = request.getParameter("pass");
//                    int status = Integer.parseInt(request.getParameter("status"));
                    
                    if (dao.checkUnique1(username   ) == false) {
                        response.sendRedirect("ControllerCustomer");
                    }
                    if (cname.length() > 30 || cphone.length() > 30 || cAddress.length() > 100
                            || username.length() > 30 || password.length() > 32 || password.length() < 8) {
                        response.sendRedirect("ControllerCustomer");
                    }
                    
                    entity.Customer obj = new entity.Customer(1, cname, cphone, cAddress, username, password, 1);
                    dao.insertCustomer(obj);
                    response.sendRedirect("ControllerCustomer?action=login");
                }
            }

            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerCustomer</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerCustomer at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCustomer.class.getName()).log(Level.SEVERE, null, ex);
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
