package leetcode.leetcode_75;

/**
 * Problem: Given a string s, reverse only all the vowels in the string and
 * return it.
 * 
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower
 * and upper cases, more than once.
 * 
 * Level: Easy (Two Pointers)
 * Runtime: 2 ms Beats 99.32% of users with Java
 * Memory: 44.62 MB Beats 41.14% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_345_Reverse_Vowels_String {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello").equals("holle"));
    }

    public static String reverseVowels(String str) {
        char[] s = str.toCharArray();
        int p1 = 0, p2 = s.length - 1;

        while (p1 < p2) { // Scan string from both the ends
            if (!isVowel(s[p1])) { // If p1 is not a vowel move forward
                p1++;
                continue;
            }
            if (!isVowel(s[p2])) { // If p2 is not a vowel move backward
                p2--;
                continue;
            }

            // Found both vowels swap them, move both pointers
            char temp = s[p1];
            s[p1] = s[p2];
            s[p2] = temp;
            p1++;
            p2--;
        }

        return new String(s);
    }

    // Helper function to check if character is vowel or not.
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U';
    }

}