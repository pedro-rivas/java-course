import java.io.*;
import java.net.*; 

class tcp_server { 
	
	ServerSocket server;  
	Socket ns;    
	DataOutputStream out;  
	DataInputStream in;  
	
	int message;  
	
	public void listenSocket(){ 
		try{  

			server = new ServerSocket(5001, 10);
			ns = server.accept();  
			
			System.out.println("reading from socket..."); 
			in = new DataInputStream(ns.getInputStream()); 
			
			message = in.readInt(); 
			
			//String gretting;

			System.out.println("<= " + message); 

			// if(message.compareTo("saludo") == 0){
			// 	gretting = greatest(message);
			// }else{
			// 	gretting = "adios";
			// }
			  
			System.out.println("writing to socket"); 
			
			out = new DataOutputStream(ns.getOutputStream());  
			
			out.flush();   
			out.writeByte(message);  
			out.writeByte('\n');     
			out.flush();  

		}
		catch (IOException e) {  
			System.out.println("Accept failed: 5000");   
			System.exit(-1); 
		} 
	}
		
	protected void finalize(){ 
		try{ 
			in.close();    
			out.close();   
			server.close(); 
		} 
		catch (IOException e) {   
			System.out.println("Could not close.");  
			System.exit(-1);  
		} 
	}	
		
	public static void main(String[] args){   
		System.out.println("Echo Server...");    
		tcp_server s = new tcp_server(); 
		do{
			s.listenSocket(); 
			s.finalize();  
		}while(true);
			
	}

	public String greatest(String x){
		//x = "hey";
		return "hey";
	}
}
