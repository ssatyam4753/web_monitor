/***********************************************************************************
*This module acts as the main and drives all other modules                         *                   
*                                                                                  *
*    it takes user input that is a url and calls copier to copy the page script    *
*     from web and writes it in a file                                             *
*                                                                                  *
*                                                                                  *
*                                                                                  *
*                                                                                  *
*                                                                                  *
*                                                                                  *
*                                                                                  *
*                                                                                  *
************************************************************************************/
package project;
import java.util.*;

public class Driver {

	public static void main(String[] args){

		String url;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Url");
		url = sc.nextLine();

		url = protocolCheck(url) ;

		Copier cp = new Copier();
		cp.copier(url);
		
	}
	
	//		method  to verify and add default protocol
	
	static String protocolCheck(String url){
		
		char[] protocol = new char[10];
		char ch =url.charAt(0);
		int i =0;
		boolean flag= false;
		//		loop to extract protocol from url
		while(ch!=':'){
			ch=url.charAt(i);
			if(i==6)break;
			if(ch==':'){flag=true;  break;}
			protocol[i]=url.charAt(i);
			++i;
		 }
		//        System.out.println(protocol);
		if (flag == false ){
			//		System.out.println("no protocol specified");
			url="http://"+url;
			//      System.out.println("default protocol added    "+url);
		}
		return url;
	}
}
