package BasicPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TopKRepeatedNumbers{
	
	public void findTopKRepeatedNumbers(int[] numbers, int k){
		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		
		for(int i=0;i<numbers.length;i++){
			int num = numbers[i];
			if(!freqMap.containsKey(num)){
				freqMap.put(num, 1);
			}else{
				int val = freqMap.get(num) + 1;
				freqMap.put(num, val);
			}
		}
		
		LinkedList<Integer> occurence = new LinkedList<Integer>();
		LinkedList<Integer> numberValues = new LinkedList<Integer>();
		
		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
			if(occurence.isEmpty()){
				numberValues.add(entry.getKey());
				occurence.add(entry.getValue());	
			}else{
				int num = entry.getKey();
				int count = entry.getValue();
				int indexToInsert = -1;
				for(int i = 0; i < occurence.size(); i++){
					
					if(occurence.get(i) > count){
						indexToInsert = i + 1;
						break;
					}else if(count > occurence.get(i)){
						if(i==0){
							indexToInsert = 0;
						}else{
							indexToInsert = i-1;
						}
						break;
					}else if(count == occurence.get(i)){
						if(num > numberValues.get(i)){
							indexToInsert = i;
						}else{
							indexToInsert = i+1;
						}
					}		
				}
				occurence.add(indexToInsert, count);
				numberValues.add(indexToInsert, num);
			}
		}
		
		System.out.println("Done");
	}
	
	public static void main(String[] args){
		TopKRepeatedNumbers topK = new TopKRepeatedNumbers();
		int[] numbers = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
		int k =2;
		topK.findTopKRepeatedNumbers(numbers, k);
	}
}