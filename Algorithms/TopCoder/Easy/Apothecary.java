package Easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Apothecary{
	
	//17
	//{ -9, -1, 27 }
	
	LinkedList<Integer> weightsAvailable = new LinkedList<Integer>();
	
	public void printAll3Weights(){
		int limit = 5;
		
		for(int i=0;i<limit;i++){
			int result = (int) Math.pow(3, i);
			weightsAvailable.add(result);
		}
	}
	
	public void printWeightsAvailable(){
		for(Integer weight : weightsAvailable){
			System.out.print(weight + "\t");
		}
		System.out.print("\n");
	}
	
	public void findtotalWeights(int target){
		int arbitaryLimit = 100;
		int totalWeights = 0;
		int sum = 0;
		
//		for(int i=1; i<arbitaryLimit; i=i+3){
//			sum = target + i;
//			int reminder = sum % 3;
//			if(reminder == 0){
//				totalWeights = i;
//				break;
//			}
//		}
		

		System.out.println("\n" + sum);		
	}
	
	public void isNumberPossible(){
		
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		numbers.add(1);
		numbers.add(3);
		numbers.add(9);
		numbers.add(2);
		
		int target = 12;
		int sum = 0;
		for(int i=0; i<numbers.size(); i++){
			sum = numbers.get(0);
			
			for(int j=0;j<numbers.size();j++){
				if(i!=j){
					sum = sum + j;
				}
			}
		}
	}
	
	public static void main(String[] args){
		Apothecary apothecary = new Apothecary(); 
		apothecary.printAll3Weights();
		apothecary.printWeightsAvailable();
		apothecary.findtotalWeights(19);
	}
}