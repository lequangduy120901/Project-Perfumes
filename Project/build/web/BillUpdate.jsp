<%-- 
    Document   : BillUpdate
    Created on : Oct 8, 2021, 10:15:40 AM
    Author     : Admin
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
            ResultSet rsUpdate = (ResultSet) request.getAttribute("rs");
        %>
        <form action="ControllerHome?action=updateBill" method="POST">
            <table border="0" style="height: 300px; width: 400px; border: 1px solid black; background-color: #EEEEEE; margin-left: 350px">
                <%if (rsUpdate.next()) {%>
                <tr>
                    <td>Bill ID</td>
                    <td><input type="text" name="oid" value="<%=rsUpdate.getString(1)%>" readonly="readonly"</td>
                </tr>
                <tr>
                    <td>Customer Name</td>
                    <td><input type="text" name="cname" value="<%=rsUpdate.getString(3)%>" readonly="readonly"/></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="cphone" value="<%=rsUpdate.getString(4)%>" readonly="readonly"/></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="cAddress" value="<%=rsUpdate.getString(5)%>" readonly="readonly"/></td>
                </tr>
                <tr>
                    <td>Total</td>
                    <td><input type="text" name="cAddress" value="<%=rsUpdate.getString(6)%>" readonly="readonly"/></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <input type="radio" name="sts" value="1"<%=(rsUpdate.getInt(7) == 1 ? "checked" : "")%>/>Wait
                        <input type="radio" name="sts" value="2"<%=(rsUpdate.getInt(7) == 2 ? "checked" : "")%>/>Process
                        <input type="radio" name="sts" value="3"<%=(rsUpdate.getInt(7) == 3 ? "checked" : "")%>/>Done
                    </td>
                </tr>
                <%}%>
                <tr>
                    <td><input type="submit" value="Submit" name="submit" /></td>
                    <td><input type="reset" value="Reset" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
