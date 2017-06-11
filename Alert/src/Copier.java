/*******************************************************************************
 * this module uses openStream method to open a stream to the url and          * 
 * copies the page script using a bufferedreader and writes the same script to * 
 * a file.                                                                     * 
 *                                                                             *
 *                                                                             *
 *                                                                             *
 *                                                                             *
 *                                                                             *
 *                                                                             *
 *                                                                             *
 *                                                                             *
 ******************************************************************************/
 

import java.net.*;
import java.io.*;
import java.sql.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Copier {
	 void copier(String str,String u_name){
		URL url;
		BufferedReader br,br1;
		InputStream is;
		int flag_update=0;
		String line;
		String strurl = str;
		File f1,f2;
		FileOutputStream fout1,fout2;
		String file_name = "H:/"+u_name+".html";
		System.out.println(file_name);
		try{
			Class.forName("com.mysql.jdbc.Driver");	
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/alert","root","");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from name_list");
			while(rs.next()){
				System.out.println(rs.getString(2));
			}
			PreparedStatement ps = con.prepareStatement("insert into name_list values(?,?)");
			ps.setString(1, null);
			ps.setString(2, u_name);			
			flag_update=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			url = new URL(strurl);
			is=url.openStream();
			br= new BufferedReader(new InputStreamReader(is));
			
			f1=new File(file_name);
			f2=new File("H:/temp_file.html");

			fout1 = new FileOutputStream(f1,false);
			fout2 = new FileOutputStream(f2,false);
			
			if(flag_update==1){
				System.out.println("creating file"+u_name);
				System.out.println("writing into file"); 
				while((line = br.readLine()) !=null){
					System.out.println(line);
					fout1.write(line.getBytes());
				}
			}
			else{
				while((line = br.readLine()) !=null){
			//		System.out.println(line);
					fout2.write(line.getBytes());
				}
				Compare cmp = new Compare();
				int flag=cmp.compare(file_name);
				System.out.println("back in copier");
				{
					if(flag==1){
						//do nothing
						System.out.println("no change");
					}
					else{
						FileInputStream fin = new FileInputStream(f2);
						br1=new BufferedReader (new InputStreamReader(fin));
						
						while((line = br1.readLine()) !=null){
							//System.out.println(line);
							fout1.write(line.getBytes());
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		
	}
}
