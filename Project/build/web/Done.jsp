<%-- 
    Document   : Done
    Created on : Oct 14, 2021, 3:03:05 PM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="entity.BillDetail"%>
<%@page import="model.DAOBillDetail"%>
<%@page import="entity.Bill"%>
<%@page import="entity.Customer"%>
<%@page import="model.DAOBill"%>
<%@page import="entity.Product"%>
<%@page import="model.DAOProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/checkout.css" rel="stylesheet" type="text/css"/> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String oid = (String) request.getAttribute("oid");
            String date = (String) request.getAttribute("date");
            String name = (String) request.getAttribute("name");
            String phone = (String) request.getAttribute("phone");
            String add = (String) request.getAttribute("add");
            DAOBill daoB = new DAOBill();
            DAOProduct dao = new DAOProduct();
            DAOBillDetail daoBD = new DAOBillDetail();
            String mess = null;
            double sum = 0;
            java.util.Enumeration em = session.getAttributeNames(); //is map
            ResultSet rs = dao.getData("Select * from Bill");
            while (rs.next()) {
                if (rs.getString(1).equals(oid)) {
                    mess = "Bill ID has already exist!";
                    request.setAttribute("mess", mess);
                    RequestDispatcher disp = request.getRequestDispatcher("/checkout.jsp");
                    disp.forward(request, response);
                }
            }
            if (mess == null) {
                while (em.hasMoreElements()) {
                    String id = em.nextElement().toString(); //get key
                    if (!id.equals("user") && !id.equals("us")) {
                        Product pro1 = (Product) session.getAttribute(id);
                        sum += pro1.getPrice() * pro1.getQuantity();
                        dao.updateQuantity(id, -pro1.getQuantity());
                    }
                    if (id.equals("user")) {
                        Customer cus = (Customer) session.getAttribute(id);
                        if (date == null || date.equals("")) {
                            daoB.insertBill1(new Bill(oid, date, name, phone, add, sum, 1, cus.getCid()));
                        } else {
                            daoB.insertBill(new Bill(oid, date, name, phone, add, sum, 1, cus.getCid()));
                        }
                    }
                }
                java.util.Enumeration em2 = session.getAttributeNames();
                while (em2.hasMoreElements()) {
                    String id = em2.nextElement().toString();
                    if (!id.equals("user") && !id.equals("us")) {
                        Product pro1 = (Product) session.getAttribute(id);
                        daoBD.insertBillDetail(new BillDetail(id, oid, pro1.getQuantity(), pro1.getPrice(), pro1.getQuantity() * pro1.getPrice()));
                        session.removeAttribute(id);
                    }
                }
                response.sendRedirect("ControllerProductCusView");
            }
        %>
    </body>
</html>
