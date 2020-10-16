
 public class HelloWorld{
	 public static void main( String args[] ) { 
		 
		 int array1 [] = new int[5];
		 int array2 [] = new int[5];
		 int array3 [] = new int[5];

		 for(int i = 0; i < 5; i++) {
			 array1[i] = i;
			 array2[i] = i;

			 array3[i] = array1[i] * array2[i];		  
		 }

		 System.out.println(array3);
	 }
 }