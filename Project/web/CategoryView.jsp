<%-- 
    Document   : CategoryView
    Created on : Oct 4, 2021, 1:59:05 PM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="model.DAOCategory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String title = (String) request.getAttribute("title");
            ResultSet rs = (ResultSet) request.getAttribute("rs");
        %>
        <p><a href="ControllerHome?action=insert">Insert Category</a></p>
        <table border="1">
            <caption><%=title%></caption>
            <thead>
                <tr>
                    <th>Category ID</th>
                    <th>Category Name</th>
                    <th>Status</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%while (rs.next()) {%>
                <tr>
                    <td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=(rs.getInt(3) == 1 ? "Enable" : "Disable")%></td>
                    <td><a href="ControllerCategory?action=update&cateID=<%= rs.getString(1)%>" >Update</a></td>
                    <td><a href="ControllerCategory?action=delete&cateID=<%= rs.getString(1)%>" >Delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
