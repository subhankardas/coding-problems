package leetcode.leetcode_75;

import java.util.List;

/**
 * Problem: There are n rooms labeled from 0 to n - 1 and all the rooms are
 * locked except for room 0. Your goal is to visit all the rooms. However, you
 * cannot enter a locked room without having its key.
 * 
 * When you visit a room, you may find a set of distinct keys in it. Each key
 * has a number on it, denoting which room it unlocks, and you can take all of
 * them with you to unlock the other rooms.
 * 
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if
 * you visited room i, return true if you can visit all the rooms, or false
 * otherwise.
 * 
 * Level: MEDIUM
 * Runtime: 0 ms Beats 100.00%
 * Memory: 43.62 MB Beats 96.35%
 * 
 * @author Subhankar Das
 */
public class LT_841_Keys_And_Rooms {

    public static void main(String[] args) {
        // rooms = [[1],[2],[3],[]]
        List<List<Integer>> input1 = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of());

        System.out.println(canVisitAllRooms(input1));

        // rooms = [[1,3],[3,0,1],[2],[0]]
        List<List<Integer>> input2 = List.of(
                List.of(1, 3),
                List.of(3, 0, 1),
                List.of(2),
                List.of(0));

        System.out.println(canVisitAllRooms(input2));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(rooms, 0, visited); // start DFS from 0th room as current room

        for (boolean b : visited) {
            if (!b) { // if any room is not visited
                return false;
            }
        }
        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int curRoom, boolean[] visited) {
        visited[curRoom] = true; // mark current room as visited

        for (int nextRoom : rooms.get(curRoom)) {
            if (visited[nextRoom]) { // if next room is already visited
                continue;
            }
            if (nextRoom == curRoom) { // if next room is current room
                continue;
            }
            dfs(rooms, nextRoom, visited); // visit next rooms from current room
        }
    }

}
