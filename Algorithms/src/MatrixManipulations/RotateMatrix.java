package MatrixManipulations;
public class RotateMatrix {
	
//	Rotate by +45:	
//	Transpose	
	
//	Rotate by +90:
//		Transpose
//		Reverse each row
	
//	Rotate by -90:
//		Transpose
//		Reverse each column
	
//	Rotate by +180:
//		Method 1: Rotate by +90 twice

//	Rotate by -180:
//		Method 1: Rotate by +180 as they are same
	
	/**
	 * Rotate matrix by +90 degrees
	 * @param matrix
	 * @return
	 */
	public int[][] rotateByPlus90(int[][] matrix){
		int[][] transpose = transposeMatrix(matrix);
		int[][] reversedMatrix = reverseRows(transpose);
		return reversedMatrix;
	}
	
	/**
	 * Rotate matrix by -90 degrees
	 * @param matrix
	 * @return
	 */
	public int[][] rotateByMinus90(int[][] matrix){
		int[][] transpose = transposeMatrix(matrix);
		int[][] reversedMatrix = reverseColumns(transpose);
		return reversedMatrix;
	}
	
	
	/*
	 * Transpose a matrix
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
	
	public int[][] reverseColumns(int[][] matrix) {
		//Reverse each column
		int counter = matrix.length -1;
		int limit = -1;
		if(counter %2 ==0){
			limit = counter/2;
		}else{
			limit = counter/2 -1;
		}
		
		for(int j=0; j< matrix.length; j++){
			counter = matrix.length -1;
			for(int i=0; i<= limit; i++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[counter][j];
				matrix[counter][j] = temp;
				counter -= 1;
			}
		}
		return matrix;
	}
	
	public int[][] reverseRows(int[][] matrix) {
		//Reverse each row
		int counter = matrix.length -1;
		int limit = -1;
		if(counter %2 ==0){
			limit = counter/2 - 1;
		}else{
			limit = counter/2;
		}
		
		for(int i=0; i< matrix.length; i++){
			counter = matrix.length -1;
			for(int j=0; j<= limit; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][counter];
				matrix[i][counter] = temp;
				counter -=1;
			}
		}
		return matrix;
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
	
	public static void main(String[] args) {
		RotateMatrix rotateMatrix = new RotateMatrix();
		int[][] matrix = rotateMatrix.createMatrix(3,3);
		rotateMatrix.printMatrix(matrix);	
		
		int[][] reverseByPlus90 = rotateMatrix.rotateByPlus90(matrix);
		rotateMatrix.printMatrix(reverseByPlus90);		
		
//		int[][] reverseByMinus90 = rotateMatrix.rotateByMinus90(matrix);
//		rotateMatrix.printMatrix(reverseByMinus90);
				
	}
}
