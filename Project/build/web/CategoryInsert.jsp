<%-- 
    Document   : CategoryInsert
    Created on : Oct 8, 2021, 9:20:37 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ControllerHome?action=insertCate" method="POST">
            <table border="1">
                <tr>
                    <td>Category Name</td>
                    <td><input type="text" name="cateName" value=""  /></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td><input type="radio" name="status" value="1" checked />Enable</td>
                    <td><input type="radio" name="status" value="0" checked/>Disable</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Update" name="submit" /></td>
                    <td><input type="reset" value="Reset" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
