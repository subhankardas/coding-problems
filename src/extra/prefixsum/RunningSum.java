package extra.prefixsum;

import java.util.Arrays;

/**
 * Given an array nums. We define a running sum of an array as runningSum[i] =
 * sum(nums[0] ... nums[i]).
 * Return the running sum of nums.
 * 
 * Input: nums = [1,2,3,4]
 * Output: [1,3,6,10]
 * Explanation: Running sum is obtained as follows: [1, 1 + 2, 1 + 2 + 3, 1 + 2
 * + 3 + 4]
 */
public class RunningSum {

    public static void main(String[] args) {
        System.err.println(Arrays.toString(runningSum(new int[] { 1 })));
        System.err.println(Arrays.toString(runningSum(new int[] { 1, 2, 3, 4 })));
    }

    public static int[] runningSum(int[] nums) {
        // Stores prefix sums i.e prefixSum[i] = sum(nums[0] ... nums[i])
        int[] prefixSum = new int[nums.length];

        // Calculate prefix sums
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        return prefixSum;
    }

}
