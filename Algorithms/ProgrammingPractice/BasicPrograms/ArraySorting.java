/*Given an array of zeros and other integers, put all zeros at the 
 * end of the array
 */
package BasicPrograms;

public class ArraySorting {
	public void sortArray(int[] numbers) {
		int counter = 0;		
		for(int i=0;i<numbers.length;i++) {			
			if(numbers[i] != 0) {
				if(counter != i) {
					int temp = numbers[i];
					numbers[counter] = temp;
					numbers[i] = 0;
				}
				counter++;
			}			
		}
		printArray(numbers);
	}
	
	public void printArray(int[]num) {
		for(int i=0;i<num.length;i++) {
			System.out.print(num[i] + "  ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		ArraySorting arraySort = new ArraySorting();
		int[] numbers1 = {0,0,8};
		int[] numbers2 = {9,8,45,7,8,-6, 0, 0};
		int[] numbers3 = {0,9,0, 98,0,0,0,};
		int[] numbers4 = {0,9, 0, 7, -9, 87,6,0,0,0,3,2,7,1,-78};
		int[] numbers5 = {0,0,0,8,0,0,0,0,9};
		arraySort.sortArray(numbers1);
		arraySort.sortArray(numbers2);
		arraySort.sortArray(numbers3);
		arraySort.sortArray(numbers4);
		arraySort.sortArray(numbers5);
	}
}
