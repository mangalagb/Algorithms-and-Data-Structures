/*
 * Bubble sort has worst-case and average complexity both О(n2), where n is the number of items being sorted. 
 * There exist many sorting algorithms with substantially better worst-case or average complexity of O(n log n). 
 * Even other О(n2) sorting algorithms, such as insertion sort, tend to have better performance than bubble sort. 
 * Therefore, bubble sort is not a practical sorting algorithm when n is large.
 * 
 * The only significant advantage that bubble sort has over most other implementations, even quicksort, but not insertion sort,
 * is that the ability to detect that the list is sorted efficiently is built into the algorithm.
 * When the list is already sorted (best-case), the complexity of bubble sort is only O(n).
 * 
 * However, not only does insertion sort have this mechanism too, but it also performs
 * better on a list that is substantially sorted (having a small number of inversions).
 */

public class BubbleSort {
	
	public void bubbleSort(int[] numbers, int size){
		
		for(int i=0; i<size; i++){
			for(int j=1; j< size-i; j++){
				if(numbers[j-1] > numbers[j]){
					int temp = numbers[j-1];
					numbers[j-1] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		printArray(numbers, "BubbleSort");
	}
	
	public void bubbleSortEasy(int[] numbers, int size){
		boolean isSwapped = true;
		while(isSwapped){
			isSwapped = false;
			for(int i=1;i<size;i++){
				if(numbers[i-1] > numbers[i]){
					int temp = numbers[i];
					numbers[i] = numbers[i-1];
					numbers[i-1] = temp;
					isSwapped = true;
				}
			}
		}
		printArray(numbers, "BubbleSort");
	}
	
	public void printArray(int[] numbers, String method){
		System.out.print(method + " :\t");
		for(int number : numbers){
			System.out.print(number+"\t");
		}
		System.out.print("\n___________________________________________________________\n");
	}

	public static void main(String[] args){
		BubbleSort bubble = new BubbleSort();
		int[] numbers =  {19,8,2,23,10,1};
		bubble.printArray(numbers, "Before");
		//bubble.bubbleSort(numbers, numbers.length);
		bubble.bubbleSortEasy(numbers, numbers.length);
	}
}
