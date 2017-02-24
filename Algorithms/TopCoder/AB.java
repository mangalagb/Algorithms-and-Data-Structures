/*
Problem Statement - https://community.topcoder.com/stat?c=problem_statement&pm=13642
    	
You are given two ints: N and K. Lun the dog is interested in strings that satisfy the following conditions:

The string has exactly N characters, each of which is either 'A' or 'B'.
The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.

 
Definition   	
	Class:	AB
	Method:	createString
	Parameters:	int, int
	Returns:	String
	Method signature:	String createString(int N, int K)
	(be sure your method is public)
    
 
Constraints
-	N will be between 2 and 50, inclusive.
-	K will be between 0 and N(N-1)/2, inclusive.
 
Examples
0)	3
	2
	Returns: "ABB"
	This string has exactly two pairs (i, j) mentioned in the statement: (0, 1) and (0, 2).
	
1)	2
	0
	Returns: "BA"
	Please note that there are valid test cases with K = 0.
	
2)	5
	8
	Returns: ""
	Five characters is too short for this value of K.
	
3)	10
	12
	Returns: "BAABBABAAB"
	Please note that this is an example of a solution; other valid solutions will also be accepted.

 */


import java.util.LinkedList;
import java.util.List;

public class AB{
	
	private List<String> stringsToCheck = new LinkedList<String>();
	
	public void createString(int N, int K){
		generateRandomString(N, "");
		
		for(String str : stringsToCheck){
			int result = countNumberOfABs(str, K);
			if(result == 0){
				System.out.println(str);
				stringsToCheck.clear();
				return;
			}
		}
		stringsToCheck.clear();
		System.out.println("No such string");
	}
	
	private int countNumberOfABs(String str, int numberOfPairs){
		List<String> pairs = new LinkedList<String>();
		
		for(int i=0; i<str.length(); i++){
			for(int j= i+1; j<str.length(); j++){
				if(str.charAt(i) == 'A' && str.charAt(j) == 'B'){
					pairs.add(Integer.toString(i) + Integer.toString(j));
					if(pairs.size() > numberOfPairs){
						return -1;
					}
				}
			}
		}
		
		if(pairs.size() == numberOfPairs){
			return 0;
		}else{
			return -1;
		}
	}
	
	private void generateRandomString(int count, String totalString){
		if(count == 0){
			stringsToCheck.add(totalString);
			return;
		}		
		//Call by appending "A"
		generateRandomString(count-1, totalString + "A");
		
		//Call by appending "B"
		generateRandomString(count-1, totalString + "B");
	}
	
	public static void main(String[] args){
		AB ab = new AB();		
		ab.createString(3, 2);
		ab.createString(2, 0);
		ab.createString(5, 8);
		ab.createString(10, 12);
	}
}