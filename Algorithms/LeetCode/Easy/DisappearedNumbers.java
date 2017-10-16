package Easy;

import java.util.LinkedList;
import java.util.List;

public class DisappearedNumbers {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		int size = nums.length;
		List<Integer> result = new LinkedList<Integer>(); 
		
		for(int i=0;i<nums.length;i++) {
			int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
		}
		
		return result;
    }

	public static void main(String[] args) {
		DisappearedNumbers num = new DisappearedNumbers();
		int[] nums = {4,3,2,7,8,2,3,1};
		num.findDisappearedNumbers(nums);
	}
}
