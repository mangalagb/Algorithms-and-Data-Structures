/*
 * Uses divide-and-conquer.
 * 
 *  The basic step of sorting an array are as follows:
	1) Select a pivot, normally the middle one
	2) From both ends, swap elements and make left elements less than pivot and all right greater than pivot.
	3) Recursively sort left part and right part
	
  *  Average time complexity is O(n log(n)).
  *  Worst case time complexity is O(n^2)
  *  
  *  Worst Case: The worst case occurs when the partition process always picks greatest or smallest element as pivot. 
  *  If we consider above partition strategy where last element is always picked as pivot, the worst case would occur 
  *  when the array is already sorted in increasing or decreasing order. Following is recurrence for worst case.
  *  
  *  The best case occurs when the partition process always picks the middle element as pivot.
  *  
  *  Although the worst case time complexity of QuickSort is O(n2) which is more than many other sorting algorithms like Merge Sort and Heap Sort, 
  *  QuickSort is faster in practice, because its inner loop can be efficiently implemented on most architectures, and in most real-world data.
  *  QuickSort can be implemented in different ways by changing the choice of pivot, so that the worst case rarely occurs for a given type of data. 
  *  However, merge sort is generally considered better when data is huge and stored in external storage.
	
	Always pick first element as pivot.
	Always pick last element as pivot (implemented below)
	Pick a random element as pivot.
	Pick median as pivot.
	

 * O(log n) - Means repeatedly dividing by a constant. 
 * (Think tree. Every time the number of comparisons gets cut by half)
 * 16 / 2 = 8
 	8 / 2 = 4
 	4 / 2 = 2
 	2 / 2 = 1
 	
 	How many steps did it take? 4 = log(16) (Base 2)
 	
 	algo with n! complexity?
 */

public class QuickSort{

	public void partition(int[] numbers, int low, int high){
		int pivotElement = numbers[low + (high - low)/2];
		int i =  low;
		int j = high;
		
		while(i<= j){
			while(numbers[i] < pivotElement){
				i++;
			}
	
			while(numbers[j] > pivotElement){
				j--;
			}
	
			if(i<= j){
				int temp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
				i++;
				j--;
			}
		}
		
		if(low < j){
			partition(numbers, low, j);
		}
		
		if(i < high){
			partition(numbers, i, high);
		}
	}
	
	
	
	public void printArray(int[] numbers, String method){
		System.out.print(method + " :\t");
		for(int number : numbers){
			System.out.print(number+"\t");
		}
		System.out.print("\n___________________________________________________________\n");
	}

	public static void main(String[] args){
		QuickSort quickSort = new QuickSort();
		int[] numbers = {19,8,2,23,10,1};
		quickSort.printArray(numbers, "Before");
		quickSort.partition(numbers, 0, numbers.length -1);
		quickSort.printArray(numbers, "Quicksort");
	}
}

