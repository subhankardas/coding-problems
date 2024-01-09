package leetcode.leetcode_75;

import java.util.Arrays;

/**
 * Problem: Given an integer array nums, return an array answer such that
 * answer[i] is equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * Level: MEDIUM (Prefix and Suffix)
 * Runtime: 2 ms Beats 69.65% of users with Java
 * Memory: 52.40 MB Beats 74.02% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_238_Product_Of_Array_Except_Self {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];

        // Store the products of left elements for each index
        leftProducts[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        // Store the products of right elements for each index
        rightProducts[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }

        // Result array is the product of left and right products
        for (int i = 0; i < nums.length; i++) {
            nums[i] = leftProducts[i] * rightProducts[i];
        }

        return nums;
    }

}
