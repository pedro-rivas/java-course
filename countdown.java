import java.util.Scanner;
 
 public class HelloWorld{
	 public static void main( String args[] ) { 
		 Scanner console = new Scanner( System.in ); 
		 
		 /*System.out.print("Name: ");       
		 String name = console.nextLine();
		 
		 System.out.print("Course: ");       
		 String actualCourse = console.nextLine();*/
		 
		 System.out.print("number of x: ");    
		 int x = console.nextInt();
		 while(x > 0) {
			 x--;
			 System.out.println("x: " + x);
		 }
		 System.out.println("x: " + x);
		 
		 /*System.out.print("Semester: ");   
		 int semester = console.nextInt();
		 
		 System.out.println("\nThe Data entered is:");  
		 System.out.println("Hi " + name +"!");      
		 System.out.println("Your code is: " + studentCode);    
		 System.out.println("Current semester: " + semester);*/
		 
	 }
 }