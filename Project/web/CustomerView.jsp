<%@page import="java.sql.ResultSet"%>
<%@page import="model.DAOCustomer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            ResultSet rsCustomer = (ResultSet) request.getAttribute("rsCustomer");
        %>
        <table border="1" style="width: 1000px; border: 1px solid black; background-color: #EEEEEE; margin-top: 40px">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>Customer Name</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Status</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%while (rsCustomer.next()) {%>
                <tr>
                    <td><%=rsCustomer.getInt(1)%></td>
                    <td><%=rsCustomer.getString(2)%></td>
                    <td><%=rsCustomer.getString(3)%></td>
                    <td><%=rsCustomer.getString(4)%></td>
                    <td><%=rsCustomer.getString(5)%></td>
                    <td><%=rsCustomer.getString(6)%></td>
                    <td><%=(rsCustomer.getInt(7) == 1 ? "Enable" : "Disable")%></td>
                    <td><a href="ControllerHome?action=updateCus&cid=<%=rsCustomer.getString(1)%>">Update</a></td>
                    <td><a href="ControllerCustomer?action=delete&cid=<%=rsCustomer.getInt(1)%>">Delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>