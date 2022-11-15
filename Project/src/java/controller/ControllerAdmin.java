/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.admin;
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
import model.DAOAdmin;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerAdmin", urlPatterns = {"/ControllerAdmin"})
public class ControllerAdmin extends HttpServlet {

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
            DAOAdmin dao = new DAOAdmin();
            String action = request.getParameter("action");
            if (action == null) {
                action = "listAll";
            }

            if (action.equals("listAll")) {
                ResultSet rs = dao.getData("select * from Admin");
                String title = "Admin List";
                request.setAttribute("rs", rs);
                request.setAttribute("title", title);
                Dispatcher(request, response, "/AdminView.jsp");
            }
            
            if (action.equals("login")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    Dispatcher(request, response, "AdminLogin.jsp");
                } else {
                    String user = request.getParameter("user");
                    String pass = request.getParameter("pass");
                    ResultSet rs = dao.getData("select * from Admin where username='" + user + "'");
                    if (dao.login(user, pass)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("us", user);
                        if (rs.next()) {
                            admin ad = new admin(rs.getInt(1), rs.getString(2), rs.getString(3));
                            session.setAttribute("ad", ad);
                        }
                        Dispatcher(request, response, "ControllerHome?action=listPro");
                    } else {
                        String mess = "Username or password is incorrect";
                        request.setAttribute("mess", mess);
                        Dispatcher(request, response, "/AdminLogin.jsp");
                    }
                }
            }

            if (action.equals("logout")) {
                HttpSession session = request.getSession();
                session.invalidate();
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/AdminLogin.jsp");
                disp.forward(request, response);
            }

            if (action.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String id = request.getParameter("adminid");
                    ResultSet rs = dao.getData("select * from Admin where adminid = '" + id + "'");
                    request.setAttribute("rs", rs);
                    Dispatcher(request, response, "/AdminUpdate.jsp");
                } else {
                    String oldpass = request.getParameter("oldpass");
                    String newpass = request.getParameter("newpass");
                    String repass = request.getParameter("renewpass");
                    String admin = request.getParameter("adminid");
                    int id = Integer.parseInt(admin);
                    if (oldpass.equals("") || oldpass == null || newpass.equals("") || newpass == null || repass.equals("") || repass == null) {
                        response.sendRedirect("ControllerAdmin");
                    } else if (!dao.checkpassword(id, oldpass)) {
                        response.sendRedirect("ControllerAdmin");
                    } else if (!newpass.equals(repass)) {
                        response.sendRedirect("ControllerAdmin");
                    } else {
                        dao.UpdatePassword(id, newpass);
                        response.sendRedirect("ControllerAdmin");
                    }
                }
            }
            
            if (action.equals("delete")) {
                String id = request.getParameter("adminid");
                dao.removeAdmin(Integer.parseInt(id));
                response.sendRedirect("ControllerAdmin");
            }
            
            if(action.equals("insert")) {
                String submit = request.getParameter("submit");
                if(submit == null) {
                    Dispatcher(request, response, "AdminInsert.jsp");
                } else {
                    String username = request.getParameter("user");
                    String password = request.getParameter("pass");
                    dao.insertAdmin(new entity.admin(1, username, password));
                    response.sendRedirect("ControllerAdmin");
                }
            }
            
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControllerAdmin</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControllerAdmin at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
