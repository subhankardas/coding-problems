package leetcode.leetcode_75;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Problem: You have a RecentCounter class which counts the number of recent
 * requests within a certain time frame.
 * 
 * Implement the RecentCounter class:
 * 
 * RecentCounter() Initializes the counter with zero recent requests.
 * int ping(int t) Adds a new request at time t, where t represents some time in
 * milliseconds, and returns the number of requests that has happened in the
 * past 3000 milliseconds (including the new request). Specifically, return the
 * number of requests that have happened in the inclusive range [t - 3000, t].
 * It is guaranteed that every call to ping uses a strictly larger value of t
 * than the previous call.
 * 
 * LEVEL: Easy
 * RUNTIME: 20 ms Beats 91.26% of users with Java
 * MEMORY: 55.28 MB Beats 18.38% of users with Java
 * 
 * @author Subhankar Das
 */
public class LT_933_Number_Recent_Calls {

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.print(obj.ping(1) + " ");
        System.out.print(obj.ping(100) + " ");
        System.out.print(obj.ping(3001) + " ");
        System.out.print(obj.ping(3002) + " ");
    }
}

class RecentCounter {

    private Queue<Integer> q;

    public RecentCounter() {
        q = new ArrayDeque<>();
    }

    public int ping(int t) {
        q.offer(t); // add current req. time to queue

        while (!q.isEmpty() && q.peek() < t - 3000) { // while queue has req. time < range
            q.poll(); // remove from head
        }

        return q.size(); // no. of req. time in range
    }

}
