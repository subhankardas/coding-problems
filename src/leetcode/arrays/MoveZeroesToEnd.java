package leetcode.arrays;

import java.util.Arrays;

public class MoveZeroesToEnd {

	public static void main(String[] args) {

		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);

	}

	// Solution
	public static void moveZeroes(int[] nums) {
		int idx = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[idx] = num;
				idx++;
			}
		}
		Arrays.fill(nums, idx, nums.length, 0);
	}

}
