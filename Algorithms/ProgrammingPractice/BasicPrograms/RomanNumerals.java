package BasicPrograms;

import java.util.HashMap;
/*
 * Lets say you want to convert IV = 4. 
 * 1) Start from end. Have 2 variables. sum and previous. 
 * 2) current = V = 5 => sum = 5, previous = 0.
 * 2) Next current = I = 1 => sum =5, previous = 5.
 * 3) Previous is greater than current. so subtract 1 from sum.
 */
public class RomanNumerals {
	HashMap<Character, Integer> values = new HashMap<Character, Integer>();
	
	public RomanNumerals(){
			values.put('I', 1);
			values.put('V', 5);
			values.put('X', 10);
			values.put('L', 50);
			values.put('C', 100);
			values.put('D', 500);
			values.put('M', 1000);
		}

	public void getDecimal(String romanValue) {
		int previousNumber = 0;
		int decimalSum = 0;
		for (int i = romanValue.length() - 1; i >= 0; i--) {
			int currentNumber = values.get(romanValue.charAt(i));
			if (previousNumber > currentNumber) {
				decimalSum = decimalSum - currentNumber;
			} else {
				decimalSum = decimalSum + currentNumber;
			}
			previousNumber = currentNumber;
		}
		System.out.println(romanValue + " = " + decimalSum);
	}

	public static void main(String[] args) {
		RomanNumerals romanNumber = new RomanNumerals();
		romanNumber.getDecimal("IV");
		romanNumber.getDecimal("XCV");
		romanNumber.getDecimal("LXXXVIII");
		romanNumber.getDecimal("MDCLXVI");
	}
}