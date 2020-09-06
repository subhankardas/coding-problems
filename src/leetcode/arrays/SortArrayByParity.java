package leetcode.arrays;

import java.util.Arrays;

public class SortArrayByParity {

	public static void main(String[] args) {

		int[] A = { 3, 1, 2, 4 };

		// Answer
		System.out.println(Arrays.toString(sortArrayByParity(A)));

	}

	/**
	 * Solution: Sort array with all even numbers on left side and odd numbers on
	 * right side. Solution uses two pointers one for even that starts from 0 and
	 * another for odd that starts from last index.
	 */
	public static int[] sortArrayByParity(int[] A) {
		int len = A.length;
		int evenIdx = 0;
		int oddIdx = len - 1;
		int temp;

		// While even index is does not cross odd index
		while (evenIdx < oddIdx) {
			boolean isEven = A[evenIdx] % 2 == 0; // Is even index element even
			boolean isOdd = A[oddIdx] % 2 != 0; // Is odd index element odd

			// If n1 is even and n2 is even, place n2 after n1
			if (isEven && !isOdd) {
				evenIdx++;
				temp = A[evenIdx];
				A[evenIdx] = A[oddIdx];
				A[oddIdx] = temp;
			} else if (!isEven && !isOdd) {
				// If n1 is odd and n2 is even, swap n1 and n2
				temp = A[evenIdx];
				A[evenIdx] = A[oddIdx];
				A[oddIdx] = temp;
				evenIdx++;
				oddIdx--;
			} else if (!isEven && isOdd) {
				// If n1 is odd and n2 is odd, place n1 before of n2
				oddIdx--;
				temp = A[evenIdx];
				A[evenIdx] = A[oddIdx];
				A[oddIdx] = temp;
			} else {
				// If n1 is even and n2 is odd, skip this case and proceed
				evenIdx++;
				oddIdx--;
			}
		}

		return A;
	}

}
