package leetcode.arrays;

public class FindMaxConsecutiveOnes {

	public static void main(String[] args) {

		// Find max. no. of consecutive ones
		int[] nums = { 1, 1, 0, 1, 1, 1 };

		// Solution
		int count = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			// Count no. of 1s
			if (nums[i] == 1) {
				count++;
			} else {
				// Window ended, check and initialize count
				max = count > max ? count : max;
				count = 0;
			}
		}
		max = count > max ? count : max; // Check for the last window count

		// Answer
		System.out.println(max);

	}

}
