package hackerrank.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

	public static void main(String[] args) {
		List<Long> arr = Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l);
		long r = 3;

		System.out.println(countTriplets(arr, r));
	}

	static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> freq = new HashMap<>();
		Map<Long, Long> freqL = new HashMap<>();
		Long result = 0l;

		// Generate frequency map
		for (Long num : arr) {
			if (freq.containsKey(num))
				freq.put(num, freq.get(num) + 1);
			else
				freq.put(num, 1l);

			freqL.put(num, 0l);
		}

		/**
		 * Calculate possible combinations for each element 
		 * No. of combinations = (Freq. of num / r) x (Freq. of num x r)
		 */
		for (Long num : arr) {
			freq.put(num, freq.get(num) - 1);

			if (num % r == 0 && freqL.containsKey(num / r) && freq.containsKey(num * r)) {
				result += freqL.get(num / r) * freq.get(num * r);
			}

			freqL.put(num, freqL.get(num) + 1);
		}

		return result;
	}

}
