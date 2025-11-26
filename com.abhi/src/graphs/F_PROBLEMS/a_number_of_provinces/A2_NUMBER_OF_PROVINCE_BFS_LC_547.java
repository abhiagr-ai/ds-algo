package graphs.F_PROBLEMS.a_number_of_provinces;

import java.util.*;

/**
 * There are n cities. Some of them are connected, while some are not.
 * If city a is connected directly with city b, and city b is connected directly with city c, then city 'a' is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1
 * if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 * Example 1:
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 */
public class A2_NUMBER_OF_PROVINCE_BFS_LC_547 {
    static void main() {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
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
        boolean[] visited = new boolean[isConnected.length];
        List<Integer>[] adj = getAdj(isConnected);
        System.out.println(Arrays.toString(adj));

        int provinceCount=0;

        // handle disconnected graph
        for(int i =0; i < isConnected.length; i++){
            if(!visited[i]){
                System.out.println("starting bfs for i "+i + " visited "+ Arrays.toString(visited));
                bfs(adj, visited, i);
                provinceCount++;
            }
        }
        System.out.println("province count"+ provinceCount);
    }

    static void bfs(List<Integer>[] adj, boolean[] visited, int k){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(k);
        visited[k] = true;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v: adj[u]){
                if(!visited[v]){
                    q.offer(v);
                    // queue mein push karte hi visited mark kar do
                    visited[v] = true;
                }
            }
        }
    }


    static List<Integer>[] getAdj(int[][] isConnected) {
        int V = isConnected.length;
        // prepare adj list
        List<Integer>[] adj = new ArrayList[isConnected.length];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        // populate adj
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {

                if (isConnected[i][j] == 1 && i != j && !adj[i].contains(j)) {
                    adj[i].add(j);
                }
            }
        }
        return adj;
    }

}
