package Easy;

import java.util.Scanner;

class CHN05{
	
	public void readInput() {
		Scanner scanner = new Scanner(System.in);
		Integer numberOfCases = Integer.parseInt(scanner.nextLine());
		
		int[] users = new int[numberOfCases];
		int[] topics = new int[numberOfCases];
			
		for(int i=0;i<numberOfCases;i++) {
			String line = scanner.nextLine();			
			String[] caseToBeProcessed = line.split(" ");
			int numberOfUsers = Integer.parseInt(caseToBeProcessed[0]);
			int numberOfTopics = Integer.parseInt(caseToBeProcessed[1]);
			
			users[i] = numberOfUsers;
			topics[i] = numberOfTopics;
		}	
		
		for(int i=0; i< users.length;i++) {
			findSolution(users[i], topics[i]);
		}
	}
	
	public int findSolution(int numberOfUsers, int numberOfTopics) {
		int result = 0;
		int counter = -1;
		if(numberOfUsers == 1) {
			result = 0;
		}else if(numberOfUsers == 2) {
			result = numberOfTopics;
		}else if(numberOfUsers == 3) {
			result = 2 * numberOfTopics;
		}else {
			if(numberOfTopics == 1) {
				result = numberOfUsers - 1;
			}else {
				for(int i=2; i<=numberOfTopics; i++) {
					counter += 2;
				}
				result = numberOfUsers + counter;
			}
		}
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		CHN05 chn05 = new CHN05();
		chn05.readInput();
	}
}