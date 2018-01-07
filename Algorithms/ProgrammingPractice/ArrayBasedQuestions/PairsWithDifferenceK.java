package ArrayBasedQuestions;
/*
 * Given an array of n integers, We need to find all pairs with difference less than k.
 * Time complexity(worst) : O(N) + NlogN     Time complexity(Best) : O(res) + NlogN  
 * res = number of pairs in output. 
 * Space Complexity : O(1)
 */

public class PairsWithDifferenceK {
	
	//Going from front to back for the second loop
	public void findPairsWithDifference(int[] numbers, int k){
		quickSort(numbers, 0, numbers.length-1);
		printArray(numbers);
		int count = 0;
		
		for(int i=0;i<numbers.length-1;i++) {
			for(int j=i+1;j<numbers.length;j++) {
				int difference = numbers[i] - numbers[j];
				if(Math.abs(difference) < k) {
					count++;
					System.out.print("(" + numbers[i] + "," + numbers[j] + ")\t");
				}else {
					break;
				}
			}
		}
		System.out.print("   Count = "+count + "\n\n\n");
	}
	
	//Going from back to front for the second loop
	public void findCountOfPairsWithDifference(int[] numbers, int k){
		quickSort(numbers, 0, numbers.length-1);
		printArray(numbers);
		int count = 0;
		
		for(int i=0;i<numbers.length-1;i++) {
			for(int j=numbers.length-1;j>i;j--) {
				int elementAti = numbers[i];
				int elementAtj = numbers[j];
				
				int difference = numbers[i] - numbers[j];
				if(Math.abs(difference) < k) {
					System.out.print("(" + numbers[i] + "," + numbers[j] + ")\t");
					count = count + (j-i);
					break;
				}
			}
		}
		System.out.print("   Count = "+count + "\n\n\n");
	}
	
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
	
	public void printArray(int[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i] + "\t");
		}
		System.out.print("\n_______________________________________________________\n");
	}
	
	public static void main(String[] args) {
		PairsWithDifferenceK pairs = new PairsWithDifferenceK();
		
		int[] numbers1 = {1, 10, 4, 2};
		int k1 = 3;
		//pairs.findPairsWithDifference(numbers1, k1);
		pairs.findCountOfPairsWithDifference(numbers1, k1);
		
//		int[] numbers2 = {1, 8, 7};
//		int k2 = 7;
//		pairs.findPairsWithDifference(numbers2, k2);
	}
}
