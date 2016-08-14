
public class HttpRequest {
	String filename;

	//we have to create constructor which accept the string 
	public HttpRequest(String request) {
		
		
		System.out.println("10.this in request");
		//now we have request we need onlly first line
		//first line contain three thing 1.-> requset type 2.->file name 3.->http version 
		//we need only file name
		
		String lines[]=request.split("\n");//here we get all lines seperately
		System.out.println(lines[0]);
		//this take the first line of request .and split the first line using space " " and select the second item
		filename =lines[0].split(" ")[1];
		
	}
		
}
