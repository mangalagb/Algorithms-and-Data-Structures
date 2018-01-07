package ArrayBasedQuestions;
/*
 * Given an array of n positive integers, write a program to print the minimum 
 * product of k integers of the given array.
 * 
 *  Input : 198 76 544 123 154 675
    k = 2
	Output : 9348
	We get minimum product after multiplying 76 and 123.
 */

public class MinimumProduct {
	private void quickSort(int[] numbers, int low, int high) {
		int pivotElement = numbers[low + (high-low)/2];
		
		int i=low;
		int j=high;
		
		while(i<=j) {
			while(numbers[i] < pivotElement) {
				i++;
			}
			
			while(numbers[j] > pivotElement) {
				j--;
			}
			
			if(i<=j) {
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				i++;
				j--;
			}
		}
		
		if(i<= high) {
			quickSort(numbers, i, high);
		}
		
		if(low<=j) {
			quickSort(numbers, low, j);
		}
	}
	
	public void findMinimumProduct(int[] numbers, int k) {
		quickSort(numbers, 0, numbers.length-1);
		
		int product = 1;
		for(int i=0;i<k;i++) {
			product *= numbers[i];
		}
		
		System.out.println(product);
	}
	
	public static void main(String[] args) {
		MinimumProduct minimumProduct = new MinimumProduct();
		
		int[] numbers1 = {198, 76, 544, 123, 154, 675};
		int k1 = 2;
		minimumProduct.findMinimumProduct(numbers1, k1);
		
		int[] numbers2 = {11, 8, 5, 7, 5, 100};
		int k2 = 4;
		minimumProduct.findMinimumProduct(numbers2, k2);
	}
}
