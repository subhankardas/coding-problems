package leetcode.leetcode_75;

import java.util.Stack;

/**
 * You are given a string s, which contains stars *.
 * 
 * In one operation, you can:
 * 
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star
 * itself.
 * Return the string after all stars have been removed.
 * 
 * Note:
 * 
 * The input will be generated such that the operation is always possible.
 * It can be shown that the resulting string will always be unique.
 * 
 * LEVEL: Medium
 * RUNTIME: 15 ms Beats 97.00% of users with Java
 * MEMORY: 45.39 MB Beats 86.76% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_2390_Removing_Stars_From_String {

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));

        System.out.println(removeStarsUsingStack("leet**cod*e"));
        System.out.println(removeStarsUsingStack("erase*****"));
    }

    public static String removeStars(String s) {
        StringBuilder res = new StringBuilder();
        int startCount = 0;
        for (int idx = s.length() - 1; idx >= 0; idx--) {
            if (s.charAt(idx) == '*') { // found star
                startCount++; // increment star count and skip
                continue;
            } else if (startCount > 0) { // found char left to star
                startCount--;// decrement star count and skip
                continue;
            } else {
                res.append(s.charAt(idx)); // add char to result
            }
        }
        return res.reverse().toString();
    }

    public static String removeStarsUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == '*') { // found star
                if (!stack.isEmpty()) {
                    stack.pop(); // remove previous char
                }
            } else {
                stack.push(s.charAt(idx)); // add char to stack
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop()); // add char to result from stack
        }
        return res.toString();
    }

}
