public class MergeSort{
	
	public void printArray(int[] numbers){
		for(int number : numbers){
			System.out.print(number+"\t");
		}
		System.out.print("\n___________________________________________________________\n");
	}
	
	public void mergeSort(int[] numbers, int low, int high){
		if(low < high){
			
			//split the array into 2
			int mid = low + (high-low)/2;
			
			//sort the left and right array
			mergeSort(numbers, low, mid);
			mergeSort(numbers, mid + 1, high);
			
			//merge the result
			merge(numbers, low, mid+1, high);
		}
	}
	
	private void merge(int[] numbers, int leftArrayBegin, int rightArrayBegin, int rightArrayEnd){
		
		int leftArrayEnd = rightArrayBegin - 1;
		int numOfElements = rightArrayEnd - leftArrayBegin + 1;
		int[] result = new int[numOfElements];
		int resultCounter = 0;
		
		 // Find the smallest element in both these array and add it to the result
        // If we have a array of the form [1,5] [2,4]
        // We need to sort the above as [1,2,4,5]
		while(leftArrayBegin <= leftArrayEnd && rightArrayBegin <= rightArrayEnd){
			if(numbers[leftArrayBegin] <= numbers[rightArrayBegin]){
				result[resultCounter] = numbers[leftArrayBegin];
				resultCounter++;
				leftArrayBegin++;
			}else{
				result[resultCounter] = numbers[rightArrayBegin];
				resultCounter++;
				rightArrayBegin++;
			}
		}
		
		// After the main loop completed we may have few more elements in
        // left array copy them first
		while(leftArrayBegin <= leftArrayEnd){
			result[resultCounter] = numbers[leftArrayBegin];
			resultCounter++;
			leftArrayBegin++;
		}
		
		// After the main loop completed we may have few more elements in
        // right array copy them
		while(rightArrayBegin <= rightArrayEnd){
			result[resultCounter] = numbers[rightArrayBegin];
			resultCounter++;
			rightArrayBegin++;
		}
		
		 // Copy resultArray back to the main array
		for (int i = numOfElements-1; i >=0; i--, rightArrayEnd--){
			numbers[rightArrayEnd] = result[i]; 
		}

		
	}
	
	public static void main(String[] args){
		int[] numbers =  {19,-8,2,23,10,1};
		MergeSort mergeSort = new MergeSort();
		
		mergeSort.printArray(numbers);
		mergeSort.mergeSort(numbers, 0, numbers.length-1);
		mergeSort.printArray(numbers);
	}
}