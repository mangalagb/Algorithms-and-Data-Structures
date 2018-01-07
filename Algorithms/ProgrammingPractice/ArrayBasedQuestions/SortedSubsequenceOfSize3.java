package ArrayBasedQuestions;
/*
 * Given an array of n integers, find the 3 elements such that 
 * a[i] < a[j] < a[k] and
 * i < j < k in 0(n) time. 
 * If there are multiple such triplets, then print any one of them.
 * 
 * 1) Create another array smaller[0..n-1]. 
 * smaller[i] should store the index of a number which is smaller than arr[i] 
 * and is on left side of arr[i]. 
 * smaller[i] should contain -1 if there is no such element.
 * 
	2) Create another array greater[0..n-1]. 
	greater[i] should store the index of a number which is greater than arr[i] 
	and is on right side of arr[i]. 
	greater[i] should contain -1 if there is no such element.

	3) Finally traverse both smaller[] and greater[] and
	 find the index i for which both smaller[i] and greater[i] are not -1.
 
 */

public class SortedSubsequenceOfSize3 {
	
	public void printArray(int[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i] + "\t");
		}
		System.out.print("\n____________________________________________________________________\n");
	}
	
	
	/*
	 * Time complexity of this is O(n).
	 * As there are 2 separate for loops.
	 */
	public void findSequenceOf3Efficiently(int[] numbers) {
		if(numbers.length == 0) {
			return;
		}
	
		//There is no minimum for the first number
		int[] minimum = new int[numbers.length];
		minimum[0] = -1;
		int minimumElement = numbers[0];
		int minimumIndex = 0;
		
		for(int i=1;i<numbers.length;i++) {
			int numberBeingCompared = numbers[i];
			if(minimumElement < numberBeingCompared) {
				minimum[i] = minimumIndex;
			}else if(numberBeingCompared < minimumElement) {
				minimumElement = numberBeingCompared;
				minimumIndex = i;
				minimum[i] = -1;
			}
		}
		
		//There is no maximum for the last number
		int maximum[] = new int[numbers.length];
		maximum[numbers.length-1] = -1;
		int maximumElement = numbers[numbers.length-1];
		int maximumIndex = numbers.length-1;
		
		for(int i=numbers.length-2; i>=0; i--) {
			int numberBeingConsidered = numbers[i];
			if(maximumElement > numberBeingConsidered) {
				maximum[i] = maximumIndex;
			}else if(numberBeingConsidered > maximumElement) {
				maximumElement = numberBeingConsidered;
				maximumIndex = i;
				maximum[i] = -1;
			}
		}
		
		for(int i=0; i<numbers.length; i++) {
			if(minimum[i] != -1 && maximum[i] != -1) {
				System.out.println(numbers[minimum[i]] + ", " + numbers[i] + ", " + numbers[maximum[i]]);
				return;
			}
		}
		System.out.println("No such sequence");
	}
	
	/*
	 * This solution is O(n^2)
	 */
	public void findSequenceOf3(int[] numbers) {
		int[] smaller = new int[numbers.length];
		int[] greater = new int[numbers.length];
		
		for(int i=0;i<numbers.length;i++) {
			
			int leftIndex = -1;
			for(int j=0; j<i; j++) {
				if(numbers[j] < numbers[i]) {
					leftIndex = j;
					break;
				}
			}
			
			int rightIndex = -1;
			for(int j=i+1; j<numbers.length; j++) {
				if(numbers[j] > numbers[i]) {
					rightIndex = j;
					break;
				}
			}
			
			if(leftIndex != -1 && rightIndex!= -1) {
				System.out.println(numbers[leftIndex] + ", " + numbers[i] + ", " + numbers[rightIndex]);
				return;
			}else {
				//Just in case you want all the pairs
				smaller[i] = leftIndex;
				greater[i] = rightIndex;
			}
		}
		System.out.print("No such triplet");
	}
	
	public static void main(String[] args) {
		SortedSubsequenceOfSize3 sequenceOf3 = new SortedSubsequenceOfSize3();
		
		int[] numbers1 = {12, 11, 10, 5, 6, 2, 30};
		sequenceOf3.printArray(numbers1);
		sequenceOf3.findSequenceOf3Efficiently(numbers1);
		System.out.print("\n\n");
		
		int[] numbers2 = {1, 2, 3, 4};
		sequenceOf3.printArray(numbers2);
		sequenceOf3.findSequenceOf3Efficiently(numbers2);
		System.out.print("\n\n");
		
		int[] numbers3 = {4, 3, 2, 1};
		sequenceOf3.printArray(numbers3);
		sequenceOf3.findSequenceOf3Efficiently(numbers3);
		System.out.print("\n\n");
		
		int[] numbers4 = {13, 11, 12, 10, 5, 6, 8};
		sequenceOf3.printArray(numbers4);
		sequenceOf3.findSequenceOf3Efficiently(numbers4);
	}

}
