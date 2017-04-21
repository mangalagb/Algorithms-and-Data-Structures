package Easy;
//Points : 250
/*You are working for the financial institution TopBank, and you have been tasked with writing a module that will take an initial account balance,
 * along with a list of that day's transactions, and return the ending balance for the day.

Each transaction will be either a credit, which adds funds to the account, or a debit, which removes funds from the account. 
If a debit exceeds the available funds at the time, then the account balance will go negative. 
You will be given an startingBalance, the initial account balance. 
You will also be given a transactions, the list of transactions for the day. 
Each element of transactions will be in the form "type amount" (quotes added for clarity). 
Each type will be 'C' or 'D', for credit or debit, respectively. 
Each amount will be an integer between 1 and 1000000, inclusive, with no leading zeros. 
You are to return an representing the ending balance after processing all of the transactions.

0)
100
{"C 1000", "D 500", "D 350"}
Returns: 250
This person had 100 dollars, got their paycheck, then went shopping at two different stores. 100 + 1000 - 500 - 350 = 250.

2)
100
{"D 50", "D 20", "D 40"}
Returns: -10
Uh oh! This person's account is overdrawn.
*/
public class AccountBalance{	
	public int processTransactions(int startingBalance, String[] transactions){
		if(transactions.length == 0){
			return startingBalance;
		}
		
		int availableBalance = startingBalance;		
		for(String transaction : transactions){
			String[] values = transaction.split(" ");
			String typeOfTransaction = values[0];
			Integer valueOfTransaction = Integer.valueOf(values[1]);
			
			if(typeOfTransaction.equals("C")){
				availableBalance += valueOfTransaction;
			}else if(typeOfTransaction.equals("D")){
				availableBalance -= valueOfTransaction;
			}
		}		
		return availableBalance;
	}
	
	public static void main(String[] args){
		AccountBalance accountBal = new AccountBalance();
		
		String[] transactions0 = {"C 1000", "D 500", "D 350"};
		int startingBalance0 = 100;		
		int result0 = accountBal.processTransactions(startingBalance0, transactions0);
		System.out.println(result0 + "\n");
		
		String[] transactions1 = {};
		int startingBalance1 = 100;		
		int result1 = accountBal.processTransactions(startingBalance1, transactions1);
		System.out.println(result1 + "\n");
		
		String[] transactions2 = {"D 50", "D 20", "D 40"};
		int startingBalance2 = 100;		
		int result2 = accountBal.processTransactions(startingBalance2, transactions2);
		System.out.println(result2 + "\n");
		
		String[] transactions3 = {"D 1234", "C 987", "D 2345", "C 654", "D 6789", "D 34567"};
		int startingBalance3 = 53874;		
		int result3 = accountBal.processTransactions(startingBalance3, transactions3);
		System.out.println(result3 + "\n");
	}
}