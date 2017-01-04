
		
import java.util.ArrayList;

public class NumberPalindrome{
	public boolean isPalindrome(int number) {
		char[] numberArray = Integer.toString(number).toCharArray();
		boolean isPalindrome = true;
		
		for(int i=0, j=numberArray.length-1; i<numberArray.length/2; i++,j--){
			if(numberArray[i] != numberArray[j]){
				isPalindrome = false;
				break;
			}
		}
		
		if(isPalindrome) {
			return true;
		}else {
			return false;
		}
	}
	
	public void getAllThreePlaceDigits(){
		ArrayList<Integer> numbers =  new ArrayList<Integer>();
		for(int i=1; i<=9; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=0; k<=9; k++) {
					int number = (i*100) + (j*10) + k;
					numbers.add(number);
				}
			}
		}
		findAllProducts(numbers);
	}
	
	public void findAllProducts(ArrayList<Integer> numbers) {
		int largest = 0;
		int firstNumber = 0;
		int secondNumber = 0;
		for(int i=0; i<numbers.size(); i++) {
			for(int j=0; j<numbers.size(); j++) {
				int product = numbers.get(i) * numbers.get(j);
				
				if(product > largest && isPalindrome(product)) {
					largest = product;
					firstNumber = numbers.get(i);
					secondNumber = numbers.get(j);
				}
			}
		}
		
		System.out.println("largest prod  = " + largest);
		System.out.println("number 1   = " + firstNumber + " second num = " + secondNumber);
	}
	
	public static void main(String[] args) {
		NumberPalindrome num = new NumberPalindrome();
		//System.out.println(num.isPalindrome(1001));		
		num.getAllThreePlaceDigits();
	}
	
}