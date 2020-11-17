import java.util.Scanner;
import interfaces.Imatrix;

public class Exceptions_Assertions {
	public static void main(String args[]) {
		Scanner console = new Scanner( System.in ); 
		Matrix matrix = new Matrix();
		int option = 0;		
		do {	 
			showMenu();
			System.out.print("option:: ");    
			option = console.nextInt();
			switch(option){
				 case 1: 
					 matrixByMatrix(); 
				 break;
				 case 2: 
					 matrixByVector(); 
				 break;
				 case 3: 
					 option3and4("add"); 
				 break;
				 case 4: 
					 option3and4("biggest"); 
				 break;
				 case 5: 
					 System.out.println("bye"); 
				 break;
				 default: System.out.println("Select a valid option"); 
			}
		}while(option != 5);
	}
	
	static void option3and4(String type){
		Matrix matrix = new Matrix();
		Scanner console = new Scanner( System.in ); 
		System.out.print("Enter number of matrix columns: ");    
		int columns = console.nextInt();
		System.out.print("Enter number of matrix rows: ");    
		int rows = console.nextInt();
		int matris[][] = new int[columns][rows];
		for(int i = 0; i < matris.length; i++) {
			for(int z = 0; z < matris[i].length; z++) {
				System.out.print("Enter value "+ (z+1) +":");  
				int value = console.nextInt();
				matris[i][z] = value;
			}
		}
		System.out.println("");
		if(type == "add"){
			int sum = matrix.summationOdd(matris);
			System.out.println("=> The sum of odd numbers is: "+ sum);
		}else{
			int biggest = matrix.greatest(matris);
			System.out.println("=> The greatest number is: "+ biggest);
		}
	 }
	
	 static void matrixByMatrix(){
		 	Matrix matrix = new Matrix();
			Scanner console = new Scanner( System.in ); 
			System.out.print("Enter number of matrix columns: ");    
			int columns = console.nextInt();
			System.out.print("Enter number of matrix rows: ");    
			int rows = console.nextInt();
			int matris[][] = new int[columns][rows];
			for(int i = 0; i < matris.length; i++) {
				for(int z = 0; z < matris[i].length; z++) {
					System.out.print("Matrix 1, enter value "+ (z+1) +":");  
					int value = console.nextInt();
					matris[i][z] = value;
				}
			}
			System.out.print("Enter number of matrix columns: ");    
			int columns2 = console.nextInt();
			System.out.print("Enter number of matrix rows: ");    
			int rows2 = console.nextInt();
			int matrix2[][] = new int[columns2][rows2];
			int numberOfColumns = matris.length;
			int numberOfRows = matrix2[0].length;
			if(numberOfColumns != numberOfRows){
				try {
					MatrixSizesExcepcion();
				}
				catch(Exception exception) {    
					System.err.println("The number of columns in the first matrix should be equal to the number of rows in the second.");   
				} 
			}else{
				for(int i = 0; i < matrix2.length; i++) {
					for(int z = 0; z < matrix2[i].length; z++) {
						System.out.print("Matrix 2, enter value "+ (z+1) +":");  
						int value = console.nextInt();
						matrix2[i][z] = value;
					}
				}
				matrix.multiply(matris, matrix2);
			}
		 }
	
	static void matrixByVector(){
		Scanner console = new Scanner( System.in ); 
		Matrix matrix = new Matrix();
		System.out.print("Enter number of matrix columns: ");    
		int columns = console.nextInt();
		System.out.print("Enter number of matrix rows: ");    
		int rows = console.nextInt();
		int matris[][] = new int[columns][rows];
		for(int i = 0; i < matris.length; i++) {
			for(int z = 0; z < matris[i].length; z++) {
				System.out.print("Matrix 1, enter value "+ (z+1) +":");  
				int value = console.nextInt();
				matris[i][z] = value;
			}
		}
		System.out.print("Enter number of vector rows: ");    
		int columns2 = console.nextInt();
		int vector[] = new int[columns2];
		int numberOfColumns = matris.length;
		int numberOfRows = vector.length;
		if(numberOfColumns != numberOfRows){
			try {
				MatrixSizesExcepcion();
			}
			catch(Exception exception) {    
				System.err.println("[ERROR] The number of columns in the first matrix should be equal to the number of rows in the vector.");   
			} 
		}else{
			for(int i = 0; i < vector.length; i++) {
					System.out.print("Vector:, enter value "+ (i+1) +":");  
					int value = console.nextInt();
					vector[i] = value;
			}
			int[] newVector = matrix.multiply(vector, matris);
			System.out.println("vector"); 
			matrix.print(newVector);
			System.out.println(""); 
			System.out.println("--"); 
		}
	 }

	static void showMenu(){
		System.out.println("");
		System.out.println("Select an option: ");
		System.out.println("1. Multiply matrix by matrix");
		System.out.println("2. Multiply matrix by vector");
		System.out.println("3. Summation of odd numbers");
		System.out.println("4. Greatest");
		System.out.println("5: Exit ");
		System.out.println("");
	}
	
	public static void MatrixSizesExcepcion() throws Exception { 
		
		try{ 
			throw new Exception();     
		} 	
		catch(RuntimeException runtimeException) {    
			System.err.println("The number of columns in the first matrix should be equal to the number of rows in the second.");   
		}  
		
	} 

}


class Matrix implements Imatrix{

	@Override
	public void print(int[] v) {
		try {
			for(int i = 0; i < v.length; i++) System.out.print(v[i]+ " ");
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.err.printf("\nExcepcion: %s\n", exception); 
		}
	}

	@Override
	public void print(int[][] m) {
		try {
			for(int i = 0; i < m.length; i++) {
				for(int z = 0; z < m[i].length; z++) {
					System.out.print(m[i][z]+" ");
				}
				System.out.println(" ");
			}
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.err.printf("\nExcepcion: %s\n", exception); 
		}
	}

	@Override
	public int[] multiply(int[] v, int[][] m) {
		int newVector[] = new int[v.length];
		try {
			for(int i = 0; i < m.length; i++) {
				for(int z = 0; z < m[i].length; z++) {
					newVector[i] = newVector[i] + v[z] * m[i][z];
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.err.printf("\nExcepcion: %s\n", exception); 
		}
		verifyFinalVector(m, newVector);
		return newVector;
	}
	
	private static void verifyFinalVector(int[][]m, int[]v) {
		assert(m.length == v.length) : "The result has not valid sizes";
	}

	@Override
	public void multiply(int a[][], int b[][]) {
		try {
			int numberOfColumns = a.length;
			int numberOfRows = b[0].length;
			int r[][] = new int[numberOfColumns][numberOfRows];
			for(int i = 0; i < a.length; i++) {
				for(int j = 0; j < b[0].length; j++) {
					for(int k=0; k < b.length; k++){
						r[i][j] = r[i][j] + a[i][k] * b[k][j];
					}
				}
			}
			
			verifyFinalMatrix(a, b, r);
			
			System.out.println("=> matrix * matrix result");  
			System.out.println("");  
			print(r);
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.err.printf("\nExcepcion: %s\n", exception); 
		}
	}
	
	private static void verifyFinalMatrix(int[][]a, int[][]b, int[][]r) {
		assert(a.length == r.length &&  b[0].length == r[0].length) : "The result has not valid sizes";
	}
	
	

	@Override
	public int summationOdd(int m[][]){
		int odds = 0;
		
		try {
			for(int i = 0; i < m.length; i++) {
				for(int z = 0; z < m[i].length; z++) {
					int currentNumber = m[i][z];
					if(currentNumber % 2 != 0) odds = odds + currentNumber;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.err.printf("\nExcepcion: %s\n", exception); 
		}
		
		return odds;
	}
	
	@Override
	public int greatest(int m[][]){
		int biggest = 0;
		
		try {
			for(int i = 0; i < m.length; i++) {
				for(int z = 0; z < m[i].length; z++) {
					if(m[i][z] > biggest) biggest = m[i][z];
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException exception) {
			System.err.printf("\nExcepcion: %s\n", exception); 
		}
		
		return biggest;
	}
}