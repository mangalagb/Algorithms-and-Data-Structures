package Easy;
import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers and an integer k, find the number of unique k-diff pairs in the array. 
 * Here a k-diff pair is defined as an integer pair (i, j), where i and j are 
 * both numbers in the array and their absolute difference is k.
 */
public class kPairs {
	public int findPairs(int[] nums, int k) {
		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		Set<Integer> matchingPairs = new HashSet<Integer>();
		
		for(int i=0; i<nums.length;i++) {
			if(uniqueNumbers.contains(Math.abs(nums[i] - k))){
				matchingPairs.add(nums[i] - k);
			}
			if(uniqueNumbers.contains(Math.abs(nums[i] + k))) {
				matchingPairs.add(nums[i]);
			}
			uniqueNumbers.add(nums[i]);
		}
		return matchingPairs.size();
    }
	
	public static void main(String[] args) {
		kPairs pairs = new kPairs();
		int[] nums = {1, 3, 1, 5, 4};
		int k = 0;
		System.out.print(pairs.findPairs(nums, k));
	}
}
