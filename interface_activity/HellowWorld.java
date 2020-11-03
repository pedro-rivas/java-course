import java.util.Scanner;
import interfaces.Imatrix;

public abstract class HellowWorld implements Imatrix{

	public void main( String args[] ) { 
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

	 public void matrixByVector(){
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
			int[] newVector = matrixXvector(vector, matrix);
			System.out.println("vector"); 
			printVector(newVector);
			System.out.println(""); 
			System.out.println("--"); 
		}
	 }
	 
	 
	 public void matrixByMatrix(){
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
			matrixXmatrix(matrix, matrix2);
		}
	 }

	 public void option3and4(String type){
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
			int sum = summationOdd(matrix);
			System.out.println("=> The sum of odd numbers is: "+ sum);
		}else{
			int biggest = greatest(matrix);
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
	 
	 public void matrixXmatrix(int a[][], int b[][]){
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

	 public int[] matrixXvector(int v[], int m[][]){
		int newVector[] = new int[v.length];
		for(int i = 0; i < m.length; i++) {
			for(int z = 0; z < m[i].length; z++) {
				newVector[i] = newVector[i] + v[z] * m[i][z];
			}
		}
		return newVector;
	 }

	 public void printVector(int v[]){
		for(int i = 0; i < v.length; i++) System.out.print(v[i]+ " ");
	 }

	 public void printMatrix(int m[][]){
		for(int i = 0; i < m.length; i++) {
			for(int z = 0; z < m[i].length; z++) {
				System.out.print(m[i][z]+" ");
			}
			System.out.println(" ");
		}
	 }
	 
	 public int summationOdd(int m[][]){
		int odds = 0;

		for(int i = 0; i < m.length; i++) {
			for(int z = 0; z < m[i].length; z++) {
				int currentNumber = m[i][z];
				if(currentNumber % 2 != 0) odds = odds + currentNumber;
			}
		}
		
		return odds;
	 }

	 public int greatest(int m[][]){
		int biggest = 0;

		for(int i = 0; i < m.length; i++) {
			for(int z = 0; z < m[i].length; z++) {
				if(m[i][z] > biggest) biggest = m[i][z];
			}
		}
		
		return biggest;
	 }
	 
 }
