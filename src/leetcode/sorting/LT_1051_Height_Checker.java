package leetcode.sorting;
import java.util.Arrays;

/**
 * Problem: A school is trying to take an annual photo of all the students. The
 * students are asked to stand in a single file line in non-decreasing order by
 * height. Let this ordering be represented by the integer array expected where
 * expected[i] is the expected height of the ith student in line.
 * 
 * You are given an integer array heights representing the current order that
 * the students are standing in. Each heights[i] is the height of the ith
 * student in line (0-indexed).
 * 
 * Return the number of indices where heights[i] != expected[i].
 * 
 * LEVEL: Easy
 * RUNTIME: 2 ms Beats 88.93% of users with Java
 * MEMORY: 40.94 MB Beats 90.77% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_1051_Height_Checker {

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[] { 1, 1, 4, 2, 1, 3 }));
        System.out.println(heightChecker(new int[] { 5, 1, 2, 3, 4 }));
        System.out.println(heightChecker(new int[] { 1, 2, 3, 4, 5 }));
    }

    public static int heightChecker(int[] heights) {
        int res = 0;

        // Get copy of sorted heights
        int[] sorted = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sorted);

        // Compare heights with sorted heights
        for (int i = 0; i < heights.length; i++) {
            if (sorted[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }

    /**
     * COUNTING SORT IMPLEMENTATION:
     * Counting Sort is a non-comparison-based sorting algorithm that works well
     * when there is limited range of input values. It is particularly efficient
     * when the range of input values is small compared to the number of elements to
     * be sorted. The basic idea behind Counting Sort is to count the frequency of
     * each distinct element in the input array and use that information to place
     * the elements in their correct sorted positions.
     * 
     * TIME COMPLEXITY:
     * Worst-case: O(N+M).
     * Average-case: O(N+M).
     * Best-case: O(N+M).
     * 
     * SPACE COMPLEXITY: O(N+M).
     */
    public static void countingSort(int[] heights) {
        int max = Integer.MIN_VALUE;
        for (int h : heights) {
            max = Math.max(max, h); // Get max height
        }

        int[] count = new int[max + 1];
        for (int h : heights) {
            count[h]++; // Count frequency of each height
        }

        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) { // Put each height in correct position
                heights[idx++] = i;
                count[i]--;
            }
        }
    }

}
