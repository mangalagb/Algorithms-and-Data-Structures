/*
 * 1) Merge sort is used when the data structure doesn’t support random access, since it works with pure sequential access (forward iterators, rather than random access iterators). 
 * 	It’s also widely used for external sorting, where random access can be very, very expensive compared to sequential access.
	For example, When sorting a file which doesn’t fit into memory, you might break it into chunks which fit into memory, 
	sort these using independently, writing each out to a file, then merge sort the generated files.
	
	2) You can use merge sort when you need a stable sort. It’s very important feature of merge sort.
	
	3) Mergesort is quicker when dealing with linked lists. This is because pointers can easily be changed when merging lists.
	  It only requires one pass (O(n)) through the list.
	  
	4) If there is a lot of parallelization occurs then parallelizing Mergesort is simpler than other sort algorithms.
 */

public class MergeSort{
	private int[] numbers;
	private int[] helper;
	
	public MergeSort(int[] array){
		numbers = array;
		helper = new int[numbers.length];
	}
	
	public void mergeSort(int low, int high){		
		 // check if low is smaller then high, if not then the array is sorted
		if(low < high){
			int middle = low + (high-low)/2;
			
			mergeSort(low, middle);
			mergeSort(middle+1, high);
			
			 //Combine left and right parts
			merge(low, middle, high);
		}
	}
	
	public void merge(int low, int middle, int high){
		// Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
                helper[i] = numbers[i];
        }
		
		int i =low;
		int j = middle +1;
		int k = low;
		
		//If left is less, copy that to helper.
		//Else, copy right
		while(i<= middle && j<=high){
			if(helper[i] < helper[j]){
				numbers[k] = helper[i];
				i++;
			}else{
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		
		// Copy the rest of the left side of the array into the target array
		while(i <= middle){
			numbers[k] = helper[i];
			i++;
			k++;
		}		
	}
	
	public void printArray(String method){
		System.out.print(method + " :\t");
		for(int number : numbers){
			System.out.print(number+"\t");
		}
		System.out.print("\n___________________________________________________________\n");
	}
	
	public static void main(String[] args){
		int[] numbers =  {19,8,2,23,10,1};
		MergeSort mergeSort = new MergeSort(numbers);
		mergeSort.printArray("Before");
		mergeSort.mergeSort(0, numbers.length - 1);
		mergeSort.printArray("After");
	}
}