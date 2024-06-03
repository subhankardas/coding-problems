package leetcode.leetcode_75;

/**
 * Problem: There is a biker going on a road trip. The road trip consists of n +
 * 1 points at different altitudes. The biker starts his trip on point 0 with
 * altitude equal 0.
 * 
 * You are given an integer array gain of length n where gain[i] is the net gain
 * in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the
 * highest altitude of a point.
 * 
 * LEVEL: Easy
 * RUNTIME: 0 ms Beats 100.00% of users with Java
 * MEMORY: 41.26 MB Beats 34.95% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_1732_Find_Highest_Altitude {

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[] { -5, 1, 5, 0, -7 }));
        System.out.println(largestAltitude(new int[] { -4, -3, -2, -1, 4, 3, 2 }));
    }

    public static int largestAltitude(int[] gain) {
        int max = 0; // max altitude
        int sum = 0; // current altitude
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i]; // update altitude
            max = Math.max(max, sum); // update max altitude
        }
        return max;
    }

}
