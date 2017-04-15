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
 


package project;

import java.net.*;
import java.io.*;
public class Copier {
	 void copier(String str){
		URL url;
		BufferedReader br;
		InputStream is;
		
		String line;
		String strurl = str;
		File f1;
		FileWriter fw;
		
		try{
			url = new URL(strurl);
			is=url.openStream();
			br= new BufferedReader(new InputStreamReader(is));
			f1=new File("/project_file.txt");
			fw = new FileWriter(f1,false);
			while((line = br.readLine()) !=null){
				System.out.println(line);
				fw.write(line);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		
	}
}
