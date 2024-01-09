package leetcode.leetcode_75;

/**
 * Problem: Given an integer array nums, return true if there exists a triple of
 * indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no
 * such indices exists, return false.
 * 
 * Level: MEDIUM (Greedy Algorithm)
 * Runtime: 2 ms Beats 91.16% of users with Java
 * Memory: 133.68 MB Beats 27.93% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_334_Increasing_Triplet_Subsequence {

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }));
    }

    public static boolean increasingTriplet(int[] nums) {
        int low = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= low) { // Got lowest value till now, update low
                low = num;
            } else if (num <= mid) { // Got second lowest value till now, update mid
                mid = num;
            } else {
                return true; // Got value greater than low and mid, return true
            }
        }
        return false;
    }

}
