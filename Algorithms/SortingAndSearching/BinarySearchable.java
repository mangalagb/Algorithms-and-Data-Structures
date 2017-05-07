/*
Procedure binary_search
   A ← sorted array
   n ← size of array
   x ← value to be searched

   Set lowerBound = 1
   Set upperBound = n 

   while x not found
      if upperBound < lowerBound 
         EXIT: x does not exists.
   
      set midPoint = lowerBound + ( upperBound - lowerBound ) / 2
      
      if A[midPoint] < x
         set lowerBound = midPoint + 1
         
      if A[midPoint] > x
         set upperBound = midPoint - 1 

      if A[midPoint] = x 
         EXIT: x found at location midPoint

   end while
   
end procedure
*/

public class BinarySearch{
	
	public int binarySearch(int[] sortedArray, int target){
		int low = 0;
		int high = sortedArray.length-1;
		
		while(true){
			if(low > high){
				System.out.println("No such element : "+target);
				return -1;
			}
			
			int mid = low + (high-low)/2;
			
			if(target > sortedArray[mid]){
				low = mid + 1;
			}
			
			if(target < sortedArray[mid]){
				high = mid - 1;
			}
						
			
			if(target == sortedArray[mid]){
				System.out.println("Found : " + sortedArray[mid]);
				return 0;
			}
		}
	}
	
	public void quickSort(int[] numbers, int low, int high){
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
			quickSort(numbers, low, j);
		}
		
		if(i < high){
			quickSort(numbers, i, high);
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
		BinarySearch binarySearch = new BinarySearch();
		
		//Sort the array first
		int[] numbers = {19,8,2,23,10,1};
		binarySearch.printArray(numbers, "Before");
		binarySearch.quickSort(numbers, 0, numbers.length -1);
		binarySearch.printArray(numbers, "Quicksort");
		
		//BinarySearch
		binarySearch.binarySearch(numbers, 1);
	}
}