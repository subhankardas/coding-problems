package leetcode.leetcode_75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: Given an array of integers arr, return true if the number of
 * occurrences of each value in the array is unique or false otherwise.
 * Example 1:
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * 
 * Example 2:
 * Input: arr = [1,2]
 * Output: false
 * 
 * LEVEL: Easy
 * RUNTIME: 2 ms Beats 95.63% of users with Java
 * MEMORY: 41.62 MB Beats 62.38% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_1207_Unique_Number_Occurrences {

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
        System.out.println(uniqueOccurrences(new int[] { 1, 2 }));
        System.out.println(uniqueOccurrences(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 }));

        System.out.println(uniqueOccurrencesMemEff(new int[] { 1, 2, 2, 1, 1, 3 }));
        System.out.println(uniqueOccurrencesMemEff(new int[] { 1, 2 }));
        System.out.println(uniqueOccurrencesMemEff(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 }));

    }

    // Time Efficient Solution
    public static boolean uniqueOccurrences(int[] arr) {
        int[] freq = new int[2001];
        for (int num : arr) {
            freq[num + 1000]++; // set freq for num
        }

        boolean freqUsed[] = new boolean[1001];
        for (int num : arr) {
            int fr = freq[num + 1000]; // get freq for num
            freq[num + 1000] = 0; // remove this freq for num

            if (fr == 0) { // no freq for num, skip
                continue;
            }

            if (freqUsed[fr]) { // freq used, return false
                return false;
            }

            freqUsed[fr] = true; // set freq used
        }

        return true;
    }

    // Memory Efficient Solution
    public static boolean uniqueOccurrencesMemEff(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Set<Integer> freqUsed = new HashSet<>();
        for (int num : freq.values()) {
            if (!freqUsed.add(num)) {
                return false;
            }
        }
        return true;
    }
}
