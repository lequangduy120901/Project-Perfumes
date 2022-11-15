<%-- 
    Document   : BillDetailUpdate
    Created on : Oct 8, 2021, 10:18:30 PM
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
        <%
            String pid = (String) request.getParameter("pid");
            String oid = (String) request.getParameter("oid");
        %>
        <form action="ControllerBillDetail?action=updatequantity&oid=<%=oid%>&pid=<%=pid%>" method="POST">
            <table border="1">
                <tr>
                    <td>Add quantity</td>
                    <td><input type="text" name="addquantity" value="" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" name="submit"/></td>
                    <td><input type="reset" value="Reset" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
