import java.util.Scanner;
 
 public class HelloWorld{
	 public static void main( String args[] ) { 
		 Scanner console = new Scanner( System.in ); 
		 
		 int option = 0;
		 
		 do {
			 
			 System.out.println("Select an option: ");
			 System.out.println("1: Add student ");
			 System.out.println("2: Delete student ");
			 System.out.println("3: Update student ");
			 System.out.println("4: Exit ");
			 
			 System.out.print("Option: ");    
			 option = console.nextInt();
			 
			 switch(option){
			 	 case 1:
			 		System.out.println("=> Add student"); 
			 		break;
			 	 case 2:
			 		System.out.println("=> Delete student"); 
			 		break;
			 	 case 3:
			 		System.out.println("=> Update student"); 
			 		break;
			 	 default:	
			 		System.out.println("Bye"); 
			 }
			 
		 }while(option != 4);
		 
	 }
 }