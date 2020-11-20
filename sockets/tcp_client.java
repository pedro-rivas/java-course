import java.io.*;
import java.net.*; 
import java.util.Scanner;

//https://docs.oracle.com/javase/7/docs/api/java/io/DataInputStream.html

public class tcp_client {   
	
	public static void main(String[] args) { 
		do{
			Socket echoSocket = null;     
			DataOutputStream os = null;   
			DataInputStream is = null;      
			Scanner stdIn = new Scanner( System.in );
			
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

						int userInput; 
						// int len = stdIn.nextInt();
						// os.writeInt(len);

						System.out.println("Echo Client...\nWrite 5  numbers \n");  

						for(int i = 0; i < 5; i++) {
							System.out.println(":: " + i); 
							userInput = stdIn.nextInt();
							os.writeInt(userInput);
						}
						// userInput = stdIn.nextInt();
						// os.writeInt(userInput);
						//System.out.println("<=" + userInput);
						System.out.println("+ awaiting output..");
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