//https://community.topcoder.com/stat?c=problem_statement&pm=13656

class Decipherability{
	
	private int findSubstring(String targetString, int length){	
		if(length == 0){
			System.out.println("Certain");
		    return 0;
		}
		
		System.out.print(targetString + "\n");
		for (int from = 0; from < targetString.length(); from++) {
	        for (int to = from + 1; to <= targetString.length(); to++) {
	        	//System.out.println(from + "\t" + to + "\n");
	        	String substr = targetString.substring(from, to);
	        	if(substr.length() == length){
	        		System.out.print(substr + "\t");
	        	}
	        }
	    }
		System.out.print("\n");
	    System.out.println("Certain");
	    return 0;
	}
	
	public void printcombinations(String targetString, int length){
		for(int i=0; i<targetString.length(); i++){
			for(int j=0; j<targetString.length();j++){
				if(i != j){
					System.out.println(i + "\t" + j);
				}
			}
		}
		
	}
	
	public void check(String targetString, int numberOfCharsRemoved){
		int length = targetString.length() - numberOfCharsRemoved;
		findSubstring(targetString, length);
	}
	
	public static void main(String[] args){
		Decipherability decipher = new Decipherability();
		decipher.check("koukyoukoukokukikou", 2);
		//decipher.printcombinations("abcd", 3);
	}
}