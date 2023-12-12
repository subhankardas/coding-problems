package leetcode.leetcode_75;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: There are n kids with candies. You are given an integer array
 * candies, where each candies[i] represents the number of candies the ith kid
 * has, and an integer extraCandies, denoting the number of extra candies that
 * you have.
 * 
 * Return a boolean array result of length n, where result[i] is true if, after
 * giving the ith kid all the extraCandies, they will have the greatest number
 * of candies among all the kids, or false otherwise.
 * 
 * Note that multiple kids can have the greatest number of candies.
 * 
 * Level: EASY
 * Runtime: 1 ms Beats 94.93% of users with Java.
 * Memory: 42.16 MB Beats 5.28% of users with Java.
 * 
 * @author Subhankar Das
 */
public class LT_1431_KidsWithGreatestNumberCandies {

    public static void main(String[] args) {
        int[] candies = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = maxCandies > candy ? maxCandies : candy;
        }

        List<Boolean> result = new ArrayList<>(candies.length);
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }
        return result;
    }

}
