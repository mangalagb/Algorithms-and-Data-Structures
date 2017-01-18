public class KnapSack{
	
	//See http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
	public int findKnapSack( int numberOfItems, int capacity, int[] weights, int[] costs){
		int[][] K = new int[numberOfItems +1][capacity +1];
		
		// i = current item.
		// rollingweight - total weight so far.
		// weights[i] = weight of the current item. Gets added to the rolling weight in case we decide to keep it.
		// costs[i] = cost of the current item. Gets added to the knapsack in case we decide to keep it.
		
		for(int i=0; i<=numberOfItems; i++){
			for(int rollingWeight=0; rollingWeight<= capacity; rollingWeight++){
				
				if(i==0 || rollingWeight==0){
					K[i][rollingWeight] = 0;
				}
				///If current item's weight is less than the rollingWeight, we can think about including it
				else if(weights[i-1] <= rollingWeight){
					//Max of dont keep it versus keep it and reduce add the weight and cost.
					K[i][rollingWeight] = max( K[i-1][rollingWeight],  costs[i-1] + K[i-1][rollingWeight - weights[i-1]]);
				}else{
					K[i][rollingWeight] = K[i-1][rollingWeight];
				}
			}
		}
		return K[numberOfItems][capacity];
	}
	
	public int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	public static void main(String[] args){
		KnapSack knapsack =  new KnapSack();
		int val[] = new int[]{60, 100, 120};
	    int wt[] = new int[]{10, 20, 30};
	    int  W = 50;
	    int n = val.length;
	    System.out.println(knapsack.findKnapSack(n ,W, wt, val));
	}
}