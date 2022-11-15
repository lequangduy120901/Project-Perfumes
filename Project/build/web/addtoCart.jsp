<%-- 
    Document   : add2Cart
    Created on : Oct 11, 2021, 2:15:53 PM
    Author     : Admin
--%>

<%@page import="model.DAOProduct"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id = request.getParameter("pid");
            Object value = session.getAttribute(id);
            Product pro = (Product) session.getAttribute(id);
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            if (quantity == 0) {
                out.println("<h1 style=\"color: red;text-align: center;\">Sold out</h1>");
            } else if (value == null) {
                DAOProduct dao = new DAOProduct();
                ResultSet rs = dao.getData("select * from Product where pid='" + id + "'");
                if (rs.next()) {
                    pro = new Product(rs.getString(1), rs.getString(2), 0, rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
                }
                out.println("<h1 style=\"color: green;text-align: center;\">Product id=" + id + " was added to the Shopping Cart</h1>");
                pro.setQuantity(1);
                session.setAttribute(id, pro);
            } else {
                if (pro.getQuantity() == quantity) {
                    out.println("<h1 style=\"color: red;text-align: center;\">Sold out</h1>");
                } else {
                    pro.setQuantity(pro.getQuantity() + 1);
                    session.setAttribute(id, pro);
                }
            }
            response.sendRedirect("showCart.jsp");%>
        <!--        <h2><a href="ControllerProductCusView?action=listAll">List Product</h2>
                <h2><a href="showCart.jsp">Show Shopping Cart</a></h2>-->
    </body>
</html>
