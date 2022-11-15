

<%@page import="java.sql.ResultSet"%>
<%@page import="model.DAOAdmin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            DAOAdmin dao = new DAOAdmin();
            ResultSet rs = dao.getData("select * from Admin");
        %>
        <p><a href="ControllerAdmin?action=insert">Login</a></p>
        <table border="1">
            <thead>
                <tr>
                    <th>Admin ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Change Password</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%while (rs.next()) {%>
                <tr>
                    <td><%= rs.getInt(1)%></td>
                    <td><%= rs.getString(2)%></td>
                    <td><%= rs.getString(3)%> </td>
                    <td><a href="ControllerAdmin?action=update&adminid=<%=rs.getString(1)%>">Change</a></td>
                    <td><a href="ControllerAdmin?action=delete&adminid=<%=rs.getString(1)%>">Delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
