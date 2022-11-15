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
import javax.servlet.http.HttpSession;
import model.DAOAdmin;
import model.DAOBill;
import model.DAOCustomer;
import model.DAOProduct;
import model.DBConnect;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerHome", urlPatterns = {"/ControllerHome"})
public class ControllerHomeAdmin extends HttpServlet {

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
            DBConnect dao = new DBConnect();
            DAOAdmin daoA = new DAOAdmin();
            DAOProduct daoPro = new DAOProduct();
            DAOCustomer daoCus = new DAOCustomer();
            DAOBill daoB = new DAOBill();
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            if (action == null) {
                action = "login";
            }

            if (action.equals("login")) {
                RequestDispatcher disp = request.getRequestDispatcher("ControllerAdmin?action=login");
                disp.forward(request, response);
            }

            if (action.equals("listPro")) {
                ResultSet rsProduct = dao.getData("select * from Product join Category on Category.cateID = Product.cateID");
                request.setAttribute("rsProduct", rsProduct);
                request.setAttribute("action", action);
                RequestDispatcher disp = request.getRequestDispatcher("/HomeAdmin.jsp");
                disp.forward(request, response);
            }

            if (action.equals("listCus")) {
                ResultSet rsCustomer = dao.getData("select * from Customer");
                request.setAttribute("rsCustomer", rsCustomer);
                request.setAttribute("action", action);
                RequestDispatcher disp = request.getRequestDispatcher("/HomeAdmin.jsp");
                disp.forward(request, response);
            }

            if (action.equals("listBill")) {
                ResultSet rsBill = dao.getData("select * from Bill");
                request.setAttribute("rsBill", rsBill);
                request.setAttribute("action", action);
                RequestDispatcher disp = request.getRequestDispatcher("/HomeAdmin.jsp");
                disp.forward(request, response);
            }

            if (action.equals("listBill2")) {
                ResultSet rsBill = dao.getData("select * from Bill where status=1");
                request.setAttribute("rsBill", rsBill);
                request.setAttribute("action", action);
                RequestDispatcher disp = request.getRequestDispatcher("/HomeAdmin.jsp");
                disp.forward(request, response);
            }

            if (action.equals("updateBill2")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String oid = request.getParameter("oid");
                    ResultSet rsBill = dao.getData("select * from Bill");
                    request.setAttribute("rsBill", rsBill);
                    ResultSet rs = dao.getData("Select status from Bill where oID = '" + oid + "'");
                    request.setAttribute("rs", rs);
                    request.setAttribute("action", action);
                    RequestDispatcher disp = request.getRequestDispatcher("/HomeAdmin.jsp");
                    disp.forward(request, response);
                } else {
                    
                }
            }

            if (action.equals("updatePro")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.setAttribute("action", action);
                    String pid = request.getParameter("pid");
                    ResultSet rs2 = dao.getData("select * from Category join Product on Category.cateID=Product.cateID where pid = '" + pid + "'");
                    ResultSet rs = dao.getData("select * from Product where pid = '" + pid + "'");
                    request.setAttribute("rs", rs);
                    request.setAttribute("rs2", rs2);
                    ResultSet rsCate = dao.getData("select * from Category");
                    request.setAttribute("rsCate", rsCate);
                    Dispatcher(request, response, "/HomeAdmin.jsp");
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
                        response.sendRedirect("ControllerHome?action=updatePro");
                    } else if (quantity < 0 || price < 0) {
                        response.sendRedirect("ControllerHome?action=updatePro");
                    } else if (pid.equals("") || pid == null || pname.equals("") || pname == null || image.equals("")
                            || image == null || des.equals("") || des == null) {
                        response.sendRedirect("ControllerHome?action=updatePro");
                    }
                    daoPro.updateProduct(new entity.Product(pid, pname, quantity, price, image, des, status, cateID));
                    response.sendRedirect("ControllerHome?action=listPro");
                }
            }

            if (action.equals("updateCus")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.setAttribute("action", action);
                    String cid = request.getParameter("cid");
                    ResultSet rs = dao.getData("Select * from Customer where cid = '" + cid + "'");
                    request.setAttribute("rs", rs);
                    Dispatcher(request, response, "/HomeAdmin.jsp");
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
                        response.sendRedirect("ControllerHome?action=updateCus");
                    }
                    if (daoCus.checkUnique1(username) == false) {
                        response.sendRedirect("ControllerHome?action=updateCus");
                    }
                    if (cname.length() > 30 || cphone.length() > 30 || cAddress.length() > 100
                            || username.length() > 30 || password.length() > 32 || password.length() < 8) {
                        response.sendRedirect("ControllerHome?action=updateCus");
                    }
                    entity.Customer obj = new entity.Customer(Integer.parseInt(cid), cname, cphone, cAddress, username, password, status);
                    daoCus.updateCustomer(obj);
                    response.sendRedirect("ControllerHome?action=listCus");
                }
            }

            if (action.equals("updateBill")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.setAttribute("action", action);
                    String oid = request.getParameter("oid");
                    ResultSet rs = dao.getData("select * from Bill where oid = '" + oid + "'");
                    request.setAttribute("rs", rs);
                    Dispatcher(request, response, "/HomeAdmin.jsp");
                } else {
                    String oid = request.getParameter("oid");
                    int status = Integer.parseInt(request.getParameter("sts"));
                    daoB.changeStatus(oid, status);
                    response.sendRedirect("ControllerHome?action=listBill");
                }
            }

            if (action.equals("listDetail")) {
                String oid = request.getParameter("oid");
                ResultSet rs = dao.getData("select * from BillDetail where oid ='" + oid + "'");
                request.setAttribute("rs", rs);
                request.setAttribute("action", action);
                Dispatcher(request, response, "/HomeAdmin.jsp");
            }

            if (action.equals("insertPro")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.setAttribute("action", action);
                    ResultSet rsCate = dao.getData("select * from Category");
                    request.setAttribute("rsCate", rsCate);
                    Dispatcher(request, response, "/HomeAdmin.jsp");
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
                    daoPro.insertProduct(new entity.Product(pid, pname, quantity, price, image, des, status, cateID));
                    response.sendRedirect("ControllerProductAdView");
                }
            }

            if (action.equals("insertAd")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.setAttribute("action", action);
                    Dispatcher(request, response, "/HomeAdmin.jsp");
                } else {
                    String username = request.getParameter("user");
                    String password = request.getParameter("pass");
                    daoA.insertAdmin(new entity.admin(1, username, password));
                    response.sendRedirect("ControllerAdmin");
                }
            }
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
