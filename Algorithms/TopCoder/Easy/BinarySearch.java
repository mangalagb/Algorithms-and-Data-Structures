package Easy;

/*
 * In this problem we will evaluate how binary search performs on data that isn't 
 * necessarily sorted. An element of S is said to be binary searchable if, regardless 
 * of how the pivot is chosen on line 3 whenever the line is executed, the above algorithm returns true.

Given a sequence containing distinct integers, return the number of elements 
from the sequence that are binary searchable.

0)
{ 1, 3, 2 }
Returns: 1
However we choose the pivots in the algorithm, we will always find the number 1 when looking for it. This does not hold for 3 and 2.
1)
{ 3, 2, 1, 10, 23, 22, 21 }
Returns: 1
2)
{ 1, 5, 7, 11, 12, 18 }
Returns: 6
All elements in a sorted sequence are binary searchable.
3)
{ 5, 4, 3, 2, 1, 0 }
Returns: 0
4)
{ 1, 3, 2, 4, 5, 7, 6, 8 }
Returns: 4
 */
public class BinarySearch{
	int howMany(int[] sequence) {
		return -1;
	}
	public boolean binary(int[] numbers, int target) {
		int low = 0;
		int high = numbers.length-1;

		while(true) {
			if(low > high) {
				return false;
			}
			
			int mid = low + (high-low)/2;
			
			if(numbers[mid] > target) {
				high = mid -1;
			}
			
			else if(numbers[mid] < target) {
				low = mid + 1;
			}
			
			else if(numbers[mid] == target) {
				System.out.print("Found : "+ numbers[mid]);
				return true;
			}
		}
	}
	
	public static void main(String[] args) {
		BinarySearch binarySearchable = new BinarySearch();
		int[] numbers = {1, 3, 2};
	}
}