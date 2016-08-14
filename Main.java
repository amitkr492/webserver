import java.net.ServerSocket;
import java.net.Socket;
public class Main {
	ServerSocket serversocket;
	
	//entry point of our program
	
	public static void main(String[] args) throws Exception {
		System.out.println("1.thsis");
		new Main().runServer(); //to avoid any problem with static fields
		

	}
	
	public void runServer() throws Exception {
		System.out.println("2.server has started");
		serversocket=new ServerSocket(8005);
		
		acceptRequests();
		System.out.println("thsis");
		
	}
		
	private void acceptRequests() throws Exception{
		System.out.println("3.thsis");
		while(true) //we have to accept all the request;
		{
			System.out.println("4.thsis");
			//connection to client in form of socket which contain input and output.
			Socket s=serversocket.accept();
			System.out.println("4.thsis");
			ConnectionHandler ch=new ConnectionHandler(s);
			System.out.println("7.thsis");
			//ch is the thread so it is required to start
			ch.start();  // this will call the void run method automatically
		}
	}
}
 