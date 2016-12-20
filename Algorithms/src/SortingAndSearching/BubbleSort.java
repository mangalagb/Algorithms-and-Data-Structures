package SortingAndSearching;

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
	
	public void printArray(int[] numbers, String method){
		System.out.print(method + " :\t");
		for(int number : numbers){
			System.out.print(number+"\t");
		}
		System.out.print("\n___________________________________________________________\n");
	}

	public static void main(String[] args){
		BubbleSort bubble = new BubbleSort();
		int[] numbers = {84,69,76,86,94,91};
		bubble.printArray(numbers, "Before");
		bubble.bubbleSort(numbers, numbers.length);
	}
}
