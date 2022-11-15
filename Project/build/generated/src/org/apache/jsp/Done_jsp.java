package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import entity.BillDetail;
import model.DAOBillDetail;
import entity.Bill;
import entity.Customer;
import model.DAOBill;
import entity.Product;
import model.DAOProduct;

public final class Done_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/checkout.css\" rel=\"stylesheet\" type=\"text/css\"/> \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String oid = (String) request.getAttribute("oid");
            String date = (String) request.getAttribute("date");
            String name = (String) request.getAttribute("name");
            String phone = (String) request.getAttribute("phone");
            String add = (String) request.getAttribute("add");
            DAOBill daoB = new DAOBill();
            DAOProduct dao = new DAOProduct();
            DAOBillDetail daoBD = new DAOBillDetail();
            String mess = null;
            double sum = 0;
            java.util.Enumeration em = session.getAttributeNames(); //is map
            ResultSet rs = dao.getData("Select * from Bill");
            while (rs.next()) {
                if (rs.getString(1).equals(oid)) {
                    mess = "Bill ID has already exist!";
                    request.setAttribute("mess", mess);
                    RequestDispatcher disp = request.getRequestDispatcher("/checkout.jsp");
                    disp.forward(request, response);
                }
            }
            if (mess == null) {
                while (em.hasMoreElements()) {
                    String id = em.nextElement().toString(); //get key
                    if (!id.equals("user") && !id.equals("us")) {
                        Product pro1 = (Product) session.getAttribute(id);
                        sum += pro1.getPrice() * pro1.getQuantity();
                        dao.updateQuantity(id, -pro1.getQuantity());
                    }
                    if (id.equals("user")) {
                        Customer cus = (Customer) session.getAttribute(id);
                        if (date == null || date.equals("")) {
                            daoB.insertBill1(new Bill(oid, date, name, phone, add, sum, 1, cus.getCid()));
                        } else {
                            daoB.insertBill(new Bill(oid, date, name, phone, add, sum, 1, cus.getCid()));
                        }
                    }
                }
                java.util.Enumeration em2 = session.getAttributeNames();
                while (em2.hasMoreElements()) {
                    String id = em2.nextElement().toString();
                    if (!id.equals("user") && !id.equals("us")) {
                        Product pro1 = (Product) session.getAttribute(id);
                        daoBD.insertBillDetail(new BillDetail(id, oid, pro1.getQuantity(), pro1.getPrice(), pro1.getQuantity() * pro1.getPrice()));
                        session.removeAttribute(id);
                    }
                }
                response.sendRedirect("ControllerProductCusView");
            }
        
      out.write("\n");
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
