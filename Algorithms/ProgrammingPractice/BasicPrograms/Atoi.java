package BasicPrograms;
/*
 * The numbers 0-9 are consecutive in the Ascii character set. A character is just an 8-bit value.
 * The characters '0', '1', '2'... have values 48, 49, 50... so subtracting 0 from a digit character gives its integer value.
 * 
 * Things to check
 * 1) Null or empty string
 * 2) White spaces
 * 3) Plus or minus sign
 * 4) Actual conversion to number
 * 5) Integer overflow limits
 */
public class Atoi{	
	public void convertToInteger(String str){		
		if(str == null || str.isEmpty()){
			System.out.println("Invalid string");
			return;
		}
		
		str = str.trim();
		
		int counter = 0;
		char sign = '+';
		if(str.charAt(0) == '-'){
			sign = '-';
			counter++;
		}else if(str.charAt(0) == '+'){
			counter++;
		}
		
		double result  = 0;
		while(counter < str.length() && str.charAt(counter)>= '0' && str.charAt(counter)<= '9'){
			int character = str.charAt(counter) - '0';
			result = result * 10;
			result = result + character;
			counter++;
		}
		
		if(sign == '-'){
			result = -result;
		}
		
		if(result > Integer.MAX_VALUE){
			result = Integer.MAX_VALUE;
		}else if(result < Integer.MIN_VALUE){
			result = Integer.MIN_VALUE;
		}
		
		System.out.println((int)result);
	}
	
	public static void main(String[] args){
		Atoi atoi = new Atoi();
		atoi.convertToInteger("   -767");
	}	
}