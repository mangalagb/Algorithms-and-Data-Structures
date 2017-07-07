/* Find the longest unbroken series of increasing numbers in a list of random numbers',
 * If given [15, 2, 38, 71, 2, 524, 98], return [2, 38, 71]
 * 
 */
package BasicPrograms;

import java.util.ArrayList;

public class LongestIncreasingSeries{
	
	public Integer[] largestSeries(int[] numbers){		
		ArrayList<Integer> longestSeries = new ArrayList<Integer>();
		
		for(int i=0; i<numbers.length; i++){
			ArrayList<Integer> localLongestSeries = new ArrayList<Integer>();
			localLongestSeries.add(numbers[i]);
			
			for(int j=i+1; j<numbers.length; j++){
				if(numbers[j] > numbers[j-1]){
					localLongestSeries.add(numbers[j]);
				}else{
					break;
				}
			}
			
			if(longestSeries.isEmpty()){
				longestSeries.addAll(localLongestSeries);
			}else if(localLongestSeries.size() > longestSeries.size()){
				longestSeries.clear();
				longestSeries.addAll(localLongestSeries);
			}
		}
		return longestSeries.toArray(new Integer[longestSeries.size()]);
	}
	
	public static void main(String[] args){
		LongestIncreasingSeries series = new LongestIncreasingSeries();
		int[] numbers = {15, 2, 38, 71, 2, 524, 98};
		
		Integer[] result = series.largestSeries(numbers);
		System.out.println("Done");
	}
}