<%-- 
    Document   : CategoryBill
    Created on : Oct 4, 2021, 2:03:42 PM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="model.DAOBill"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            ResultSet rsBill = (ResultSet) request.getAttribute("rsBill");
        %>
        <table border="1" style="width: 1000px; border: 1px solid black; background-color: #EEEEEE">
            <thead>
                <tr>
                    <th>Bill ID</th>
                    <th>Date Create</th>
                    <th>Customer Name</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Total</th>
                    <th>Status</th>
                    <th>Customer ID</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%while (rsBill.next()) {%>
                <tr>
                    <td><a href="ControllerHome?action=listDetail&oid=<%=rsBill.getString(1)%>"><%=rsBill.getString(1)%></a></td>
                    <td><%=rsBill.getString(2)%></td>
                    <td><%=rsBill.getString(3)%></td>
                    <td><%=rsBill.getString(4)%></td>
                    <td><%=rsBill.getString(5)%></td>
                    <td><%=rsBill.getDouble(6)%></td>
                    <td>
                        <%if(rsBill.getInt(7) == 1) {%>Wait<%}%>
                        <%if(rsBill.getInt(7) == 2) {%>Process<%}%>
                        <%if(rsBill.getInt(7) == 3) {%>Done<%}%>
                    </td>
                    <td><%=rsBill.getInt(8)%></td>
                    <td><a href="ControllerHome?action=updateBill2&oid=<%=rsBill.getString(1)%>">Update</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
