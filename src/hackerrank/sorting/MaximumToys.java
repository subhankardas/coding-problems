package hackerrank.sorting;

import java.util.Arrays;

public class MaximumToys {

	public static void main(String[] args) {

		int[] prices = { 1, 12, 5, 111, 200, 1000, 10 };
		int k = 50;

		System.out.println(maximumToys(prices, k));

	}

	static int maximumToys(int[] prices, int k) {
		Arrays.sort(prices);
		long totalPrice = 0l;
		int num = 0;
		int idx = 0;

		while (totalPrice + prices[idx] <= k) {
			num++;
			totalPrice += prices[idx];
			idx++;
		}

		return num;
	}

}
