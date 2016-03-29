package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/include/homeMenu.html");
    _jspx_dependants.add("/include/connection.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>User Login</title>\n");
      out.write("        <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <script src=\"validate.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table width=\"98%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#FFFFFF\">\n");
      out.write("            ");
      out.write("<tr>\r\n");
      out.write("   <td class=\"image\" align=\"center\">\r\n");
      out.write("       EFFECTIVE MEMORY UTILIZATION AND INTEGRITY AUDITING IN CLOUD\r\n");
      out.write("   </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("   <td class=\"menuhead\">\r\n");
      out.write("      <a class=\"menus\" href=\"index.jsp\">Home</a>\r\n");
      out.write("      <a class=\"menus\" href=\"registration.jsp\">Register</a>\r\n");
      out.write("   </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr><td>\n");
      out.write("            <p>&nbsp;</p><center>\n");
      out.write("            <h3>Authorized User Login</h3></center>\n");
      out.write("                    <form name=\"Login\" action=\"login.jsp?va=1\" method=\"post\" onSubmit=\"return LoginValidate()\">\n");
      out.write("                        \n");
      out.write("                        <table background=\"bg-body.jpg\" width=\"454\" border=\"0\" align=\"center\" cellpadding=\"15\" cellspacing=\"0\" class=\"box-border\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"bold\" align=\"center\"><br>USERNAME</td>\n");
      out.write("                                <td align=\"center\"><br><input type=\"text\" class=\"bold\" name=\"UserName\" value=\"\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"bold\" align=\"center\">PASSWORD</td>\n");
      out.write("                                <td align=\"center\"><input type=\"password\" class=\"bold\" name=\"Password\" value=\"\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"2\" align=\"center\"><input class=\"button\" name=\"Submit\" type=\"submit\" value=\"Login\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        ");
      out.write("\n");
      out.write("        ");

        Class.forName("com.mysql.jdbc.Driver");   
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureduplication","root","");
        
      out.write("\n");
      out.write("                        ");

                        //String path=request.getContextPath();
                  //out.println(path);
                        String ent = request.getParameter("va");
                                        if (ent != null) {
                        Statement smt = null;
                        ResultSet rs = null;
                        String UserName = request.getParameter("UserName");
                        String Password = request.getParameter("Password");
                        try
                        {
                            smt = con.createStatement();
                            rs = smt.executeQuery("select * from user_details where username='" + UserName + "' and password='" + Password + "'");
                            if (rs.next()) 
                            {
                                session.setAttribute("userid", rs.getString("user_id"));
                                session.setAttribute("username", rs.getString("user_name"));
                                response.sendRedirect("viewDetails.jsp");
                            }
                            else
                            {
                                out.println("error");
                            }

                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                                               }
                        
      out.write("\n");
      out.write("                    </form>\n");
      out.write("        </td></tr></table>\n");
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
}
