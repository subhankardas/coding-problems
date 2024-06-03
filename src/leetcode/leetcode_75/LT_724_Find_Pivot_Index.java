package leetcode.leetcode_75;

/**
 * Problem: Given an array of integers nums, calculate the pivot index of this
 * array.
 * 
 * The pivot index is the index where the sum of all the numbers strictly to the
 * left of the index is equal to the sum of all the numbers strictly to the
 * index's right.
 * 
 * If the index is on the left edge of the array, then the left sum is 0 because
 * there are no elements to the left. This also applies to the right edge of the
 * array.
 * 
 * Return the leftmost pivot index. If no such index exists, return -1.
 * 
 * LEVEL: Easy
 * RUNTIME: 1 ms Beats 95.13% of users with Java
 * MEMORY: 45.68 MB Beats 24.37% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_724_Find_Pivot_Index {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
        System.out.println(pivotIndex(new int[] { 1, 2, 3 }));
        System.out.println(pivotIndex(new int[] { 2, 1, -1 }));
    }

    public static int pivotIndex(int[] nums) {
        int[] sumLeft = new int[nums.length]; // sum of all nos. in left + nums[i]
        int[] sumRight = new int[nums.length]; // sum of all nos. in right + nums[i]

        // calculate prefix sums for left
        sumLeft[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumLeft[i] = sumLeft[i - 1] + nums[i];
        }

        // calculate prefix sums for right
        sumRight[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sumRight[i] = sumRight[i + 1] + nums[i];
        }

        // check if sumLeft[i] == sumRight[i] i.e. pivot index
        for (int i = 0; i < nums.length; i++) {
            if (sumLeft[i] == sumRight[i])
                return i;
        }
        return -1;
    }

}
