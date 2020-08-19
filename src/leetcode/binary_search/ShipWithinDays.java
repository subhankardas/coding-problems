package leetcode.binary_search;

public class ShipWithinDays {

	public static void main(String[] args) {

		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int D = 5;

		// Solution
		int capacity = 0;
		for (int weight : weights) {
			capacity = Math.max(capacity, weight);
		}

		int splits = splitPackages(weights, capacity);

		while (splits > D - 1) {
			capacity++;
			splits = splitPackages(weights, capacity);
		}

		// Answer
		System.out.println(capacity);

	}

	private static int splitPackages(int[] weights, int capacity) {
		int len = weights.length;
		int splits = 0;
		int weightSum = 0;

		for (int idx = 0; idx < len; idx++) {
			int weight = weights[idx];

			if (weight + weightSum <= capacity) {
				weightSum += weight;
			}

			if (idx < len - 1 && weightSum + weights[idx + 1] > capacity) {
				splits++;
				weightSum = 0;
			}
		}
		return splits;
	}

}
