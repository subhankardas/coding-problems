package leetcode.leetcode_75;

/**
 * Problem: You are given an integer array 'nums' consisting of n elements, and
 * an integer k.
 * 
 * Find a contiguous sub-array whose length is equal to k that has the maximum
 * average value and return this value. Any answer with a calculation error less
 * than 10^-5 will be accepted.
 * 
 * Level: EASY (Sliding Window)
 * Runtime: 2 ms Beats 100.00% of users with Java
 * Memory: 55.70 MB Beats 19.95% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_643_Maximum_Average_SubArray_I {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));
        System.out.println(findMaxAverage(new int[] { 7, 4, 5, 8, 8, 3, 9, 8, 7, 6 }, 7));
        System.out.println(findMaxAverage(new int[] { 0, 4, 0, 3, 2 }, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        // 1. Calculate initial sum of window of size k from left i.e. 0 index
        int sum = 0;
        for (int idx = 0; idx < k; idx++) {
            sum += nums[idx];
        }

        // 2. Slide window from left to right, calculate window sum and max sum
        int window = sum;
        for (int idx = 1; idx + k - 1 < nums.length; idx++) {
            window = window - nums[idx - 1] + nums[idx + k - 1]; // Remove element removed from window and add from end
            sum = sum > window ? sum : window;
        }

        return ((double) sum / (double) k); // 3. Return max average
    }

}
