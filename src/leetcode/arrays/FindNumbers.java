package leetcode.arrays;

public class FindNumbers {

	public static void main(String[] args) {

		// Find no. of elements with even no. of digits
		int[] nums = { 12, 345, 2, 6, 7896 };

		// Solution 1
		int count = 0;
		for (int num : nums) {
			String s = Integer.toString(num);
			if (s.length() % 2 == 0)
				count++;
		}

		// Answer
		System.out.println(count);

		// Solution 2 - No. of digits = log10(num) + 1
		count = 0;
		for (int num : nums) {
			if ((int) (Math.log10(num) + 1) % 2 == 0)
				count++;
		}

		// Answer
		System.out.println(count);

	}

}
