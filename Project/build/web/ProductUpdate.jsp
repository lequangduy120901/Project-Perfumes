<%-- 
    Document   : Update
    Created on : Oct 6, 2021, 1:34:47 PM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="model.DAOProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
    </head>
    <body>

        <%
            ResultSet rs = (ResultSet) request.getAttribute("rs");
            ResultSet rsCate = (ResultSet) request.getAttribute("rsCate");
            ResultSet rs2 = (ResultSet) request.getAttribute("rs2");
        %>
        <form action="ControllerHome?action=updatePro" method="POST">
            <table border="0" style="height: 300px; width: 400px; border: 1px solid black; background-color: #EEEEEE; margin-left: 350px">
                <tr>
                    <td>Category ID</td>
                    <td><select  name="cateID">
                            <%if (rs2.next()) {%>
                            <option value="<%=rs2.getInt(1)%>"><%=rs2.getString(2)%></option>
                            <%}%>
                            <%while (rsCate.next()) {%>
                            <%if (rsCate.getInt(1) != rs2.getInt(1)) {%>
                            <option value="<%=rsCate.getInt(1)%>"><%=rsCate.getString(2)%></option>
                            <%}%>
                            <%}%>
                        </select></td>
                </tr>
                <%if (rs.next()) {%>
                <tr>
                    <td>Product ID</td>
                    <td><input type="text" name="pid" value="<%=rs.getString(1)%>"/></td>
                </tr>
                <tr>
                    <td>Product name</td>
                    <td><input type="text" name="pname" value="<%=rs.getString(2)%>" /></td>
                </tr>
                <tr>
                    <td>Quantity</td>
                    <td><input type="text" name="quantity" value="<%=rs.getInt(3)%>" /></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input type="text" name="price" value="<%=rs.getDouble(4)%>" /></td>
                </tr>
                <tr>
                    <td>image</td>
                    <td>
                        <input type="text" name="img" value="<%=rs.getString(5)%>" />
                    </td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input type="text" name="description" value="<%=rs.getString(6)%>" /></td>
                </tr>
                <tr>
                    <td>status</td>
                    <td>
                        <input type="radio" name="sts" value="1"<%=(rs.getInt(7) == 1 ? "checked" : "")%>/>Enable
                        <input type="radio" name="sts" value="0"<%=(rs.getInt(7) == 0 ? "checked" : "")%>/>Disable
                    </td>
                </tr>
                <%}%>
                <tr>
                    <td><input type="submit" name="submit" value="update"></td>
                    <td><input type="submit" value="Reset"></td>
                </tr>
            </table>

        </form>
    </body>
</html>
