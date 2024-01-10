package leetcode.leetcode_75;

/**
 * Problem: Given two strings s and t, return true if s is a subsequence of t,
 * or false otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * Level: EASY (Two Pointers)
 * Runtime: 0 ms Beats 100.00% of users with Java
 * Memory: 41.28 MB Beats 33.18% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_392_Is_Subsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        char[] st = s.toCharArray();
        char[] tt = t.toCharArray();
        int sLen = st.length, tLen = tt.length;

        int sP = 0, tp = 0;
        while (sP < sLen && tp < tLen) { // Traverse both strings
            if (st[sP] == tt[tp]) { // Found match at current positions
                sP++;
            }
            tp++;
        }

        return sP == sLen; // All characters in s are found in t
    }

}
