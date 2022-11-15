package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.DAOProduct;
import java.sql.ResultSet;

public final class ProductCusView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>HyA Corporation</title>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/ProductCusView.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />\n");
      out.write("        <link href='//fonts.googleapis.com/css?family=Cabin+Condensed' rel='stylesheet' type='text/css'>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            DAOProduct dao = new DAOProduct();
            ResultSet rs = (ResultSet) request.getAttribute("rs");
            ResultSet rs1 = dao.getData("Select * from Product where pid = 'P10'");
            ResultSet rsCate = (ResultSet) request.getAttribute("rsCate");
            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String caID = (String) request.getAttribute("caID");
        
      out.write("\n");
      out.write("        <div class=\"wrap\">\n");
      out.write("            <div class=\"panner\">\n");
      out.write("                <div>Lê Trương Thái Bảo -  HE153367</div>\n");
      out.write("                <div>Welcome: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"ControllerProductCusView\"><img src=\"img/logo.png\" alt=\"\"> </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"box-search\">\n");
      out.write("                    <div class=\"search\">\n");
      out.write("                        <form action=\"ControllerProductCusView?action=searchName\" method=\"POST\">\n");
      out.write("                            <input type=\"search\" value=\"Keyword here\" name=\"sname\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {\n");
      out.write("                                        this.value = 'Keyword here';\n");
      out.write("                                    }\">\n");
      out.write("                            <input type=\"submit\" value=\"Search\" name=\"submit\" class=\"pad-w3l-search\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <!--<img src=\"img/ad2.jpg\" alt=\"\">-->\n");
      out.write("                </div>\n");
      out.write("                <div class=\"header-right\">\n");
      out.write("                    <div class=\"menu\">\n");
      out.write("                        <ul class=\"nav\">\n");
      out.write("                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            <div class=\"clear\"></div>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"clear\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"content-1\">\n");
      out.write("                <div class=\"cnt-main\">\n");
      out.write("                    <div class=\"grid\">\n");
      out.write("                        <div class=\"grid-img\">\n");
      out.write("                            <div id=\"slideshow\">\n");
      out.write("                                <div class=\"slide-wrapper\">\n");
      out.write("                                    <div class=\"slide\"><img src=\"img/advertisement.jpg\"></div>\n");
      out.write("                                    <div class=\"slide\"><img src=\"img/adv1.jpg\"></div>\n");
      out.write("                                    <div class=\"slide\"><img src=\"img/adv2.jpg\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"grid-para\">\n");
      out.write("                            ");
while (rs1.next()) {
      out.write("\n");
      out.write("                            <h2>Special Offer</h2>\n");
      out.write("                            <h3>");
      out.print(rs1.getString(2));
      out.write("</h3>\n");
      out.write("                            <div class=\"speDes\">\n");
      out.write("                                <p>Hệ điều hành: Android 10</p>\n");
      out.write("                                <p>Camera sau: 2 camera 12 MP</p>\n");
      out.write("                                <p>Camera trước: 10 MP</p>\n");
      out.write("                                <p>Chip: Snapdragon 855+</p>\n");
      out.write("                                <p>RAM: 8 GB; Bộ nhớ trong: 256 GB</p>\n");
      out.write("                                <p>SIM: 1 Nano SIM & 1 eSIM Hỗ trợ 4G</p>\n");
      out.write("                                <p>Pin, Sạc: 3300 mAh</p>\n");
      out.write("                                <p>");
      out.print(rs1.getString(6));
      out.write("</p>\n");
      out.write("                            </div>\n");
      out.write("                            <h4 class=\"spePrice\">$");
      out.print(Double.parseDouble(rs1.getString(4)));
      out.write("</h4>\n");
      out.write("                            <div class=\"btn top\">\n");
      out.write("                                <a href=\"addtoCart.jsp?pid=");
      out.print(rs1.getString(1));
      out.write("&quantity=");
      out.print(rs1.getString(3));
      out.write("\">Add to Cart</a>\n");
      out.write("                            </div>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"clear\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"main\">\n");
      out.write("                <div class=\"sidebar\">\n");
      out.write("                    <div class=\"s-main\">\n");
      out.write("                        <div class=\"s_hdr\">\n");
      out.write("                            <h2>Categories</h2>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"text1-nav\">\n");
      out.write("                            <ul>\n");
      out.write("                                ");
while (rsCate.next()) {
      out.write("\n");
      out.write("                                <li><a href=\"ControllerProductCusView?action=searchCate&cateid=");
      out.print(rsCate.getString(1));
      out.write('"');
      out.write('>');
      out.print(rsCate.getString(2));
      out.write("</a></li>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"s-main\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"content\">\n");
      out.write("                    <div style=\"margin-top: 20px; margin-bottom: 20px; float: left; width: 25%\">\n");
      out.write("                        <div class=\"dropdown\" style=\"width: 160px\">\n");
      out.write("                            <button class=\"nut_dropdown\" style=\"width: 160px; background-color: #fed100; color: black; border-radius: 10px;\">Sort by price</button>\n");
      out.write("                            <div class=\"noidung_dropdown\" style=\"border-radius: 10px\">\n");
      out.write("                                ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_3.setPageContext(_jspx_page_context);
      _jspx_th_c_if_3.setParent(null);
      _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${caID != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
      if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <a href=\"ControllerProductCusView?action=sort&type=1&cateID=");
          out.print(caID);
          out.write("\">Ascending</a>\n");
          out.write("                                    <a href=\"ControllerProductCusView?action=sort&type=2&cateID=");
          out.print(caID);
          out.write("\">Descending</a>\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div style=\"float: left; width: 75%; margin-top: 30px; text-align: end\">\n");
      out.write("                        ");
      if (_jspx_meth_c_if_4(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_5.setPageContext(_jspx_page_context);
      _jspx_th_c_if_5.setParent(null);
      _jspx_th_c_if_5.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${caID!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
      if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <form action=\"ControllerProductCusView?action=sort&type=3\" method=\"Post\">\n");
          out.write("                                <input type=\"hidden\" name=\"cateID\" value=\"");
          out.print(caID);
          out.write("\" />\n");
          out.write("                                <input style=\"margin-left: 20px; border-radius: 5px; width: 100px\" type=\"text\" name=\"Pfrom\" value=\"\" placeholder=\"From\"/>\n");
          out.write("                                <input style=\"border-radius: 5px; width: 100px\" type=\"text\" name=\"Pto\" value=\"\" placeholder=\"To\"/>\n");
          out.write("                                <input style=\"background-color: #fed100; border-radius: 5px\" type=\"submit\" value=\"Search\" name=\"submit\" />\n");
          out.write("                            </form>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"clear row\">\n");
      out.write("                        ");
while (rs.next()) {
                                if (rs.getInt(3) > 0 && rs.getInt(7) == 1) {
      out.write("\n");
      out.write("                        <div class=\"btm col-md-4\">\n");
      out.write("                            <div class=\"section group\">\n");
      out.write("                                <div class=\"grid_1_of_3 images_1_of_3\">\n");
      out.write("                                    <img src=\"");
      out.print(rs.getString(5));
      out.write("\" alt=\"\"/>\n");
      out.write("                                    <h3 class=\"pname\">");
      out.print(rs.getString(2));
      out.write("</h3>\n");
      out.write("                                    <h3 class=\"des\">");
      out.print(rs.getString(6));
      out.write("</h3>\n");
      out.write("                                    <div class=\"cart-b\">\n");
      out.write("                                        <span class=\"price left\"><h4>$");
      out.print(Double.parseDouble(rs.getString(4)));
      out.write("</h4><sub></sub></span>\n");
      out.write("                                        <div class=\"btn top-right right\"><a href=\"addtoCart.jsp?pid=");
      out.print(rs.getString(1));
      out.write("&quantity=");
      out.print(rs.getString(3));
      out.write("\">Add to Cart</a></div>\n");
      out.write("                                        <!--                                    <div class=\"clear\"></div>-->\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        ");
}
                            }
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!--<div class=\"clear\"></div>-->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer-bg\" style=\"clear: both \">\n");
      out.write("            <div class=\"wrap\">\n");
      out.write("                <div class=\"footer\">\n");
      out.write("                    <div class=\"f_nav\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"footer1\">\n");
      out.write("                        <p>&copy; 2021 HyACorp. All rights reserved | Design by <a href=\"https://www.facebook.com/huyanh.tranphan.24121/\">HuyAnh</a></p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <li><a href=\"ControllerCustomer?action=login\">Login</a></li>\n");
        out.write("                                <li><a href=\"ControllerCustomer?action=insert\">Register</a></li>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                <li><a href=\"showCart.jsp\">Cart</a></li>\n");
        out.write("                                <li><a href=\"ControllerCustomer?action=logout\">Log Out</a></li>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${caID == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                    <a href=\"ControllerProductCusView?action=sort&type=1\">Ascending</a>\n");
        out.write("                                    <a href=\"ControllerProductCusView?action=sort&type=2\">Descending</a>\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent(null);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${caID==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <form action=\"ControllerProductCusView?action=sort&type=3\" method=\"Post\">\n");
        out.write("                                <input style=\"margin-left: 20px; border-radius: 5px; width: 100px\" type=\"text\" name=\"Pfrom\" value=\"\" placeholder=\"From\"/>\n");
        out.write("                                <input style=\"border-radius: 5px; width: 100px\" type=\"text\" name=\"Pto\" value=\"\" placeholder=\"To\"/>\n");
        out.write("                                <input style=\"background-color: #fed100; border-radius: 5px\" type=\"submit\" value=\"Search\" name=\"submit\" />\n");
        out.write("                            </form>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }
}
