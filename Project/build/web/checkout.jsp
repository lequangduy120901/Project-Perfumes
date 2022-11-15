<%@page import="entity.BillDetail"%>
<%@page import="entity.Bill"%>
<%@page import="entity.Customer"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.DAOBill"%>
<%@page import="model.DAOBillDetail"%>
<%@page import="entity.Product"%>
<%@page import="model.DAOProduct"%>
<html>
    <body>
    <head>
        <link href="css/checkout.css" rel="stylesheet" type="text/css"/> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <div class="row">
        <%
            String mess = (String) request.getAttribute("mess");
        %>
        <div class="col-75">
            <div class="container">
                <form action="ControllerProductCusView?action=checkout" method="POST">
                    <div class="row">
                        <div class="col-50">
                            <h1>Billing Address</h1>
                            <label for="BillID"><i class="fa fa-user"></i> Bill ID</label>
                            <input type="text" id="fname" name="oID" value="">
                            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                            <input type="text" id="fname" name="cname" value="${sessionScope.user.cname}">
                            <label for="phone"><i class="fa fa-phone"></i> Phone</label>
                            <input type="text" id="email" name="cphone" value="${sessionScope.user.cphone}">
                            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                            <input type="text" id="adr" name="cAddress" value="${sessionScope.user.cAddress}">
                            <label style="font-weight: bold;font-size: 20px" for="date"><i class="fa fa-date"></i>Date Order</label>
                            <input type="date" id="fname" name="dateCreate" value="">
                            <h2>${mess}</h2>
                        </div>
                    </div>
                    <input type="submit" name="submit" value="Checkout" class="btn">
                </form>
            </div>
        </div>
    </div>
</body>
</html>