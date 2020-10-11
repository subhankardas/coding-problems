package hackerrank.string_manipulation;

import java.util.HashMap;
import java.util.Map;

public class SherlockValidString {

	public static void main(String[] args) {

		String s = "aabbccddd";
		System.out.println(isValid(s));

	}

	static String isValid(String s) {
		// Count the frequency of all the letters in string
		Map<Character, Integer> freq = new HashMap<>();
		for (int idx = 0; idx < s.length(); idx++) {
			char curr = s.charAt(idx);
			if (freq.containsKey(curr))
				freq.put(curr, freq.get(curr) + 1);
			else
				freq.put(curr, 1);
		}

		// Count the no. of frequencies
		Map<Integer, Integer> freqCount = new HashMap<>();
		for (int frq : freq.values()) {
			if (freqCount.containsKey(frq))
				freqCount.put(frq, freqCount.get(frq) + 1);
			else
				freqCount.put(frq, 1);
		}

		// Many frequencies exist i.e INVALID
		if (freqCount.size() > 2) {
			return "NO";
		}
		// Only one frequency exist, all letters has same count i.e VALID
		else if (freqCount.size() == 1) {
			return "YES";
		}
		// Two frequency exists, we can remove one letter and create a VALID string
		else {
			int idx = 0;
			int[] keys = new int[2];
			for (Integer key : freqCount.keySet()) {
				keys[idx] = key;
				idx++;
			}

			// [ X -> COUNT, Y -> 1 ] and [ Y - 1 = X or Y - 1 = 0 ]
			if ((freqCount.get(keys[1]) == 1 && (keys[1] - 1 == keys[0] || keys[1] - 1 == 0))
					|| (freqCount.get(keys[0]) == 1 && (keys[1] - 1 == keys[0] || keys[0] - 1 == 0))) {
				return "YES";
			}
		}

		return "NO";
	}

}
