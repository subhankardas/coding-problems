package leetcode.arrays;

import java.util.Arrays;

public class ReplaceElementsGreatestElementOnRightSide {

	public static void main(String[] args) {

		int[] arr = { 17, 18, 5, 4, 6, 1 };

		// Solution
		int max = arr[arr.length - 1];
		for (int idx = arr.length - 2; idx >= 0; idx--) {
			int curr = arr[idx];
			arr[idx] = max;

			max = Math.max(max, curr);
		}
		arr[arr.length - 1] = -1;

		// Answer
		System.out.println(Arrays.toString(arr));

	}

}
