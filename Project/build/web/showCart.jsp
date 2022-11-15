
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Product"%>
<html>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <section class="jumbotron text-center" style="background-color: #fed100">
        <div class="container">
            <h1 class="jumbotron-heading">Shopping Cart</h1>
        </div>
    </section>
    <body>
        <table width=50% border="1">
            <div class="container mb-4">
                <div class="row">
                    <div class="col-12">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <tr style="text-align: center">
                                    <th scope="col">Product ID</th>
                                    <th scope="col">Product name</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Total</th>
                                    <th scope="col">Remove</th>
                                </tr>
                                <%
                                    java.util.Enumeration em = session.getAttributeNames();
                                    double sumTotal = 0;
                                    while (em.hasMoreElements()) {
                                        String pid = em.nextElement().toString(); //get key
                                        if (!pid.equals("us") && !pid.equals("user")) {
                                            Product pro = (Product) session.getAttribute(pid);%>
                                <tr style="text-align: center">
                                    <td><%=pid%></td>
                                    <td><%=pro.getPname()%></td>
                                <form action="ControllerProductCusView?action=updateCart" method="POST">
                                    <td>
                                        <input type="submit" value="-" name="submit"/>
                                        <input type="hidden" value="<%=pid%>" name="pid"/>
                                        <input type="text" name="quantity" value="<%=pro.getQuantity()%>" readonly="readonly" style="width: 40px; text-align: center"/>
                                        <input type="submit" value="+" name="submit"/>
                                    </td>
                                </form>
                                <td><%=pro.getPrice()%></td>
                                <td><%=pro.getQuantity() * pro.getPrice()%></td>
                                <td><a href="remove.jsp?remove=delete&pid=<%=pid%>">Remove</a></td>
                                </tr>
                                <%sumTotal += pro.getQuantity() * pro.getPrice();
                                        }
                                    }
                                    out.println("<tr style=\"text-align: center\">");
                                    out.println("<td></td>");
                                    out.println("<td></td>");
                                    out.println("<td></td>");
                                    out.println("<td style=\"font-weight:bold\">Total</td>");
                                    out.println("<td style=\"font-weight:bold\">" + sumTotal + "</td>");
                                    out.println("<td style=\"font-weight:bold\"><a href=\"remove.jsp?remove=deleteAll\">RemoveAll</a></td>");
                                    out.println("</tr>");
                                %>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col mb-2">
                <div class="row">
                    <div class="col-sm-12  col-md-6">
                        <button class="btn btn-block btn-light" style="height: 45px"><a style="color: black" href="ControllerProductCusView">Continue Shopping</a></button>
                    </div>
                    <div class="col-sm-12 col-md-6 text-right">
                        <c:if test="${sessionScope.user == null}">
                            <button class="btn btn-lg btn-block btn-success text-uppercase" style="background-color: #fed100"><a style="color: black" href="ControllerCustomer?action=login">Checkout</a></button>
                        </c:if>
                        <c:if test="${sessionScope.user != null}">
                            <button class="btn btn-lg btn-block btn-success text-uppercase" style="background-color: #fed100"><a style="color: black" href="ControllerProductCusView?action=checkout">Checkout</a></button>
                        </c:if>
                    </div>
                </div>
            </div>
    </body>
</html>