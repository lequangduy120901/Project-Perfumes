package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.BillDetail;
import entity.Bill;
import entity.Customer;
import java.sql.ResultSet;
import model.DAOBill;
import model.DAOBillDetail;
import entity.Product;
import model.DAOProduct;

public final class checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <body>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link href=\"css/checkout.css\" rel=\"stylesheet\" type=\"text/css\"/> \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        ");

            String mess = (String) request.getAttribute("mess");
        
      out.write("\r\n");
      out.write("        <div class=\"col-75\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <form action=\"ControllerProductCusView?action=checkout\" method=\"POST\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-50\">\r\n");
      out.write("                            <h1>Billing Address</h1>\r\n");
      out.write("                            <label for=\"BillID\"><i class=\"fa fa-user\"></i> Bill ID</label>\r\n");
      out.write("                            <input type=\"text\" id=\"fname\" name=\"oID\" value=\"\">\r\n");
      out.write("                            <label for=\"fname\"><i class=\"fa fa-user\"></i> Full Name</label>\r\n");
      out.write("                            <input type=\"text\" id=\"fname\" name=\"cname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.cname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            <label for=\"phone\"><i class=\"fa fa-phone\"></i> Phone</label>\r\n");
      out.write("                            <input type=\"text\" id=\"email\" name=\"cphone\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.cphone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            <label for=\"adr\"><i class=\"fa fa-address-card-o\"></i> Address</label>\r\n");
      out.write("                            <input type=\"text\" id=\"adr\" name=\"cAddress\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.cAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            <label style=\"font-weight: bold;font-size: 20px\" for=\"date\"><i class=\"fa fa-date\"></i>Date Order</label>\r\n");
      out.write("                            <input type=\"date\" id=\"fname\" name=\"dateCreate\" value=\"\">\r\n");
      out.write("                            <h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mess}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <input type=\"submit\" name=\"submit\" value=\"Checkout\" class=\"btn\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
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
}
