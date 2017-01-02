package ProjectEuler;
/* Problem 38
 * Take the number 192 and multiply it by each of 1, 2, and 3:

192 × 1 = 192
192 × 2 = 384
192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576. 
We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, 
giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated 
product of an integer with (1,2, ... , n) where n > 1?
*/

public class PantadigitalProduct{
	public int largestPantaDigitalProduct = 0;
	public int[] largestMultipliers = new int[10];
	public int largestNumber = 0;
	
	public boolean isPantaDigital(String number) {
		if(number.isEmpty() || number == null || number.length() < 9 || number.contains("0")){
			return false;
		}
		boolean[] pantadigitalNumbers = new boolean[9];
		for(int i=0; i<9;i++) {
			pantadigitalNumbers[i] = false;
		}
		
		for(int i=0; i<number.length(); i++) {
			int digit = Character.getNumericValue(number.charAt(i)) -1;
			
			if(pantadigitalNumbers[digit] == false) {
				pantadigitalNumbers[digit] = true;
			}else {
				//the digit is being repeated. so not pantadigital
				return false;
			}
		}
		return true;
	}
	
	public void findConcatenedProduct(int number, int[] multipliers) {
		StringBuilder concatenetaedProduct =  new StringBuilder();
		for(int multi : multipliers) {
			int product = number * multi;
			concatenetaedProduct.append(Integer.toString(product));
		}
		
		if(isPantaDigital(concatenetaedProduct.toString())) {
			int concatenedNumber = Integer.parseInt(concatenetaedProduct.toString());
			if(concatenedNumber > largestPantaDigitalProduct) {
				largestPantaDigitalProduct = concatenedNumber;
				largestMultipliers = multipliers;
				largestNumber = number;
			}
		}
	}
	
	public void getLargest(){
		System.out.println("Largest pantadigital number = "+ largestPantaDigitalProduct);
		System.out.println("Largest number = "+ largestNumber);
		String products = "";
		if(largestPantaDigitalProduct !=0) {
		for(int i=1;i<= largestMultipliers.length; i++) {
			products = products + "  " + i;
		}
		}
		System.out.println("Largest multipliers = "+ products);
	}
	
	public void getMulipliers(){
		int integers = 500;
		int numbersToCheck = 9999;
		
		for(int size=2;size<=integers;size++) {
			int[] mulitipliers = new int[size];
			for(int k =0;k <size; k++) {
				mulitipliers[k] = k+1;
			}
			
			//Now iterate for numbers
			for(int i=1;i<=numbersToCheck;i++){
				findConcatenedProduct(i, mulitipliers);
			}
		}
	}
	
	public static void main(String[] args){
		PantadigitalProduct panta = new PantadigitalProduct();
		
		//System.out.println(panta.isPantaDigital("9182736"));
		//panta.findConcatenedProduct(192, new int[] {1,2,3});
		//panta.getLargest();
		
		panta.getMulipliers();
		panta.getLargest();
	}
	
}
