package leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and integer target find the indices of elements
 * in the array that sums total to target.
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 15, 11 };
		int target = 9;

		System.out.println(Arrays.toString(twoSum(nums, target)));
	}

	public static int[] twoSum(int[] nums, int target) {
		// Use map to keep track of elements traversed
		Map<Integer, Integer> occur = new HashMap<>();
		occur.put(nums[0], 0);

		// Traverse elements and find if nums has element i.e. target - current element
		for (int i = 1; i < nums.length; i++) {
			Object pos = occur.get(target - nums[i]);
			if (pos != null) {
				return new int[] { (int) pos, i };
			} else {
				occur.put(nums[i], i);
			}
		}

		return null;
	}

}
