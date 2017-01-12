/*
 * In Tower of Hanoi, we need 3 pegs - 1, 2 and 3.
 * Now, say we want to move from 1 to 2. The helper will be 3.
 * If we move from 3 to 2, the helper will be 1.
 * Sum of all pegs = 1+2+3 = 6. 
 * Therefore, helperpeg = 6 - frompeg - topeg
 * 
 * 1)Move (n-1) discs from start pole to helper pole.
 * 2)Move the last disc from start pole to end pole.
 * 3)Move the (n-1) discs from helper pole to end pole. 
 */
package chapter3;

public class TowerOfHanoi{

	public void towerOfHanoi(int numberOfDisks, int fromPeg, int toPeg){
		// Because fromPeg + helpPeg + toPeg = 6 
		int helperPeg = 6-fromPeg-toPeg;     

		if(numberOfDisks == 1){
			System.out.println(fromPeg+"->"+toPeg);
		}
		else{
			towerOfHanoi(numberOfDisks-1,fromPeg,helperPeg);
			System.out.println(fromPeg+"->"+toPeg);
			towerOfHanoi(numberOfDisks-1, helperPeg, toPeg);
		}
	}

	public static void main(String[] args){
		TowerOfHanoi hanoi = new TowerOfHanoi();
		hanoi.towerOfHanoi(3, 1, 3);	
	}
}