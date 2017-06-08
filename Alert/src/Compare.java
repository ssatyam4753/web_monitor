
import java.io.*;
import java.net.*;

public class Compare {
	
	public  int compare(String name){
		
		BufferedReader br1,br2;
		try{
			
			System.out.println("in the compare method");
			
			File f1=new File("H:/permanent_file.html");
			File f2=new File("H:/temp_file.html");
			
			
			FileInputStream fin1 = new FileInputStream(f1);
			FileInputStream fin2 = new FileInputStream(f2);
			
			br1 = new BufferedReader(new InputStreamReader(fin1));
			br2 = new BufferedReader(new InputStreamReader(fin2));
			
			String str2=br2.readLine();
			System.out.println(str2);
			
			String str1=br1.readLine();
			System.out.println(str1);
			
			System.out.println("comparing files");
			if(str1.equals(str2)){
				System.out.println("line equal ");
				return 1;
				
			}
			else{
					System.out.println("line not equal ");
							return 0;
				}
			
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		//br1.close();
		//br2.close();
		}
		
		return 0;
	}

}

