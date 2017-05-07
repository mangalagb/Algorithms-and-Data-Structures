package Easy;
/*
 * Points : 900
 * In this problem we will evaluate how binary search performs on data that isn't necessarily sorted.
 * An element of S is said to be binary searchable if, regardless of how the pivot is chosen on line 3 whenever the line is executed, the above algorithm returns true.

Given a sequence containing distinct integers, return the number of elements from the sequence that are binary searchable.

Examples

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
public class BinarySearchable{
	
	static int binarySearchable = 0;
	
	public void printArray(int[] numbers){
		for(int number : numbers){
			System.out.print(number+"\t");
		}
		System.out.print("\n___________________________________________________________\n");
	}
	
	public boolean verifyIfBinarySearchable(int[] numbers, int target){
		boolean searchable = true;
		int indexOfTarget = -1;
		
		for(int i=0;i<numbers.length; i++){
			if(numbers[i] == target){
				indexOfTarget = i;
				break;
			}
			
			if(numbers[i] > target){
				searchable = false;
				break;
			}
		}
		
		if(!searchable || indexOfTarget == -1){
			return false;
		}
		
		for(int i=indexOfTarget+1;i<numbers.length;i++){
			if(numbers[i] < target){
				searchable = false;
				break;
			}
		}
		
		if(!searchable){
			return false;
		}
		
		return true;
	}
	
	public int howMany(int[] sequence){		
		for(int i=0;i<sequence.length;i++){
			int target = sequence[i];
			boolean result = verifyIfBinarySearchable(sequence, target);
			//System.out.println("Target : " + target + "\tResult : " + result);
			if(result){
				binarySearchable++;
			}
		}	
		return binarySearchable;
	}


	public static void main(String[] args){
		BinarySearchable quickSort = new BinarySearchable();
		int[] numbers = {1, 3, 2, 4, 5, 7, 6, 8 };
		quickSort.printArray(numbers);

		quickSort.howMany(numbers);
		System.out.println(binarySearchable);
	}
}