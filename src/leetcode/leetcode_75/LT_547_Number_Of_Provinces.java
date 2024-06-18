package leetcode.leetcode_75;

/**
 * Problem: There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly
 * with city c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * 
 * Return the total number of provinces.
 * Runtime: 1 ms Beats 91.71%
 * Memory: 48.22 MB Beats 51.86%
 * 
 * @author Subhankar Das
 */
public class LT_547_Number_Of_Provinces {

    public static void main(String[] args) {
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;

        for (int curCity = 0; curCity < cities; curCity++) {
            if (!visited[curCity]) { // if current city is not visited
                dfs(isConnected, curCity, visited); // visit current city

                provinces++;
            }
        }

        return provinces;
    }

    public static void dfs(int[][] isConnected, int curCity, boolean[] visited) {
        visited[curCity] = true; // mark current city as visited

        // visit all the cities connected to current city
        for (int nextCity = 0; nextCity < isConnected.length; nextCity++) {
            if (isConnected[curCity][nextCity] == 1 && !visited[nextCity]) {
                dfs(isConnected, nextCity, visited);
            }
        }
    }

}
