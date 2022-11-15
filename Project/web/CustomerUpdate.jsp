<%-- 
    Document   : CustomerUpdate
    Created on : Oct 7, 2021, 10:58:59 PM
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
            ResultSet rs = (ResultSet) request.getAttribute("rs");
        %>
        <form action="ControllerCustomer?action=update" method="POST">
            <table border="0" style="height: 300px; width: 400px; border: 1px solid black; background-color: #EEEEEE; margin-left: 350px">
                <%if (rs.next()) {%>
                <tr>
                    <td><input type="hidden" name="cid" value="<%=rs.getInt(1)%>" />
                </tr>
                <tr>
                    <td>Customer name</td>
                    <td><input type="text" name="cname" value="<%=rs.getString(2)%>" /></td>
                </tr>
                <tr>
                    <td>Customer Phone</td>
                    <td><input type="text" name="phone" value="<%=rs.getString(3)%>" /></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="add" value="<%=rs.getString(4)%>" /></td>
                </tr>
                <tr>
                    <td>UserName</td>
                    <td>
                        <input type="text" name="user" value="<%=rs.getString(5)%>" />
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pass" value="<%=rs.getString(6)%>" /></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <input type="radio" name="status" value="1"<%=(rs.getInt(7) == 1 ? "checked" : "")%>/>Enable
                        <input type="radio" name="status" value="0"<%=(rs.getInt(7) == 0 ? "checked" : "")%>/>Disable
                    </td>
                </tr>
                <%}%>
                <tr>
                    <td><input type="submit" name="submit" value="Update"></td>
                    <td><input type="submit" value="Reset"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
