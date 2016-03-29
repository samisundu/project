import java.sql.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class viewDetails extends HttpServlet 
{
    Connection con=null;
    ResultSet rs=null;
    Statement st=null;
    
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");   
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/secureduplication","root","");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        response.setContentType("text/html"); 
        PrintWriter out=response.getWriter();
        try
        {
            String UserId=request.getParameter("user_id");
            Statement smt = con.createStatement();
            rs = smt.executeQuery("select * from user_details where user_id = '"+UserId+"'");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}