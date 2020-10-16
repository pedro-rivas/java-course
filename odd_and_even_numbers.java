import java.util.Scanner;
 
public class HellowWorld{

	public static void main( String args[] ) { 
		Scanner console = new Scanner( System.in ); 
		int[] _array = new int[10];
		int[] oddNumbers = new int[10];
		int[] evenNumbers = new int[10];
		
		for(int i = 0; i < _array.length; i++){
			System.out.println("=> Add number ");
			_array[i] = console.nextInt();
		}
		for(int i = 0; i < _array.length; i++){
			if(_array[i]%2 == 0){
				evenNumbers[i] = _array[i];
			}else{
				oddNumbers[i] = _array[i];
			}
		}
		System.out.println("Odd numbers");
		directSortDesc(oddNumbers);
		print(oddNumbers);

		System.out.println("Even numbers");
		directSortDesc(evenNumbers);
		print(evenNumbers);
	 }
	 
	 static void print(int a[]) {
		 for(int n: a) {
			 if(n !=  0){
				System.out.println(n);
			 }
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

	static void directSortDesc(int a[]){
		int k; 
		int menor; 
		int i; 
		int j; 
		int n = a.length; 
		for(i=0; i < n-1; i++) {
			k = i;      
			menor= a[i]; 
			for(j=i+1; j<n; j++) {
				if(a[j] > menor){ 
					k = j;        
					menor= a[k];           
					a[k] = a[i];  
					a[i] = menor; 
				}
			}
		}
	 }
 }