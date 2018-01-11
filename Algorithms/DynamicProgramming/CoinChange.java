/* Given an amount V, if we want to make change for V rupees, 
 * and we have infinite supply of each of C = { C1, C2, .. , Cm} 
 * valued coins, what is the minimum number of coins to make the change?
*/
public class CoinChange {
	
	public void coinChange(int amount, int[] coins) {
		
		//Two arrays. One for storing the number of coins and 
		//one for storing the denomination value for the answer
		int[] result = new int[amount+1];
		int[] track = new int[amount+1];	
		
		//Intialize arrays with default values
		for(int i=1;i<result.length;i++) {
			result[i] = Integer.MAX_VALUE;
			track[i] = -1;
		}
		
		for(int amt=1; amt<=amount; amt++) {			
			for(int coin : coins) {
				if(coin <= amt) {
					if(result[amt] > (result[amt-coin] + 1)) {
						result[amt] = result[amt-coin] + 1;
						track[amt] = coin;
					}
				}
			}
		}
		
		System.out.println("\n---------------------------------------------------------------------------------");
		System.out.println("Minimum number of coins required for " + amount + " dollars = " + result[amount]);
		System.out.println("The coins are :\t");
		int pos = amount;
		while(pos != 0) {
			System.out.print(track[pos] + "\t");
			pos = pos - track[pos];
		}
	}
	
	public static void main(String[] args) {
		CoinChange coinChange = new CoinChange();
		int[] coins1 = {25, 10, 5};
		int amount1 = 30;
		coinChange.coinChange(amount1, coins1);
		
		int[] coins2 = {9, 6, 5, 1};
		int amount2 = 11;
		coinChange.coinChange(amount2, coins2);
	}
}
