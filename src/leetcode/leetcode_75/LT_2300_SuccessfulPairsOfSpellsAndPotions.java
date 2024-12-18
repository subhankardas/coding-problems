package leetcode.leetcode_75;

import java.util.Arrays;

public class LT_2300_SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs(new int[] { 5, 1, 3 }, new int[] { 1, 2, 3, 4, 5 }, 7)));
        System.out.println(Arrays.toString(successfulPairs(new int[] { 3, 1, 2 }, new int[] { 8, 5, 8, }, 16)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];

        // Sort the portions, to find the first index for which the
        // product is >= success, rest all will be greater
        potions = Arrays.stream(potions).sorted().toArray();

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i]; // Spell i.e. first element of pair
            int idx = findTargetIdx(potions, spell, success); // Find index where product >= success

            res[i] = idx == -1 ? 0 : potions.length - idx; // Add pair counts if index found
        }

        return res;
    }

    /**
     * Helper function to find the first index in a sorted array for which
     * the product (target * element) is >= success.
     */
    public static int findTargetIdx(int[] nums, int target, long success) {
        int start = 0, end = nums.length - 1;
        int foundIdx = -1;

        // Binary search
        while (start <= end) {
            int mid = end + (start - end) / 2;
            long prod = nums[mid] * (long) target;

            if (prod >= success) { // Search in left side
                foundIdx = mid;
                end = mid - 1;
            } else { // Search in right side
                start = mid + 1;
            }
        }

        return foundIdx;
    }

}
