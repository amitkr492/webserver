import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//this class handles all the connection contains the requests
public class ConnectionHandler extends Thread {
	//this is the thread class.
	
	Socket s;
	//for sending the output to client
	PrintWriter pw;
	
	//for generating the input from client;
	BufferedReader br;
	//constructer which take arguement as socket 
	public ConnectionHandler (Socket s) throws Exception{
		System.out.println("5.thsis");
		this.s=s;
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		pw=new PrintWriter(s.getOutputStream());
		System.out.println("6.thsis");
	}
	
	
	//in this method we read the request and response back
	@Override
	public void run() {
		try{
		//here we get string and give this request to the HttpRequest class
			
		String reqS="";
		
		//from br we have to the read the request
		//read until request is nog get   
		while(br.ready() || reqS.length()==0)
		reqS+=(char) br.read();
		System.out.println("9.thsis");
		System.out.println(reqS);
		HttpRequest req=new HttpRequest(reqS); //for displaying the request
		
		//now we send the http request to HttpResponse
		
		HttpResponse res=new HttpResponse(req);
		
		
		
		//write the final output to pw
		pw.write(res.response.toCharArray());
		
		pw.close();
		br.close();
		System.out.println("closing");
		s.close();
		System.out.println("finally closed");
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
