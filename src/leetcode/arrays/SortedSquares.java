package leetcode.arrays;

import java.util.Arrays;

public class SortedSquares {

	public static void main(String[] args) {

		// Get the array of squares in sorted order from array of sorted numbers
		int[] A = { -4, 0, 1, 3 };

		// Solution
		int len = A.length;
		int[] res = new int[len];
		int start = 0;
		int end = len - 1;
		int idx = end;

		while (start <= end) {
			// Pointers from start and end of array
			int n1 = A[start] * A[start];
			int n2 = A[end] * A[end];

			if (n1 > n2) {
				res[idx--] = n1; // Add element to end of result array
				start++;
			} else {
				res[idx--] = n2;
				end--;
			}
		}

		// Answer
		System.out.println(Arrays.toString(res));
	}

}
