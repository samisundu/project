<%@page import="java.sql.*" %>
<html>
    <head>
        <title>User Details</title>
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
        <p class="bold">User Details</p>
        <table width="50%" border="0" align="center" cellpadding="15" cellspacing="12" class="box-border">
        <tr>
              <td class="bold">S No</td><td class="bold">File Name</td>
          </tr></table><table background="bg-body.jpg" width="50%" border="0" align="center" cellpadding="15" cellspacing="12" class="box-border">
            <%
            ResultSet rs=null;
            String UserId = (String) session.getAttribute("userid");
            String UserName = (String) session.getAttribute("username");
            try
            {
                Statement smt=con.createStatement();
                int sno=0;
                rs=smt.executeQuery("select * from document where userid = '"+UserId+"'");
                while(rs.next())
                {
                    sno++;
        %>
        
          
          <tr>
            <td>
            <%out.println(sno);%>
            </td>
            <td>
            <%out.println(rs.getString("fileName"));%>
            </td>
          
            <%
                }
            }
            catch(Exception e)
            {
               out.println(e.getMessage());
            }
            %>
            </tr>
          
        </table>
        </td></tr></table>
    </body>
</html>