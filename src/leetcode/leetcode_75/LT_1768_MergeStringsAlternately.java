package leetcode.leetcode_75;

/**
 * Problem : You are given two strings word1 and word2. Merge the strings by
 * adding letters in alternating order, starting with word1. If a string is
 * longer than the other, append the additional letters onto the end of the
 * merged string. Return the merged string.
 * 
 * Level : EASY
 * Runtime: 0 ms Beats 100.00% of users with Java.
 * Memory : 40.58 MB Beats 78.67% of users with Java.
 * 
 * @author Subhankar Das
 */
class LT_1768_MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd", "pq")); // Output: apbqcd
    }

    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int minLen = Math.min(len1, len2);
        char[] res = new char[len1 + len2];

        for (int i = 0; i < minLen; i++) { // Join the two words until min. length
            res[2 * i] = word1.charAt(i);
            res[2 * i + 1] = word2.charAt(i); // Put alternative chars in sequence
        }
        if (len1 == minLen && len1 != len2) { // Add remaining chars of word2
            for (int i = 0; i < len2 - minLen; i++) {
                res[2 * minLen + i] = word2.charAt(minLen + i);
            }
        } else {
            for (int i = 0; i < len1 - minLen; i++) { // Else add remaining chars of word1
                res[2 * minLen + i] = word1.charAt(minLen + i);
            }
        }
        return new String(res);
    }

}