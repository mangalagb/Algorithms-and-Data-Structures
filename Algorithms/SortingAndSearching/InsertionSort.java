/*
 *  1) It is very simple.
	2) It is very efficient for small data sets.
	3) It is stable; i.e., it does not change the relative order of elements with equal keys.
	4) In-place; i.e., only requires a constant amount O(1) of additional memory space.
	
	The best case input is an array that is already sorted. In this case insertion sort has a linear running time (i.e., Θ(n)).
	
	The simplest worst case input is an array sorted in reverse order.
	The set of all worst case inputs consists of all arrays where each element is the smallest or second-smallest of the elements before it.
	In these cases every iteration of the inner loop will scan and shift the entire sorted subsection of the array before inserting the next element. 
	This gives insertion sort a quadratic running time (i.e., O(n2)).
	
	The average case is also quadratic, which makes insertion sort impractical for sorting large arrays.
	
	However, insertion sort is one of the fastest algorithms for sorting very small arrays(around 10), even faster than quicksort.
 */

public class InsertionSort{
	
	public void insertionSort(int[] numbers){
		for(int i=1; i< numbers.length; i++){
			for(int j = i; j>0; j--){
				if(numbers[j-1] > numbers[j]){
					int temp = numbers[j];
					numbers[j] = numbers[j-1];
					numbers[j-1] = temp;
				}
			}
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
		InsertionSort insertionSort = new InsertionSort();
		int[] numbers =  {19,8,2,23,10,1};
		insertionSort.printArray(numbers, "Before");
		insertionSort.insertionSort(numbers);
		insertionSort.printArray(numbers, "After");
	}
}