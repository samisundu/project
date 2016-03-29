<html>
    <head>
        <title>User Login</title>
        <link href="style.css" rel="stylesheet" type="text/css">
        <script src="validate.js" type="text/javascript"></script>
    </head>
    <body>
        <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
            <%@include file="include\homeMenu.html" %><tr><td>
            <p>&nbsp;</p><center>
            <h3>Authorized User Login</h3></center>
                    <form name="Login" action="login.jsp?va=1" method="post" onSubmit="return LoginValidate()">
                        
                        <table background="bg-body.jpg" width="454" border="0" align="center" cellpadding="15" cellspacing="0" class="box-border">
                            <tr>
                                <td class="bold" align="center"><br>USERNAME</td>
                                <td align="center"><br><input type="text" class="bold" name="UserName" value="" /></td>
                            </tr>
                            <tr>
                                <td class="bold" align="center">PASSWORD</td>
                                <td align="center"><input type="password" class="bold" name="Password" value="" /></td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center"><input class="button" name="Submit" type="submit" value="Login" /></td>
                            </tr>
                        </table>
                        <%@include file="include\connection.jsp"%>
                        <%
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
                        %>
                    </form>
        </td></tr></table>
    </body>
</html>