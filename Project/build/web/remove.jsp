<%-- 
    Document   : remove
    Created on : 13-10-2021, 11:05:23
    Author     : a
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
            java.util.Enumeration em = session.getAttributeNames();
            String remove = request.getParameter("remove");
            String pid = request.getParameter("pid");
            if (remove.equals("delete")) {
                session.removeAttribute(pid);
                response.sendRedirect("showCart.jsp");
            }
            if (remove.equals("deleteAll")) {
                while (em.hasMoreElements()) {
                    String idremove = em.nextElement().toString();
                    if (!idremove.equals("user") && !idremove.equals("us")) {
                        session.removeAttribute(idremove);
                    }
                }
                response.sendRedirect("showCart.jsp");
            }
        %>
    </body>
</html>
