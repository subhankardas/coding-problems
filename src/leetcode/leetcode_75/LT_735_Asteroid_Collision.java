package leetcode.leetcode_75;

import java.util.Arrays;
import java.util.Stack;

/**
 * Problem: We are given an array asteroids of integers representing asteroids
 * in a row.
 * 
 * For each asteroid, the absolute value represents its size, and the sign
 * represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * 
 * Find out the state of the asteroids after all collisions. If two asteroids
 * meet, the smaller one will explode. If both are the same size, both will
 * explode. Two asteroids moving in the same direction will never meet.
 * 
 * LEVEL: Medium
 * RUNTIME: 5 ms Beats 83.93% of users with Java
 * MEMORY: 45.08 MB Beats 76.94% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_735_Asteroid_Collision {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[] { 5, 10, -5 })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] { 8, -8 })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] { 10, 2, -5 })));
        System.out.println(Arrays.toString(asteroidCollision(new int[] { -2, -1, 1, 2 })));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> alive = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                alive.push(asteroids[i]); // moving right, add to alive
            } else {
                while (!alive.isEmpty() && alive.peek() > 0 && alive.peek() < -asteroids[i]) {
                    alive.pop(); // moving left and collide, remove last alive
                }

                if (!alive.isEmpty() && alive.peek() > 0) {
                    if (alive.peek() == -asteroids[i]) { // last alive is same size
                        alive.pop();
                    }
                } else if (alive.isEmpty() || alive.peek() < 0) {
                    alive.push(asteroids[i]); // no more alive, last one
                }
            }
        }

        int[] res = new int[alive.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = alive.pop();
        }
        return res;
    }

}
