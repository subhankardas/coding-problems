package hackerrank.string_manipulation;

/**
 * Strings: Making Anagrams - Given two strings, and , that may or may not be of
 * the same length, determine the minimum number of character deletions required
 * to make and anagrams. Any characters can be deleted from either of the
 * strings.
 */
public class MakingAnagrams {

	public static void main(String[] args) {

		System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));

	}

	public static int makeAnagram(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		int count = 0;

		int[] achars = new int[26];
		int[] bchars = new int[26];

		for (int idx = 0; idx < len1; idx++) {
			int chridx = a.charAt(idx) - 'a';
			achars[chridx]++;
		}

		for (int idx = 0; idx < len2; idx++) {
			int chridx = b.charAt(idx) - 'a';
			bchars[chridx]++;
		}

		for (int idx = 0; idx < 26; idx++) {
			count += Math.abs(achars[idx] - bchars[idx]);
		}

		return count;
	}

}
