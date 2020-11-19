import java.io.*;
import java.net.*; 

//https://docs.oracle.com/javase/7/docs/api/java/io/DataInputStream.html

public class tcp_client {   
	
	public static void main(String[] args) { 
		do{
			Socket echoSocket = null;     
			DataOutputStream os = null;   
			DataInputStream is = null;    
			DataInputStream stdIn = new DataInputStream(System.in);   
			System.out.println("Echo Client...\nWrite a string and type return\n");  
		
		
			try {
				echoSocket = new Socket("localhost", 5001); 
				os = new DataOutputStream(echoSocket.getOutputStream()); 
				is = new DataInputStream(echoSocket.getInputStream());      
			}       
			catch (UnknownHostException e) {         
				System.err.println("Don't know about host: localhost");   
			}      
			catch (IOException e) {       
				System.err.println("Couldn't get I/O for the connection to: localhost");   
			}  
		
			if (echoSocket != null && os != null && is != null) {        
				try {  
						//String userInput;  
						//userInput = stdIn.readLine();   
						int userInput = stdIn.readInt();
						os.writeByte(userInput);       
						os.writeByte('\n');    

						System.out.println("=> " + is.readInt());
						os.close();           
						is.close();        
						echoSocket.close();     
					
				}
				catch (IOException e) {             
					System.err.println("I/O failed on the " + "connection to: localhost");        
				}      
			}

		}while(true);
			
	}
	
}