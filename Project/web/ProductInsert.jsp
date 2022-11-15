<%-- 
    Document   : ProductInsert
    Created on : Oct 7, 2021, 10:32:27 PM
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
            ResultSet rs = (ResultSet) request.getAttribute("rsCate");
        %>
        <form action="ControllerHome?action=insertPro" method="POST">
            <table border="1" style="height: 300px; width: 400px; border: 1px solid black; background-color: #EEEEEE; margin-left: 350px">
                <tr>
                    <td>Category ID</td>
                    <td><select name="cateID">
                            <%while (rs.next()) {%>
                            <option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>
                            <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td>Product ID</td>
                    <td><input type="text" name="pid" value="" /></td>
                </tr>
                <tr>
                    <td>Product name</td>
                    <td><input type="text" name="pname" value="" /></td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td><input type="text" name="quantity" value="" /></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" value="" /></td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td>
                        <input type="text" name="img" value="" />
                    </td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="description" value="" /></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <input type="radio" name="status" value="1" checked />Enable
                        <input type="radio" name="status" value="0" />Disable
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" name="submit" /></td>
                    <td><input type="reset" value="Reset" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
