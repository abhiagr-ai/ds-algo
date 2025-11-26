package graphs.F_PROBLEMS.a_number_of_provinces;

import java.util.*;

/**
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c, then city 'a' is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1
 * if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 * Example 1:
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 */
public class A1_NUMBER_OF_PROVINCE_DFS_LC_547 {
    static void main() {

        int[][] isConnected = {{1,1,0}, {1,1,0},{0,0,1}};
        //    0 1 2
        //    ------
        // 0  1 1 0
        // 1  1 1 0
        // 2  0 0 1

        /**
         *
         * m[0][0] -> 1 -> need to skip it
         * m[0][1] -> 1 --> city 0 is connected to city 1
         * m[0][2] -> 0

         * m[1][0] -> 1 --> city 1 is connected to city 0
         * m[1][1] -> 1 -> need to skip it
         * m[1][2] -> 0

         * m[2][0] -> 0
         * m[2][1] -> 0
         * m[2][2] -> 1 -> need to skip it [--> city 3 is not connected to any city]
         *
         * [[1], [0], []]
         *
         * adj
         * 0 -> 1
         * 1 -> 0
         * 2 -> none
         */


        int n = isConnected.length;
        List<Integer>[] adj = new ArrayList[n];
        for(int i =0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i =0; i< n ; i++){
            for (int j =0; j < n; j++){
                if(isConnected[i][j]==1 && !adj[i].contains(j) && i != j){
                    adj[i].add(j);
                }
            }
        }

        boolean[] visited = new boolean[n];
        System.out.println(Arrays.toString(adj));
        int count = 0;
        for(int i=0; i < n; i++){
            if(!visited[i]){
                dfs(adj, visited, 0);
                count++;
            }
        }
        System.out.println("No of provinces"+count);
    }

    static void dfs(List<Integer>[] adj, boolean[] visited, int u){
        visited[u] = true;
        for(int v: adj[u]){
            if(!visited[v]){
                dfs(adj, visited, v);
            }
        }

    }
}
