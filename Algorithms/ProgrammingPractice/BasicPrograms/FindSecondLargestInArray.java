package BasicPrograms;
// Java program to find largest and second largest elements
 
public class FindSecondLargestInArray{
	
	public int findSecondLargest(int[] numbers) {
		if(numbers.length == 0) {
			System.out.print("empty array");
			return -1;
		}if(numbers.length == 1) {
			return numbers[0];
		}if(numbers.length == 2) {
			if(numbers[0] > numbers[1]) {
				return numbers[1];
			}else {
				return numbers[0];
			}
		}
		
		int largest = numbers[0];
		int secondLargest = -1;
		for(int i=1; i<numbers.length;i++) {
			if(numbers[i] > largest) {
				secondLargest = largest;
				largest = numbers[i];
			}else if(numbers[i] > secondLargest && numbers[i] != largest) {
				secondLargest = numbers[i];
			}	
		}
		System.out.print(largest + "\t" + secondLargest);
		return -1;
	}
	
	public static void main(String[] args) {
		FindSecondLargestInArray find = new FindSecondLargestInArray();
		int[] numbers = {12, 13, 34, 10, 34, 1};
		find.findSecondLargest(numbers);
	}
}