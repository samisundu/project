<%@page import="java.sql.*" %>
<html>
    <head>
        <title>User Details</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script language="JavaScript" src="validate.js"></script>
    </head>
    <body>
        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <%@include file="include\loginMenu.html" %>
        <tr>
        <td align="center">
        <p>&nbsp;</p>
        <p class="bold">Registration</p>
        <form name="Register" action="registration.jsp?va=1" method="post" onSubmit="return regValidate()">
        <table background="bg-body.jpg" width="402" border="0" align="center" cellpadding="10" cellspacing="0" class="box-border">
            <tr>
                <td width="149" class="bold">Name</td>
                <td width="151"><input name="name" type="text" class="bold"  id="name"/></td>
            </tr>
            <tr>
                <td class="bold">Email Address </td>
                <td><input name="email" type="email" class="bold" id="email"/></td>
            </tr>
            <tr>
                <td class="bold">Contact Number</td>
                <td><input name="contact" class="bold"  id="contact"/></td>
            </tr>
            <tr>
                <td class="bold">Address</td>
                <td><input name="address" type="text" class="bold"  id="address"/></td>
            </tr>
            <tr>
                <td class="bold">UserName</td>
                <td><input name="username" type="text" class="bold" id="username"/></td>
            </tr>
            <tr>
                <td class="bold">Password</td>
                <td><input name="password" type="password" class="bold" id="password" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input name="Submit" type="submit" class="button" value="Register" /></td>
            </tr>
        </table>
            <%
                Class.forName("com.mysql.jdbc.Driver");   
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureduplication","root","");
                String ent = request.getParameter("va");
                if (ent != null) 
                {
                    String name = request.getParameter("name");
                    String email = request.getParameter("email");
                    String contact = request.getParameter("contact");
                    String address = request.getParameter("address");
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    try 
                    {
                        Statement smt = con.createStatement();
                        Statement smt1 = con.createStatement();
                        Statement smt2 = con.createStatement();
                        ResultSet rs = smt.executeQuery("select max(id) as cnt from user_details");
                        int Id = 0;
                        if (rs.next()) 
                        {
                            Id = rs.getInt("cnt");
                        }
                        Id = Id + 1;
                        String UserId = "USR" + Id;
                        ResultSet rs1 = smt.executeQuery("select * from user_details where username='" + username + "'");
                        if (rs1.next()) 
                        {
                            out.println("Username already exists");
                        } 
                        else 
                        {
                            int n = smt1.executeUpdate("insert into user_details values(" + Id + ",'" + UserId + "','" + name + "','" + email + "','" + contact + "','" + address + "','" + username + "','" + password + "')");
                            if (n == 1) 
                            {
                                out.println("Register successfully..");
                            }
                        }
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e.getMessage());
                    }
                }
            %>
        </form>
        </td></tr></table>
    </body>
</html>