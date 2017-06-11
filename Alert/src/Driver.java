import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class Driver extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Driver() {
        super();
    }
	
                      //**get method to process user's request**//
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url;
		url = request.getParameter("url");
		PrintWriter out = response.getWriter();
		url = protocolCheck(url) ;
		String UniqueName=getName(url);
		System.out.println("UniqueName returned : "+UniqueName);
		
		
		Copier cp = new Copier();
		cp.copier(url,UniqueName);
		System.out.println("operation success ");
		
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
				//System.out.println(protocol);
		if (flag == false ){
				System.out.println("no protocol specified");
			url="http://"+url;
				System.out.println("default protocol added  "+url);
		}
		return url;
	}
	
						//** method to generate unique name **//
	
	public String getName(String str){
		System.out.println("enter url");
		try{

			String url = str;
			System.out.println("url entered by you"+url);
			byte[] Byte = url.getBytes();
			byte[] name = {95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95};
			int i =0,j=0,flag=0;
			String Name;
			while(i<Byte.length){
				System.out.println((char)Byte[i]);
				if(Byte[i]==46&&flag==0){
					i++;flag=1;
					while(i<Byte.length){
						if(Byte[i]==46){i++;continue;}
						name[j]=Byte[i];
						j++;i++;
					}
				}
				i++;
			}
			String str1 = new String(name);
			str1=str1.trim();
			return str1;
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	
	}
}
