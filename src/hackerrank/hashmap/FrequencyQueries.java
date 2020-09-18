package hackerrank.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FrequencyQueries {

	public static void main(String[] args) {
		List<List<Integer>> queries = new ArrayList<List<Integer>>();

		queries.add(Arrays.asList(1, 3));
		queries.add(Arrays.asList(2, 3));
		queries.add(Arrays.asList(3, 2));
		queries.add(Arrays.asList(1, 4));
		queries.add(Arrays.asList(1, 5));
		queries.add(Arrays.asList(1, 5));
		queries.add(Arrays.asList(1, 4));
		queries.add(Arrays.asList(3, 2));
		queries.add(Arrays.asList(2, 4));
		queries.add(Arrays.asList(3, 2));

		System.out.println(freqQuery(queries));
	}

	public static List<Integer> freqQuery(List<List<Integer>> queries) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		Map<Integer, Integer> freqCountMap = new HashMap<>();

		List<Integer> result = new ArrayList<>();

		for (List<Integer> query : queries) {
			int opcode = query.get(0);
			int value = query.get(1);

			int freq;
			int countPrev;
			int countNext;

			if (opcode == 1) {
				freq = Optional.ofNullable(freqMap.get(value)).isPresent() ? freqMap.get(value) : 0;
				countPrev = Optional.ofNullable(freqCountMap.get(freq)).isPresent() ? freqCountMap.get(freq) : 0;
				countNext = Optional.ofNullable(freqCountMap.get(freq + 1)).isPresent() ? freqCountMap.get(freq + 1)
						: 0;

				// Increment freq. and freq. count by 1 and decrement prev. freq. by 1
				freqCountMap.put(freq, countPrev - 1);
				freqMap.put(value, freq + 1);
				freqCountMap.put(freq + 1, countNext + 1);
			} else if (opcode == 2) {
				freq = Optional.ofNullable(freqMap.get(value)).isPresent() ? freqMap.get(value) : 0;
				countPrev = Optional.ofNullable(freqCountMap.get(freq)).isPresent() ? freqCountMap.get(freq) : 0;
				countNext = Optional.ofNullable(freqCountMap.get(freq - 1)).isPresent() ? freqCountMap.get(freq - 1)
						: 0;

				// If value exists in array, decrement freq. and prev. freq. count by 1 and
				// increment next freq. by 1
				if (freq > 0) {
					freqCountMap.put(freq, countPrev - 1);
					freqMap.put(value, freq - 1);
					freqCountMap.put(freq - 1, countNext + 1);
				}
			} else if (opcode == 3) {
				// If freq. count is present and greater than 0, add 1 to result else add 0
				freq = Optional.ofNullable(freqCountMap.get(value)).isPresent() && freqCountMap.get(value) > 0 ? 1 : 0;
				result.add(freq);
			}
		}

		return result;
	}

}
