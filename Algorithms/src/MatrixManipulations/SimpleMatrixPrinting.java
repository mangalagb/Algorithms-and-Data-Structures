package MatrixManipulations;
public class SimpleMatrixPrinting {
	
	/*
	 * Transpose a symmetric matrix
	 */
	public int[][] transposeMatrix(int[][] matrix){
		int size = matrix.length;
		
		for(int i=0; i<size; i++){
			for(int j=i+1; j<size; j++){
				int originalElement = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = originalElement;
			}
		}
		return matrix;
	}
	
	/*
	 * Transpose a non-symmetric matrix
	 */
	public int[][] transposeNonSymmetricMatrix(int[][] matrix){
		int row = matrix.length;
		int col =  matrix[0].length;
		int[][] newMatrix = new int[col][row];
		
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				newMatrix[j][i] = matrix[i][j]; 
			}
		}
		return newMatrix;
	}
	
	public void printMatrix(int[][] matrix) {
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.print('\n');
		}
		System.out.print("_______________________________________________\n");
	}

	public int[][] createMatrix(int row, int col) {
		int counter = 1;
		int[][] matrix = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = counter;
				counter++;
			}
		}
		return matrix;
	}

	public void printLowerTriangle(int[][] matrix){
		int row = matrix.length;
		for(int i=0; i<row; i++){
			for(int j=0; j<= i; j++){
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.print('\n');
		}
		System.out.print("_______________________________________________\n");
	}
	
	public void printUpperTriangle(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
			
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				
				if(j >=i){
					System.out.print(matrix[i][j] + "\t");
				}else{
					System.out.print( "\t");
				}
			}
			System.out.print('\n');
		}
		System.out.print("_______________________________________________\n");
	}
	
	public static void main(String[] args) {		
		SimpleMatrixPrinting matrixManipulations = new SimpleMatrixPrinting();
		
		int[][] matrix = matrixManipulations.createMatrix(2, 3);
		matrixManipulations.printMatrix(matrix);
		
		//Transpose of non-symmetric matix
		int[][] transpose1 = matrixManipulations.transposeNonSymmetricMatrix(matrix);
		matrixManipulations.printMatrix(transpose1);
		
		//Transpose of symmetric matix
		int[][] transpose2 = matrixManipulations.transposeMatrix(matrix);
		matrixManipulations.printMatrix(transpose2);
		
		//Print lower triangle
		matrixManipulations.printLowerTriangle(matrix);
		
		//Print upper triangle
		matrixManipulations.printUpperTriangle(matrix);
	}
}
