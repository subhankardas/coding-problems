package hackerrank.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

	public static void main(String[] args) {
		String str = "ifailuhkqq";
		System.out.println(sherlockAndAnagrams(str));
	}

	static int sherlockAndAnagrams(String str) {
		Map<String, Integer> freq = new HashMap<>();
		int result = 0;

		// Store the frequency of all the sorted substrings
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				char[] chrs = str.substring(i, j).toCharArray();
				Arrays.sort(chrs);
				String st = new String(chrs);

				if (freq.containsKey(st)) {
					int f = freq.get(st);
					freq.put(st, f + 1);
				} else {
					freq.put(st, 1);
				}
			}
		}

		// Calculate possible combinations based on the frequency and divide by 2
		for (String st : freq.keySet()) {
			int f = freq.get(st);
			result += (f * (f - 1)) / 2;
		}

		return result;
	}

}
