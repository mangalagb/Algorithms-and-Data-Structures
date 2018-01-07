package ArrayBasedQuestions;
/*
 * Given an array of n numbers and a positive integer k. 
 * The problem is to find k numbers with most occurrences,
 * i.e., the top k numbers having the maximum frequency. 
 * If two numbers have same frequency then the larger number 
 * should be given preference. The numbers should be displayed 
 * in decreasing order of their frequencies. It is assumed that 
 * the array consists of k numbers with most occurrences.
 */

public class MaxRepeatingNumbers {
	
	public void printArray(int[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i] + "\t");
		}
		System.out.print("\n____________________________________________________________________________\n");
	}
	
	public static void main(String[] args) {
		MaxRepeatingNumbers maximumRepeating = new MaxRepeatingNumbers();
		
		int[] numbers1 = {3, 1, 4, 4, 5, 2, 6, 1};
		int k1 =2;
		maximumRepeating.printArray(numbers1);
	}

}
