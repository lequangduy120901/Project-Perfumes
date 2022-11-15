<%-- 
    Document   : listProduct
    Created on : 12-10-2021, 20:59:56
    Author     : a
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
//        DAOProduct daoP = new DAOProduct();
//        ResultSet rs = daoP.getData("Select * from Product");
            ResultSet rs = (ResultSet) request.getAttribute("rs");           
        %>
        <h2><a  href="showCart.jsp">Show Shopping Cart</a></h2>
        <table border="1">
            <caption style="font-size: 30px;"><%="List Product"%></caption>
            <thead>
                <tr>
                    <th>Pid</th>
                    <th>Pname</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>CateID</th>
                    <th>AddToCart</th>
                </tr>
            </thead>
            <tbody>
                <%while (rs.next()) {%>                                                                               
                <tr>
                    <td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getString(4)%></td>
                    <td><%=rs.getString(5)%></td>
                    <td><%=rs.getString(6)%></td>
                    <td><%=(rs.getInt(7) == 1 ? "Active" : "DeActive")%></td>
                    <td><%=rs.getString(10)%></td>                                      
                    <td><a href="addtoCart.jsp?pid=<%=rs.getString(1)%>">Add</a></td>                     
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
