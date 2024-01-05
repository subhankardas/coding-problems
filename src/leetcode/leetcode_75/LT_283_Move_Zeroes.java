package leetcode.leetcode_75;

import java.util.Arrays;

/**
 * Problem: Given an integer array, move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * Level: EASY (Two Pointers)
 * Runtime: 3 ms Beats 24.88% of users with Java
 * Memory: 46.27 MB Beats 8.55% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_283_Move_Zeroes {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };

        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int zPos = 0, nzPos = 0;
        while (nzPos >= zPos && nzPos < nums.length) {
            if (nums[nzPos] == 0) { // Found 0, move to next position, keep zero position fixed
                nzPos++;
            } else { // Found non-zero, swap with zero position, move both positions forward
                int temp = nums[zPos];
                nums[zPos] = nums[nzPos];
                nums[nzPos] = temp;
                zPos++;
                nzPos++;
            }
        }
    }

}
