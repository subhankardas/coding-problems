package leetcode.string;

/**
 * Problem: Print all the palindrome subsequences of a string.
 * 
 * Solution: To find all the subsequences for a string, we need to generate list
 * of all possible strings using all combinations of indices and there
 * characters in that sequence. We can use a bitmask for generating all possible
 * sequences of indices to select characters for subsequence.
 * 
 * STRING : ABC 
 * BITMASK: 000 -> No characters selected in subsequence 
 *          001 -> C
 *          010 -> B 
 *          110 -> AB 
 *          111 -> ABC 
 * Hence we loop from 1 to 2^length - 1 i.e. 001 -> 111
 * Now for a generate bitmask we need to find if the character at current index should
 * be accepted or not for the subsequence. Hence we create a shift mask i.e. lets say
 * 
 * BITMASK: 110
 * 
 * SHIFT 0: 001   BITMASK & SHIFT = 0
 * SHIFT 1: 010   BITMASK & SHIFT = SHIFT / ACCEPT
 * SHIFT 1: 100   BITMASK & SHIFT = SHIFT / ACCEPT
 * 
 * Now if BITMASK & SHIFT == SHIFT  -> ACCEPT this index character. Now just simply
 * append characters at end for sequence and at front for the reverse subsequence.    
 */
public class PallindromeSubsequences {

	public static void main(String[] args) {
		printSubsequence("leetcodecom");
	}

	public static void printSubsequence(String str) {
		int len = str.length();

		// Loop to generate all possible bitmask for string of length
		for (int bitmask = 1; bitmask <= (1 << len) - 1; bitmask++) {
			String subseq = "", subseqrev = "";
			
			// Loop through the string for all indices
			for (int idx = 0; idx < len; idx++) {
				int shift = 1 << idx;  // Generate shift mask by shifting 1 to char index
				
				// Test if the character index matches the bitmask index as 1, then accept
				if ((bitmask & shift) == shift) {
					subseq += str.charAt(idx);
					subseqrev = str.charAt(idx) + subseqrev;
				}
			}
			
			// Compare the subsequence and reverse subsequence
			if (subseq.equals(subseqrev)) {
				System.out.println(subseq);
			}
		}
	}

}
