package leetcode.arrays;

public class ValidMountainArray {

	public static void main(String[] args) {

		int[] A = { 0, 2, 3, 4, 5, 2, 1, 0 };

		// Answer
		System.out.println(validMountain(A));

	}

	// Solution
	public static boolean validMountain(int[] A) {
		// Valid mountain should have min. length of 3
		if (A.length < 3) {
			return false;
		}

		boolean hillTop = false;
		int lastDiff = 0;

		for (int idx = 1; idx < A.length; idx++) {
			// Height difference of current height from previous height
			int diff = A[idx] - A[idx - 1];

			// Valley found, invalid mountain
			if (diff == 0) {
				return false;
			}

			// Height drop i.e hill top found
			if (lastDiff > 0 && diff < 0) {
				hillTop = true;
			}

			// If hill top found and going up, invalid mountain
			if (hillTop && diff > 0) {
				return false;
			}

			// If hill top not found and going down, invalid mountain
			if (!hillTop && diff < 0) {
				return false;
			}

			lastDiff = diff;
		}

		return hillTop;
	}

}
