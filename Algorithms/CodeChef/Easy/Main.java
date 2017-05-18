package Easy;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	
	public int isProgression(ArrayList<Integer> elements){
		int numberOfElements = elements.size();
		if(elements.size() == 0 || elements.size() == 1){
			System.out.println("-1");
			return -1;
		}else if(elements.size() == 2){
			int number = elements.remove(0);
			System.out.println(number);
			return elements.remove(0);
		}
		
		ArrayList<Integer> differences = new ArrayList<Integer>();		
		int i = 0;
		int j = i+1;
		
		while(j != numberOfElements){
			int localDifference = elements.get(j) - elements.get(i);
			differences.add(localDifference);
			i++;
			j++;
		}
		
//		for(Integer diff : differences){
//			System.out.print(diff + "\t");
//		}
		analyzeDifferences(differences, elements);
		return -1;
	}
	
	private void analyzeDifferences(ArrayList<Integer> differences, ArrayList<Integer> elements){
		boolean removeOneNumber = false;
		int i = 0;
		int j = i+1;
		int removedNumber = elements.get(0);
		
		int index = -1;
		
		while(j != differences.size()){
			if(differences.get(i) != differences.get(j) && !removeOneNumber){
				
				if(i == 0){
					differences.remove(i);
					index = i;
				}else if(j== differences.size()-1){
					differences.remove(j);
					index = j + 1;
				}else{
					differences.remove(j);
					differences.remove(j);
					index = j + 1;
				}
				removeOneNumber = true;
				removedNumber = removeOneNumber(elements, index);
				
				continue;
			}
			
			if(differences.get(i) != differences.get(j) && removeOneNumber){
				removedNumber = -1;
				break;
			}
			
			i++;
			j++;
		}

		System.out.println(removedNumber);
	}
	
	public int removeOneNumber(ArrayList<Integer> elements, int index){
		int numberRemoved = elements.get(index);
		elements.remove(index);
		return numberRemoved;
	}
	
	public void printSequence(ArrayList<Integer> elements){
		for(Integer element : elements){
			System.out.print(element + "\t");
		}
		System.out.print("\n");
	}
	
	public void readInput() {
		Scanner scanner = new Scanner(System.in);
		Integer numberOfCases = Integer.parseInt(scanner.nextLine());
		ArrayList<ArrayList<Integer>> allElements = new ArrayList<>();
		
		for(int i=0;i<numberOfCases;i++) {
			String numberOfElements = scanner.nextLine();
			String line = scanner.nextLine();			
			ArrayList<Integer> elements = new ArrayList<Integer>();
			if(line.contains(" ")){				
				String[] caseToBeProcessed = line.split(" ");
				for(String str : caseToBeProcessed){
					elements.add(Integer.parseInt(str));
				}
				allElements.add(elements);
			}
		}
		scanner.close();
		
		for(ArrayList<Integer> elements : allElements){
			isProgression(elements);
		}
	}
	
	public static void main(String[] args){
		Main arithmeticSequence = new Main();
		arithmeticSequence.readInput();
	}
}