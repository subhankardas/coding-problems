package hackerrank.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Problem: Calculate the minimum absolute difference between the given array of
 * numbers. The difference is the positive distance between the numbers on
 * numeric line.
 * 
 * Solution: Sort the numbers to get them in order of numeric line, calculate
 * and store the minimum distance between two consecutive numbers.
 */
public class MinimumAbsoluteDifference {

	public static void main(String[] args) {

		System.out.println(minimumAbsoluteDifference(Arrays.asList(3, -7, 0)));
		System.out.println(minimumAbsoluteDifference(Arrays.asList(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75)));

	}

	public static int minimumAbsoluteDifference(List<Integer> arr) {
		Collections.sort(arr);

		int idx = 0;
		int diff = 0;
		int mindiff = Integer.MAX_VALUE;

		// Calculate distance between adjacent indices and store the minimum
		while (idx < arr.size() - 1) {
			diff = Math.abs(arr.get(idx) - arr.get(idx + 1));
			mindiff = Math.min(diff, mindiff);
			idx++;
		}

		return mindiff;
	}

}
