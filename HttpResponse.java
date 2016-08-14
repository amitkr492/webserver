import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class HttpResponse {
		String response;//this the final response which is generated
		
		//the root path of server it is the path of server which contain all files name
		String root="C:/root"; 
		HttpRequest req;
		public HttpResponse(HttpRequest request){
			try{
			req=request;
			
			//now we have to open the file which has been mention in the request.\
			System.out.println("file name is " + req.filename);
			
			
			File f=new File(root + req.filename);
			
			
			response="HTTP/1.1 200 \r\n"; //version number and response code
			response+="serv:AMIT java server\r\n";
			response+="content type: text/html";
			
			
			//this line tell the browser that close the connectin 
			response+="Connection: close\r\n";
			response+="content length :" + f.length()+ "\r\n";
			response+="\r\n";
			
			
			
			
			//to read this file
			FileInputStream fis =new FileInputStream(f);
			int s;
			while((s= fis.read()) != -1){
				//-1 mean end of file
				response+=(char) s;
			}
			fis.close();
			}catch(FileNotFoundException e)
			{
				//if we do not get file then we send 404 error
				response=response.replace("200", "404");
				e.printStackTrace();
				
			}
			catch (Exception e)
			{
				//other error is 500 that is server internal error
				response=response.replace("200", "500");
				e.printStackTrace();
			}
		}
}
