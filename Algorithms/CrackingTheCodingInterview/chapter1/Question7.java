/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 */
package chapter1;

public class Question7 {
	
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
				if(i==1 && j==1 || i==1 && j==2){
					matrix[i][j] = 0;
				}else{
				matrix[i][j] = counter;
				counter++;
				}
			}
		}
		return matrix;
	}
	
	public void setToZero(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		int numberOfitems = row * col;
		
		//create an array to store zero positions. For example, Matrix(2,3) is zero.
		//This array will conatin an entry for each element. Hence size is number of elements.
		//And second dimension is 2 as we have to store 2 indexes(i and j)
		int[][] zeroIndexes = new int[numberOfitems][2];
		int zeroIndexesRow = zeroIndexes.length;
		int zeroIndexesCol = zeroIndexes[0].length;
		
		//Initialize everything to -1
		for(int i=0; i<zeroIndexesRow; i++){
			for(int j=0; j<zeroIndexesCol ; j++){
				zeroIndexes[i][j] = -1;
			}
		}
		
		//Store zero indexes from the matrix
		int zeroCounter = 0;
		for(int i=0;i<row;i++){
			for(int j=0; j<col; j++){
				if(matrix[i][j] == 0){
					zeroIndexes[zeroCounter][0] = i;
					zeroIndexes[zeroCounter][1] = j;
					zeroCounter++;
				}
			}
		}
		
		//Loop through the zero indexes. Then loop through the matrix and set those rows and cols to zero
		for(int i=0; i<zeroIndexesRow; i++){
			int[] val = zeroIndexes[i];
			if(val[0] != -1){
				int rowNumber = val[0];
				int colNum = val[1];
				
				for(int x=0; x<row;x++){
					for(int y=0;y<col;y++){
						if(x== rowNumber || y==colNum){
							matrix[x][y] = 0;
						}
					}
				}
			}
		}
	}

	
	public static void main(String[] args){
		Question7 question7 = new Question7();
		
		int[][] mat = question7.createMatrix(5,5);
		question7.printMatrix(mat);
		
		question7.setToZero(mat);
		question7.printMatrix(mat);
	}
}
