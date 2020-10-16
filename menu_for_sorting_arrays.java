import java.util.Scanner;
 
public class HellowWorld{

	public static void main( String args[] ) { 
		Scanner console = new Scanner( System.in ); 
		int[] _array = new int[5];
		int option = 0;

		do {
			 
			System.out.println("Select an option: ");
			System.out.println("1: Sort (ascending) ");
			System.out.println("2: Sort (descending)");
			System.out.println("3: Exit ");

			System.out.print("option:: ");    
			option = console.nextInt();
			
			switch(option){
				 case 1:
					for(int i = 0; i < _array.length; i++){
						System.out.println("=> Add number ");
						_array[i] = console.nextInt();
					}
					System.out.println("Your selection::");
					print(_array);
					directSortAsce(_array);
					System.out.println("Your selection sorted ascending");
					print(_array);
					break;
				 case 2:
					for(int i = 0; i < _array.length; i++){
						System.out.println("=> Add number ");
						_array[i] = console.nextInt();
					}
					System.out.println("Your selection::");
					print(_array);
					bubbleSortDesc(_array);
					System.out.println("Your selection sorted descending");
					print(_array);
					break;
				 case 3:
				 	System.out.println("bye"); 
					break;
				 default:	
					System.out.println("Select a valid option"); 
			}
			
		}while(option != 3);

	 }
	 
	 static void print(int a[]) {
		 for(int n: a) {
			 System.out.println(n);
		 }
	 }
	 
	 static void sort(int a[]) {
		 
	 }
	 static void bubbleSortAsce(int a[]) {
		 int i;
		 int j;
		 int tmp;
		 int length = a.length;
		 
		 for(i=0; i < length-1; i++) {
			 for(j=0; j< length-1-i; j++) {
				 if(a[j+1] < a[j]) {
					 tmp = a[j];
					 a[j] = a[j+1];
					 a[j+1] = tmp;
				 }
			 }
		 }
		 
	 }
	 
	 static void bubbleSortDesc(int a[]) {
		 int i;
		 int j;
		 int tmp;
		 int length = a.length;
		 
		 for(i=0; i < length-1; i++) {
			 for(j=0; j< length-1-i; j++) {
				 if(a[j+1] > a[j]) {
					 tmp = a[j];
					 a[j] = a[j+1];
					 a[j+1] = tmp;
				 }
			 }
		 }
	 }

	static void directSortAsce(int a[]){
		int k; 
		int menor; 
		int i; 
		int j; 
		int n = a.length; 
		for(i=0; i < n-1; i++) {
			k = i;      
			menor= a[i]; 
			for(j=i+1; j<n; j++) {
				if(a[j] < menor){ 
					k = j;        
					menor= a[k];           
					a[k] = a[i];  
					a[i] = menor; 
				}
			}
		}
	 }
 }