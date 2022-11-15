<%-- 
Document   : ProductView
Created on : Oct 4, 2021, 1:27:23 PM
Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.DAOProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            ResultSet rsProduct = (ResultSet) request.getAttribute("rsProduct");
        %>
        <a href="ControllerHome?action=insertPro" style="margin-left: 450px; border: 1px solid black; background-color: #fed100; color: black; text-decoration: none; border-radius: 5px; margin-bottom: 10px; width: 150px">Insert Product</a>
        <table border="1" style="width: 1000px; border: 1px solid black; background-color: #EEEEEE">
            <thead>
                <tr>
                    <th>PID</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Category name</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%while (rsProduct.next()) {%>
                <tr>
                    <td><%=rsProduct.getString(1)%></td>
                    <td><%=rsProduct.getString(2)%></td>
                    <td><%=rsProduct.getString(3)%></td>
                    <td><%=rsProduct.getString(4)%></td>
                    <td><img style="width: 50px; height: 50px;" src="<%=rsProduct.getString(5)%>"></td>
                    <td><%=rsProduct.getString(6)%></td>
                    <td><%=(rsProduct.getInt(7) == 1 ? "Enable" : "Disable")%></td>
                    <td><%=rsProduct.getString(10)%></td>
                    <td><a href="ControllerHome?action=updatePro&pid=<%=rsProduct.getString(1)%>"</a>Update</td>
                    <td><a href="ControllerProductAdView?action=delete&pid=<%= rsProduct.getString(1)%>"</a>Delete</td>
                </tr>
                <%}%>
        </table>
    </body>
</html>
