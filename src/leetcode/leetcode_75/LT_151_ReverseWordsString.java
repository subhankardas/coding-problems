package leetcode.leetcode_75;

/**
 * Problem : Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the
 * words. Do not include any extra spaces.
 * 
 * Level: MEDIUM (Two-pointer approach)
 * Runtime: 7 ms Beats 74.65% of users with Java
 * Memory: 42.36 MB Beats 73.32% of users with Java
 */
public class LT_151_ReverseWordsString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("  hello world  "));
    }

    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int len = s.length();

        int start = 0, end = 0; // Index for start and end of each word
        boolean word = false; // True if scanning word, else false

        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && !word) { // Mark end of word, set flag as true
                end = i;
                word = true;
            } else if (s.charAt(i) == ' ' && word) { // Found start of word, set flag as false
                start = i + 1;
                word = false;
                res.append(s.substring(start, end + 1)).append(' '); // Append word to result
            }

            if (i == 0 && word) { // Reach end of string, append word to result i.e. last word
                res.append(s.substring(0, end + 1));
            }
        }

        return res.toString().trim();
    }

}
