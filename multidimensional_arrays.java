import java.util.Scanner;
 
public class HellowWorld{

	public static void main( String args[] ) { 
		Scanner console = new Scanner( System.in ); 
		int option = 0;		
		do {	 
			showMenu();
			System.out.print("option:: ");    
			option = console.nextInt();
			
			switch(option){
				 case 1: matrixByMatrix(); break;
				 case 2: matrixByVector(); break;
				 case 3: option3and4("add"); break;
				 case 4: option3and4("biggest"); break;
				 case 5: System.out.println("bye"); break;
				 default: System.out.println("Select a valid option"); 
			}
		}while(option != 5);
	 }

	 static void matrixByVector(){
		Scanner console = new Scanner( System.in ); 
		System.out.print("Enter number of matrix columns: ");    
		int columns = console.nextInt();
		System.out.print("Enter number of matrix rows: ");    
		int rows = console.nextInt();
		int matrix[][] = new int[columns][rows];
		for(int i = 0; i < matrix.length; i++) {
			for(int z = 0; z < matrix[i].length; z++) {
				System.out.print("Matrix 1, enter value "+ (z+1) +":");  
				int value = console.nextInt();
				matrix[i][z] = value;
			}
		}
		System.out.print("Enter number of vector rows: ");    
		int columns2 = console.nextInt();
		int vector[] = new int[columns2];
		int numberOfColumns = matrix.length;
		int numberOfRows = vector.length;
		if(numberOfColumns != numberOfRows){
			System.out.println("[ERROR] The number of columns in the first matrix should be equal to the number of rows in the vector.");
			return;
		}else{
			for(int i = 0; i < vector.length; i++) {
					System.out.print("Vector:, enter value "+ (i+1) +":");  
					int value = console.nextInt();
					vector[i] = value;
			}
			int[] newVector = multiplyVectorByMatrix(vector, matrix);
			System.out.println("vector"); 
			printVector(newVector);
			System.out.println(""); 
			System.out.println("--"); 
		}
	 }

	 static void matrixByMatrix(){
		Scanner console = new Scanner( System.in ); 
		System.out.print("Enter number of matrix columns: ");    
		int columns = console.nextInt();
		System.out.print("Enter number of matrix rows: ");    
		int rows = console.nextInt();
		int matrix[][] = new int[columns][rows];
		for(int i = 0; i < matrix.length; i++) {
			for(int z = 0; z < matrix[i].length; z++) {
				System.out.print("Matrix 1, enter value "+ (z+1) +":");  
				int value = console.nextInt();
				matrix[i][z] = value;
			}
		}
		System.out.print("Enter number of matrix columns: ");    
		int columns2 = console.nextInt();
		System.out.print("Enter number of matrix rows: ");    
		int rows2 = console.nextInt();
		int matrix2[][] = new int[columns2][rows2];
		int numberOfColumns = matrix.length;
		int numberOfRows = matrix2[0].length;
		if(numberOfColumns != numberOfRows){
			System.out.println("[ERROR] The number of columns in the first matrix should be equal to the number of rows in the second.");
			return;
		}else{
			for(int i = 0; i < matrix2.length; i++) {
				for(int z = 0; z < matrix2[i].length; z++) {
					System.out.print("Matrix 2, enter value "+ (z+1) +":");  
					int value = console.nextInt();
					matrix2[i][z] = value;
				}
			}
			multiplyMatrixByMatrix(matrix, matrix2);
		}
	 }

	 static void option3and4(String type){
		Scanner console = new Scanner( System.in ); 
		System.out.print("Enter number of matrix columns: ");    
		int columns = console.nextInt();
		System.out.print("Enter number of matrix rows: ");    
		int rows = console.nextInt();
		int matrix[][] = new int[columns][rows];
		for(int i = 0; i < matrix.length; i++) {
			for(int z = 0; z < matrix[i].length; z++) {
				System.out.print("Enter value "+ (z+1) +":");  
				int value = console.nextInt();
				matrix[i][z] = value;
			}
		}
		System.out.println("");
		if(type == "add"){
			int sum = sumOddNumbersInMatrix(matrix);
			System.out.println("=> The sum of odd numbers is: "+ sum);
		}else{
			int biggest = getBiggestNumberInMatrix(matrix);
			System.out.println("=> The greatest number is: "+ biggest);
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

	 static void multiplyMatrixByMatrix(int a[][], int b[][]){
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
		System.out.println("=> matrix * matrix result");  
		System.out.println("");  
		printMatrix(r);
	 }

	 static int[] multiplyVectorByMatrix(int vector[], int matrix[][]){
		int newVector[] = new int[vector.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int z = 0; z < matrix[i].length; z++) {
				newVector[i] = newVector[i] + vector[z] * matrix[i][z];
			}
		}
		return newVector;
	 }

	 static void printVector(int vector[]){
		for(int i = 0; i < vector.length; i++) {
			
			System.out.print(vector[i]+ " ");
		}
	 }

	 static void printMatrix(int matrix[][]){
		for(int i = 0; i < matrix.length; i++) {
			for(int z = 0; z < matrix[i].length; z++) {
				System.out.print(matrix[i][z]+" ");
			}
			System.out.println(" ");
		}
	 }

	 static int sumOddNumbersInMatrix(int matrix[][]){
		int odds = 0;

		for(int i = 0; i < matrix.length; i++) {
			for(int z = 0; z < matrix[i].length; z++) {
				int currentNumber = matrix[i][z];
				if(currentNumber % 2 != 0) odds = odds + currentNumber;
			}
		}
		
		return odds;
	 }

	 static int getBiggestNumberInMatrix(int matrix[][]){
		int biggest = 0;

		for(int i = 0; i < matrix.length; i++) {
			for(int z = 0; z < matrix[i].length; z++) {
				if(matrix[i][z] > biggest) biggest = matrix[i][z];
			}
		}
		
		return biggest;
	 }
	 
 }