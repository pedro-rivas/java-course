import java.util.Scanner;
import java.util.Arrays;

public class HellowWorld{

	public static void main( String args[] ) { 
		Scanner console = new Scanner( System.in ); 

		String s = "0123456789";
		String[] numbers = s.split("");

		System.out.print("Enter a 10 digits phone number:: ");    
		String phoneNumb = console.next();
		// System.out.println(phoneNumb);   
		String phoneNumbe = phoneNumb.replace(" ", "");
		String phoneNumber = phoneNumbe.replace("-", "");
		// System.out.println(phoneNumber);   
		if(phoneNumber.length() != 10){
			System.out.println("invalid number");
		}else{
			String[] phoneNumberArray = phoneNumber.split("");
			boolean validNumber = true;
			for (int i = 0; i < phoneNumberArray.length; i++) { 
				boolean isNumber = false;
				for (int n = 0; n < numbers.length; n++) { 
					if(phoneNumberArray[i].compareTo(numbers[n]) == 0) {
						isNumber = true;
					    break;
					} 
				}
				if(isNumber == false){
					validNumber = false;
					break;
				}
			} 
			if(validNumber == true){
				System.out.println("valid number");
			}else{
				System.out.println("invalid number");
			}
		}	
	 }
 }