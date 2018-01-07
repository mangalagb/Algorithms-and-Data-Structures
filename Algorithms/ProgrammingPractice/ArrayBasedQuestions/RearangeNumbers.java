package ArrayBasedQuestions;

/*
 * Given an array of positive and negative numbers, arrange them 
 * such that all negative integers appear before all the positive 
 * integers in the array without using any additional data structures.
 */
public class RearangeNumbers {
	
	public void rearrange(int[] numbers, int low, int high) {
		int pivotElement = 0;
		int i = low;
		int j = high;
		
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
	}
	
	public void printArray(int[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i] + "\t");
		}
		System.out.print("\n____________________________________________________________________\n");
	}
	
	public static void main(String[] args) {
		RearangeNumbers reaarnge = new RearangeNumbers();
		int[] numbers = {12, 11, -13, -5, 6, -7, 5, -3, -6};
		reaarnge.printArray(numbers);
		reaarnge.rearrange(numbers, 0, numbers.length-1);
		reaarnge.printArray(numbers);
	}

}
