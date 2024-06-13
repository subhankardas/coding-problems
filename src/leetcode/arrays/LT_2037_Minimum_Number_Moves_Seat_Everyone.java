package leetcode.arrays;

import java.util.Arrays;

/**
 * Problem: There are n seats and n students in a room. You are given an array
 * seats of length n, where seats[i] is the position of the ith seat. You are
 * also given the array students of length n, where students[j] is the position
 * of the jth student.
 * 
 * You may perform the following move any number of times:
 * 
 * Increase or decrease the position of the ith student by 1 (i.e., moving the
 * ith student from position x to x + 1 or x - 1)
 * Return the minimum number of moves required to move each student to a seat
 * such that no two students are in the same seat.
 * 
 * Note that there may be multiple seats or students in the same position at the
 * beginning.
 * 
 * LEVEL: Easy
 * RUNTIME: 2 ms Beats 97.35% of users with Java
 * MEMORY: 43.76 MB Beats 90.27% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_2037_Minimum_Number_Moves_Seat_Everyone {

    public static void main(String[] args) {
        System.out.println(minMovesToSeat(new int[] { 3, 1, 5 }, new int[] { 2, 7, 4 }));
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats); // Sort seats in order of positions
        Arrays.sort(students); // Sort students in order of positions

        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]); // Calculate dist b/w seats and nearest student i.e no.of moves
        }
        return res;
    }

}
