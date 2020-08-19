package leetcode.arrays;

import java.util.Arrays;

public class RemoveElement {

	public static void main(String[] args) {

		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;

		// Solution
		int len = nums.length;
		int idx = 0;
		while (idx < len) {
			// If removal element found decrement length, shift all elements to left
			if (nums[idx] == val) {
				len--;
				for (int rem = idx; rem < len; rem++) {
					nums[rem] = nums[rem + 1];
				}
			} else {
				// Else increment index i.e move forward
				idx++;
			}
		}

		// Solution
		System.out.println(Arrays.toString(nums));
		System.out.println(len);

	}

}
