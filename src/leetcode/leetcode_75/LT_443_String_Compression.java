package leetcode.leetcode_75;

/**
 * Problem: Given an array of characters chars, compress it using the following
 * algorithm:
 * 
 * Begin with an empty string s. For each group of consecutive repeating
 * characters in chars:
 * 
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be
 * stored in the input character array chars. Note that group lengths that are
 * 10 or longer will be split into multiple characters in chars.
 * 
 * After you are done modifying the input array, return the new length of the
 * array.
 * 
 * You must write an algorithm that uses only constant extra space.
 * 
 * Level: MEDIUM (String Manipulation)
 * Runtime: 1 ms Beats 99.49% of users with Java
 * Memory: 43.68 MB Beats 48.24% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_443_String_Compression {

    public static void main(String[] args) {
        System.out.println(compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
        System.out.println(compress(new char[] { 'a' }));
        System.out.println(compress(new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' }));
    }

    public static int compress(char[] chars) {
        // Handle base cases of empty array and single character array
        if (chars.length == 0 || chars.length == 1) {
            return chars.length;
        }

        int resIdx = 0;
        int count = 0;
        char last = chars[0];

        for (int idx = 0; idx < chars.length; idx++) {
            // If current character is different from last character
            if (chars[idx] != last) {
                chars[resIdx++] = last; // Update result, set last character
                if (count > 1) { // Update result, set count if greater than 1
                    for (char ch : String.valueOf(count).toCharArray()) {
                        chars[resIdx++] = ch;
                    }
                }
                count = 0;
            }

            // Same character, increment count
            last = chars[idx];
            count++;
        }

        // Handle last character after scanning is complete
        chars[resIdx++] = last;
        if (count > 1) {
            for (char ch : String.valueOf(count).toCharArray()) {
                chars[resIdx++] = ch;
            }
        }

        // Return new length of result
        return resIdx;
    }

}
