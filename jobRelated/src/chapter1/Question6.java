package chapter1;

class Question6 {
	public void printMatrix(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("______________________________");
	}

	public void myRotate(int[][] array, int n) {
		System.out.println("Original");
		printMatrix(array);

		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {

				int temp;
				temp = array[i][j];

				array[i][j] = array[j][i];

				array[j][i] = temp;

			}
		}

		System.out.println("After partial rotation");
		printMatrix(array);

		for (int i = 0; i < array.length; i++) {
			
			for(int j=0, k=array[0].length-1; j<k; j++,k--)
			{
				int temp;
				temp= array[i][j];
				array[i][j] = array[i][k];
				array[i][k] = temp;
			}
			
		}
		System.out.println("Final");
		printMatrix(array);
	}

	public void rotate(int[][] matrix, int n) {
		System.out.println("Original");
		printMatrix(matrix);

		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}

		System.out.println("after rotation");
		printMatrix(matrix);
	}

	public static void main(String[] args) {
		Question6 q = new Question6();
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		// int[][] array = {{1,2},{3,4}};

		q.myRotate(array, 3);
		// q.rotate(array, 3);

	}
}