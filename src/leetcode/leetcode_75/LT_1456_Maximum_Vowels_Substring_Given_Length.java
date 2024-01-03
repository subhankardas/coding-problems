package leetcode.leetcode_75;

/**
 * Problem: Given a string s and an integer k, return the maximum number of
 * vowel letters in any substring of s with length k.
 * 
 * Level: EASY (Sliding Window)
 * Runtime: 13 ms Beats 65.98% of users with Java
 * Memory: 44.28 MB Beats 37.73% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_1456_Maximum_Vowels_Substring_Given_Length {

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
        System.out.println(maxVowels("leetcode", 3));
    }

    public static int maxVowels(String s, int k) {
        // 1. Load initial window vowels count
        int count = 0;
        for (int idx = 0; idx < k; idx++) {
            if (isVowel(s.charAt(idx))) {
                count++;
            }
        }

        // 2. Slide window to right, update count based on added and removed vowels
        int window = count;
        for (int idx = 1; idx + k - 1 < s.length(); idx++) {
            if (isVowel(s.charAt(idx - 1))) {
                window--;
            }
            if (isVowel(s.charAt(idx + k - 1))) {
                window++;
            }
            count = count > window ? count : window;
        }

        return count;
    }

    // Helper function to check if character is vowel or not.
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
