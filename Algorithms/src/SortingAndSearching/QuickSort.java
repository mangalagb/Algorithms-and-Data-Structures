package SortingAndSearching;

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
		int[] numbers = {9, 14, 1};
		quickSort.printArray(numbers, "Before");
		quickSort.partition(numbers, 0, numbers.length -1);
		quickSort.printArray(numbers, "Quicksort");
	}
}

