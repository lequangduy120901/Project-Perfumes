<%@page import="model.DAOProduct"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>HyA Corporation</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/ProductCusView.css" rel="stylesheet" type="text/css" media="all" />
        <link href='//fonts.googleapis.com/css?family=Cabin+Condensed' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <%
            DAOProduct dao = new DAOProduct();
            ResultSet rs = (ResultSet) request.getAttribute("rs");
            ResultSet rs1 = dao.getData("Select * from Product where pid = 'P10'");
            ResultSet rsCate = (ResultSet) request.getAttribute("rsCate");
            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String caID = (String) request.getAttribute("caID");
        %>
        <div class="wrap">
            <div class="panner">
                <div>Lê Trương Thái Bảo -  HE153367</div>
                <div>Welcome: ${sessionScope.user.username}</div>
            </div>
            <div class="header">
                <div class="logo">
                    <a href="ControllerProductCusView"><img src="img/logo.png" alt=""> </a>
                </div>
                <div class="box-search">
                    <div class="search">
                        <form action="ControllerProductCusView?action=searchName" method="POST">
                            <input type="search" value="Keyword here" name="sname" onfocus="this.value = '';" onblur="if (this.value == '') {
                                        this.value = 'Keyword here';
                                    }">
                            <input type="submit" value="Search" name="submit" class="pad-w3l-search">
                        </form>
                    </div>
                    <!--<img src="img/ad2.jpg" alt="">-->
                </div>
                <div class="header-right">
                    <div class="menu">
                        <ul class="nav">
                            <c:if test="${sessionScope.user == null}">
                                <li><a href="ControllerCustomer?action=login">Login</a></li>
                                <li><a href="ControllerCustomer?action=insert">Register</a></li>
                                </c:if>
                                <c:if test="${sessionScope.user != null}">
                                <li><a href="showCart.jsp">Cart</a></li>
                                <li><a href="ControllerCustomer?action=logout">Log Out</a></li>
                                </c:if>
                            <div class="clear"></div>
                        </ul>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="content-1">
                <div class="cnt-main">
                    <div class="grid">
                        <div class="grid-img">
                            <div id="slideshow">
                                <div class="slide-wrapper">
                                    <div class="slide"><img src="img/advertisement.jpg"></div>
                                    <div class="slide"><img src="img/adv1.jpg"></div>
                                    <div class="slide"><img src="img/adv2.jpg"></div>
                                </div>
                            </div>
                        </div>
                        <div class="grid-para">
                            <%while (rs1.next()) {%>
                            <h2>Special Offer</h2>
                            <h3><%=rs1.getString(2)%></h3>
                            <div class="speDes">
                                <p>Hệ điều hành: Android 10</p>
                                <p>Camera sau: 2 camera 12 MP</p>
                                <p>Camera trước: 10 MP</p>
                                <p>Chip: Snapdragon 855+</p>
                                <p>RAM: 8 GB; Bộ nhớ trong: 256 GB</p>
                                <p>SIM: 1 Nano SIM & 1 eSIM Hỗ trợ 4G</p>
                                <p>Pin, Sạc: 3300 mAh</p>
                                <p><%=rs1.getString(6)%></p>
                            </div>
                            <h4 class="spePrice">$<%=Double.parseDouble(rs1.getString(4))%></h4>
                            <div class="btn top">
                                <a href="addtoCart.jsp?pid=<%=rs1.getString(1)%>&quantity=<%=rs1.getString(3)%>">Add to Cart</a>
                            </div>
                            <%}%>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
            <div class="main">
                <div class="sidebar">
                    <div class="s-main">
                        <div class="s_hdr">
                            <h2>Categories</h2>
                        </div>

                        <div class="text1-nav">
                            <ul>
                                <%while (rsCate.next()) {%>
                                <li><a href="ControllerProductCusView?action=searchCate&cateid=<%=rsCate.getString(1)%>"><%=rsCate.getString(2)%></a></li>
                                    <%}%>
                            </ul>
                        </div>

                    </div>
                    <div class="s-main">
                    </div>
                </div>

                <div class="content">
                    <div style="margin-top: 20px; margin-bottom: 20px; float: left; width: 25%">
                        <div class="dropdown" style="width: 160px">
                            <button class="nut_dropdown" style="width: 160px; background-color: #fed100; color: black; border-radius: 10px;">Sort by price</button>
                            <div class="noidung_dropdown" style="border-radius: 10px">
                                <c:if test="${caID == null}">
                                    <a href="ControllerProductCusView?action=sort&type=1">Ascending</a>
                                    <a href="ControllerProductCusView?action=sort&type=2">Descending</a>
                                </c:if>
                                <c:if test="${caID != null}">
                                    <a href="ControllerProductCusView?action=sort&type=1&cateID=<%=caID%>">Ascending</a>
                                    <a href="ControllerProductCusView?action=sort&type=2&cateID=<%=caID%>">Descending</a>
                                </c:if>
                            </div>
                        </div>

                    </div>
                    <div style="float: left; width: 75%; margin-top: 30px; text-align: end">
                        <c:if test="${caID==null}">
                            <form action="ControllerProductCusView?action=sort&type=3" method="Post">
                                <input style="margin-left: 20px; border-radius: 5px; width: 100px" type="text" name="Pfrom" value="" placeholder="From"/>
                                <input style="border-radius: 5px; width: 100px" type="text" name="Pto" value="" placeholder="To"/>
                                <input style="background-color: #fed100; border-radius: 5px" type="submit" value="Search" name="submit" />
                            </form>
                        </c:if>
                        <c:if test="${caID!=null}">
                            <form action="ControllerProductCusView?action=sort&type=3" method="Post">
                                <input type="hidden" name="cateID" value="<%=caID%>" />
                                <input style="margin-left: 20px; border-radius: 5px; width: 100px" type="text" name="Pfrom" value="" placeholder="From"/>
                                <input style="border-radius: 5px; width: 100px" type="text" name="Pto" value="" placeholder="To"/>
                                <input style="background-color: #fed100; border-radius: 5px" type="submit" value="Search" name="submit" />
                            </form>
                        </c:if>
                    </div>

                    <div class="clear row">
                        <%while (rs.next()) {
                                if (rs.getInt(3) > 0 && rs.getInt(7) == 1) {%>
                        <div class="btm col-md-4">
                            <div class="section group">
                                <div class="grid_1_of_3 images_1_of_3">
                                    <img src="<%=rs.getString(5)%>" alt=""/>
                                    <h3 class="pname"><%=rs.getString(2)%></h3>
                                    <h3 class="des"><%=rs.getString(6)%></h3>
                                    <div class="cart-b">
                                        <span class="price left"><h4>$<%=Double.parseDouble(rs.getString(4))%></h4><sub></sub></span>
                                        <div class="btn top-right right"><a href="addtoCart.jsp?pid=<%=rs.getString(1)%>&quantity=<%=rs.getString(3)%>">Add to Cart</a></div>
                                        <!--                                    <div class="clear"></div>-->
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%}
                            }%>
                    </div>
                </div>
                <!--<div class="clear"></div>-->
            </div>
        </div>
        <div class="footer-bg" style="clear: both ">
            <div class="wrap">
                <div class="footer">
                    <div class="f_nav">
                    </div>
                    <div class="footer1">
                        <p>&copy; 2021 HyACorp. All rights reserved | Design by <a href="https://www.facebook.com/huyanh.tranphan.24121/">HuyAnh</a></p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>