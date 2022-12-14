<%-- 
    Document   : Login.jsp
    Created on : Oct 13, 2021, 1:38:38 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Space Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>

        <link href="css/login.css" rel="stylesheet" type="text/css" media="all" />

        <link href="//fonts.googleapis.com/css?family=Montserrat:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext,vietnamese" rel="stylesheet">

    </head>
    <body>
        <%
            String mess = (String) request.getAttribute("mess");
        %>
        <div class="main">
            <div class="main-w3l">
                <h1 class="logo-w3">Login</h1>
                <div class="w3layouts-main">
                    <h2><span>Login now</span></h2>
                    <form action="" method="POST">
                        <input placeholder="Username" name="user" type="text" required="">
                        <input placeholder="Password" name="pass" type="password" required="">
                        <h3>${mess}</h3>
                        <input type="submit" value="Login" name="submit">
                    </form>
                    <h6><a href="ControllerAdmin?action=login">Admin login</a></h6> 
                    <h6><a href="ControllerCustomer?action=insert">Register</a></h6>
                </div>

                <div class="footer-w3l"></div>
            </div>
        </div>

    </body>
</html>
