package leetcode.arrays;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {

		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		int m = 3;
		int n = 3;

		// Solution
		int[] num = Arrays.copyOfRange(nums1, 0, m);
		int p1 = 0;
		int p2 = 0;
		int idx = 0;

		// Loop if any of array pointers are not at end
		while (p1 < m || p2 < n) {
			int n1;
			int n2;

			// If array 1 pointer at end, add element from array 2
			if (p1 == m) {
				n2 = nums2[p2];
				nums1[idx] = n2;
				idx++;
				p2++;
			} else if (p2 == n) {
				// If array 2 pointer at end, add element from array 1
				n1 = num[p1];
				nums1[idx] = n1;
				idx++;
				p1++;
			} else {
				// If both array pointers are not at end
				n1 = num[p1];
				n2 = nums2[p2];

				// If n1 from array 1 smaller add to array, else add n2 from array 2
				if (n1 < n2) {
					nums1[idx] = n1;
					idx++;
					p1++;
				} else {
					nums1[idx] = n2;
					idx++;
					p2++;
				}
			}
		}

		// Solution
		System.out.println(Arrays.toString(nums1));
	}

}
