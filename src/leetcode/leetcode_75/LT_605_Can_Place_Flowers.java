package leetcode.leetcode_75;

/**
 * Problem: You have a long flowerbed in which some of the plots are planted,
 * and some are not. However, flowers cannot be planted in adjacent plots.
 * 
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
 * and 1 means not empty, and an integer n, return true if n new flowers can be
 * planted in the flowerbed without violating the no-adjacent-flowers rule and
 * false otherwise.
 * 
 * Level: EASY (Greedy Algorithm)
 * Runtime: 2 ms Beats 10.45% of users with Java
 * Memory: 45.76 MB Beats 5.18% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_605_Can_Place_Flowers {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
        System.out.println(canPlaceFlowers(new int[] { 0, 0, 1, 0, 1 }, 1));
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1, 0, 0 }, 2));
        System.out.println(canPlaceFlowers(new int[] { 0, 1, 0 }, 1));
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0 }, 1));
        System.out.println(canPlaceFlowers(new int[] { 0, 0, 0, 0, 1 }, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) // Case 1: No flowers can be placed
            return true;

        else if (flowerbed.length == 1) { // Case 2: Only one flowerbed
            if (flowerbed[0] == 0 && n == 1)
                return true;
            else if (flowerbed[0] == 1 && n == 0)
                return true;
            return false;
        } else if (flowerbed.length == 2) { // Case 3: Two flowerbeds
            if (flowerbed[0] == 0 && flowerbed[1] == 0 && n == 1)
                return true;
            return false;
        }

        // Greedy algorithm for checking places without adjacent flowers planted
        for (int idx = 0; idx < flowerbed.length - 1; idx++) {
            if (idx == 0 && flowerbed[idx] == 0 && flowerbed[idx + 1] == 0) { // Case 4: First flowerbed
                flowerbed[idx] = 1; // Plant flower here
                n--;
            } else if (idx == flowerbed.length - 2 && flowerbed[idx] == 0 && flowerbed[idx + 1] == 0) {
                // Case 5: Last flowerbed, planting can be done
                flowerbed[idx + 1] = 1;
                n--;
            } else if (idx > 0 && flowerbed[idx - 1] == 0 && flowerbed[idx] == 0 && flowerbed[idx + 1] == 0) {
                // Case 6: Middle flowerbed, planting can be done
                flowerbed[idx] = 1;
                n--;
            }

            if (n == 0) // No more flowers can be placed
                return true;
        }

        return false;
    }

}
