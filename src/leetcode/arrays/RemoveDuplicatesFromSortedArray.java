package leetcode.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {

		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		// Solution
		int currentElement;
		int lastElement = nums[0]; // Let first element be the last visited element
		int lastIndex = 0;
		int len;

		// Loop from second element to last of array
		for (int idx = 1; idx < nums.length; idx++) {
			currentElement = nums[idx]; // Get current element

			// If current element is not same as last element i.e new record found
			if (currentElement != lastElement) {
				// Insert new element after the last element index, set last visited element
				nums[++lastIndex] = currentElement;
				lastElement = currentElement;
			}
		}
		len = lastIndex + 1;

		// Solution
		System.out.println(Arrays.toString(nums));
		System.out.println(len);

	}

}
