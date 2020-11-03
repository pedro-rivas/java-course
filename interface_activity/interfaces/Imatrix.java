package interfaces;

public interface Imatrix {
	
	public void printVector(int v[]);
	/*{
		for(int i = 0; i < v.length; i++) System.out.print(v[i]+ " ");
	};*/

	public void printMatrix(int m[][]); 
	/*{
		for(int i = 0; i < m.length; i++) {
			for(int z = 0; z < m[i].length; z++) {
				System.out.print(m[i][z]+" ");
			}
			System.out.println(" ");
		}
	}*/
	
	public int[] matrixXvector(int m[][], int v[]); 
	/*{
		int newVector[] = new int[v.length];
		for(int i = 0; i < m.length; i++) {
			for(int z = 0; z < m[i].length; z++) {
				newVector[i] = newVector[i] + v[z] * m[i][z];
			}
		}
		return newVector;
	}*/

	public void matrixXmatrix(int a[][], int b[][]); 
	/*{
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
	}*/

	public int summationOdd(int m[][]); 
	/*{
		int odds = 0;

		for(int i = 0; i < m.length; i++) {
			for(int z = 0; z < m[i].length; z++) {
				int currentNumber = m[i][z];
				if(currentNumber % 2 != 0) odds = odds + currentNumber;
			}
		}
		
		return odds;
	}*/

	public int greatest(int m[][]);
	/*{
		int biggest = 0;

		for(int i = 0; i < m.length; i++) {
			for(int z = 0; z < m[i].length; z++) {
				if(m[i][z] > biggest) biggest = m[i][z];
			}
		}
		
		return biggest;
	}*/
}
