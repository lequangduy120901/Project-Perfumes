<%-- 
    Document   : ForgetPassword
    Created on : Oct 8, 2021, 1:30:37 PM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forget Password</title>
    </head>
    <body>
        <form action="ControllerCustomer?action=changepassword" method="POST">
            <table border="0">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="user" value="" /></td>
                </tr>
                <tr>
                    <td>New Password</td>
                    <td><input type="password" name="newpass" value="" /></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="renewpass" value="" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" name="submit"/></td>
                    <td><input type="reset" value="Reset" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
