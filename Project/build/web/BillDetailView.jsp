<%-- 
    Document   : BillDetailView
    Created on : Oct 4, 2021, 2:09:59 PM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="model.DAOBillDetail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("rs");
        %>
        <a href="ControllerHome?action=listBill" style="margin-left: 450px; border: 1px solid black; background-color: #fed100; color: black; text-decoration: none; border-radius: 5px; margin-bottom: 10px; width: 150px">Back to Bill List</a><br>
        <table border="1" style="width: 1000px; border: 1px solid black; background-color: #EEEEEE">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Bill ID</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th>Update Quantity</th>
                </tr>
            </thead>
            <tbody>
                <%while (rs.next()) {%>
                <tr>
                    <td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getInt(3)%></td>
                    <td><%=rs.getDouble(4)%></td>
                    <td><%=rs.getDouble(5)%></td>
                    <td><a href="ControllerBillDetail?action=updatequantity&oid=<%=rs.getString(2)%>&pid=<%=rs.getString(1)%>">Change</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
