package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/include/Menu.html");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>File Upload</title>\n");
      out.write("        <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    ");

        Class.forName("com.mysql.jdbc.Driver");   
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureduplication","root","");
        String SeesionId = (String) session.getAttribute("userid");
        if(SeesionId == null)
            response.sendRedirect("login.jsp");
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <table width=\"95%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#FFFFFF\">\n");
      out.write("            ");
      out.write("<tr>\r\n");
      out.write("   <td class=\"image\" align=\"center\">\r\n");
      out.write("       EFFECTIVE MEMORY UTILIZATION AND INTEGRITY AUDITING IN CLOUD\r\n");
      out.write("   </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("   <td class=\"menuhead\">\r\n");
      out.write("      <a class=\"menus\" href=\"index.jsp\">Home</a>\r\n");
      out.write("      <a class=\"menus\" href=\"viewDetails.jsp\">User Details</a>\r\n");
      out.write("      <a class=\"menus\" href=\"upload.jsp\">Upload File</a>\r\n");
      out.write("      <a class=\"menus\" href=\"fileDetails.jsp\">File Details</a>\r\n");
      out.write("      <a class=\"menus\" href=\"logout.jsp\">Log out</a>\r\n");
      out.write("   </td>\r\n");
      out.write("</tr>\r\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td align=\"center\">\n");
      out.write("                    <p>&nbsp;</p>\n");
      out.write("                    <p class=\"bold\">User File Upload</p>\n");
      out.write("                    <form name=\"Upload\"  enctype=\"multipart/form-data\" method=\"post\" onSubmit=\"return validation()\" action=\"upload.jsp?va=1\">\n");
      out.write("                        <table width=\"484\" border=\"0\" align=\"center\" cellpadding=\"10\" cellspacing=\"0\" class=\"box-border\">\n");
      out.write("                            \n");
      out.write("                            <tr>\n");
      out.write("                                <td width=\"149\" class=\"bold\">Select File </td>\n");
      out.write("                                <td width=\"151\"><input name=\"FileName\" type=\"file\" class=\"bold\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"2\" align=\"center\"><input name=\"Submit\" type=\"submit\" class=\"button\" value=\"Upload\" /></td>\n");
      out.write("                            </tr>\n");
      out.write("\t                </table>\n");
      out.write("                        ");

                        String UserId = (String) session.getAttribute("userid");
                        String UserName = (String) session.getAttribute("username");
                        DiskFileItemFactory factory=new DiskFileItemFactory();
                        boolean isMultipart;
                        String filePath;
                        int maxFileSize=5000*1024;
                        int maxMemSize=5000*1024;
                        File file;
                        filePath=getServletContext().getInitParameter("file-upload");
                        isMultipart=ServletFileUpload.isMultipartContent(request);
                        if(!isMultipart)
                            out.println("no file uloaded");
                        factory.setSizeThreshold(maxMemSize);
                        factory.setRepository(new File("F:\\project"));
                        ServletFileUpload upload=new ServletFileUpload(factory);
                        upload.setSizeMax(maxFileSize);
                                               
                        try
                        {
                            List fileItems=upload.parseRequest(request);
                            Iterator i=fileItems.iterator();
                            out.println("file uploaded successfully");
                            while(i.hasNext())
                            {
                                FileItem fi=(FileItem)i.next();
                                if(!fi.isFormField())
                                {
                                    String fieldName=fi.getFieldName();
                                    String fileName=fi.getName();
                                    String contentType=fi.getContentType();
                                    boolean isInMemory=fi.isInMemory();
                                    long sizeInBytes=fi.getSize();
                                    if(fileName.lastIndexOf("\\")>=0)
                                    {
                                        file=new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));   
                                    }
                                    else
                                    {
                                        file=new File(filePath + fileName.substring(fileName.lastIndexOf("\\")+1));
                                    }
                                    fi.write(file);
                                    out.println("file uploaded to : " +filePath+ " from " + fileName+"<br>");
                                    String datafile = fileName;
                                    MessageDigest md = MessageDigest.getInstance("SHA1");
                                    FileInputStream fis = new FileInputStream(datafile);
                                    byte[] dataBytes = new byte[1024];
                                    int nread = 0; 
                                    while ((nread = fis.read(dataBytes)) != -1) 
                                    {
                                        md.update(dataBytes, 0, nread);
                                    }
                                    byte[] mdbytes = md.digest();
                                    StringBuffer sb = new StringBuffer("");
                                    for (int j = 0; j < mdbytes.length; j++) 
                                    {
                                        sb.append(Integer.toString((mdbytes[j] & 0xff) + 0x100, 16).substring(1));
                                    }
                                    String hashvalue=sb.toString();
                                    System.out.println("Digest(in hex format):: " + hashvalue);
                                    Statement s=con.createStatement();
                                    ResultSet r=s.executeQuery("Select Hash from document");
                                    Statement smt = con.createStatement();
                                    Statement Inssmt = con.createStatement();
                                    ResultSet rs = smt.executeQuery("select max(id) as cnt from document");
                                    int id=0;
                                    if(rs.next())
                                    {
                                        id = rs.getInt("cnt");
                                    }
                                    while(r.next())
                                    {
                                        String check=r.getString("Hash");
                                        if(check.equals(hashvalue))
                                        {
                                            out.println("dup");
                                        }
                                        if(!check.equals(hashvalue))
                                        {
                                    
                                    id = id + 1;
                                    int n = Inssmt.executeUpdate("insert into document values("+id+",'"+UserId+"','"+UserName+"','"+fileName+"','"+hashvalue+"')");
                                    break;
                                    }   }
                                }
                            }
                        }
                        catch (Exception e) 
                        {
                            //out.println(e.getMessage());
                        }
                                                                    
                        
      out.write("\n");
      out.write("                    </form></td></tr></table>\n");
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
