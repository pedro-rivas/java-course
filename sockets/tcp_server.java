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
			out = new DataOutputStream(ns.getOutputStream());  
			
			int n;

			int vector[] = new int[5];

			for(int i = 0; i < 5; i++) {
				n = in.readInt();
				vector[i] = n;
				System.out.println("==" + n + "=="); 
			}

			message = greatest(vector);

			System.out.println("+ writing to socket"); 
			System.out.println("=> " + message); 

			out.flush();   
			out.writeInt(message);
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

	public int greatest(int[] x){
		int biggest = 0;

		System.out.println("+ calculating the biggest number. ");

		for(int i = 0; i < x.length; i++) {
			if(x[i] > biggest) biggest = x[i];
		}

		System.out.println("+ biggest number found. ");
		
		return biggest;
	}
}
