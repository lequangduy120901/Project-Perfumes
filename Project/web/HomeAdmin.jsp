<%@page import="model.DAOProduct"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>BAO Corporation</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/HomeAdmin.css" rel="stylesheet" type="text/css" media="all" />
        <link href='//fonts.googleapis.com/css?family=Cabin+Condensed' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <%
            if (session.getAttribute("ad") == null) {
                response.sendRedirect("ControllerAdmin?action=login");
            }
            String go = (String) request.getAttribute("action");
            String actP = (String) request.getAttribute("actP");
            String actC = (String) request.getAttribute("actC");
            String actB = (String) request.getAttribute("actB");
        %>
        <div class="wrap">
            <div class="panner">
                <div>Le Truong Thai Bao - HE153367</div>
                <div>Welcome: ${sessionScope.ad.username}</div>
            </div>
            <div class="header">
                <div class="logo">
                    <a href="ControllerHome?action=listPro"><img src="img/logo.png" alt=""> </a>
                </div>
                <div class="header-right">
                    <div class="menu">
                        <ul class="nav">
                            <c:if test="${sessionScope.ad == null}">
                                <li><a href="ControllerAdmin?action=login">Login</a></li>
                                </c:if>
                                <c:if test="${sessionScope.ad != null}">
                                <li><a href="ControllerHome?action=insertAd">Register</a></li>
                                <li><a href="ControllerAdmin?action=logout">Log Out</a></li>
                                </c:if>
                            <div class="clear"></div>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="main">
                <div class="sidebar">
                    <div class="s-main">
                        <div class="s_hdr">
                            <h2>Manager</h2>
                        </div>
                        <div class="text1-nav">
                            <ul>
                                <li><a href="ControllerHome?action=listCus">Customer Manager</a></li>
                                <li><a href="ControllerHome?action=listPro">Product Manager</a></li>
                                <li><a href="ControllerHome?action=listBill">Bill Manager</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="s-main">
                    </div>
                </div>
                
                <div class="content">
                    <%if (go.equals("listPro")) {%>
                    <jsp:include page="ProductAdView.jsp"></jsp:include>
                    <%}%>
                    <%if (go.equals("insertAd")) {%>
                    <jsp:include page="AdminInsert.jsp"></jsp:include>
                    <%}%>
                    <%if (go.equals("listCus")) {%>
                    <jsp:include page="CustomerView.jsp"></jsp:include>
                    <%}%>
                    <%if (go.equals("listBill")) {%>
                    <jsp:include page="BillView.jsp"></jsp:include>
                    <%}%>
                    <%if (go.equals("listDetail")) {%>
                    <jsp:include page="BillDetailView.jsp"></jsp:include>
                    <%}%>
                    <%if (go.equals("updatePro")) {%>
                    <jsp:include page="ProductUpdate.jsp"></jsp:include>
                    <%}%>
                    <%if (go.equals("updateCus")) {%>
                    <jsp:include page="CustomerUpdate.jsp"></jsp:include>
                    <%}%>
                    <%if (go.equals("updateBill")) {%>
                    <jsp:include page="BillUpdate.jsp"></jsp:include>
                    <%}%>
                    <%if (go.equals("insertPro")) {%>
                    <jsp:include page="ProductInsert.jsp"></jsp:include>
                    <%}%>
                    <%if (go.equals("listBill2")) {%>
                    <jsp:include page="BillView.jsp"></jsp:include>
                    <%}%>
                    <%if (go.equals("updateBill2")) {%>
                    <jsp:include page="BillView2.jsp"></jsp:include>
                    <%}%>
                </div>
            </div>
        </div>
        <div class="clearboth"></div>
        <footer>
            <div class="footer-bg">
                <div class="wrap">
                    <div class="footer">
                        <div class="f_nav">
                        </div>
                        <div class="footer1">
                            <p>&copy; 2022 BAOCorp. All rights reserved | Design by <a href="#">Bao</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>