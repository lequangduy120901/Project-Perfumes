<%-- 
    Document   : CategoryUpdate
    Created on : Oct 8, 2021, 9:20:27 PM
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
        <form action="ControllerHome?action=updateCate" method="POST">
            <table border="1">
                <%if (rs.next()) {%>
                <tr>
                    <td><input type="hidden" name="cateID" value="<%=rs.getInt(1)%>" /></td>
                </tr>
                <tr>
                    <td>Category Name</td>
                    <td><input type="text" name="cateName" value="<%=rs.getString(2)%>"  /></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <input type="radio" name="status" value="1"<%=(rs.getInt(3) == 1 ? "checked" : "")%>/>Enable
                        <input type="radio" name="status" value="0"<%=(rs.getInt(3) == 0 ? "checked" : "")%>/>Disable
                    </td>
                </tr>
                <%}%>
                <tr>
                    <td><input type="submit" value="Update" name="submit" /></td>
                    <td><input type="reset" value="Reset" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
