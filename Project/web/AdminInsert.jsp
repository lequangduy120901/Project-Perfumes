

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ControllerAdmin?action=insert" method="POST">
            <table border="0" style="height: 100px; width: 400px; border: 1px solid black; background-color: #EEEEEE; margin-left: 350px; margin-top: 80px">
                <tr>
                    <td>UserName</td>
                    <td><input type="text" name="user" value="" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pass" value="" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Register" name="submit"/></td>
                    <td><input type="reset" value="Reset" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
