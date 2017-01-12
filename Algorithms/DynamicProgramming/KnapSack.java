
public class KnapSack{
	
	//See http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
	public int findKnapSack(int capacity, int[] weights, int[] costs, int numberOfItems){
		int[][] K = new int[numberOfItems +1][capacity +1];
		
		for(int i=0; i<=numberOfItems; i++){
			for(int w=0; w<= capacity; w++){
				
				if(i==0 || w==0){
					K[i][w] = 0;
				}
				///If current item's weight is less than the cumulative weight,
				else if(weights[i-1] <= w){
					K[i][w] = max(costs[i-1] + K[i-1][w - weights[i-1]], K[i-1][w]);
				}else{
					K[i][w] = K[i-1][w];
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
	    System.out.println(knapsack.findKnapSack(W, wt, val, n));
	}
}