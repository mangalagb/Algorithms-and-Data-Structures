/*
 * You are given N distinct numbers. Find the number of groups of 2 or 3 that can be formed whose sum is divisible by three.
 * 
 * When u divide by 3, you get reminder 0 , 1 and 2
 * 
 * Group of 2 
 * 		Both numbers are divisible by 3(their sum will be divisible by 3) (Reminder 0, 0)
 * 		First num has reminder 1 (say 7), second num has reminder 2 (say 5). So 5+7 = 12 (Reminder 1 ,2)
 * 
 * Group of 3
 * 		Reminder 0, 1, 2
 * 		Reminder 0, 0, 0
 */
package BasicPrograms;

import java.util.LinkedList;

public class GroupsOfNumbersDivisibleBy3{
	
	public void findGroups(int[] numbers){
		LinkedList<Integer> reminder0 = new LinkedList<Integer>();
		LinkedList<Integer> reminder1 = new LinkedList<Integer>();
		LinkedList<Integer> reminder2 = new LinkedList<Integer>();
		int numberOfGroups = 0;
		
		for(Integer num : numbers){
			if(num % 3 == 0){
				reminder0.add(num);
			}else if(num % 3 == 1){
				reminder1.add(num);
			}else{
				reminder2.add(num);
			}
		}
		
		//If you dont want to print the groups, you can break here
		//But the formula is compilcated :-(
		
		//Find groups of 2
		System.out.println("Gropus of 2\n");
		
		//Reminder 0, 0
		if(reminder0.size() > 1){
			for(int i=0;i<reminder0.size();i++){
				for(int j=i; j< reminder0.size();j++){
					System.out.println(reminder0.get(i) + "\t" + reminder0.get(j));
					numberOfGroups++;
				}
			}
		}
		
		//Reminder 1 ,2
		for(int i=0;i<reminder1.size();i++){
			for(int j=0; j< reminder2.size();j++){
				System.out.println(reminder1.get(i) + "\t" + reminder2.get(j));
				numberOfGroups++;
			}
		}
		
		//Find groups of 3
		System.out.println("Gropus of 3\n");
		
		//Reminder 0, 0, 0
		if(reminder0.size() >2){
			for(int i=0;i<reminder0.size();i++){
				for(int j=i; j< reminder0.size();j++){
					for(int k=j;k<reminder0.size();k++){
						System.out.println(reminder0.get(i) + "\t" + reminder0.get(j) + "\t" + reminder0.get(k));
						numberOfGroups++;
					}
				}
			}
		}
		
		//Reminder 0, 1, 2
		for(int i=0;i<reminder0.size();i++){
			for(int j=0; j< reminder1.size();j++){
				for(int k=0;k<reminder2.size();k++){
					System.out.println(reminder0.get(i) + "\t" + reminder1.get(j) + "\t" + reminder2.get(k));
					numberOfGroups++;
				}
			}
		}
		
		System.out.println("Number of groups = " + numberOfGroups);
	}
	
	public static void main(String[] args){
		GroupsOfNumbersDivisibleBy3 groups = new GroupsOfNumbersDivisibleBy3();
		int[] numbers = {1, 5, 7, 2, 9, 14};
		groups.findGroups(numbers);
	}
	
}