package ArrayBasedQuestions;
/*
 * You are given an array of 0s and 1s in random order. 
 * Segregate 0s on left side and 1s on right side of the array. 
 * Traverse array only once.
 */
public class Segregate0and1 {
	public void printArray(int[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i] + "\t");
		}
		System.out.print("\n____________________________________________________________________________\n");
	}
	
	public void doSegregation(int[] numbers) {
		if(numbers.length == 0) {
			return;
		}
		
		int i = 0;
		int j = numbers.length-1;
		
		while(i<=j) {
			while(numbers[i] == 0) {
				i++;
			}
			
			while(numbers[j] == 1) {
				j--;
			}
			
			if(i<=j) {
				numbers[i] = 0;
				numbers[j] = 1;
				i++;
				j--;
			}
		}
	}
	
	public static void main(String[] args) {
		Segregate0and1 segregate = new Segregate0and1();
		int[] numbers = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		segregate.printArray(numbers);
		segregate.doSegregation(numbers);
		segregate.printArray(numbers);
	}

}
