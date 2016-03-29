<%@page import = "java.io.*" %>
<%@page import = "java.sql.*" %>
<%@page import = "java.util.*" %>
<%@page import = "java.security.*" %>
<%@page import = "javax.servlet.*"  %>
<%@page import = "javax.servlet.http.*"  %>
<%@page import = "org.apache.commons.fileupload.*"  %>
<%@page import = "org.apache.commons.fileupload.disk.*"  %>
<%@page import = "org.apache.commons.fileupload.servlet.*"  %>
<html>
    <head>
        <title>File Upload</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
    </head>
    <%
        Class.forName("com.mysql.jdbc.Driver");   
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureduplication","root","");
        String SeesionId = (String) session.getAttribute("userid");
        if(SeesionId == null)
            response.sendRedirect("login.jsp");
    %>
    <body>
        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
            <%@include file="include\Menu.html" %>
            <tr>
                <td align="center">
                    <p>&nbsp;</p>
                    <p class="bold">User File Upload</p>
                    <form name="Upload"  enctype="multipart/form-data" method="post" onSubmit="return validation()" action="upload.jsp?va=1">
                        <table background="bg-body.jpg" width="484" border="0" align="center" cellpadding="10" cellspacing="0" class="box-border">
                            
                            <tr>
                                <td width="149" class="bold">Select File </td>
                                <td width="151"><input name="FileName" type="file" class="bold" /></td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center"><input name="Submit" type="submit" class="button" value="Upload" /></td>
                            </tr>
	                </table>
                        <%
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
                            out.println("select a file to upload");
                        factory.setSizeThreshold(maxMemSize);
                        factory.setRepository(new File("F:\\project"));
                        ServletFileUpload upload=new ServletFileUpload(factory);
                        upload.setSizeMax(maxFileSize);
                                               
                        try
                        {
                            List fileItems=upload.parseRequest(request);
                            Iterator i=fileItems.iterator();
                            while(i.hasNext())
                            {
                                FileItem fi=(FileItem)i.next();
                                if(!fi.isFormField())
                                {
                                    //String fieldName=fi.getFieldName();
                                    String fileName=fi.getName();
                                    String contentType=fi.getContentType();
                                    //boolean isInMemory=fi.isInMemory();
                                    //long sizeInBytes=fi.getSize();
                                   // if(fileName.lastIndexOf("\\")>=0)
                                    //{
                                        file=new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));   
                                   // }
                                   /* else
                                    {
                                        file=new File(filePath + fileName.substring(fileName.lastIndexOf("\\")+1));
                                    }*/
                                    fi.write(file);
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
                                    ResultSet r=s.executeQuery("select Hash from document");
                                    int a=0;
                                    while(r.next())
                                    {
                                        String check=r.getString("Hash");
                                        if(check.compareTo(hashvalue)==0)
                                        {
                                            a=1;
                                        }
                                        else
                                        {
                                        }    
                                    }
                                    if(a==1)
                                    {
                                        out.println("<br>FILE ALREADY EXISTS<BR>");
                                        out.println("YOU CAN FOUND IT IN  "  + fileName+"<br>");
                                    }
                                    if(a==0)
                                    {
                                        out.println("<br>FILE UPLOADED TO : " +filePath+ " FROM " + fileName+"<br>");
                                        Statement smt = con.createStatement();
                                        Statement Inssmt = con.createStatement();
                                        ResultSet rs = smt.executeQuery("select max(id) as cnt from document");
                                        int id=0;
                                        if(rs.next())
                                        {
                                            id = rs.getInt("cnt");
                                        }
                                        id = id + 1;
                                        int n = Inssmt.executeUpdate("insert into document values("+id+",'"+UserId+"','"+UserName+"','"+fileName+"','"+hashvalue+"')");
                                    }  
                                } 
                            }
                        }
                        catch (Exception e) 
                        {
                            System.out.println(e.getMessage());
                        }
                                                                    
                        %>
                    </form></td></tr></table>
    </body>
</html>
