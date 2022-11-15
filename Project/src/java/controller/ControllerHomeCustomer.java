/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Product;
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
import model.DAOProduct;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ControllerProductCusView", urlPatterns = {"/ControllerProductCusView"})
public class ControllerHomeCustomer extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            DAOProduct dao = new DAOProduct();
            String action = request.getParameter("action");
            if (action == null) {
                action = "listAll";
            }

            if (action.equals("listAll")) {
                // model
                ResultSet rs = dao.getData("select * from Product join Category on Category.cateID = Product.cateID");
                ResultSet rsCate = dao.getData("select * from Category");
                // some information
                String title = "Product List";
                // data view
                request.setAttribute("rs", rs);
                request.setAttribute("rsCate", rsCate);
                request.setAttribute("title", title);
                // select view
                RequestDispatcher disp = request.getRequestDispatcher("/ProductCusView.jsp");
                // run
                disp.forward(request, response);
            }

            if (action.equals("checkout")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    Dispatcher(request, response, "/checkout.jsp");
                } else {
                    String oid = request.getParameter("oID");
                    String date = request.getParameter("dateCreate");
                    String name = request.getParameter("cname");
                    String phone = request.getParameter("cphone");
                    String add = request.getParameter("cAddress");
                    request.setAttribute("oid", oid);
                    request.setAttribute("date", date);
                    request.setAttribute("name", name);
                    request.setAttribute("phone", phone);
                    request.setAttribute("add", add);
                    Dispatcher(request, response, "/Done.jsp");
                }
            }

            if (action.equals("updateCart")) {
                String pid = request.getParameter("pid");
                String submit = request.getParameter("submit");
                HttpSession session = request.getSession();
                java.util.Enumeration em = session.getAttributeNames();
                Product pro = null;
                if (submit == null) {
                    Dispatcher(request, response, "/showCart.jsp");
                }
                if (submit.equals("+")) {
                    while (em.hasMoreElements()) {
                        String id = em.nextElement().toString();
                        ResultSet rsProduct = dao.getData("select quantity from product where pid='" + id + "'");
                        if (!id.equals("user") && !id.equals("us") && id.equals(pid)) {
                            pro = (Product) session.getAttribute(id);
                            if (rsProduct.next()) {
                                if (rsProduct.getInt(1) == pro.getQuantity()) {
                                    pro.setQuantity(rsProduct.getInt(1));
                                } else {
                                    pro.setQuantity(pro.getQuantity() + 1);
                                }
                            }
                            session.setAttribute(id, pro);
                            Dispatcher(request, response, "/showCart.jsp");
                        }
                    }
                }
                if (submit.equals("-")) {
                    while (em.hasMoreElements()) {
                        String id = em.nextElement().toString();
                        ResultSet rsProduct = dao.getData("select quantity from product where pid='" + id + "'");
                        if (!id.equals("user") && !id.equals("us") && id.equals(pid)) {
                            pro = (Product) session.getAttribute(id);
                            if (rsProduct.next()) {
                                if (pro.getQuantity() <= 1) {
                                    pro.setQuantity(1);
                                } else {
                                    pro.setQuantity(pro.getQuantity() - 1);
                                }
                            }
                            session.setAttribute(id, pro);
                            Dispatcher(request, response, "/showCart.jsp");
                        }
                    }
                }
            }

            if (action.equals("searchCate")) {
                ResultSet rs = null;
                String id = request.getParameter("cateid");
                if (id == null || id.equals("")) {
                    rs = dao.getData("select * from Product");
                } else {
                    rs = dao.getData("select * from Product where cateID = '" + id + "'");
                }
                request.setAttribute("caID", id);
                request.setAttribute("rs", rs);
                ResultSet rsCate = dao.getData("Select * from Category");
                request.setAttribute("rsCate", rsCate);
                RequestDispatcher disp = request.getRequestDispatcher("/ProductCusView.jsp");
                disp.forward(request, response);
            }

            if (action.equals("searchName")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    response.sendRedirect("ControllerProductCusView");
                } else {
                    String name = request.getParameter("sname");
                    ResultSet rs = dao.getData("select * from Product where pname like '%" + name + "%'");
                    request.setAttribute("rs", rs);
                    ResultSet rsCate = dao.getData("Select * from Category");
                    request.setAttribute("rsCate", rsCate);
                    Dispatcher(request, response, "/ProductCusView.jsp");
                }
            }
            
            if (action.equals("sort")) {
                String type = request.getParameter("type");
                String cateID = request.getParameter("cateID");
                ResultSet rsCate = dao.getData("select * from Category");
                String sql = "select * from Product ";
                if(cateID != null){
                    sql += "where cateID = "+cateID+ " ";
                }
                if (type.equals("1")) {
                    sql += "order by price ASC";
                }
                if (type.equals("2")) {
                    sql += "order by price DESC";
                }
                if (type.equals("3") && cateID != null) {
                    String Pfrom = request.getParameter("Pfrom");
                    String Pto = request.getParameter("Pto");
                    if (Pfrom.equals("") && !Pto.equals("")) {
                        sql += " and price between 0 and " + Pto;
                    }
                    else if (Pto.equals("") && !Pfrom.equals("")) {
                        sql += " and price >= " + Pfrom;
                    }
                    else if (Pto.equals("") && Pfrom.equals("")) {
                        sql += "";
                    }
                    else {
                        sql += " and price between " + Pfrom + " and " + Pto;
                    }
                }
                if (type.equals("3") && cateID == null) {
                    String Pfrom = request.getParameter("Pfrom");
                    String Pto = request.getParameter("Pto");
                    if (Pfrom.equals("") && !Pto.equals("")) {
                        sql += " where price between 0 and " + Pto;
                    }
                    else if (Pto.equals("") && !Pfrom.equals("")) {
                        sql += " where price >= " + Pfrom;
                    }
                    else if (Pto.equals("") && Pfrom.equals("")) {
                        sql += "";
                    }
                    else {
                        sql += " where price between " + Pfrom + " and " + Pto;
                    }
                }
                ResultSet rs = dao.getData(sql);
                request.setAttribute("rs", rs);
                request.setAttribute("rsCate", rsCate);
                request.setAttribute("caID", cateID);
                RequestDispatcher disp = request.getRequestDispatcher("/ProductCusView.jsp");
                disp.forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControllerHomeCustomer.class.getName()).log(Level.SEVERE, null, ex);
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
