import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		PrintWriter out = response.getWriter();
		String uname=request.getParameter("username");
//		out.println(uname);
		
		String password=request.getParameter("password");
//		out.println(password);
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alert","root","");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from tbl_user");
		/*if(rs.next()){
			out.println("hello"+uname);
		}
		else{
			out.println("wrong username or password");
		}*/
		
		while(rs.next()){
			if(uname.equals(rs.getString("username"))&&password.equals(rs.getString("password"))){
				out.println("hello"+uname);
				response.sendRedirect("H:/programs/Alert/WebContent/index.jsp");
			}
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		doGet(request,response);
	}
	
}