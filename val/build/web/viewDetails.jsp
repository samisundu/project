<%@page import="java.sql.*" %>
<html>
    <head>
        <title>User Details</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="JavaScript" src="validate.js"></script>
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
        <table background="bg-body.jpg" width="402" border="0" align="center" cellpadding="10" cellspacing="0" class="box-border">
        <%
            ResultSet rs=null;
            String UserId = (String) session.getAttribute("userid");
            String UserName = (String) session.getAttribute("username");
            try
            {
                Statement smt=con.createStatement();
                rs=smt.executeQuery("select * from user_details where user_id = '"+UserId+"'");
                if(rs.next())
                {
        %>
        <tr>
            <td width="149" class="bold">Name</td>
            <td width="151" class="bold">
            <%out.println(rs.getString("user_name"));%>
            </td>
          </tr>
          <tr>
            <td class="bold">Email Address </td>
            <td class="bold">
            <%out.println(rs.getString("email"));%>
            </td>
          </tr>
          <tr>
            <td class="bold">Contact Number </td>
            <td class="bold">
            <%out.println(rs.getString("contactno"));%>
            </td>
          </tr>
          <tr>
            <td class="bold">Address</td>
            <td class="bold">
            <%out.println(rs.getString("address"));%>
            </td>
          </tr>
          <tr>
            <td class="bold">UserName</td>
            <td class="bold">
            <%out.println(rs.getString("username"));%>
            </td>
          </tr>
          <tr>
            <td class="bold">Password</td>
            <td class="bold">
            <%out.println(rs.getString("password"));%>
            </td>
          </tr>
        </table>
            <%
                }
            }
            catch(Exception e)
            {
               out.println(e.getMessage());
            }
            %>
        </td></tr></table>
    </body>
</html>