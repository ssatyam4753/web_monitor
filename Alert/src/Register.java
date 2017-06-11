

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;




public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Register() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("first_name : "+request.getParameter("first_name"));
		out.println("last_name : "+request.getParameter("last_name"));
		out.println("email : "+request.getParameter("email"));
		out.println("username : "+request.getParameter("username"));
		out.println("gender : "+request.getParameter("gender"));
		out.println("age : "+request.getParameter("age"));
		out.println("password : "+request.getParameter("password"));
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alert","root","");
			PreparedStatement ps = con.prepareStatement("insert into tbl_user values(?,?,?,?,?,?,?)");
			ps.setString(1, request.getParameter("first_name"));
			ps.setString(2, request.getParameter("last_name"));
			ps.setString(3, request.getParameter("email"));
			ps.setString(4, request.getParameter("username"));
			ps.setString(5, request.getParameter("gender"));
			ps.setString(6, request.getParameter("age"));
			ps.setString(7, request.getParameter("password"));
			int flag = ps.executeUpdate();
			if(flag==7){
				out.println("successfully registered");
			}
		}	catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
