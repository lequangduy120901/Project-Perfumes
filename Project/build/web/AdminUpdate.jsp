

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
        <form action="ControllerAdmin?action=update" method="POST">
            <table border="0">
                <%if (rs.next()) {%>
                <tr>
                    <td><input type="hidden" name="adminid" value="<%=rs.getString(1)%>" /></td>
                    <td><input type="hidden" name="oldpass1" value="<%=rs.getString(3)%>" /></td>
                </tr>
                <tr>
                    <td>Old Password</td>
                    <td><input type="password" name="oldpass" value="" /></td>
                </tr>
                <tr>
                    <td>New Password</td>
                    <td><input type="password" name="newpass" value="" /></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="renewpass" value="" /></td>
                </tr>
                <%}%>
                <tr>
                    <td><input type="submit" value="Submit" name="submit"/></td>
                    <td><input type="reset" value="Reset" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
