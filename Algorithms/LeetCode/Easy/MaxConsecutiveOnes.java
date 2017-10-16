/*
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 */
package Easy;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int localCount = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] == 1) {
				localCount++;
			}else {
				if(localCount > count) {
					count = localCount;
				}
				localCount = 0;
			}
		}
		if(localCount > count) {
			count = localCount;
		}
        return count;
    }
	
	public static void main(String[] args) {
		MaxConsecutiveOnes maxOnes = new MaxConsecutiveOnes();
		int[] nums = {1,1,0,1,1,1};
		System.out.print(maxOnes.findMaxConsecutiveOnes(nums));
	}
}
