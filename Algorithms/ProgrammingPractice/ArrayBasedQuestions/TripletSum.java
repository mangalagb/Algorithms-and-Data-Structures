package ArrayBasedQuestions;

import java.util.HashSet;
import java.util.Set;

/*
 * Find a triplet that sums to a given value
 * 
 * 1) Sort the array
 * 2) For each element in the array, have a left pointer and a right pointer
 * 		Left moves from i+1 to end. Right moves from numbers.length-1 to 0.
 * 		While(left < right), check target.
 * 		Since the numbers are sorted, if sum is less than target, do left++.
 * 		Else if sum is greater than target, do right--.
 * 
 * 	The time complexity for this is O(N^2) + O(NlogN)
 */
public class TripletSum {
	public void findTriplets(int[] numbers, int target) {
		//Sort the array
		quickSort(numbers, 0, numbers.length-1);
		
		for(int i=0;i<numbers.length;i++) {
			int left = i+1;
			int right = numbers.length-1;
			
			while(left <  right) {
				if(numbers[i] + numbers[left] + numbers[right] == target) {
					System.out.print(numbers[i] +"," + numbers[left] +","+ numbers[right]+"\n");
					left++;
					right--;
				}else if(numbers[i] + numbers[left] + numbers[right] < target) {
					left++;
				}else if(numbers[i] + numbers[left] + numbers[right] > target) {
					right--;	
				}
			}
		}
	}
	
	public void findTripletsUsingSet(int[] numbers, int target) {
		for(int i=0;i<numbers.length;i++) {
			Set<Integer> firstNumber = new HashSet<Integer>();
			
			for(int j=i+1;j<numbers.length;j++) {
				Integer remainingNumber = target - (numbers[i] + numbers[j]);				
				if(firstNumber.contains(remainingNumber)) {
					System.out.print(remainingNumber + "," + numbers[i] + "," + numbers[j]+ "\n");
				}else {
					firstNumber.add(numbers[j]);
				}
			}
		}
	}
	
	private void quickSort(int[] numbers, int low, int high) {
		int pivotElement = numbers[low + (high-low)/2];
		
		int i= low;
		int j= high;
		
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
		
		if(i< high) {
			quickSort(numbers, i, high);
		}
		
		if(low < j) {
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
		int[] numbers = {10,-5,0,-3,-7,5,8};
		int target = 0;
		TripletSum tripletSum = new TripletSum();
		//tripletSum.findTriplets(numbers, target);
		tripletSum.findTripletsUsingSet(numbers, target);
	}
}
