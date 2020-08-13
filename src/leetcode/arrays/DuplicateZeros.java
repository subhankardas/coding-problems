package leetcode.arrays;

import java.util.Arrays;

public class DuplicateZeros {

	public static void main(String[] args) {

		int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };

		// Solution
		int[] copy = Arrays.copyOf(arr, arr.length);
		int window = 0;
		int zcount = 0;
		int idx = 0;

		for (int num : copy) {
			if (num == 0) {
				if (window == 0)
					window = 1;
				if (window == 1)
					zcount++;
			} else {
				window = 0;
				int count = zcount % 2 == 0 ? zcount : zcount + 1;

				for (int i = 1; i <= count; i++) {
					arr[idx] = 0;
					idx++;
				}

				arr[idx] = num;
				idx++;

				zcount = 0;
				if (idx == arr.length)
					break;
			}
		}

		// Answer
		System.out.println(Arrays.toString(arr));

	}

}
