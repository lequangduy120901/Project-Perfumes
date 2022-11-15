package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import model.DAOProduct;

public final class ProductAdView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            ResultSet rsProduct = (ResultSet) request.getAttribute("rsProduct");
        
      out.write("\n");
      out.write("        <a href=\"ControllerHome?action=insertPro\" style=\"margin-left: 450px; border: 1px solid black; background-color: #fed100; color: black; text-decoration: none; border-radius: 5px; margin-bottom: 10px; width: 150px\">Insert Product</a>\n");
      out.write("        <table border=\"1\" style=\"width: 1000px; border: 1px solid black; background-color: #EEEEEE\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>PID</th>\n");
      out.write("                    <th>Product Name</th>\n");
      out.write("                    <th>Quantity</th>\n");
      out.write("                    <th>Price</th>\n");
      out.write("                    <th>Image</th>\n");
      out.write("                    <th>Description</th>\n");
      out.write("                    <th>Status</th>\n");
      out.write("                    <th>Category name</th>\n");
      out.write("                    <th>Update</th>\n");
      out.write("                    <th>Delete</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
while (rsProduct.next()) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(rsProduct.getString(1));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rsProduct.getString(2));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rsProduct.getString(3));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rsProduct.getString(4));
      out.write("</td>\n");
      out.write("                    <td><img style=\"width: 50px; height: 50px;\" src=\"");
      out.print(rsProduct.getString(5));
      out.write("\"></td>\n");
      out.write("                    <td>");
      out.print(rsProduct.getString(6));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print((rsProduct.getInt(7) == 1 ? "Enable" : "Disable"));
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(rsProduct.getString(10));
      out.write("</td>\n");
      out.write("                    <td><a href=\"ControllerHome?action=updatePro&pid=");
      out.print(rsProduct.getString(1));
      out.write("\"</a>Update</td>\n");
      out.write("                    <td><a href=\"ControllerProductAdView?action=delete&pid=");
      out.print( rsProduct.getString(1));
      out.write("\"</a>Delete</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
